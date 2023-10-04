<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>안전결제</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #333;
        }
        select, table {
            width: 100%;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ccc;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        button {
        	border-radius: 0.375rem;
            background-color: #007bff;
            color: #fff;
            border: none black;
            padding: 10px 20px;
            margin: 10px;
            cursor: pointer;
        }
        button:hover {
            background-color: #007bff;
        }
        h1{
        	position:relative;
        	left:330px;
        }
        h3{
        	position:relative;
        	top:35px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>안전결제</h1>

        <h3>배송지</h3>
        <select id="addresses">
            <c:forEach var="address" items="${userAddress}">
                <option value="${address.roadAddress}, ${address.detailAddress}">
                    ${address.addressNickname},  
                    ${address.roadAddress},  
                    ${address.detailAddress} 
                </option>
            </c:forEach>
        </select>

        <table>
            <tr>
                <td>주문자</td>
                <td>${payUserInfo.name}</td>
            </tr>
            <tr>
                <td>휴대폰번호</td>
                <td>${payUserInfo.mobileNumber}</td>
            </tr>
            <tr>
                <td>주문상품</td>
                <td>${goodsInfo.title}</td>
            </tr>
            <tr>
                <td>안전결제수수료</td>
                <td>
                    <script>
                        var price = ${goodsInfo.price}; // JSP 변수로부터 가격을 가져옴
                        var fee = Math.round(price * 0.035); // 계산
                        document.write(fee); // 결과를 출력
                    </script>
                </td>
            </tr>
            <tr>
                <td>총결제금액</td>
                <td>
                    <script>
                        var total = Math.round(price * 1.035);// 계산
                        document.write(total); // 결과를 출력
                    </script>
                </td>
            </tr>
        </table> 

        <button onclick="kakaoPay()">카카오페이</button>
        <button onclick="tossPay()">토스페이</button>
        <button onclick="nicePay()">카드결제</button>
    </div>

    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	
<script>
	//카카오페이 호출함수
	function kakaoPay(){			
		IMP.init('${merchantIdentificationCode}');	//IMP를 가맹점 식별번호로 초기화
		var selectedOption = $("#addresses > option:selected").val();
		var addressParts = selectedOption.split(', ');

		var roadAddress = addressParts[0];
		var detailAddress = addressParts[1];
		
		IMP.request_pay( //IMP의 pay함수 실행 
		{	
			  pg: "kakaopay", // 카카오페이 결제창 호출
			  amount: total,	// 가격
			  name: "${goodsInfo.title}",	// 주문이름
			  buyer_name: "${payUserInfo.name}",	// 구매자
		},
		 rsp => {					//rsp를 인자로 받는 무명함수 실행
			 console.log(rsp);
			 $.ajax({
			  url: "<%=request.getContextPath()%>/payment/callback" ,	
			  method: "post",
			  dataType: 'json',
			  data: {
				  	goodsId:"${goodsInfo.goodsId}",
				  	impUid: rsp.imp_uid, //결제서비스 제공자가 거래식별자
				  	roadAddress: roadAddress,
				  	detailAddress:detailAddress
			  		},
		  	  success: callback	
			  });
		 });	
	}
	
	//토스페이 호출함수
		function tossPay(){
		IMP.init('${merchantIdentificationCode}');	//IMP를 가맹점 식별번호로 초기화
		var selectedOption = $("#addresses > option:selected").val();
		var addressParts = selectedOption.split(', ');

		var roadAddress = addressParts[0];
		var detailAddress = addressParts[1];

		IMP.request_pay( //IMP의 pay함수 실행 
		{		
			  pg: "tosspay", // 카카오페이 결제창 호출
			  amount: total,	// 가격
			  name: "${goodsInfo.title}",	// 주문이름
			  buyer_name: "${payUserInfo.name}",	// 구매자
		},
		 rsp => {					//rsp를 인자로 받는 무명함수 실행
			 $.ajax({
			  url: "<%=request.getContextPath()%>/payment/callback" ,	
			  method: "post",
			  dataType: 'json',
			  data: {
				 	goodsId:"${goodsInfo.goodsId}",
				  	impUid: rsp.imp_uid, //결제서비스 제공자가 거래식별자
				  	roadAddress: roadAddress,
				  	detailAddress:detailAddress
			  		},
		  	  success: callback	
			  });
		 });	
	}
	
	
	//나이스 페이먼츠 호출함수
	function nicePay(){
	IMP.init('${merchantIdentificationCode}');
	var selectedOption = $("#addresses > option:selected").val();
	var addressParts = selectedOption.split(', ');

	var roadAddress = addressParts[0];
	var detailAddress = addressParts[1];

	console.log(roadAddress);
	console.log(detailAddress);
	IMP.request_pay({
		  pg: "nice_v2.iamport00m", // (신) 나이스페이먼츠 인증 결제용 호출
		  amount: total,
		  name: "${goodsInfo.title}",
		  buyer_name: "${payUserInfo.name}",
	},
	 rsp => {	//rsp를 인자로 받는 무명함수 실행
		 $.ajax({
		  url: "<%=request.getContextPath()%>/payment/callback",
		  method: "post",
		  dataType: 'json',
		  data: {
			  	goodsId: "${goodsInfo.goodsId}",	//해당 상품글 번호를 같이 보내준다.
			  	impUid: rsp.imp_uid, //결제서비스 제공자가 만든 거래식별자
			  	roadAddress: roadAddress,
			  	detailAddress:detailAddress
		  		},
		  		success: callback	
		    });
	 });
	}
	
	//callback 함수
	function callback(data){
		if(data.response.status=='paid') {
			alert("결제완료")
			window.location.href="${pageContext.request.contextPath}/mypage/orderstatus/safe";
		}
		else{
			console.log(data);
			alert(data.response.failReason);
		}
	}
	</script>
</body>
</html>

