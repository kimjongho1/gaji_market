<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/mypage/side.css" rel='stylesheet' type='text/css'>
</head>
<body>


<div id="sidebar">
            	
            <nav>
            	<ul class='sidebarul' id="trade"> 
            		<strong>거래내역</strong>
                    <a href="${pageContext.request.contextPath}/mypage/orderstatus/safe"><li><span class="liner">구매내역</span></li></a>
                    <a href="${pageContext.request.contextPath}/mypage/salestatus/safe"><li><span class="liner">판매내역</li></span></a>
             	</ul>
            	<ul class='sidebarul' id="write"> 
					<strong>작성 글</strong>
                    <a href="${pageContext.request.contextPath}"><li><span class="liner">판매글</span></li></a>
               	</ul>
            	<ul class='sidebarul' id="privacy" >
					<strong>개인정보</strong>
                    <a href="${pageContext.request.contextPath}"><li><span class="liner">회원정보</span></li></a>
                    <a href="${pageContext.request.contextPath}"><li><span class="liner">비밀번호 변경</span></li></a>
             	</ul>
            </nav>
        </div>


<script src="${pageContext.request.contextPath}/resources/js/side.js"></script>



</body>
</html>