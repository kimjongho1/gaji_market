<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
	
	<!--favicon  -->
	<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
	
	
</head>
	<style>
	
	.box{
	max-width:600px;
	width:100%;
	margin:0 auto;
	position:relative;
	border: 1px solid #bbb1d6;
	text-align: center;
	background:#F9F9F9;
	color:#777777;
	}
	
	h2{
	color: black;
	display: block;
    font: bold;
    font-size: 26px;
    padding: 10px;
	}
	
	p{
	margin: 0;
	}
	
	a{
	  text-decoration: none;
	  color: #988fb2;
	}
	
	.found{
	width:100%;
	border:1px solid #CCC;
	background:#FFF;
	margin:0 auto;
	padding:10px;
    border-radius: 5px;
    box-shadow: inset 1px 2px rgba(0, 0, 0, 0.1);
    max-width: 400px;

	}

	.btn{
	margin: 15px 50px 15px 50px;
		border:1px solid #bbb1d6;
			background:#FFF;
				padding:3px;
				    border-radius: 5px;
				        box-shadow:  1px 2px rgba(0, 0, 0, 0.1);
	}
	
	</style>
<body>

<header width="100%" id="header">
<div class="container">
			<div class="header__logo">
				<a href="./"><img
					src="${pageContext.request.contextPath}/resources/img/gaji_logo.png"
					alt="GaJi" height="70" width="170"></a>
			</div>
</div>
</header>

	<div class="container">
		<div class="box">
		     <h2>아이디 찾기 결과</h2>
		<div class="found">
    <% if (request.getAttribute("foundId") != null) { %>
        <p>찾은 아이디: <%= request.getAttribute("foundId") %></p>
		   	
    <% } else { %>
        <p>일치하는 정보로 등록된 아이디를 찾을 수 없습니다.</p>
    <% } %>
		</div>
    <% if (request.getAttribute("foundId") != null) { %>
        <div class="btn"><a href="<%= request.getContextPath() %>/login">로그인하러 가기</a></div>
    	<div class="btn"><a href="<%= request.getContextPath() %>/pwInquiry">비밀번호 찾기</a></div>
    <% } else { %>
        <div class="btn"><a href="javascript:history.back();">전 페이지로 돌아가기</a></div>
    	<div class="btn"><a href="<%= request.getContextPath() %>/signup">회원가입</a></div> 
    <% } %>
    	</div>
   	</div>
</body>
</html>