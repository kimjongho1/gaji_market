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
                    <a><li><span class="liner">구매내역</span></li></a>
                    <a><li><span class="liner">판매내역</li></span></a>
             	</ul>
            	<ul class='sidebarul' id="write"> 
					<strong>작성 글</strong>
                    <a><li><span class="liner">판매글</span></li></a>
               	</ul>
            	<ul class='sidebarul' id="privacy" >
					<strong>개인정보</strong>
                    <a><li><span class="liner">회원정보</span></li></a>
                    <a><li><span class="liner">비밀번호 변경</span></li></a>
             	</ul>
            </nav>
        </div>


<%-- <script src="${pageContext.request.contextPath}/resources/js/side.js"></script> --%>

<script type="text/javascript">

document.addEventListener('DOMContentLoaded', function () {
    const sidebar = document.getElementById('sidebar');
    const footer = document.querySelector('.footer');
    const sidebarNav = document.querySelector('#sidebar nav');

    window.addEventListener('scroll', function () {
        const sidebarRect = sidebar.getBoundingClientRect();
        const footerRect = footer.getBoundingClientRect();

        if (sidebarRect.bottom >= footerRect.top) {
            // Calculate the distance to move the sidebar up
            const moveDistance = sidebarRect.bottom - footerRect.top;
            sidebar.style.bottom = moveDistance + 'px';
            sidebar.style.border = 0;
            sidebar.style.zIndex = -1;
            sidebar.style.backgroundColor = '#988fb200';
            
            // Adjust the position of the nav inside the sidebar
            sidebarNav.style.position = 'relative';
            sidebarNav.style.top = -moveDistance + 'px';
        } else {
            // Reset the sidebar position when it's not overlapping the footer
            sidebar.style.zIndex = 1;
            sidebar.style.backgroundColor = '#988fb217';
            sidebar.style.bottom = '0';
            sidebar.style.border = '1px solid #bbb1d6';
            sidebarNav.style.position = 'absolute';
            sidebarNav.style.top = '0px'; // You can adjust this value
        }
    });
});


</script>

</body>
</html>