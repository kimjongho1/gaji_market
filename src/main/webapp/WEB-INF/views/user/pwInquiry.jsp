<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 재설정</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sign/sign.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sign/header_footer.css" type="text/css">

<!--favicon  -->
	<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
	<script>
    	
    	</script>
</head>
<body>
    <header width="100%" id="header">
    			<div class="row">
					<div class="header__logo">
						<a href="./"><img
							src="${pageContext.request.contextPath}/resources/img/gaji_logo.png"
							alt="GaJi" height="70" width="170"></a>
					</div>
		<div class="container">
				
			<div class="row">
			
					
									
					<a class="menu-item " href="./idInquiry"> <h1>아이디 찾기</h1> </a>
					
					
					<div>
					
					<a class="menu-item active" href="./pwInquiry"> <h1>비밀번호 찾기</h1> </a>
					</div>
			</div>
		</div>
		</div>

    </header>
    
    <div class="container" style="height: 900px;">  
        <form id="contact" action="${pageContext.request.contextPath}/pwInquiry" method="post" onsubmit="return Validation();">
            <div id="search">
                <h2>비밀번호 재설정</h2>
            </div>

        <h4>아이디</h4>
        <fieldset>
            <input placeholder="Your id" type="text" tabindex="1" name="userId" id="userId" autofocus>
        </fieldset>
        <h4>이름</h4>
        <fieldset>
            <input placeholder="Your name" type="text" tabindex="2" name="name" id="name" >
        </fieldset>
        <h4 style="display: inline-block;">이메일 주소</h4> <button type="button" class="ibtn" id="mail-Check-Btn">인증번호 발송</button>
          <fieldset>
            <input placeholder="Your Email Address" type="email" id="email" name="email" tabindex="3" >
          </fieldset>
        <h4 style="display: inline-block;">인증번호 확인</h4> <button type="button" class="ibtn" id="btn-mail-check-input">인증 하기</button>
          <fieldset>
            <input placeholder="Your Email Verification Code" type="text" id="mail-check-input" tabindex="3" >
          </fieldset> 
		  <h4 style="display: inline-block;">새 비밀번호</h4>
          <fieldset>
            <input placeholder="Your New Password" type="password" id="password" name="password" tabindex="4"  >
          </fieldset>
		  <!-- 경고 -->
		  <h4>새 비밀번호 확인</h4>
          <fieldset>
			  <input placeholder="Verify Your New Password" type="password" id="loginPwConfirm" tabindex="5" >
			</fieldset>
			<!-- 경고 -->
			<fieldset>
            <button name="submit" type="submit" id="contact-submit" data-submit="...Sending">Submit</button>
          </fieldset>
        </form>
       
        
       </div> <!--divcon -->

        <script>
        let code;
        checkemailbutton = false;
        
     // 유효성 검사 메서드
        function Validation() {
        // 변수에 저장
        var userId = document.getElementById("userId");
        var password = document.getElementById("password");
        var emailcheck = document.getElementById("email");
        var name = document.getElementById("name");

        
        var idPattern = /^[a-zA-Z0-9]{4,10}$/; // 아이디는 4~10자의 영문 대소문자와 숫자만 허용
        var passwordPattern = /^[a-zA-Z0-9!@#$%^&*()_+]{6,20}$/; // 비밀번호는 6~20자의 영문 대소문자, 숫자, 특수문자 허용
        var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/; // 이메일 주소 형식
        var namePattern = /^[가-힣a-zA-Z]{2,30}$/; // 이름은 2~30자의 한글 또는 영문 허용
        
        if(checkemailbutton == true) {
        	 const password1 = $('#password').val();
             const confirmPassword = $('#loginPwConfirm').val();
             if (password1 !== confirmPassword) {
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

             // 비밀번호 일치여부
             if (loginPwConfirm.value !== password.value) {
                 alert("비밀번호와 확인 비밀번호가 일치하지 않습니다.");
                 loginPwConfirm.focus();
                 return false;
             }
             
          // 이메일 확인
             if (emailcheck.value == "") {
                 alert("이메일을 입력하세요.");
                 email.focus();
                 return false;
             }
             if (!emailPattern.test(emailcheck.value)) {
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
             
             return true;
             
        } else {
            // 중복 확인 또는 인증 번호 확인이 실패한 경우 사용자에게 알림
            alert('인증번호 확인을 먼저 해주세요.');
            return false;
        }
     };
     
        
        
        $('#mail-Check-Btn').click(function() {
            const email = $('#email').val(); // 이메일 주소값 얻어오기
            console.log('완성된 이메일 : ' + email); // 이메일 확인
            const checkInput = $('#mail-check-input'); // 인증번호 입력하는 곳
            /* let code; */

            $.ajax({
                type: 'get',
                url: '${pageContext.request.contextPath}/mailcheck', // 수정된 URL
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
        $('#btn-mail-check-input').click(function() {
            // 서버에서 받은 인증번호를 변수에 저장
            const inputCode = $('#mail-check-input').val(); // 입력한 인증번호를 가져옴
            if (code === inputCode) {
                alert('인증번호 확인 완료');
                checkemailbutton = true;
                // 인증번호 확인이 성공한 경우 원하는 동작 수행
            } else {
                alert('인증번호를 다시 확인해주세요.');
                // 인증번호 확인이 실패한 경우 사용자에게 알림
            }
        });
        var msg = '${msg}';
    	if(msg){
    		alert(msg);
    	}

        
        </script>
        
        <div id="footer">
		<ul class="guides fl">
		<li class="first"><a href="#" target="_blank" onclick="clickcr(this,'fot.ecommerce','','',event);">전자금융거래 이용약관</a></li>
		<li><a href="#" target="_blank" onclick="clickcr(this,'fot.privacy','','',event);">개인정보처리방침</a></li>
		<li><a href="#" target="_blank" onclick="clickcr(this,'fot.disclaimer','','',event);">책임의 한계와 법적고지</a></li>
		</ul>
		<address class="copyright">
		Copyright <em>©</em> <a href="#" target="_blank" onclick="clickcr(this,'fot.navercorp','','',event);"><strong>GaJi Corp.</strong></a> All Rights Reserved.
		</address>
		<ul class="guides fr">
		<li><a href="#" target="_blank" title="새창" onclick="clickcr(this,'fot.help','','',event);"> 회원정보 고객센터 </a></li>
		</ul>
	</div>
        
        
</body>
</html>