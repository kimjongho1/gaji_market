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
	<h2>정지된 회원정보 조회</h2>
	<table border="1">
		<thead>
			<tr>
				<th>정지 번호</th>
				<th>관리자 아이디</th>
				<th>정지된 아이디</th>
				<th>정지사유</th>
				<th>정지된 날짜</th>
				<th>유저 생성 날짜</th>
				<th>유저 활성화 상태</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" var="user">
				<tr onclick="userReportList('${user.bannedId}');">
					<td>${user.banNo}</td>
					<td>${user.adminId}</td>
					<td>${user.bannedId}</td>
					<td>${user.reasonForBlocking}</td>
					<td>${user.bandate}</td>
					<td>${user.usercreated}</td>
					<td>
						<c:choose>
							<c:when test="${user.enabled == 0}">정지</c:when>
							<c:when test="${user.enabled == 1}">활성화</c:when>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button onclick="userListPage()">유저 관리페이지 가기</button>
	<button onclick="goBack()">뒤로가기</button>
	<script>
    function userReportList(bannedId) {
        window.location.href = "${pageContext.request.contextPath}/admin/reportlist?userId=" + bannedId;
    }
    function goBack() {
        history.back();
    }
    function userListPage() {
    	 window.location.href = "${pageContext.request.contextPath}/admin";
    }
</script>
</body>
</html>