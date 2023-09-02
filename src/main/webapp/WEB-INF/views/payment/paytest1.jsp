<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>paytest 1</title>
</head>
<body>
	<button onclick="kakaoPay()">카카오페이</button>
	<button onclick="tossPay()">토스페이</button>
	<button onclick="nicePay()">카드결제</button>

	<script>
	function kakaoPay(){
		const userCode='';
		IMP.init(userCode);
		IMP.request_pay({
			  pg: "kakaopay", // 카카오페이 결제창 호출
			  amount: 1000,
			  name: "테스트 주문",
			  buyer_name: "구매자",
			  buyer_email: "buyer@iamport.kr",
			  merchant_uid: "123"
		},
		 rsp => {	//rsp를 인자로 받는 무명함수 실행
			 alert(rsp.imp_uid+ ":" + rsp.merchant_uid);
			 console.log(rsp.imp_uid+ ":" + rsp.merchant_uid);
			 $.ajax({
			  url: "<%=request.getContextPath()%>/payment/callback",
			  method: "POST",
			  dataType: 'json',
			  data: {
			        imp_uid: rsp.imp_uid, //결제서비스 제공자가 만든 거래식별자
			        merchant_uid: rsp.merchant_uid// 판매자가 지정한 거래식별자
			  		},
		  	  success: callback	
			    });
		 });
	}
	
	function callback(successFail){
		if(successFail==1)
		alert("성공?")
		else
		alert("실패?")
	}
	
	function tossPay(){
		const userCode='';
		IMP.init(userCode);
		IMP.request_pay({
			  pg: "tosspay", // 카카오페이 결제창 호출
			  amount: 1000,
			  name: "테스트 주문",
			  buyer_name: "구매자",
			  buyer_email: "buyer@iamport.kr",
		},
		 rsp => {	//rsp를 인자로 받는 무명함수 실행
			 alert(rsp.imp_uid+ ":" + rsp.merchant_uid);
			 console.log(rsp.imp_uid+ ":" + rsp.merchant_uid);
			 $.ajax({
			  url: "<%=request.getContextPath()%>/payment/callback",
			  method: "POST",
			  dataType: 'json',
			  data: {
			        imp_uid: rsp.imp_uid, //결제서비스 제공자가 만든 거래식별자
			        merchant_uid: rsp.merchant_uid,// 판매자가 지정한 거래식별자
			  		},
			  		success: callback	
			    });
		 });
	}
	
	function nicePay(){
	const userCode='';
	IMP.init(userCode);
	IMP.request_pay({
		  pg: "nice_v2.iamport00m", // (신) 나이스페이먼츠 인증 결제용 호출
		  amount: 1000,
		  name: "테스트 주문",
		  buyer_name: "구매자",
		  buyer_email: "buyer@iamport.kr"
	},
	 rsp => {	//rsp를 인자로 받는 무명함수 실행
		 alert(rsp.imp_uid+ ":" + rsp.merchant_uid);
		 console.log(rsp.imp_uid+ ":" + rsp.merchant_uid);
		 $.ajax({
		  url: "<%=request.getContextPath()%>/payment/callback",
		  method: "POST",
		  dataType: 'json',
		  data: {
		        imp_uid: rsp.imp_uid, //결제서비스 제공자가 만든 거래식별자
		        merchant_uid: rsp.merchant_uid,// 판매자가 지정한 거래식별자
		  		},
		  		success: callback	
		    });
	 });
	}
	</script>
</body>
</html>