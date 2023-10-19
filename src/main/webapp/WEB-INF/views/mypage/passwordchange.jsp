<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>비밀번호 변경</h2>
    <form action="${pageContext.request.contextPath}/mypage/changepassword" method="post" onsubmit="return validateForm()">
    	<input type="hidden" name="userId" value="${userId}">
        <label>현재 비밀번호:</label>
        <input type="password" name="password" id="password" required><br>
        
        <label for="newPassword">새 비밀번호:</label>
        <input type="password" name="newPassword" id="newPassword" required><br>
        
        <label for="confirmPassword">새 비밀번호 확인:</label>
        <input type="password" name="confirmPassword" id="confirmPassword" required><br>
        
        <input type="submit" value="변경">
        </form>
        <script>
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
</body>
</html>