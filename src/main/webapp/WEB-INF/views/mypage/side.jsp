<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<style>

#sidebar {
    float: left;
    width: 250px;
    height: 720px;
    border:1px solid gray;

}

nav {
    width:250px;
    position: absolute;

    padding-top: 20px;
}

li{

    padding: 30px 0px 30px 35px;

}

ul {
    list-style: none;
    padding-left: 0px;
}

.sidebarul {

    list-style: none;
    padding-left:35px;

}

a:hover {
  color: orange;
}

</style>
</head>
<body>

<div id="sidebar">
            	<div class="header__logo">
						<a href="./index.html"><img
							src="${pageContext.request.contextPath}/resources/img/gaji_logo.png"
							alt="GaJi" height="70" width="170"></a>
				</div>
            <nav>메뉴
            	<ul class='sidebarul' id="trade"> 
            		<h4>거래내역</h4>
                    <a><li>구매내역</li></a>
                    <a><li>판매내역</li></a>
             	</ul>
            	<ul class='sidebarul' id="write"> 
					<h4>작성 글</h4>
                    <a><li>판매글 </li></a>
               	</ul>
            	<ul class='sidebarul' id="privacy" >
					<h4>개인정보</h4>
                    <a><li>회원정보</li></a>
                    <a><li>비밀번호 변경</li></a>
             	</ul>
            </nav>
        </div>

</body>
</html>