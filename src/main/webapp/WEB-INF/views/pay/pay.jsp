<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/pay/pay.css" rel='stylesheet' type='text/css'>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>안전결제</title> 
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
        
        <!-- 모달 트리거 버튼 -->
        <button type="button" id="showAddressModalBtn" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#AddressModal">
  			주소변경
		</button>
		
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

        <button type="button" onclick="kakaoPay()">카카오페이</button>
        <button type="button" onclick="tossPay()">토스페이</button>
        <button type="button" onclick="nicePay()">카드결제</button>
    </div>

	<div class="modal fade" id="AddressModal" tabindex="-1" role="dialog"
		aria-labelledby="AddressModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="AddressModalLabel">주소등록</h5>
				</div>
				<div class="modal-body">

					 <select id="modalAddresses">
            			<c:forEach var="address" items="${userAddress}">
                			<option value="${address.roadAddress}, ${address.detailAddress}, ${address.addressNo}">
                    			${address.addressNickname},  
                    			${address.roadAddress},  
                    			${address.detailAddress} 
                			</option>
            			</c:forEach>
        			</select>
        			<button type="button" id="deleteAddress" onclick="deleteAddress()">주소삭제</button>
        			<button type="button" id="alterPrimaryAddress" onclick="alterPrimaryAddress()">대표주소 변경</button>
        			
					<form id="addressForm">
						<div class="textForm">
							<span style="display: flex;"> <input type="text"
								name="postCode" id="sample4_postcode" placeholder="우편번호" class="cellphoneNo" required="required" readonly>
								<button type="button" class="btn-postcode" onclick="sample4_execDaumPostcode()">우편번호 찾기</button>
							</span>
						</div>
						<div class="textForm">
							<span style="display: flex;"> <input type="text"
								name="roadAddress" id="sample4_roadAddress" placeholder="도로명주소" class="cellphoneNo" required="required" readonly>
							</span>
						</div>
						<div class="textForm">
							<span style="display: flex;"> <input type="text"
								name="address" id="sample4_jibunAddress" placeholder="지번주소" class="cellphoneNo" required="required"> <span id="guide" style="color: #999; display: none" ></span>
							</span>
						</div>
						<div class="textForm">
							<span style="display: flex;"> <input type="text"
								name="detailAddress" id="sample4_detailAddress"
								placeholder="상세주소" class="cellphoneNo" required>
							</span>
						</div>
						<div class="textForm">
							<span style="display: flex;"> <input type="text"
								name="addressNickname" id="sample4_detailAddress"
								placeholder="주소별칭" class="cellphoneNo" required>
							</span>
						</div>
						<button type="button" onclick="addressRegist()">주소 등록</button>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>

	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
		  	  success: callback	,
				error : (request,status,error)=>{
					console.log(request);
					console.log(status);
					console.log(error);
					alert("code:"+request.status+"\n"+"message"+request.responseText+"\n"+error+":error");
				}
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
		  	  success: callback	,
				error : (request,status,error)=>{
					console.log(request);
					console.log(status);
					console.log(error);
					alert("code:"+request.status+"\n"+"message"+request.responseText+"\n"+error+":error");
				}
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
		  		success: callback,
				error : (request,status,error)=>{
					console.log(request);
					console.log(status);
					console.log(error);
					alert("code:"+request.status+"\n"+"message"+request.responseText+"\n"+error+":error");
				}	
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
			if(data.response.failReason==null||data.response.failReason=="알 수 없는 이유로 결제가 중단되었습니다. 나이스페이로 문의(1661-0808)하세요.")
				alert("[결제포기] 사용자가 결제를 취소하셨습니다");
			else
				alert(data.response.failReason);
		}
	}

	$(document).ready(function () {
	    $('#AddressModal').modal({
	        backdrop: 'static', // 모달 바깥을 클릭해도 모달이 닫히지 않도록 설정
	        show: false // 페이지 로드 시 모달을 표시하지 않도록 설정
	    });

	    // 주소변경 버튼을 클릭하면 모달을 표시
	    $('#showAddressModalBtn').click(function () {
	        $('#AddressModal').modal('show');
	    });
	    
	    $('.btn-secondary').click(function(){
	    	 $('#AddressModal').modal('hide');
	    });
	});
	

	function sample4_execDaumPostcode() {
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수

						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample4_postcode').value = data.zonecode;
						document.getElementById("sample4_roadAddress").value = roadAddr;
						document.getElementById("sample4_jibunAddress").value = data.jibunAddress;

						// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
						/* if (roadAddr !== '') {
							document.getElementById("sample4_extraAddress").value = extraRoadAddr;
						} else {
							document.getElementById("sample4_extraAddress").value = '';
						} */

						var guideTextBox = document.getElementById("guide");
						// 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
						if (data.autoRoadAddress) {
							var expRoadAddr = data.autoRoadAddress
									+ extraRoadAddr;
							guideTextBox.innerHTML = '(예상 도로명 주소 : '
									+ expRoadAddr + ')';
							guideTextBox.style.display = 'block';

						} else if (data.autoJibunAddress) {
							var expJibunAddr = data.autoJibunAddress;
							guideTextBox.innerHTML = '(예상 지번 주소 : '
									+ expJibunAddr + ')';
							guideTextBox.style.display = 'block';
						} else {
							guideTextBox.innerHTML = '';
							guideTextBox.style.display = 'none';
						}
					}
				}).open();
	}
	
	var addressRegist=()=> {
		var formData = $('#addressForm').serialize();
		var item;
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/mypage/address/regist/do",
			data:formData,
			dataType:"json",
			async:false,
			success: (data)=>{
				alert("주소 등록에 성공했습니다.");
				var html="<select id='addresses'>";
				for(var i=0; i<data.length; i++){
				item=data[i];
				html+="<option value='"+item.roadAddress+","+item.detailAddress+"'>";
				html+=item.addressNickname+","+item.roadAddress+","+item.detailAddress+"</option>";
				}
				html+="</select>";
				$("#addresses").replaceWith(html);
				
				html="<select id='modalAddresses'>";
				for(var i=0; i<data.length; i++){
					item=data[i];
					html+="<option value='"+item.roadAddress+","+item.detailAddress+","+item.addressNo+"'>";
					html+=item.addressNickname+","+item.roadAddress+","+item.detailAddress+"</option>";
				}
				html+="</select>";
				$("#modalAddresses").replaceWith(html);
			},
			error: (data)=>{
				if($("#modalAddresses option").length > 8)
					alert("등록가능한 주소갯수를 초과하였습니다.");
				else if($(".textForm input[name=postCode]").val()==="")
					alert("우편번호를 입력해주세요.");
				else if($(".textForm input[name=address]").val()==="")
					alert("지번주소를 입력해주세요.");
				else if($(".textForm input[name=detailAddress]").val()==="")
					alert("상세주소를 입력해주세요.");
				else if($(".textForm input[name=addressNickname]").val()==="")
					alert("주소별칭을 입력해주세요.");
				else
					alert("잘못된 접근입니다.");
			}
		});
	}
	
	var deleteAddress=()=>{
		var selectedOption = $("#modalAddresses option:selected").val();
		var addressParts = selectedOption.split(', ');
		var addressNo = addressParts[2];
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/mypage/address/delete",
			dataType:"json",
			data: { addressNo: addressNo},
			success:  (data)=>{
				if(data=='1')
					alert("주소를 삭제했습니다.");
				else
					alert("주소 삭제에 실패했습니다.");
				window.location.href="${pageContext.request.contextPath}/payment/pay?goodsId=${goodsInfo.goodsId}";
			},
			error : (request,status,error)=>{
				console.log(request);
				console.log(status);
				console.log(error);
				alert("code:"+request.status+"\n"+"message"+request.responseText+"\n"+error+":error");
			}
		});
	}
	
	var alterPrimaryAddress=()=>{
		var selectedOption = $("#modalAddresses option:selected").val();
		var addressParts = selectedOption.split(', ');
		var addressNo = addressParts[2];
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/mypage/address/alterPrimaryAddress",
			data: { addressNo: addressNo},
			dataType:"json",
			success:  (data)=>{
				alert("대표주소가 변경되었습니다.");
				window.location.href="${pageContext.request.contextPath}/payment/pay?goodsId=${goodsInfo.goodsId}";
			},
			error : (request,status,error)=>{
				console.log(request);
				console.log(status);
				console.log(error);
				alert("code:"+request.status+"\n"+"message"+request.responseText+"\n"+error+":error");
			}
		});
	}
	
	</script>
</body>
</html>

