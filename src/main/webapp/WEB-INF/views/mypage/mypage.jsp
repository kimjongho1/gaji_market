<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>

<!--favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
<!-- Css Styles -->
<link rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"	type="text/css">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"	type="text/css">
<link rel="stylesheet"	href="${pageContext.request.contextPath}/resources/css/style.css"	type="text/css">
<script	src="${pageContext.request.contextPath}/resources/js/orderstatus.js"></script>
<link	href="${pageContext.request.contextPath}/resources/css/orderstatus.css"	rel='stylesheet' type='text/css'>

<style>
	select, table {
            width: 100%;
            margin-top: 20px;
        }

 /* 모달 배경 스타일 */
    .modal-backdrop {
        background-color: rgba(0, 0, 0, 0.5) !important;
    }

    /* 모달 내용 스타일 */
    .modal-content {
        border-radius: 0;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }

    /* 모달 제목 스타일 */
    .modal-title {
        font-size: 24px;
        color: #333;
    }

    /* 모달 입력 필드 스타일 */
    .textForm {
        margin-bottom: 10px;
    }

    .textForm input[type="text"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    /* 모달 버튼 스타일 */
    .modal-footer button {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
    }

    .modal-footer button:hover {
        background-color: #0056b3;
    }
    
    .fa-facebook, .fa-instagram, .fa-twitter, .fa-pinterest {
    top: 0;    
    }
   .content {
   margin: 50px auto;
   padding: 50px 100px;
   width: 1000px;
   border: 1px solid #bbb1d6;
   border-radius: 5px;
   box-shadow: 5px 5px 5px 1px #bbb1d6cc;
   }
    
    label {
	height: 30px;
	width: 100px;
}

	section input {
	
	width: auto;
	
	
	}
	
	section {
	
	min-height: 1200px;
	
	}
	
	.btn-modi {
	
	display: inline-block;
  padding: 4px 8px;
  font-size: 16px;
  background-color: #7b6aa6;;
  color: #ffffff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s;
	
	
	}
	.btn-modi:hover {
	
	background-color: #6a598f;
	}
	
	.btn-modi:active {
  	background-color: #5a4978; 
}
	
	.pline{
	
    border-bottom: 1px solid #bbb1d6;
   	margin: 10px;
	}
	
	.pline input {
	
	border: 0;
	background-color: #f1f1f1;
	
	}
	
	
	.bgo {
	background-color: rgba(204,244,220,1); 
	border-radius: 0.25rem;
	overflow: hidden;
	width: 100%;
	height: 0.375rem;
	}
	
	.bgs {
	background-color: rgba(13,204,90,1);
	height: 100%;
	border-radius: 0.25rem;
	
	}
	.gt {
	color: #0CB650;
	font-weight: 500;
	width: 73.5%;
	}	
	
	.contls {
	
    width: 500px;
    display: flex;
    justify-content: space-between;
	}
	
	.contls input {
	
	min-width: 350px;
	
	}
	
</style>
</head>
<body>

<header>
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</header>
	<jsp:include page="/WEB-INF/views/mypage/side.jsp"></jsp:include>

	<h2>회원 정보</h2>
	<section>
	
<div class="content">
	<nav>
		<a href=""></a>
	</nav>
	<c:forEach items="${userMypage}" var="user" begin="0" end="0">
	<div class="pline">
	<span class="row flex justify-content-between align-items-center">
		<label><strong>이름 : </strong></label> 
		<div class="contls">
		<input type="text" name="name" id="name" value="${user.name}">
		<button type="button" class="btn-modi" id="nameUpdate">변경</button>
		</div>
	</span>
	</div>
	<div class="pline">
	<span class="row flex justify-content-between align-items-center">
		<label>가지온도 :</label> 
		<div class="contls">
		<div class="flex justify-between mb-2 gt">
						<strong>${user.ratingScore}%</strong>
						<div class="bgo">
							<div class="bgs" style="width: ${user.ratingScore}%;"></div>
						</div>
					</div>
		</div>
	</span>
	</div>
	<div class="pline">
	<span class="row flex justify-content-between align-items-center">
		<label>닉네임 :</label> 
		<div class="contls">
		<input type="text" name="nickname" id="nickname" value="${user.nickname}">
		<button type="button" class="btn-modi" id="nicknameUpdate">변경</button>
		</div>
	</span>
	</div>
	<div class="pline">
	<span class="row flex justify-content-between align-items-center">
		<label>이메일 :</label> 
		<div class="contls">
		<input type="text" name="email" id="email" value="${user.email}">
		<button type="button" class="btn-modi" id="emailUpdate">변경</button>
		</div>
	</span>
	</div>
	<div class="pline">
	<span class="row flex justify-content-between align-items-center">
		<label>연락처 :</label> 
		<div class="contls">
		<input type="text" name="mobileNumber" id="mobileNumber" value="${user.mobileNumber}">
		<button type="button" class="btn-modi" id="mobileNumberUpdate">변경</button>
		</div>
	</span>
	</div>
	<div class="pline">
	<span class="row flex justify-content-between align-items-center">
	<label>주소 : </label> 
		<div class="contls">
		<input type="text" name="name" id="name" value="${user.roadAddress} ${user.detailAddress}">
		<!-- 모달 트리거 버튼 -->
        <button type="button" id="showAddressModalBtn" class="btn-modi" data-toggle="modal" data-target="#AddressModal">
  			주소등록
		</button>
		</div>
	</span>
	</div>
	</div>
</section>	
	<!-- 모달부분 -->
	
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
        			<button id="deleteAddress" onclick="deleteAddress()">주소삭제</button>
        			<button id="alterPrimaryAddress" onclick="alterPrimaryAddress()">대표주소 변경</button>
        			
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
						<button onclick="addressRegist()">주소 등록</button>
					</form>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>

	
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	</c:forEach>
	<script>
	$(document).ready(function() {
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
	    
	    
		
	    // 버튼 클릭 시 서버에 이름 업데이트 요청 보내기
	    $("#nameUpdate").click(function() {
	    	console.log("버튼클릭확인");
	        var userId = "${user.userId}"; // 사용자 아이디
	        var nameInput = $("#name"); // 이름 입력란
	        var name = nameInput.val(); // 입력된 이름
	        var namePattern = /^[가-힣a-zA-Z]{2,30}$/; // 이름은 2~30자의 한글 또는 영문 허용

	        // 이름 유효성 검사
	        if (name.trim() === "") {
	            alert("이름을 입력하세요.");
	            nameInput.focus();
	            return;
	        }

	        if (!namePattern.test(name)) {
	            alert("이름은 2~30자의 한글 또는 영문만 허용합니다.");
	            nameInput.focus();
	            return;
	        }
	        $.ajax({
	            url: "${pageContext.request.contextPath}/mypage/updatename",
	            type: "POST",
	            data: {
	                userId: userId,
	                name: name
	            },
	            success: function(data) {
	                if (data.status === "1") {
	                    // 성공 메시지를 alert 창으로 표시
	                    alert(data.msg1);
	                } else {
	                    // 오류 메시지를 alert 창으로 표시
	                    alert(data.msg1);
	                }
	            },
	            error: function() {
	                // 서버 오류 메시지를 alert 창으로 표시
	                alert("서버 오류");
	            }
	        });
	    });
	    
	 // 버튼 클릭 시 서버에 닉네임 업데이트 요청 보내기
	    $("#nicknameUpdate").click(function() {
	    	console.log("버튼클릭확인");
	        var userId = "${user.userId}"; // 사용자 아이디
	        var nickname = $("#nickname").val(); // 입력된 닉네임
	        var nicknamePattern = /^[a-zA-Z0-9ㄱ-ㅎ가-힣]{4,30}$/; // 닉네임은 4~30자의 영문 대소문자, 숫자, 한글 허용
	     // 닉네임 확인
	        if (nickname == "") {
	            alert("닉네임을 입력하세요.");
	            $("#nickname").focus();
	            return;
	        }
	        if (!nicknamePattern.test(nickname)) {
	            alert("닉네임은 4~30자의 영문 대소문자, 숫자, 한글만 허용합니다.");
	            $("#nickname").focus();
	            return;
	        }
	        
	        $.ajax({
	            url: "${pageContext.request.contextPath}/mypage/updatenickname",
	            type: "POST",
	            data: {
	                userId: userId,
	                nickname: nickname
	            },
	            success: function(data) {
	                if (data.status === 1) {
	                    // 성공 메시지를 alert 창으로 표시
	                    alert(data.msg2);
	                } else if (data.status === -1) {
	                    // 중복 메시지를 alert 창으로 표시
	                    alert(data.msg2);
	                } else {
	                    // 오류 메시지를 alert 창으로 표시
	                    alert(data.msg2);
	                }
	            },
	            error: function() {
	                // 서버 오류 메시지를 alert 창으로 표시
	                alert("서버 오류");
	            }
	        });
	    });
	 
	 // 버튼 클릭 시 서버에 이메일 업데이트 요청 보내기
	    $("#emailUpdate").click(function() {
	    	console.log("버튼클릭확인");
	        var userId = "${user.userId}"; // 사용자 아이디
	        var email = $("#email").val(); // 입력된 이름
	        var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // 이메일 주소 형식
	     // 이메일 확인
	        if (email == "") {
	            alert("이메일을 입력하세요.");
	            $("#email").focus();
	            return;
	        }
	        if (!emailPattern.test(email)) {
	            alert("올바른 이메일 주소 형식이 아닙니다.");
	            $("#email").focus();
	            return;
	        }
	        
	        $.ajax({
	            url: "${pageContext.request.contextPath}/mypage/updateemail",
	            type: "POST",
	            data: {
	                userId: userId,
	                email: email
	            },
	            success: function(data) {
	                if (data.status === 1) {
	                    // 성공 메시지를 alert 창으로 표시
	                    alert(data.msg3);
	                } else if (data.status === -1) {
	                    // 중복 메시지를 alert 창으로 표시
	                    alert(data.msg3);
	                } else {
	                    // 오류 메시지를 alert 창으로 표시
	                    alert(data.msg3);
	                }
	            },
	            error: function() {
	                // 서버 오류 메시지를 alert 창으로 표시
	                alert("서버 오류");
	            }
	        });
	    });
	    
	 // 버튼 클릭 시 서버에 핸드폰번호 업데이트 요청 보내기
	    $("#mobileNumberUpdate").click(function() {
	    	console.log("버튼클릭확인");
	        var userId = "${user.userId}"; // 사용자 아이디
	        var mobileNumber = $("#mobileNumber").val(); // 입력된 이름
	        var mobileNumberPattern = /^[0-9]{10,11}$/; // 전화번호는 10자 또는 11자의 숫자만 허용
	     // 전화번호 확인
	        if (mobileNumber == "") {
	            alert("전화번호를 입력하세요.");
	            $("#mobileNumber").focus();
	            return;
	        }
	        if (!mobileNumberPattern.test(mobileNumber)) {
	            alert("전화번호는 10자 또는 11자의 숫자만 허용합니다.");
	            $("#mobileNumber").focus();
	            return;
	        }
	        $.ajax({
	            url: "${pageContext.request.contextPath}/mypage/updatemobilenumber",
	            type: "POST",
	            data: {
	                userId: userId,
	                mobileNumber: mobileNumber
	            },
	            success: function(data) {
	                if (data.status === 1) {
	                    // 성공 메시지를 alert 창으로 표시
	                    alert(data.msg4);
	                } else if (data.status === -1) {
	                    // 중복 메시지를 alert 창으로 표시
	                    alert(data.msg4);
	                } else {
	                    // 오류 메시지를 alert 창으로 표시
	                    alert(data.msg4);
	                }
	            },
	            error: function() {
	                // 서버 오류 메시지를 alert 창으로 표시
	                alert("서버 오류");
	            }
	        });
	    });
	 
	 
	 
	});
	
	
	var addressRegist=()=>{
		var formData = $('#addressForm').serialize();
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/mypage/address/regist/do",
			data:formData,
			success: function(data){
				var item;
				alert("주소 등록에 성공했습니다.");
				var html="<select id='addresses' items='${userAddress}'>";
				for(var i=0; i<data.length; i++){
				item=data[i];
				html+="<option value="+item.roadAddress+","+item.detailAddress+">";
				html+=item.addressNickname+","+item.roadAddress+","+item.detailAddress+"</option>";
				}
				$("#addresses").replaceWith(html);
			},
			error: function(data){
				if($("#modalAddresses option").length > 8)
					alert("등록가능한 주소갯수를 초과하였습니다.");
				else
					alert("잘못된 접근입니다.");
			}
		});
	}
	
	var deleteAddress=()=>{
		var selectedOption = $("#addresses > option:selected").val();
		var addressParts = selectedOption.split(', ');
		var selectedOption = $("#modalAddresses option:selected").val();
		var addressParts = selectedOption.split(', ');
		var addressNo = addressParts[2];
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath}/mypage/address/delete",
			data: { addressNo: addressNo },
			success: function(data){
				if(data=='1')
					alert("주소를 삭제했습니다.");
				else
					alert("주소 삭제에 실패했습니다.");
				window.location.href="${pageContext.request.contextPath}/payment/pay";
			},
			error : (request,status,error)=>{
				console.log(request);
				console.log(status);
				console.log(error);
				alert("code:"+request.status+"\n"+"message"+request.responseText+"\n"+error+":error");
			}
		});
	}
	
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
	
	</script>
	
	
	
	<!-- Footer Section Begin -->
	<footer>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</footer>
	<!-- Footer Section End -->


	<!-- Js Plugins -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>