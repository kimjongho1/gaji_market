<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>판매중</title>
<!-- Favicon-->
<!--         <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->


<script
	src="${pageContext.request.contextPath}/resources/js/orderstatus.js"></script>
<link
	href="${pageContext.request.contextPath}/resources/css/orderstatus.css"
	rel='stylesheet' type='text/css'>
<style>
.personal1 {
	position: absolute;
	left: 850px;
	top: 35px;
}

.personal2 {
	position: absolute;
	left: 980px;
	top: 35px;
}

.btn {
	background-color: #007BFF; /* 파란색 배경 */
	color: white; /* 흰색 글자색 */
}

.btn-top {
	display: flex;
	justify-content: center;
	padding-top: 35px;
}

.personal {
	margin: 0 50px 0 50px;
}
  	.searchWord {
		text-align: center;
		margin-top: 20px;
	}
	
	.searchWord input[type="search"] {
		height: 42px;
		width: 250px;
		border-radius: 5px;
		background-color: white;
		color: black;
	}
	
	.searchWord input[type="submit"] {
		background-color: #007BFF;
		color: white;
		border: none;
		border-radius: 5px;
		padding: 10px 20px;
		cursor: pointer;
		font-weight: bold;
	}
	
	.searchWord input[type="submit"]:hover {
		background-color:black;
		color: white;
		text-decoration: none;
	}
	
	/* 페이징 위치 및 디자인 */
	.paging {
		text-align: center;
		margin-top: 20px;
	}
	
	.paging a {
		background-color: #007BFF;
		text-decoration: none;
		margin: 0 10px;
		font-size: 16px;
		font-weight: bold;
		padding: 5px 10px;
		border: 1px solid black;
		border-radius: 5px;
	}
	
	.paging span {
		color: white;
		margin: 0 10px;
		font-size: 16px;
	}
	
	.paging a:hover {
		background-color:black;
		color: white;
		text-decoration: none;
	}
	
	/* 페이지 번호 활성화 스타일 */
	.paging .active {
		background-color: #FFC107;
		color: #1E1E1E;
		border: 1px solid #FFC107;
		border-radius: 5px;
	}
	
	.safeTrading, .infaceTrading {
		color: white;
		background-color: #007BFF;
		text-decoration: none;
		display: inline-block;
		font-weight: bold;
		font-size: 18px;
		padding: 10px 20px;
		border: 1px solid #FFC107;
		border-radius: 5px;
		margin: 0 auto;
	}
	
	.safeTrading:hover, .infaceTrading:hover {
		background-color:black;
		color: white;
		text-decoration: none;
	}
	
	.margin10{
		margin:30px 0 30px 0;
	}
</style>
</head>

<body>
	<!-- Section-->
	<div class="searchWord">
		<form
			action="${pageContext.request.contextPath}/mypage/goods/onsale" method="get">
			<input type="search" name="searchWord"> <input class="btn" type="submit" value="검색">
		</form>
	</div>

	<div class="buttons-container text-center margin10">
		<a class="btn safeTrading" href="${pageContext.request.contextPath}/mypage/goods/onsale">판매중</a>
		<a class="btn infaceTrading" href="${pageContext.request.contextPath}/mypage/goods/closed">판매완료</a>
		<a class="btn infaceTrading" href="${pageContext.request.contextPath}/mypage/goods/hide">숨김</a>
	</div>

	<section class="py-1">
		<div class="container px-4 px-lg-5 mt-5">
			<div id="replacePoint"
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
				<c:forEach var="myGoodsInfo" items="${myGoodsList}">
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Sale badge-->
							<div class="badge bg-dark text-white position-absolute"
								style="top: 0.5rem; right: 0.5rem">
								<c:choose>
									<c:when test="${myGoodsInfo.status eq 1}">판매중</c:when>
									<c:when test="${myGoodsInfo.status eq 2}">예약중</c:when>
								</c:choose>
							</div>
							<!-- Product image-->
							<img class="card-img-top"
								src="${myGoodsInfo.url}" alt="상품 이미지 없음"  width="268" height="179"/>
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">${myGoodsInfo.title}</h5>
									<div class="d-flex justify-content-center small text-warning mb-2">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bag-heart-fill" viewBox="0 0 16 16">
  <path d="M11.5 4v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5ZM8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1Zm0 6.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132Z"/>
</svg>+${myGoodsInfo.wishCount}
                                    </div>
									<!-- Product price-->
									끌올일자:${myGoodsInfo.refreshedAt}<br>
                                    가격:${myGoodsInfo.price}<br>
                                    ${myGoodsInfo.dongName} 조회수:${myGoodsInfo.viewCount}<br>
                                    판매자:${myGoodsInfo.nickname}
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
								<div class="text-center">
									<a class="btn btn-outline-dark mt-auto"
										href="${pageContext.request.contextPath}/goods/get?goodsId=${myGoodsInfo.goodsId}">상품이동</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>

	<div class="paging">
		<c:choose>
			<c:when test="${not empty searchWord}">
				<c:if test="${startPageNum!=1}">
					<%--페이징 이전,번호,다음에 대한 코드 --%>
					<a
						href="<%=request.getContextPath()%>/mypage/goods/onsale?currentPage=${startPageNum-1}&searchWord=${searchWord}">이전</a>
				</c:if>
				<c:forEach begin="${startPageNum}" end="${endPageNum}" var="i">
					<a
						href="<%=request.getContextPath()%>/mypage/goods/onsale?currentPage=${i}&searchWord=${searchWord}"><span>${i}</span></a>
				</c:forEach>
				<c:if test="${endPageNum<totalPageNum}">
					<a
						href="<%=request.getContextPath()%>/mypage/goods/onsale?currentPage=${endPageNum+1}&searchWord=${searchWord}">다음</a>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${startPageNum!=1}">
					<a
						href="<%=request.getContextPath()%>/mypage/goods/onsale?currentPage=${startPageNum-1}">이전</a>
				</c:if>
				<c:forEach begin="${startPageNum}" end="${endPageNum}" var="i">
					<a
						href="<%=request.getContextPath()%>/mypage/goods/onsale?currentPage=${i}"><span>${i}
					</span></a>
				</c:forEach>
				<c:if test="${endPageNum<totalPageNum}">
					<a
						href="<%=request.getContextPath()%>/mypage/goods/onsale?currentPage=${endPageNum+1}">다음</a>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>

	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>