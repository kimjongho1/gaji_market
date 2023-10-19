package kh.spring.gaji.pay.controller;

import java.io.IOException;
import java.security.Principal;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
import kh.spring.gaji.notification.model.dto.InsertNotificationDto;
import kh.spring.gaji.notification.model.dto.TitleBuyerDto;
import kh.spring.gaji.pay.model.dto.GoodsPayInfoDto;
import kh.spring.gaji.pay.model.dto.InsertSafeTradingDto;
import kh.spring.gaji.pay.model.dto.PayUserInfoDto;
import kh.spring.gaji.pay.model.service.PayService;
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
	private InsertNotificationDto insertNotificationDto;
	
	private CancelData cancelData;
	
	@Value("${merchant.identification.code}")
    private String merchantIdentificationCode;
	
	public PayController() {
		super();
	}
	
		@GetMapping("payment/pay")
		public String pay(Model model,RedirectAttributes attribute,Integer goodsId,HttpServletRequest request,Principal principal) {
			String userId=principal.getName();
			if(payServiceImpl.checkIdForPay(goodsId).equals(userId)) {
				attribute.addFlashAttribute("msg", "본인 상품을 구매할 수 없습니다.");
				return "redirect:/";
			}
			else if(payServiceImpl.checkGoodsStatus(goodsId)!=1) {	
				attribute.addFlashAttribute("msg", "판매중인 상품이 아닙니다.");
				return "redirect:/";
			}
			GoodsPayInfoDto goodsInfo=payServiceImpl.getGoodsInfo(goodsId);
			List<UserAddressDto> userAddress = payServiceImpl.getUserAddressList(userId);	 
			PayUserInfoDto payUserInfo= payServiceImpl.getUserInfo(userId);			  
			model.addAttribute("merchantIdentificationCode",merchantIdentificationCode);
			model.addAttribute("goodsInfo",goodsInfo);		//상품정보
			model.addAttribute("userAddress",userAddress);	//유저주소들
			model.addAttribute("payUserInfo",payUserInfo);	//유저정보
			return "pay/pay";
		}
		
		@PostMapping("payment/closepay")
		@ResponseBody
		public int closePay(String transactionId,HttpServletRequest request,Principal principal) {
			int result=0;
			String userId=principal.getName();
				result = payServiceImpl.closeSafeTrading(transactionId,userId);	 
				if(result==1) {
					Map<String,Object> map=new HashMap<String,Object>();
					map.put("status",3);
					map.put("goodsId",payServiceImpl.getGoodsId(transactionId));
					payServiceImpl.updateStatus(map);
//					payServiceImpl.insertClosePayNotice(transactionId);
				}
				System.out.println("result:"+result);
			return result;
		}
	
	@Transactional
	@PostMapping("payment/changestatus")
	@ResponseBody
	public int changeStatus(String transactionId,int status,HttpServletRequest request,Principal principal) {
		Map<String,Object> map=new HashMap<String,Object>();
		String userId=principal.getName();
		map.put("userId", userId);
		map.put("status", status);
		map.put("transactionId",transactionId);
		if(payServiceImpl.changeStatus(map)==1) {
			TitleBuyerDto titleBuyerDto=payServiceImpl.getBuyerIdFromTransactionId(transactionId);
			insertNotificationDto.setUserId(titleBuyerDto.getBuyerId());  
			insertNotificationDto.setType(3);
			insertNotificationDto.setReferenceId(transactionId);
			insertNotificationDto.setMessage(titleBuyerDto.getGoodsTitle()+"의 거래가 수락되었습니다.");
			payServiceImpl.insertNoti(insertNotificationDto);
			return 1;
		}
		return 0;
	}
		
	@PostMapping("payment/cancel")	//안전거래 후 취소처리를 위한 버튼
	@ResponseBody
	public IamportResponse<Payment> cancel(int goodsId,String transactionId,HttpServletRequest request,Principal principal) {
		IamportResponse<Payment> result=null;
		String userId=principal.getName();
		try {
			result = api.cancelPaymentByImpUid(cancelData=new CancelData(transactionId, true)); //가맹점 고유식별번호로 거래취소후 , 거래정보담은 객체반환
			if(result.getResponse().getStatus().equals("cancelled")) {
				payServiceImpl.cancelSafeTrading(transactionId);//데이터베이스에서 안전거래 취소로 변경. 상품 판매중으로 변경
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("status",1);
				map.put("goodsId",goodsId);
				payServiceImpl.updateStatus(map);
				TitleBuyerDto titleBuyerDto=payServiceImpl.getBuyerIdFromTransactionId(transactionId);
				insertNotificationDto.setUserId(titleBuyerDto.getBuyerId());  
				insertNotificationDto.setType(3);
				insertNotificationDto.setReferenceId(transactionId);
				insertNotificationDto.setMessage(titleBuyerDto.getGoodsTitle()+"의 거래가 취소되었습니다.");
				payServiceImpl.insertNoti(insertNotificationDto);
			}
			return result;	// 거래정보담은 객체반환 이후 페이지에서 이에따른 처리함.
		} catch (IamportResponseException | IOException e) {
			e.printStackTrace();
		}
		/* } */
		return result;		// 거래정보담은 객체반환 이후 페이지에서 이에따른 처리함.
	}
	

	@PostMapping("payment/callback")
	@ResponseBody
	public IamportResponse<Payment> callback(String impUid, String detailAddress,
			String roadAddress,Integer goodsId,HttpServletRequest request,Principal principal) {
		IamportResponse<Payment> result=null;
		String userId=principal.getName();
		try {
			result= api.paymentByImpUid(impUid);
			int amount =(int)Math.round(payServiceImpl.getAmount(goodsId) * 1.035);
			String goodTitle=result.getResponse().getName();
			if(result.getResponse().getStatus().equals("paid")&&amount==result.getResponse().getAmount().intValue()) {	// 금액이 일치하고 지불이 완료되었다면.
				insertSafeTradingDto.setTransactionId(impUid);
				insertSafeTradingDto.setGoodsId(goodsId);
				insertSafeTradingDto.setGoodsTitle(goodTitle);
				insertSafeTradingDto.setPrice(amount);
				insertSafeTradingDto.setPurchaseMethod(result.getResponse().getPayMethod());
				insertSafeTradingDto.setDetailAddress(detailAddress);
				insertSafeTradingDto.setRoadAddress(roadAddress);
				insertSafeTradingDto.setBuyerId(userId);
				
				int addResult = payServiceImpl.addSafeTrading(insertSafeTradingDto); //데이터베이스에 안전거래에 대한 데이터를 넣음
				
				if(addResult==1) { // 가지 데이터베이스에 값이 정상적으로 들어갔다면
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("status", 2);
					map.put("goodsId",goodsId); // 추후 goodsId로 변경해야함.
					if(payServiceImpl.updateStatus(map)==1);
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
	@ExceptionHandler
	public String exception(Exception e, RedirectAttributes ra,Principal principal) {
		e.printStackTrace();
		try {
		principal.getName();		
		}catch(Exception e1) {
			e1.printStackTrace();
			ra.addFlashAttribute("msg", "로그인이 필요한 페이지입니다.");
			return "redirect:/";
		}
		ra.addFlashAttribute("msg", "예기치않은 오류로 메인페이지로 이동합니다.");
		System.out.println("PayController인가??");
		return "redirect:/";
	}	
}
