<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<script
		src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<style>
header {
	position: static;
	z-index: 1000;
	width: 100%;
	position: sticky;
	top: 0px;
	background-color: rgba(255, 255, 255, 0.9);
}

.rights {
	position: fixed;
	right: 50px;
	padding: 30px;
}

.btn {
	display: inline;

}



</style>
<body>






	<!-- Header Section Begin -->
	<header width="100%" id="header">


		<div class="container">
			<div class="head_top">
				<div class="row">

					<div class="header__logo">
						<a href="${pageContext.request.contextPath}"><img
							src="${pageContext.request.contextPath}/resources/img/gaji_logo.png"
							alt="GaJi" height="70" width="170"></a>
					</div>




					<div class="hero__search">
						<div class="hero__search__form">
							<form  id="searchForm" action="${pageContext.request.contextPath}/goods/board" method="get" onsubmit="searching(event)">
								<input type="text" placeholder="What do yo u need?" name="searchWord">
								<button type="submit" class="site-btn searchButton">SEARCH</button>
							</form>
						</div>
					</div>

					<div class="header__cart rights">
						<ul>
							<li><a href="${pageContext.request.contextPath}/notice"><i class="fa fa-bell"></i></a></li>
							<li><a href="${pageContext.request.contextPath}/mypage/keepuseds"><i class="fa fa-heart"></i></a></li>
							<li><a href="${pageContext.request.contextPath}/mypage/keepusers"><i class="fa fa-shopping-bag"></i></a></li>
							<sec:authorize access="isAnonymous()">
								<!-- 사용자가 로그인하지 않은 경우에만 로그인 링크 표시 -->
								<li class="log-btn"><a href="${pageContext.request.contextPath}/login">로그인</a></li>
							</sec:authorize>
							<sec:authorize access="isAuthenticated()">
								<!-- 사용자가 로그인한 경우에만 로그아웃 링크 표시 -->
								<li>
									<form class="form-signin" method="post" action="${pageContext.request.contextPath}/logout">
										<button type="submit" class="log-btn">
											로그아웃
										</button>
									</form>
								</li>
							</sec:authorize>
						</ul>

					</div>


				</div>
			</div>
			<div class="row">
				<nav class="header__menu">
					<ul>
						<li><a href="#">카테고리</a>
							<ul class="header__menu__dropdown">
								<li><a href="${pageContext.request.contextPath}/goods/board?category=1">디지털기기</a></li>
								<li><a href="${pageContext.request.contextPath}/goods/board?category=2">가구/인테리어</a></li>
								<li><a href="${pageContext.request.contextPath}/goods/board?category=3">생활가전</a></li>
								<li><a href="${pageContext.request.contextPath}/goods/board?category=4">생활/주방</a></li>
								<li><a href="${pageContext.request.contextPath}/goods/board?category=5">취미/게임</a></li>
								<li><a href="${pageContext.request.contextPath}/goods/board?category=6">기타</a></li>
							</ul></li>
						<li><a href="${pageContext.request.contextPath}/goods/board">상품</a></li>
						<li><a href="${pageContext.request.contextPath}/chat">1:1채팅</a></li>
						<li><a href="${pageContext.request.contextPath}/mypage">마이페이지</a></li>
					</ul>
<!-- class="active" -->


				</nav>







			</div>

		</div>
	</header>
	<!-- Header Section End -->










	<!-- Js Plugins -->

	<script>
		window.addEventListener("scroll", function() {
			if (window.pageYOffset > 1) {
				document.querySelector("#header").className = 'sc';
			} else {
				document.querySelector("#header").className = 'sc';
			}
		});
		
		function loadNoti(){
			$.ajax({
				  url: "<%=request.getContextPath()%>/notice/getNotiCount" ,	
				  method: "post",
				  dataType: "text",
			  	  success: function(count){
			  		  console.log(count);
			  		if(count!=0)
						$(".fa-bell").replaceWith("<i class='fa fa-bell'><span>"+count+"</span></i>");
			  	  },
					error : (request,status,error)=>{
						console.log(request);
						console.log(status);
						console.log(error);
						alert("code:"+request.status+"\n"+"message"+request.responseText+"\n"+error+":error");
					}
				  });		
		}
		
		$(document).ready(function() {
			  // 페이지가 로드될 때 실행할 코드
			  loadNoti();
		});
		setInterval(loadNoti, 30000);	// 이후 30초마다 최신화.
	</script>
	
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.nice-select.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/jquery.slicknav.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/mixitup.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>