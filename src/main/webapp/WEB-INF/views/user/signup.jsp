<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
* {
	margin: 0px;
	padding: 0px;
	text-decoration: none;
	font-family: sans-serif;
}

body {
	background-image: #34495e;
}

.joinForm {
	position: absolute;
	width: 400px;
	height: 400px;
	padding: 30px, 20px;
	background-color: #FFFFFF;
	text-align: center;
	top: 40%;
	left: 50%;
	transform: translate(-50%, -50%);
	border-radius: 15px;
}

.joinForm h2 {
	text-align: center;
	margin: 30px;
}

.textForm {
	border-bottom: 2px solid #adadad;
	margin: 30px;
	padding: 10px 10px;
}

.id {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 25px;
	background: none;
}

.pw {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 25px;
	background: none;
}

.name {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 25px;
	background: none;
}

.email {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 25px;
	background: none;
}

.nickname {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 25px;
	background: none;
}

.cellphoneNo {
	width: 100%;
	border: none;
	outline: none;
	color: #636e72;
	font-size: 16px;
	height: 25px;
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
	padding: 5px 10px;
	cursor: pointer;
	border-radius: 5px;
	width:150px;
	margin-left: 5px;
}
.btn-email {
	background-color: #3498db;
	color: #fff;
	border: none;
	padding: 5px 10px;
	cursor: pointer;
	border-radius: 5px;
	width:150px;
	margin-left: 5px;
}
.btn-id {
	background-color: #3498db;
	color: #fff;
	border: none;
	padding: 5px 10px;
	cursor: pointer;
	border-radius: 5px;
	width:150px;
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
</style>
</head>
<body>
	<form action=signup method="POST" class="joinForm"
		onsubmit="return Validation(); return false;">

		<div class="textForm">
			<span style="display: flex;">
				<input name="userId" type="text" class="id" placeholder="아이디" id="userId"
				required="required">
				<button type="button" class="btn-id"
				id="checkDuplicateBtn">중복확인</button>
			</span>
		</div>
		<div class="textForm">
			<input name="password" type="password" class="pw" placeholder="비밀번호" id="password"
				required="required">
		</div>
		<div class="textForm">
			<input name="loginPwConfirm" type="password" class="pw"
				placeholder="비밀번호 확인" required="required">
		</div>
		<div class="textForm">
			<span style="display: flex;">
				<input name="email" type="text" class="email" placeholder="이메일" id="email"
				required="required">
				<button type="button" class="btn-email" id="mail-Check-Btn"
				>인증번호 요청</button>
			</span>
		</div>
		<div class="textForm">
			<span style="display: flex;">
				<input name="certification" type="text" class="mail-check-input" id="verificationCode"
					placeholder="인증번호 확인" required="required">
				<button type="button" class="btn" id="verify-button">인증번호 확인</button>
			</span>
		</div>
		<div class="textForm">
			<input name="name" type="text" class="name" placeholder="이름" id="name"
				required="required">
		</div>
		<div class="textForm">
			<input name="nickname" type="text" class="nickname" placeholder="닉네임" id="nickname"
				required="required">
		</div>
		<div class="textForm">
			<input name="mobileNumber" type="text" class="cellphoneNo" id="mobileNumber"
				placeholder="전화번호" required="required">
		</div>
		<div class="textForm">
			<span style="display: flex;">
			<input type="text" name="postCode" id="sample4_postcode"
				placeholder="우편번호" required="required" class="cellphoneNo">
			<button type="button" class="btn-postcode"
				onclick="sample4_execDaumPostcode()">우편번호 찾기</button>
				</span>
		</div>
		<br>
		<div class="textForm">
			<input type="text" name="roadAddress" id="sample4_roadAddress"
				placeholder="도로명주소" class="cellphoneNo">
		</div>
		<div class="textForm">
			<input type="text" name="address" id="sample4_jibunAddress"
				placeholder="지번주소" class="cellphoneNo"> <span id="guide"
				style="color: #999; display: none"></span>
		</div>
		<div class="textForm">
			<input type="text" name="detailAddress" id="sample4_detailAddress"
				placeholder="상세주소" class="cellphoneNo">
		</div>
		<div class="textForm">
			<input type="text" name="addressNickname" id="sample4_detailAddress"
				placeholder="주소별칭" class="cellphoneNo">
		</div>
		<input type="submit" onclick="Validation()" class="btn" value="J O I N" />
	</form>
</body>
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
<script>
let code;


$('#mail-Check-Btn').click(function() {
    const email = $('#email').val(); // 이메일 주소값 얻어오기
    console.log('완성된 이메일 : ' + email); // 이메일 확인
    const checkInput = $('.mail-check-input'); // 인증번호 입력하는 곳
    /* let code; */

    $.ajax({
        type: 'get',
        url: '/gaji/user/mailcheck', // 수정된 URL
        data: { email: email }, // 이메일을 데이터로 전달
        success: function(data) {
            console.log("data: " + data);
            checkInput.prop('disabled', false);
            code = data;
            alert('인증번호가 전송되었습니다.');
        }
    }); // end ajax
    
});

//인증번호 비교
$('#verify-button').click(function() {
    // 서버에서 받은 인증번호를 변수에 저장
    const inputCode = $('#verificationCode').val(); // 입력한 인증번호를 가져옴

    if (code === inputCode) {
        alert('인증번호 확인 완료');
        // 인증번호 확인이 성공한 경우 원하는 동작 수행
    } else {
        alert('인증번호를 다시 확인해주세요.');
        // 인증번호 확인이 실패한 경우 사용자에게 알림
    }
});

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

        // 정규식 패턴 정의
        var idPattern = /^[a-zA-Z0-9]{4,10}$/; // 아이디는 4~10자의 영문 대소문자와 숫자만 허용
        var passwordPattern = /^[a-zA-Z0-9!@#$%^&*()_+]{6,20}$/; // 비밀번호는 6~20자의 영문 대소문자, 숫자, 특수문자 허용
        var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // 이메일 주소 형식
        var namePattern = /^[가-힣a-zA-Z]{2,30}$/; // 이름은 2~30자의 한글 또는 영문 허용
        var nicknamePattern = /^[a-zA-Z0-9ㄱ-ㅎ가-힣]{4,30}$/; // 닉네임은 4~30자의 영문 대소문자, 숫자, 한글 허용
        var mobileNumberPattern = /^[0-9]{10,11}$/; // 전화번호는 10자 또는 11자의 숫자만 허용
        var postCodePattern = /^[0-9]{5}$/; // 우편번호는 5자리 숫자만 허용


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

        // 비밀번호 확인
        if (loginPwConfirm.value !== password.value) {
            alert("비밀번호와 확인 비밀번호가 일치하지 않습니다.");
            loginPwConfirm.focus();
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



        // 유효성 문제가 없을 시 폼 제출
        document.joinForm.submit();
    }
    
    // 중복 확인을 수행하는 함수
    $("#checkDuplicateBtn").click(function () {
    	console.log("버튼클릭확인");
        // 중복 확인할 아이디 값을 가져옴
        var userId = $("#userId").val();

        // 서버에 보낼 요청 URL (실제로는 서버 엔드포인트에 맞게 수정해야 함)
        var apiUrl = "checkid"; // 예시 URL, 실제로는 서버의 URL로 수정

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
            	}
            },
            error: function (error) {
                console.error("중복 확인 중 오류 발생:", error);
            }
        });
    });
    var msg = '${msg}';
	if(msg){
		alert(msg);
	}
</script>

</html>