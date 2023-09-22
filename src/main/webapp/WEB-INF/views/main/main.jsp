<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/main">로고</a>
<a href="<%=request.getContextPath()%>/goods/board">상품 게시판</a>
<a href="<%=request.getContextPath()%>/chat">1:1 채팅</a>

<form action="<%=request.getContextPath()%>/goods/board" method="get"> <!-- 중고물품 검색창 -->
	<input type="text" name="searchWord">
</form>

<c:choose>
    <c:when test="${not empty userId}">
        <a href="<%=request.getContextPath()%>/mypage/keepusers">모아보기</a>
        <a href="<%=request.getContextPath()%>/mypage/keepuseds">찜</a>
        <a href="<%=request.getContextPath()%>/mypage">마이페이지</a>
        <a href="<%=request.getContextPath()%>/notice">알림 ${notificationCount}</a>
        <a href="<%=request.getContextPath()%>/logout">로그아웃</a>
    </c:when>
    <c:otherwise>
        <a href="<%=request.getContextPath()%>/login">로그인</a>
    </c:otherwise>
</c:choose>

</body>
</html>