<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!--favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">

<style>
.container-box {
	position: relative;
	margin: 50px;
	padding: 0px;
	text-decoration: none;
	font-family: sans-serif;
	vertical-align: middle;
	min-height: 1500px;
}

body {
	background-image: #34495e;
}

/* 640 */
.joinForm {
	width: 700px;
	height: 400px;
	background-color: #FFFFFF;
	text-align: center;
	border-radius: 15px;
	margin: auto;
}

.joinForm h2 {
	text-align: center;
	margin: 30px;
}

.textForm {
	border-bottom: 2px solid #adadad;
	margin: 50px;
	padding: 10px 10px;
}

.id {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 35px;
	background: none;
}

.pw {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 35px;
	background: none;
}

.name {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 35px;
	background: none;
}

.email {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 35px;
	background: none;
}

.mail-check-input {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 35px;
	background: none;
}

.nickname {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 35px;
	background: none;
}

.cellphoneNo {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 35px;
	background: none;
}

.btn {
	position: relative;
	left: 40%;
	transform: translateX(-50%);
	margin-bottom: 40px;
	width: 80%;
	height: 40px;
	background: linear-gradient(125deg, #81ecec, #6c5ce7, #81ecec);
	background-position: left;
	background-size: 200%;
	color: white;
	font-weight: bold;
	border: none;
	cursor: pointer;
	transition: 0.4s;
	display: inline;
}

.btn:hover {
	background-position: right;
}

.btn-postcode {
	background-color: #3498db;
	color: #fff;
	border: none;
	padding: 5px;
	cursor: pointer;
	border-radius: 5px;
	width: 200px;
	margin-left: 5px;
}

.btn-email {
	background-color: #3498db;
	color: #fff;
	border: none;
	padding: 5px;
	cursor: pointer;
	border-radius: 5px;
	width: 200px;
	margin-left: 5px;
}

.btn-mail-check-input {
	background-color: #3498db;
	color: #fff;
	border: none;
	padding: 5px;
	cursor: pointer;
	border-radius: 5px;
	width: 200px;
	margin-left: 5px;
}

.btn-id {
	background-color: #3498db;
	color: #fff;
	border: none;
	padding: 5px;
	cursor: pointer;
	border-radius: 5px;
	width: 200px;
	margin-left: 5px;
}

.btn-postcode:hover {
	background-color: #2980b9;
}

.btn-email:hover {
	background-color: #2980b9;
}

.btn-id:hover {
	background-color: #2980b9;
}

.btn-mail-check-input:hover {
	background-color: #2980b9;
}



</style>

<!-- Css Styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/nice-select.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css">
</head>
<body>

	<!-- header start -->
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<!-- header end -->


	<div class="container-box">

		<form action="${pageContext.request.contextPath}/signup" method="POST" class="joinForm" onsubmit="return Validation();">
			<div class="textForm">
				<span style="display: flex;">
				 <input name="userId" type="text" class="id" placeholder="아이디" id="userId" required="required">
					<button type="button" class="btn-id" id="checkDuplicateBtn">중복확인</button>
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;">
				 <input name="password" type="password" class="pw" placeholder="비밀번호" id="password" required="required">
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;">
				 <input name="loginPwConfirm" type="password" class="pw" id="passwordVerification" placeholder="비밀번호 확인" required="required">
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;"> <input name="email" type="text" class="email" placeholder="이메일" id="email" required="required">
					<button type="button" class="btn-email" id="mail-Check-Btn">인증번호 요청</button>
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;">
				 <input name="certification" type="text" class="mail-check-input" id="verificationCode" placeholder="인증번호 확인" required="required">
					<button type="button" class="btn-mail-check-input" id="verify-button">인증번호 확인</button>
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;">
				 <input name="name" type="text" class="name" placeholder="이름" id="name" required="required">
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;"> 
					<input name="nickname" type="text" class="nickname" placeholder="닉네임" id="nickname" required="required">
					<button type="button" class="btn-id" id="checkNickName">중복확인</button>
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;">
				 <input name="mobileNumber" type="text" class="cellphoneNo" id="mobileNumber" placeholder="전화번호" required="required">
				 <button type="button" class="btn-id" id="checkMobileNumber">중복확인</button>
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;">
				 <input type="text" name="postCode" id="sample4_postcode" placeholder="우편번호" required="required" class="cellphoneNo">
					<button type="button" class="btn-postcode" onclick="sample4_execDaumPostcode()">우편번호 찾기</button>
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;">
				 <input type="text" name="roadAddress" id="sample4_roadAddress" placeholder="도로명주소" class="cellphoneNo" required="required">
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;">
				 <input type="text" name="address" id="sample4_jibunAddress" placeholder="지번주소" class="cellphoneNo" required="required">
				  <span id="guide" style="color: #999; display: none"></span>
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;">
				 <input type="text" name="detailAddress" id="sample4_detailAddress" placeholder="상세주소" class="cellphoneNo" required="required">
				</span>
			</div>
			<div class="textForm">
				<span style="display: flex;">
				 <input type="text" name="addressNickname" id="sample4_detailAddress" placeholder="주소별칭" class="cellphoneNo" required="required">
				</span>
			</div>
			<div>
			<!-- 구 선택 드롭다운 -->
			<label for="selectedGu">구 선택:</label>
			 <select name="selectedGu" id="selectedGu" onchange="updateDongDropdown()" required="required">
				<option value="">구를 선택하세요</option>
				<c:forEach items="${guList}" var="gu">
					<option value="${gu.guId}">${gu.guName}</option>
				</c:forEach>
			</select>
			<!-- 동 선택 드롭다운 -->
			<label for="selectedDong">동 선택:</label>
			 <select name="dongId" id="selectedDong" required="required">
				<option value="">동을 선택하세요</option>
				<c:forEach items="${dongList}" var="dong">
					<option value="${dong.dongId}" data-gu="${dong.guId}">${dong.dongName}</option>
				</c:forEach>
			</select> 
			</div>
			<input type="submit" class="btn" value="J O I N" />
		</form>
	</div>

	<!-- Footer Section Begin -->
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	<!-- Footer Section End -->

</body>

<!-- Js Plugins -->
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<%-- <script
	src="${pageContext.request.contextPath}/resources/js/jquery.nice-select.min.js"></script> --%>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery.slicknav.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/mixitup.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
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

						/* // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
						 if (roadAddr !== '') {
							document.getElementById("sample4_extraAddress").value = extraRoadAddr;
						} else {
							document.getElementById("sample4_extraAddress").value = '';
						}  */
						 
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
<script>
var code;
var duplicateChecked = false;
var verificationChecked = false;
var buttonNickName = false;
var buttonMobileNumber = false;


$('#mail-Check-Btn').click(function() {
    const email = $('#email').val(); // 이메일 주소값 얻어오기
    console.log('완성된 이메일 : ' + email); // 이메일 확인
    const checkInput = $('.mail-check-input'); // 인증번호 입력하는 곳
    /* let code; */
	var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; 
	
	if (email === "") {
        alert("이메일을 입력하세요.");
        return;
    }
	
	if (!emailPattern.test(email)) {
        alert("올바른 이메일 주소 형식이 아닙니다.");
        email.focus();
        return ;
    }
	
	alert('인증번호가 전송되었습니다.');
	
    $.ajax({
        type: 'get',
        url: '${pageContext.request.contextPath}/mailcheck', // 수정된 URL
        data: { email: email }, // 이메일을 데이터로 전달
        success: function(data) {
            /* checkInput.prop('disabled', false); */
            code = data;
            
        }
    }); // end ajax
    
});
$('#verify-button').click(function () {
    console.log("인증 및 중복 확인 버튼 클릭 확인");

    var email = $("#email").val();
    var inputCode = $('#verificationCode').val();
    var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // 이메일 주소 형식

    if (email === "") {
        alert("이메일을 입력하세요.");
        return;
    }

    if (inputCode === "") {
        alert("인증번호를 입력하세요.");
        return;
    }

    

    var url = "${pageContext.request.contextPath}/checkemail"; // 이메일 중복 확인 엔드포인트 URL 수정

    // AJAX를 사용하여 서버에 이메일 중복 확인 요청을 보냄
    $.ajax({
        url: url,
        type: "post",
        data: { email: email },
        success: function (data) {
            if (data !== "") {
                alert("이미 사용 중인 이메일 주소입니다.");
            } else {
                // 이메일 중복 확인이 성공한 경우, 인증번호 확인 수행
                verifyCode(inputCode);
            }
        },
        error: function (error) {
            console.error("중복 확인 중 오류 발생:", error);
        }
    });
});
function verifyCode(inputCode) {
    if (code === inputCode) {
        alert('사용 가능한 이메일입니다 !! 인증번호 확인 완료');
        verificationChecked = true;
        // 인증번호 확인이 성공한 경우, 원하는 동작 수행
    } else {
        alert('인증번호를 다시 확인해주세요.');
    }
}



    // 유효성 검사 메서드
    function Validation() {
        // 변수에 저장
        var userId = document.getElementById("userId");
        var password = document.getElementById("password");
        var loginPwConfirm = document.getElementById("loginPwConfirm");
        var email = document.getElementById("email");
        var name = document.getElementById("name");
        var nickname = document.getElementById("nickname");
        var mobileNumber = document.getElementById("mobileNumber");
        var postCode = document.getElementById("sample4_postcode");
        var roadAddress = document.getElementById("sample4_roadAddress");
        var address = document.getElementById("sample4_jibunAddress");
        var detailAddress = document.getElementById("sample4_detailAddress");
        var addressNickname = document.getElementById("addressNickname");
        var selectedGu = document.getElementById("selectedGu").value;
        var selectedDong = document.getElementById("selectedDong").value;

		
        // 정규식 패턴 정의
        var idPattern = /^[a-zA-Z0-9]{4,10}$/; // 아이디는 4~10자의 영문 대소문자와 숫자만 허용
        var passwordPattern = /^[a-zA-Z0-9!@#$%^&*()_+]{6,20}$/; // 비밀번호는 6~20자의 영문 대소문자, 숫자, 특수문자 허용
        var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // 이메일 주소 형식
        var namePattern = /^[가-힣a-zA-Z]{2,30}$/; // 이름은 2~30자의 한글 또는 영문 허용
        var nicknamePattern = /^[a-zA-Z0-9ㄱ-ㅎ가-힣]{4,30}$/; // 닉네임은 4~30자의 영문 대소문자, 숫자, 한글 허용
        var mobileNumberPattern = /^\d{10,11}$/; // 전화번호는 10자 또는 11자의 숫자만 허용
        var postCodePattern = /^[0-9]{5}$/; // 우편번호는 5자리 숫자만 허용
		
       
       	if(duplicateChecked == false) {
       		alert("아이디 중복확인을 먼저 해주세요.")
       		return false;
       	};
        
    	if(verificationChecked == false) {
       		alert("이메일 인증을 먼저 해주세요.")
       		return false;
       	};
       	
    	if(duplicateChecked == false) {
       		alert("닉네임 중복확인을 먼저 해주세요.")
       		return false;
       	};
       	
    	if(buttonMobileNumber == false) {
       		alert("핸드폰 중복확인을 먼저 해주세요.")
       		return false;
       	};
        
        if (duplicateChecked && verificationChecked && buttonNickName && buttonMobileNumber){

        // 비밀번호와 비밀번호 확인란 값이 일치하지 않을 때
        const password1 = $('#password').val();
        const confirmPassword = $('#passwordVerification').val();
        console.log(password1);
        console.log(confirmPassword);
        if (password1 != confirmPassword) {
            alert('비밀번호와 비밀번호 확인이 일치하지 않습니다.');
            return false;
        }
	
        // 아이디 확인
        if (userId.value == "") {
            alert("아이디를 입력하세요.");
            userId.focus();
            return false;
        }
        if (!idPattern.test(userId.value)) {
            alert("아이디는 4~10자의 영문 대소문자와 숫자만 허용합니다.");
            userId.focus();
            return false;	
        }

        // 비밀번호 확인
        if (password.value == "") {
            alert("비밀번호를 입력하세요.");
            password.focus();
            return false;
        }
        if (!passwordPattern.test(password.value)) {
            alert("비밀번호는 6~20자의 영문 대소문자, 숫자, 특수문자를 허용합니다.");
            password.focus();
            return false;
        }

        // 이메일 확인
        if (email.value == "") {
            alert("이메일을 입력하세요.");
            email.focus();
            return false;
        }
        if (!emailPattern.test(email.value)) {
            alert("올바른 이메일 주소 형식이 아닙니다.");
            email.focus();
            return false;
        }

        // 이름 확인
        if (name.value == "") {
            alert("이름을 입력하세요.");
            name.focus();
            return false;
        }
        if (!namePattern.test(name.value)) {
            alert("이름은 2~15자의 한글 또는 영문만 허용합니다.");
            name.focus();
            return false;
        }

        // 닉네임 확인
        if (nickname.value == "") {
            alert("닉네임을 입력하세요.");
            nickname.focus();
            return false;
        }
        if (!nicknamePattern.test(nickname.value)) {
            alert("닉네임은 4~30자의 영문 대소문자, 숫자, 한글만 허용합니다.");
            nickname.focus();
            return false;
        }
        
     // 전화번호 확인
        if (mobileNumber.value == "") {
            alert("전화번호를 입력하세요.");
            mobileNumber.focus();
            return false;
        }
        if (!mobileNumberPattern.test(mobileNumber.value)) {
            alert("전화번호는 10자 또는 11자의 숫자만 허용합니다.");
            mobileNumber.focus();
            return false;
        }

        // 우편번호 확인
        if (postCode.value == "") {
            alert("우편번호를 입력하세요.");
            postCode.focus();
            return false;
        }
        if (!postCodePattern.test(postCode.value)) {
            alert("우편번호는 5자리 숫자만 허용합니다.");
            postCode.focus();
            return false;
        }
     // 선택되지 않은 경우, 경고 메시지를 표시하고 제출을 막습니다.
        if (selectedGu === "" || selectedDong === "") {
            alert("구와 동을 선택하세요.");
            return false;
        }



        // 유효성 문제가 없을 시 폼 제출
         document.joinForm.submit();
        /* return true; */
        
        }
        else {
            // 중복 확인 또는 인증 번호 확인이 실패한 경우 사용자에게 알림
            alert('중복확인과 인증번호 확인을 먼저 해주세요.');
           	return false;
        }
    }
    
// 중복 확인을 수행하는 함수
$("#checkDuplicateBtn").click(function () {
    	console.log("버튼클릭확인");
        // 중복 확인할 아이디 값을 가져옴
        var userId = $("#userId").val();
        var idPattern = /^[a-zA-Z0-9]{4,10}$/;
        
        
        if (userId === "") {
            alert("아이디를 입력하세요.");
            return;
        }
        if (!idPattern.test(userId)) {
            alert("아이디는 4~10자의 영문 대소문자와 숫자만 허용합니다.");
            userId.focus();
            return;	
        }
        
        
        // 서버에 보낼 요청 URL (실제로는 서버 엔드포인트에 맞게 수정해야 함)
        var apiUrl = "${pageContext.request.contextPath}/checkid"; // 예시 URL, 실제로는 서버의 URL로 수정
        
     // AJAX를 사용하여 서버에 중복 확인 요청 보냄
        $.ajax({
            url: apiUrl,
            type: "post",
            data: { userId: userId },
            success: function (data) {
            	console.log(data);
            	if (data !== ""){
            		 // 아이디가 중복된 경우 처리 (예: 메시지 표시)
            		alert("이미 사용 중인 아이디입니다.");
            	}else {
            		// 아이디가 중복되지 않은 경우 처리 (예: 메시지 표시)
                    alert("사용 가능한 아이디입니다.");
                    duplicateChecked = true;
            	}
            },
            error: function (error) {
                console.error("중복 확인 중 오류 발생:", error);
            }
        });
    });
    
$("#checkNickName").click(function () {
    	console.log("버튼클릭확인");
        // 중복 확인할 아이디 값을 가져옴
        var nickname = $("#nickname").val();
        var nicknamePattern = /^[a-zA-Z0-9ㄱ-ㅎ가-힣]{4,30}$/;
        
        if (nickname === "") {
            alert("닉네임을 입력하세요.");
            return;
        }
        if (!nicknamePattern.test(nickname)) {
            alert("닉네임은 4~30자의 영문 대소문자, 숫자, 한글만 허용합니다.");
            nickname.focus();
            return;
        }
        // 서버에 보낼 요청 URL (실제로는 서버 엔드포인트에 맞게 수정해야 함)
        var url = "${pageContext.request.contextPath}/checknickname"; // 예시 URL, 실제로는 서버의 URL로 수정
        
     // AJAX를 사용하여 서버에 중복 확인 요청 보냄
        $.ajax({
            url: url,
            type: "post",
            data: { nickname: nickname },
            success: function (name) {
            	console.log(name);
            	if (name !== ""){
            		 // 아이디가 중복된 경우 처리 (예: 메시지 표시)
            		alert("이미 사용 중인 닉네임입니다.");
            	}else {
            		// 아이디가 중복되지 않은 경우 처리 (예: 메시지 표시)
                    alert("사용 가능한 닉네임입니다.");
                    buttonNickName = true;
            	}
            },
            error: function (error) {
                console.error("중복 확인 중 오류 발생:", error);
            }
        });
    });
$("#checkMobileNumber").click(function () {
	console.log("버튼클릭확인");
    // 중복 확인할 아이디 값을 가져옴
    var mobileNumber = $("#mobileNumber").val();
    var mobileNumberPattern = /^\d{10,11}$/; // 전화번호는 10자 또는 11자의 숫자만 허용
    if (mobileNumber === "") {
        alert("핸드폰번호를 입력하세요.");
        return;
    }
    
    if (!mobileNumberPattern.test(mobileNumber)) {
        alert("전화번호는 10자 또는 11자의 숫자만 허용합니다.");
        mobileNumber.focus();
        return;
    }
    
    // 서버에 보낼 요청 URL (실제로는 서버 엔드포인트에 맞게 수정해야 함)
    var url = "${pageContext.request.contextPath}/checkmn"; // 예시 URL, 실제로는 서버의 URL로 수정
    
 // AJAX를 사용하여 서버에 중복 확인 요청 보냄
    $.ajax({
        url: url,
        type: "post",
        data: { mobileNumber: mobileNumber },
        success: function (data) {
        	console.log(data);
        	if (data !== ""){
        		 // 아이디가 중복된 경우 처리 (예: 메시지 표시)
        		alert("이미 사용 중인 핸드폰 번호입니다.");
        	}else {
        		// 아이디가 중복되지 않은 경우 처리 (예: 메시지 표시)
                alert("사용 가능한 핸드폰 번호입니다.");
                buttonMobileNumber = true;
        	}
        },
        error: function (error) {
            console.error("중복 확인 중 오류 발생:", error);
        }
    });
});    
    var msg = '${msg}';
	if(msg ){
		alert(msg);
	}
	
	
	
	</script>
<script>
function updateDongDropdown() {
    const selectedGu = document.getElementById("selectedGu").value;
    const dongDropdown = document.getElementById("selectedDong");
	
    // 모든 동 옵션 숨기기
    Array.from(dongDropdown.options).forEach(option => {
        option.style.display = "none";
    });

    // 선택한 구에 맞는 동 옵션 보이기
    Array.from(dongDropdown.options).forEach(option => {
        if (option.getAttribute("data-gu") === selectedGu || option.value === "") {
            option.style.display = "block";
        }
    });
}

// 페이지 로드 시 호출하여 초기화
updateDongDropdown();
</script>
</html>