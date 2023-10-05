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
<link rel="shortcut icon" href="/.ico" type="image/x-icon">
<link rel="icon" href="/.ico" type="image/x-icon">
<style>
@import
	url(https://fonts.googleapis.com/css?family=Open+Sans:400italic,400,300,600)
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-webkit-font-smoothing: antialiased;
	-moz-font-smoothing: antialiased;
	-o-font-smoothing: antialiased;
	font-smoothing: antialiased;
	text-rendering: optimizeLegibility;
}

body {
	font-family: "Open Sans", Helvetica, Arial, sans-serif;
	font-weight: 300;
	font-size: 12px;
	line-height: 30px;
	color: #777;
	background: #FFF;
}

.container {
	max-width: 600px;
	width: 100%;
	margin: 0 auto;
	position: relative;
}

#contact input[type="text"], #contact input[type="email"], #contact textarea,
	#contact button[type="submit"] {
	font: 400 12px/16px "Open Sans", Helvetica, Arial, sans-serif;
}

#contact {
	background: #F9F9F9;
	padding: 0 150px;
	margin: 50px 0;
	border-color: black;
	border: solid 1px;
}

#contact h2 {
	color: black;
	display: block;
	font: bold;
	font-size: 26px;
}

#contact h4 {
	margin: 5px 0 15px;
	display: block;
	font-size: 15px;
}

fieldset {
	border: medium none !important;
	margin: 0 0 10px;
	min-width: 100%;
	padding: 0;
	width: 100%;
}

#contact input[type="text"], #contact input[type="email"], #contact textarea
	{
	width: 100%;
	border: 1px solid #CCC;
	background: #FFF;
	margin: 0 0 5px;
	padding: 10px;
	border-radius: 5px;
	box-shadow: inset 1px 2px rgba(0, 0, 0, 0.1);
}

#contact input[type="text"]:hover, #contact input[type="email"]:hover,
	#contact textarea:hover {
	-webkit-transition: border-color 0.3s ease-in-out;
	-moz-transition: border-color 0.3s ease-in-out;
	transition: border-color 0.3s ease-in-out;
	border: 1px solid #AAA;
}

#contact textarea {
	height: 100px;
	max-width: 100%;
	resize: none;
}

#contact button[type="submit"] {
	cursor: pointer;
	width: 100%;
	border: none;
	background: #5D8233;
	color: #F9F9F9;;
	margin: 0 0 5px;
	padding: 10px;
	font-size: 15px;
	margin: 10px 0 10px 0;
	border-radius: 5px;
}

#contact button[type="submit"]:hover {
	background: #F9F9F9;
	color: #5D8233;
	-webkit-transition: background 0.3s ease-in-out;
	-moz-transition: background 0.3s ease-in-out;
	transition: background-color 0.3s ease-in-out;
}

#contact button[type="submit"]:active {
	box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.5);
}

#contact input:focus, #contact textarea:focus {
	outline: 0;
	border: 1px solid #999;
}

::-webkit-input-placeholder {
	color: #888;
}

:-moz-placeholder {
	color: #888;
}

::-moz-placeholder {
	color: #888;
}

:-ms-input-placeholder {
	color: #888;
}

#search {
	text-align: center;
	padding: 50px;
}

.row>* {
	width: auto
}

#header {
	background: green;
}

a {
	text-decoration: none;
}
</style>
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