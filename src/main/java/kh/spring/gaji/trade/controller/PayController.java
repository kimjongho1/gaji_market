package kh.spring.gaji.trade.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

/**
 * Handles requests for the application home page.
 */
@Controller
@PropertySource("classpath:/properties/application.properties")
public class PayController {
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	@Autowired
	private IamportClient api;
	private CancelData cancelData;
	@Value("${merchant.identification.code}")
    private String merchantIdentificationCode;
	
	@GetMapping("payment/paytest") //이후 삭제할 Mapping
	public String paytest() {
		return "pay/paytest";
	}
	
	public PayController() {
		super();
	}
	
	@GetMapping("payment/pay")
	public String paytest1(Model model) {
		model.addAttribute("merchantIdentificationCode",merchantIdentificationCode);
		return "pay/paytest1";
	}
	
	
	@PostMapping("payment/cancel")	//안전거래 후 취소처리를 위한 버튼
	@ResponseBody
	public IamportResponse<Payment> cancel(String merchantId) {
		IamportResponse<Payment> result=null;
		try {
			result = api.cancelPaymentByImpUid(cancelData=new CancelData(merchantId, false)); //가맹점 고유식별번호로 거래취소후 , 거래정보담은 객체반환
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
	public IamportResponse<Payment> callback(String imp_uid,String merchant_uid) {
		IamportResponse<Payment> result=null;
		try {
			result= api.paymentByImpUid(imp_uid);
			BigDecimal amount = new BigDecimal(1000); // 이후에는 merchant로 불러온 가격과 비교할것임.
			if(result.getResponse().getStatus().equals("paid")&&amount==result.getResponse().getAmount()) {	// 금액이 일치하고 지불이 완료되었다면.
								//데이터베이스에 안전거래에 대한 데이터를 넣음(상품준비중)
				return result;	// 거래정보 반환.
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
