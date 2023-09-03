package kh.spring.gaji.paycontroller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class PayController {
	private static final Logger logger = LoggerFactory.getLogger(PayController.class);
	private IamportClient api = new IamportClient("");
	private CancelData cancelData;
	
	@GetMapping("payment/paytest")
	public String paytest() {
		return "payment/paytest";
	}
	
//	@Autowired
	public PayController() {
		super();
	}
	
	@GetMapping("payment/paytest1")
	public String paytest1() {
		return "payment/paytest1";
	}
	

	@PostMapping("payment/callback")
	@ResponseBody
	public String callback(String imp_uid,String merchant_uid) {
		IamportResponse<Payment> result=null;
		try {
			System.out.println("imp_uid:"+ imp_uid);
			System.out.println("merchant_uid:"+ merchant_uid);
			result= api.paymentByImpUid(imp_uid);
			BigDecimal amount = new BigDecimal(1000);
			if(result.getResponse().getStatus().equals("paid")&&amount== result.getResponse().getAmount()) {		// 금액이 일치하면
				return result.getResponse().getMerchantUid();	// 가맹점에서 부여한 거래정보를 반환.
			}
			else {
				cancelData=new CancelData(imp_uid, true); // imp_uid를 이용하여 거래취소함수에 인자가될 객체생성
				cancelData.setReason("금액이 일치하지 않습니다.");	// 취소이유를 세팅해줌
				api.cancelPaymentByImpUid(cancelData);	// api의 취소함수에 cancelData를 인자로하여 거래취소.
				return "금액이 일치하지 않습니다.";	// 이유를 반환함
				//결제취소후 return result;
			}
		} catch (IamportResponseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "서버상의 문제가 발생하였습니다. 관리자에게 문의하세요";
	}
}
