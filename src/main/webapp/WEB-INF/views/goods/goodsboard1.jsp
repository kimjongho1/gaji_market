<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품게시판</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/goods/board" id="condition">
<input type="search" name="searchWord" value="${searchWord}">
<button type="submit">검색</button>

<div class="category">
<ul>
	<li><h3>카테고리</h3></li>
	<li><a href="${pageContext.request.contextPath}/goods/board/category=1">가구/인테리어</a></li>
	<li><a href="${pageContext.request.contextPath}/goods/board/category=2">생활가전</a></li>
	<li><a href="${pageContext.request.contextPath}/goods/board/category=3">생활/주방</a></li>
	<li><a href="${pageContext.request.contextPath}/goods/board/category=4">디지털기기</a></li>
	<li><a href="${pageContext.request.contextPath}/goods/board/category=5">취미/게임</a></li>
	<li><a href="${pageContext.request.contextPath}/goods/board/category=6">기타</a></li>
</ul>
</div>

	<input type="radio" name="price" value="" id="priceOption1" onclick="priceOptionF1()">
    <label for="male">10만원 이하</label>

    <input type="radio" name="price" value="" id="priceOption2" onclick="priceOptionF2()">
    <label for="female">10~30만원</label>

    <input type="radio" name="price" value="" id="priceOption3" onclick="priceOptionF3()">
    <label for="other">30~50만원</label>

	<input type="radio" name="price" value="" id="priceOption4" onclick="priceOptionF4()">
    <label for="other">50만원 이상</label>
    
 	<c:if test="${not empty priceCeiling}">
    	<input type="hidden" name="priceCeiling" id="priceCeiling" value="${priceCeiling}">
    </c:if>
    
    <c:if test="${not empty priceFloor}">
    	<input type="hidden" name="priceFloor" id="priceFloor" value="${priceFloor}">
    </c:if>
    
    <c:if test="${not empty Category}">
    	<input type="hidden" name="Category" id="Category" value="${Category}">
    </c:if>
    
    <label for="selectedGu">구 선택:</label> 
    	<select name="selectedGu"
			id="selectedGu" onchange="updateDongDropdown()">
			<option value="">구를 선택하세요</option>
			<c:forEach items="${guList}" var="gu">
				<option value="${gu.guId}">${gu.guName}</option>
			</c:forEach>
		</select>
		<!-- 동 선택 드롭다운 -->
	<label for="selectedDong">동 선택:</label> 
		<select name="dongId"
			id="selectedDong">
			<option value="">동을 선택하세요</option>
			<c:forEach items="${dongList}" var="dong">
				<option value="${dong.dongId}" data-gu="${dong.guId}">${dong.dongName}</option>
			</c:forEach>
	</select>
</form>
<div class="totalCnt">
${totalCnt}개의 상품
</div>
</body>
<script>
	function priceOptionF1(){
		alert("실행됨1");
		$("#priceFloor").val(-1);
		$("#priceCeiling").val(100000);
	}
	
	function priceOptionF2(){
		alert("실행됨2");
		$("#priceFloor").val(100000);
		$("#priceCeiling").val(300000);
	}
	
	function priceOptionF3(){
		alert("실행됨3");
		$("#priceFloor").val(300000);
		$("#priceCeiling").val(500000);
	}
	
	function priceOptionF4(){
		alert("실행됨4");
		$("#priceFloor").val(500000);
		$("#priceCeiling").val(-1);
	}
</script>
</html>