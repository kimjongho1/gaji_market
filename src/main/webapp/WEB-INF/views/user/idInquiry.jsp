<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아이디 찾기</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sign/sign.css" type="text/css">

<!--favicon  -->
	<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
</head>
<body>
	<header width="100%" id="header">
		<div class="row">
			<div class="header__logo">
				<a href="./"><img
					src="${pageContext.request.contextPath}/resources/img/gaji_logo.png"
					alt="GaJi" height="70" width="170"></a>
			</div>
			<div class="container">
				<div class="row">
					<img alt="" src="아이디"> <a href="./idInquiry">
						<h1>아이디 찾기</h1>
					</a>
					<div>
						<img alt="" src="비밀번호"> <a href="./pwInquiry">
							<h1>비밀번호 찾기</h1>
						</a>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="container">
		<form id="contact" action="${pageContext.request.contextPath}/idInquiry" method="post">
			<div id="search">
				<h2>아이디 찾기</h2>
			</div>
			<h4>이름</h4>
			<fieldset>
				<input placeholder="Your name" type="text" tabindex="1" name="name" required
					autofocus>
			</fieldset>
			<h4>이메일 주소</h4>
			<fieldset>
				<input placeholder="Your Email Address" type="email" tabindex="2" name="email"
					required>
			</fieldset>
			<fieldset>
				<button name="submit" type="submit" id="contact-submit"
					data-submit="...Sending">Submit</button>
			</fieldset>
		</form>
	</div>
	<!--divcon -->
	<script>
		
	</script>
</body>
</html>