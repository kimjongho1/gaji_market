<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${request.getContextPath()}/payment/cancel" method="POST">
	<input type="hidden" name=transactionId value="${safePurchaseInfoDto.transactionId}"/>
	<button type="submit">결제취소</button>

<form action="#" method="get">	<!-- 미구현 상태임 -->
	<input type="hidden" name=transactionId value="${safePurchaseInfoDto.transactionId}"/>
	<button type="submit">신고하기</button>
</form>

<form action="${request.getContextPath()}/payment/closePay" method="POST">
	<input type="hidden" name=transactionId value="${safePurchaseInfoDto.transactionId}"/>
	<button type="submit">거래확정</button>
</form>

<a href="#"><p>상품명:${safePurchaseInfoDto.goodsTitle}</p></a>
<p>판매자명:${safePurchaseInfoDto.sellerName}</p>
<p>구매자명:${safePurchaseInfoDto.buyerName}</p>
<p>휴대폰번호:${safePurchaseInfoDto.mobileNumber}</p>
<p>배송지:${safePurchaseInfoDto.roadAddress}, ${safePurchaseInfoDto.detailAddress}</p>
<p>거래일자:${safePurchaseInfoDto.tradingDate}</p>
<c:if test="${safePurchaseInfoDto.tradingStatus} eq 1"><p>거래상태:입금완료</p></c:if>
<c:if test="${safePurchaseInfoDto.tradingStatus} eq 2"><p>거래상태:상품준비중</p></c:if>
<c:if test="${safePurchaseInfoDto.tradingStatus} eq 3"><p>거래상태:배송중</p></c:if>
<c:if test="${safePurchaseInfoDto.tradingStatus} eq 4"><p>거래상태:거래완료</p></c:if>
<c:if test="${safePurchaseInfoDto.tradingStatus} eq 5"><p>거래상태:결제취소</p></c:if>

<c:if test="not empty ${safePurchaseInfoDto.trackingNumber}">
<p>운송장번호:${safePurchaseInfoDto.trackingNumber}</p>
</c:if>

</body>
</html>