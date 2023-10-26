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
	<h2>유저 신고 리스트</h2>
	<table border="1">
		<thead>
			<tr>
				<th>상품 넘버</th>
				<th>사용자 ID</th>
				<th>신고자 ID</th>
				<th>신고 카테고리</th>
				<th>신고된 날짜</th>
				<th>검토 여부</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userReportList}" var="report">
				<tr>
					<td onclick="sendGoods('${report.refId}')">${report.refId}</td>
					<td onclick="sendUser('${report.refId}')">${report.userId}</td>
					<td onclick="sendUser('${report.refId}')">${report.reporterId}</td>
					<td onclick="sendUser('${report.refId}')"><c:choose>
							<c:when test="${report.reportCategory eq 1}">광고</c:when>
							<c:when test="${report.reportCategory eq 2}">욕설/비방</c:when>
							<c:when test="${report.reportCategory eq 3}">음란물</c:when>
							<c:when test="${report.reportCategory eq 4}">사기</c:when>
							<c:when test="${report.reportCategory eq 5}">기타</c:when>
						</c:choose></td>
					<td onclick="sendUser('${report.refId}')">${report.createdAt.substring(0, 16)}</td>
					<td onclick="sendUser('${report.refId}')">${report.approvalStatus}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button onclick="goBack()">뒤로가기</button>
	<script>
	function goBack() {
        history.back();
    }
		function sendUser(refId) {
			var url = "${pageContext.request.contextPath}/admin/report/get?refId=" + refId;
            window.location.href = url;
		}
		
		function sendGoods(refId){
			var url = "${pageContext.request.contextPath}/goods/get?goodsId=" + refId;
			window.location.href = url;
		}
	</script>
</body>
</html>