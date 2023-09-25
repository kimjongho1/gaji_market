package kh.spring.gaji.pay.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import kh.spring.gaji.goods.model.Service.GoodsService;
import kh.spring.gaji.pay.model.dto.GoodsPayInfoDto;
import kh.spring.gaji.pay.model.dto.InsertSafeTradingDto;
import kh.spring.gaji.pay.model.dto.PayUserInfoDto;
import kh.spring.gaji.pay.model.service.PayService;
import kh.spring.gaji.pay.model.service.PayServiceImpl;
import kh.spring.gaji.user.model.dto.UserAddressDto;

@Controller
@PropertySource("classpath:/properties/application.properties")
public class PayController {
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	@Autowired
	private IamportClient api;
	@Autowired
	private PayService payServiceImpl;
	@Autowired
	private InsertSafeTradingDto insertSafeTradingDto;
	@Autowired
	private GoodsService goodsService;
	
	private CancelData cancelData;
	
	@Value("${merchant.identification.code}")
    private String merchantIdentificationCode;
	
	public PayController() {
		super();
	}
	
		@GetMapping("payment/pay")
		public String paytest1(Model model,RedirectAttributes attribute/* ,int goodsId */,HttpServletRequest request) {
			/* String userId=(String)request.getSession().getAttribute("userId"); */
			if(payServiceImpl.checkGoodsStatus(2)!=1) {	//추후 1은 goodsId로 대체
				attribute.addFlashAttribute("errorMsg", "예약중인 상품입니다.");
				return "redirect:/main";
			}
			GoodsPayInfoDto goodsInfo=payServiceImpl.getGoodsInfo(2);	//추후 1은 goodsId로 대체
			List<UserAddressDto> userAddress = payServiceImpl.getUserAddressList("qordmlgjs");	 //추후대체 userId =qordmlgjs
			PayUserInfoDto payUserInfo= payServiceImpl.getUserInfo("qordmlgjs");			 //추후대체 userId =qordmlgjs 
			model.addAttribute("merchantIdentificationCode",merchantIdentificationCode);
			model.addAttribute("goodsInfo",goodsInfo);		//상품정보
			model.addAttribute("userAddress",userAddress);	//유저주소들
			model.addAttribute("payUserInfo",payUserInfo);	//유저정보
			return "pay/pay";
		}
		
	@PostMapping("payment/cancel")	//안전거래 후 취소처리를 위한 버튼
	@ResponseBody
	public IamportResponse<Payment> cancel(String impUid) {
		IamportResponse<Payment> result=null;
		try {
			result = api.cancelPaymentByImpUid(cancelData=new CancelData(impUid, true)); //가맹점 고유식별번호로 거래취소후 , 거래정보담은 객체반환
			if(result.getResponse().getStatus().equals("cancelled"))
				payServiceImpl.cancelSafeTrading(impUid);//데이터베이스에서 안전거래 취소로 변경. 상품 판매중으로 변경
			return result;	// 거래정보담은 객체반환 이후 페이지에서 이에따른 처리함.
		} catch (IamportResponseException | IOException e) {
			e.printStackTrace();
		}
		return result;		// 거래정보담은 객체반환 이후 페이지에서 이에따른 처리함.
	}
	

	@PostMapping("payment/callback")
	@ResponseBody
	public IamportResponse<Payment> callback(String impUid, String detailAddress,
			String roadAddress,int goodsId,HttpServletRequest request) {
		IamportResponse<Payment> result=null;
		try {
			result= api.paymentByImpUid(impUid);
			int amount =(int)Math.round(payServiceImpl.getAmount(2) * 1.035);	//goodsId =1
			String goodTitle=result.getResponse().getName();
			if(result.getResponse().getStatus().equals("paid")&&amount==result.getResponse().getAmount().intValue()) {	// 금액이 일치하고 지불이 완료되었다면.
				insertSafeTradingDto.setTransactionId(impUid);
				insertSafeTradingDto.setGoodsId(goodsId);
				insertSafeTradingDto.setGoodsTitle(goodTitle);
				insertSafeTradingDto.setPrice(amount);
				insertSafeTradingDto.setPurchaseMethod(result.getResponse().getPayMethod());
				insertSafeTradingDto.setDetailAddress(detailAddress);
				insertSafeTradingDto.setRoadAddress(roadAddress);
				insertSafeTradingDto.setBuyerId("qordmlgjs");	 //userId =qordmlgjs
				
				int addResult = payServiceImpl.addSafeTrading(insertSafeTradingDto); //데이터베이스에 안전거래에 대한 데이터를 넣음
				
				if(addResult==1) { // 가지 데이터베이스에 값이 정상적으로 들어갔다면
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("status", 2);
					map.put("goodsId",Integer.valueOf(2)); // 추후 goodsId로 변경해야함.
					if(goodsService.updateStatus(map)==1);
						return result;	// 거래정보 반환.
				}
				else			// 가지 데이터베이스에 값이 입력되지 않았거나 거래중으로 변경이 안되었다면 거래취소함.
				{
					cancelData=new CancelData(impUid, true); 
					api.cancelPaymentByImpUid(cancelData);
					return result;	//거래 정보 반환
				}
			}
			
			else {
				cancelData=new CancelData(impUid, true); // imp_uid를 이용하여 거래취소함수에 인자가될 객체생성
				api.cancelPaymentByImpUid(cancelData);	// api의 취소함수에 cancelData를 인자로하여 거래취소.
				return result;	//거래 정보 반환
			}
		} catch (IamportResponseException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
