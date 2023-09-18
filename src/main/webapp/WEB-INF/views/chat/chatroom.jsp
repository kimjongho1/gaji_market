<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>chatting room</title>
</head>
<body>
	<textarea rows="5" cols="30" id="msgArea">
	</textarea>
	<!-- 채팅 내용이 올라갈 화면 -->
	<br> 메시지 :
	<input type="text" id="message">
	<!-- 메시지를 보내는 부분 -->
	<br> 상대 아이디 :
	<input type="text" id="sellerId">
	<!-- TODO 김종호 유저 아이디가 자동 할당되게 수정해야함 -->
	<br>
	<input type="button" value="전송" id="btnSend">
</body>
</html>