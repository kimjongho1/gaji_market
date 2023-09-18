<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>안전결제</title>
</head>
<body>
	<button onclick="kakaoPay()">카카오페이</button> <!-- 1.카카오페이버튼 -->
	<button onclick="tossPay()">토스페이</button>
	<button onclick="nicePay()">카드결제</button>

	<script>
	//카카오페이 호출함수
	function kakaoPay(){									
		IMP.init('${merchantIdentificationCode}');	//IMP를 가맹점 식별번호로 초기화
		
		IMP.request_pay( //IMP의 pay함수 실행 
		{	
			  pg: "kakaopay", // 카카오페이 결제창 호출
			  amount: 1000,	// 가격
			  name: "테스트 주문",	// 주문이름
			  buyer_name: "구매자",	// 구매자
			  buyer_email: "buyer@iamport.kr",	//구매자 이메일 
			  merchant_uid: "ss"
		},
		 rsp => {					//rsp를 인자로 받는 무명함수 실행
			 alert(rsp.imp_uid+ ":" + rsp.merchant_uid);	
			 console.log(rsp.imp_uid+ ":" + rsp.merchant_uid);
			 console.log(rsp);
			 $.ajax({
			  url: "<%=request.getContextPath()%>/payment/callback" ,	
			  method: "post",
			  dataType: 'json',
			  data: {
			        imp_uid: rsp.imp_uid, //결제서비스 제공자가 거래식별자
			        merchant_uid: rsp.merchant_uid// 판매자가 지정한 거래식별자
			  		},
		  	  success: callback	
			  });
		 });	
	}
	
	//토스페이 호출함수
		function tossPay(){
		IMP.init('${merchantIdentificationCode}');	//IMP를 가맹점 식별번호로 초기화
		
		IMP.request_pay( //IMP의 pay함수 실행 
		{	
			  pg: "tosspay", // 카카오페이 결제창 호출
			  amount: 1000,	// 가격
			  name: "테스트 주문",	// 주문이름
			  buyer_name: "구매자",	// 구매자
			  buyer_email: "buyer@iamport.kr",	//구매자 이메일
		},
		 rsp => {					//rsp를 인자로 받는 무명함수 실행
			 alert(rsp.imp_uid+ ":" + rsp.merchant_uid);	
			 console.log(rsp.imp_uid+ ":" + rsp.merchant_uid);
			 $.ajax({
			  url: "<%=request.getContextPath()%>/payment/callback" ,	
			  method: "post",
			  dataType: 'json',
			  data: {
			        imp_uid: rsp.imp_uid, //결제서비스 제공자가 거래식별자
			        merchant_uid: rsp.merchant_uid// 판매자가 지정한 거래식별자
			  		},
		  	  success: callback	
			  });
		 });	
	}
	
	
	//나이스 페이먼츠 호출함수
	function nicePay(){
	IMP.init('${merchantIdentificationCode}');
	IMP.request_pay({
		  pg: "nice_v2.iamport00m", // (신) 나이스페이먼츠 인증 결제용 호출
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
		  method: "post",
		  dataType: 'json',
		  data: {
		        imp_uid: rsp.imp_uid, //결제서비스 제공자가 만든 거래식별자
		        merchant_uid: rsp.merchant_uid// 판매자가 지정한 거래식별자
		  		},
		  		success: callback	
		    });
	 });
	}
	
	//callback 함수
	function callback(data){
		if(data.response.status=='paid') {
			alert("결제완료")
			//window.location.href="{pageContext.request.contextPath}/mypage/purchaselist";
		}
		else{
			console.log(data);
			alert(data.response.failReason);
		}
	}
	</script>
</body>
</html>