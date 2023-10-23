<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <c:set var="userList" value="${userList}" />
    <h2>관리자페이지 유저 리스트</h2>
    <table border="1">
        <thead>
            <tr>
                <th>유저 ID</th>
                <th>가지온도</th>
                <th>가입일</th>
                <th>상태</th>
                <th>안전 거래 수</th>
                <th>판매 상품 수</th>
                <th>신고 횟수</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userList}" var="user">
                <tr onclick="redirectToReportList('${user.userId}')">
                    <td>${user.userId}</td>
                    <td>${user.ratingScore}</td>
                    <td>${user.createdAt.substring(0, 19)}</td>
                    <td>${user.enabled == 1 ? 'Permission' : 'Ban'}</td>
                    <td>${user.safetradecount}</td>
                    <td>${user.sellgoods}</td>
                    <td>${user.reportcount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <script>
        function redirectToReportList(userId) {
        	var url = "${pageContext.request.contextPath}/admin/reportlist?userId=" + userId;
            window.location.href = url;
        }
    </script>
</body>
</html>