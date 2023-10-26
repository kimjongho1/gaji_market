<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
  body {
    font-family: Arial, sans-serif;
  }

  h2 {
    background-color: #333;
    color: #fff;
    padding: 10px;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
  }

  table, th, td {
    border: 1px solid #ddd;
  }

  th, td {
    padding: 8px;
    text-align: left;
  }

  tr:nth-child(even) {
    background-color: #f2f2f2;
  }

  th {
    background-color: #333;
    color: #fff;
  }

  button {
    background-color: #333;
    color: #fff;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
  }

  button:hover {
    background-color: #555;
  }
</style>
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
                <tr onclick="ReportList('${user.userId}')">
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
	<button onclick="banListPage()">정지 유저 확인하기</button>
	<button onclick="mainPage()">메인페이지 이동</button>
    <script>
        function ReportList(userId) {
        	var url = "${pageContext.request.contextPath}/admin/reportlist?userId=" + userId;
            window.location.href = url;
        }
        function banListPage() {
            window.location.href = "${pageContext.request.contextPath}/admin/banlist";
          }

          function mainPage() {
            window.location.href = "${pageContext.request.contextPath}";
          }
        
    </script>
</body>
</html>