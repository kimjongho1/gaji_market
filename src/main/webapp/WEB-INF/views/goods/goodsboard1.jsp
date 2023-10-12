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
    	<input type="hidden" name="priceCeiling" id="priceCeiling" 
    	<c:if test="${not empty priceCeiling}">
    	value="${priceCeiling}"
    	 </c:if>
    	>
   
    
    
    	<input type="hidden" name="priceFloor" id="priceFloor" 
    	<c:if test="${not empty priceFloor}">
    	value="${priceFloor}"
    	 </c:if>
    	>
   
    
    
    	<input type="hidden" name="category" id="category" 
    	<c:if test="${not empty category}">
    	value="${category}"
    	</c:if>
    	>
    
    
     
    	<input type="hidden" name="searchWord" id="searchWord" 
    	<c:if test="${not empty searchWord}">
    	value="${searchWord}"
    	</c:if>
    	>
    
  
    <input type="hidden" name="currentPage" id="currentPage" value="${currentPage}">
    
	</form>
<div class="totalCnt">
${totalCnt}개의 상품
</div>

<footer>
	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</body>
<script>
function priceOptionF1(){
	$("#priceFloor").val(-1);
	$("#priceCeiling").val(100000);
	$("#condition").submit();
	console.log(data);
}

function priceOptionF2(){
	$("#priceFloor").val(100000);
	$("#priceCeiling").val(300000);
	$("#condition").submit();
}

function priceOptionF3(){
	$("#priceFloor").val(300000);
	$("#priceCeiling").val(500000);
	$("#condition").submit();
}

function priceOptionF4(){
	$("#priceFloor").val(500000);
	$("#priceCeiling").val(-1);
	$("#condition").submit();
}

function pageMove(i){
	alert(i);
	$("#currentPage").val(i);
	$("#condition").submit();
}

function clearAll(){
	window.location.href="${pageContext.request.contextPath}/goods/board";
}

 function checking() {
	 if ($("#priceFloor").val() === "-1" && $("#priceCeiling").val()==="100000") 
		    $("#priceOption1").prop("checked", true);
		
	 else if($("#priceFloor").val() === "100000" && $("#priceCeiling").val()==="300000")
		 $("#priceOption2").prop("checked", true);
	 
	 else if($("#priceFloor").val() === "300000" && $("#priceCeiling").val()==="500000")
		 $("#priceOption3").prop("checked", true);
	 
	 else if($("#priceFloor").val() === "500000" && $("#priceCeiling").val()==="-1")
		 $("#priceOption4").prop("checked", true);
 }

 window.onload = checking; // Attach the function to the window's onload event
</script>
</html>