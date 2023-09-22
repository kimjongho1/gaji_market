package kh.spring.gaji.pay.controller;

import java.io.IOException;

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

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import kh.spring.gaji.pay.model.dto.InsertSafeTradingDto;
import kh.spring.gaji.pay.model.service.PayService;
import kh.spring.gaji.pay.model.service.PayServiceImpl;

@Controller
@PropertySource("classpath:/properties/application.properties")
public class PayController {
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	@Autowired
	private IamportClient api;
	@Autowired
	private PayService payServiceImpl;
	private CancelData cancelData;
	
	@Value("${merchant.identification.code}")
    private String merchantIdentificationCode;
	
	public PayController() {
		super();
	}
	
	@GetMapping("payment/pay")
	public String paytest1(Model model) {
		model.addAttribute("merchantIdentificationCode",merchantIdentificationCode);
		return "pay/pay";
	}
	
	
	@PostMapping("payment/cancel")	//안전거래 후 취소처리를 위한 버튼
	@ResponseBody
	public IamportResponse<Payment> cancel(String imp_uid) {
		IamportResponse<Payment> result=null;
		try {
			result = api.cancelPaymentByImpUid(cancelData=new CancelData(imp_uid, true)); //가맹점 고유식별번호로 거래취소후 , 거래정보담은 객체반환
			if(result.getResponse().getStatus().equals("cancelled"))
				//데이터베이스에서 안전거래 삭제. 상품 판매중으로 변경
			return result;	// 거래정보담은 객체반환 이후 페이지에서 이에따른 처리함.
		} catch (IamportResponseException | IOException e) {
			e.printStackTrace();
		}
		return result;		// 거래정보담은 객체반환 이후 페이지에서 이에따른 처리함.
	}
	

	@PostMapping("payment/callback")
	@ResponseBody
	public IamportResponse<Payment> callback(String imp_uid,int goodsId,HttpServletRequest request) {
		IamportResponse<Payment> result=null;
		try {
			result= api.paymentByImpUid(imp_uid);
			int amount =payServiceImpl.getAmount(goodsId);
			if(result.getResponse().getStatus().equals("paid")&&amount==result.getResponse().getAmount().intValue()) {	// 금액이 일치하고 지불이 완료되었다면.
/*				InsertSafeTradingDto insertSafeTradingDto=
				new InsertSafeTradingDto(imp_uid,
				(String)request.getSession().getAttribute("user_id"),
				result.getResponse().getPayMethod(),
				amount,
				result.getResponse().getBuyerAddr());
				int addResult = payServiceImpl.addSafeTrading(insertSafeTradingDto); //데이터베이스에 안전거래에 대한 데이터를 넣음(입금완료)
				if(addResult==1) // 가지 데이터베이스에 값이 정상적으로 들어갔다면
					return result;	// 거래정보 반환.
				else			// 가지 데이터베이스에 값이 입력되지 않았다면 거래취소.
				{*/
					cancelData=new CancelData(imp_uid, true); 
					api.cancelPaymentByImpUid(cancelData);
					return result;	//거래 정보 반환
				}		
			}
			else {
				cancelData=new CancelData(imp_uid, true); // imp_uid를 이용하여 거래취소함수에 인자가될 객체생성
				api.cancelPaymentByImpUid(cancelData);	// api의 취소함수에 cancelData를 인자로하여 거래취소.
				return result;	//거래 정보 반환
			}
		} catch (IamportResponseException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
