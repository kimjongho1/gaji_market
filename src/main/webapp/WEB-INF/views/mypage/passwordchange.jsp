<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>

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
    
    section {
	
	min-height: 1200px;
	
	}
	
	.pline{
	
    border-bottom: 1px solid #bbb1d6;
   	margin: 10px;
	}
	
	.pline input {
	
	border: 0;
	background-color: #f1f1f1;
	min-width: 500px;
	margin-right: 14px;
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
	margin: 20px 20px 0px;
	
	}
	
	.btn-modi:hover {
	
	background-color: #6a598f !important;
	}
	
	.btn-modi:active {
  	background-color: #5a4978 !important; 
}
	
	
	</style>
</head>
<body>
	
	<header>
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</header>
	<jsp:include page="/WEB-INF/views/mypage/side.jsp"></jsp:include>

	<section>
	
<div class="content">
	
    <form action="${pageContext.request.contextPath}/mypage/changepassword" method="post" onsubmit="return validateForm()">
    <div class="pline">
    <span class="row flex justify-content-between align-items-center">
    	<input type="hidden" name="userId" value="${userId}">
        <label>현재 비밀번호:</label>
        <input type="password" name="password" id="password" required>
    </span>
    </div>
    <div class="pline">
    <span class="row flex justify-content-between align-items-center">
        <label for="newPassword">새 비밀번호:</label>
        <input type="password" name="newPassword" id="newPassword" required>
    </span>
    </div>
    <div class="pline">
    <span class="row flex justify-content-between align-items-center">
        <label for="confirmPassword">새 비밀번호 확인:</label>
        <input type="password" name="confirmPassword" id="confirmPassword" required>
    </span>
    </div>
        <div class="row flex justify-content-end">
        <input type="submit" class="btn-modi" value="변경">
        </div>
        </form>
</div>
</section>

	<!-- Footer Section Begin -->
	<footer>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</footer>
	<!-- Footer Section End -->


        <script>
        
        console.log("${userId}");
        
        function validateForm() {
            var currentPassword = document.getElementById("password").value;
            var newPassword = document.getElementById("newPassword").value;
            var confirmPassword = document.getElementById("confirmPassword").value;

            var passwordPattern = /^[a-zA-Z0-9!@#$%^&*()_+]{6,20}$/; // 비밀번호는 6~20자의 영문 대소문자, 숫자, 특수문자 허용
            
            if (newPassword !== confirmPassword) {
                alert("새 비밀번호와 새 비밀번호 확인이 일치하지 않습니다.");
                return false;
            }

            if (currentPassword.trim() === "") {
                alert("비밀번호를 입력하세요.");
                document.getElementById("password").focus();
                return false;
            }

            if (!passwordPattern.test(currentPassword) || !passwordPattern.test(newPassword)) {
                alert("비밀번호는 6~20자의 영문 대소문자, 숫자, 특수문자를 허용합니다.");
                document.getElementById("newPassword").focus();
                return false;
            }

            return true;
        }
        
        var msg = '${msg}';
    	if(msg){
    		alert(msg);
    	}
    	
    	
        </script>

	<!-- Js Plugins -->
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        
</body>
</html>