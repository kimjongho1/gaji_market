<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품거래 게시판</title>

<!--favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"
	type="text/css">
</head>
<body>

	<!-- header start -->
	<header>
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</header>
	<!-- header end -->
	<h2>중고 거래 게시판</h2>

	<div></div>

	<div></div>


	<!-- Footer Section Begin -->
	<footer>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</footer>
	<!-- Footer Section End -->


<!-- Js Plugins -->
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>


</body>
</html>