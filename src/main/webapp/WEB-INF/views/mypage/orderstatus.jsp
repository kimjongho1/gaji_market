<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매내역</title>
</head>

<body>
<table>
	<c:forEach var="safePurchaseInfo"  items="${safePurchaseList}">
		<tr>
		<th>거래상태</th>
				<td>
					<c:choose>
						<c:when test="${safePurchaseInfo.tradingStatus eq 1}">입금완료</c:when>
						<c:when test="${safePurchaseInfo.tradingStatus eq 2}">상품준비중</c:when>
						<c:when test="${safePurchaseInfo.tradingStatus eq 3}">배송중</c:when>
						<c:when test="${safePurchaseInfo.tradingStatus eq 4}">거래완료</c:when>
						<c:when test="${safePurchaseInfo.tradingStatus eq 5}">결제취소</c:when>
					</c:choose>
				</td>
		</tr>
		<tr><th>상품명:</th><td>${safePurchaseInfo.goodsTitle}</td></tr>
		<tr><th>가격:</th><td>${safePurchaseInfo.price}</td></tr>
		<tr><th>거래일자:</th><td>${safePurchaseInfo.tradingDate}</td></tr>
	</c:forEach>
</table>
</body>
</html>