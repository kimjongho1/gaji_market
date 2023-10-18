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
    <form action="${pageContext.request.contextPath}/mypage/changepassword" method="post">
    	<input type="hidden" name="userId" value="${userId}">
        <label>현재 비밀번호:</label>
        <input type="password" name="password" id="password" required><br>
        
        <label for="newPassword">새 비밀번호:</label>
        <input type="password" name="newpassword" id="newpassword" required><br>
        
        <label for="confirmPassword">새 비밀번호 확인:</label>
        <input type="password" name="confirmPassword" id="confirmPassword" required><br>
        
        <input type="submit" value="변경">
        </form>
</body>
</html>