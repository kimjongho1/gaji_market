<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고 게시판 상세보기</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/locale/ko.js"></script>
	<!-- Swiper -->

<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />

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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/goods/goods.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/goods/goodsget.css"
	type="text/css">

</head>
<body>

	<!-- header start -->
	<header>
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</header>
	<!-- header end -->
	
	<main class="relative flex-grow border-b-2"
		style="min-height: -webkit-fill-available; -webkit-overflow-scrolling: touch">
		<div
			class="max-w-[1280px] lg:min-h-[950px] mx-auto max-w-[1280px] px-4 md:px-8 2xl:px-16 box-content">
			<div
				class="items-start block grid-cols-2 pt-5 lg:grid gap-x-10 xl:gap-x-14 pb-14 lg:py-10 lg:pb-14 2xl:pb-20">
				<div
					class="carouselWrapper relative product-gallery swiperThumbnail   ">
					<div
						class="swiper swiper-initialized swiper-horizontal swiper-pointer-events swiper-backface-hidden"
						dir="ltr">
						<div class="swiper-wrapper"
							style="transform: translate3d(0px, 0px, 0px);">
							<div class="swiper-slide swiper-slide-active"
								style="width: 612px;">
								<c:set var="firstgoodsUrl" value="${goodsUrl[0]}" />
								<div
									class="col-span-1 transition duration-150 ease-in hover:opacity-90 w-full relative pt-[100%]">
									<img alt="${goodsDto.title }" referrerpolicy="no-referrer" 
									<c:choose>
								<c:when test="${not empty firstgoodsUrl.url }">
									src="${firstgoodsUrl.url}"
								</c:when>
								<c:otherwise>
									src="${pageContext.request.contextPath}/resources/img/no_photo.png"
								</c:otherwise>
								</c:choose>
										decoding="async" data-nimg="fill"
										class="object-cover w-full h-full rounded-lg top-1/2 left-1/2"
										loading="lazy"
										style="position: absolute; height: 100%; width: 100%; inset: 0px; color: transparent;">
								</div>
							</div>
							<c:forEach var="url" items="${goodsUrl}" varStatus="loop">
        					<c:if test="${loop.index > 0}">
							<div class="swiper-slide swiper-slide-next" style="width: 612px;">
								<div class="col-span-1 transition duration-150 ease-in hover:opacity-90 w-full relative pt-[100%]">
									<img alt="${goodsDto.title }" referrerpolicy="no-referrer" src="${url.url }" decoding="async" data-nimg="fill" class="object-cover w-full h-full rounded-lg top-1/2 left-1/2" loading="lazy" style="position: absolute; height: 100%; width: 100%; inset: 0px; color: transparent;">
								</div>
							</div>
							 </c:if>
    						</c:forEach>
						</div>
						<div
							class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets swiper-pagination-horizontal" >
								
						</div>
					</div>
					<div class="flex items-center w-full absolute top-2/4 z-10 hidden">
						<button
							class="w-7 h-7 lg:w-8 lg:h-8 text-sm md:text-base lg:text-lg text-black flex items-center justify-center rounded absolute transition duration-250 hover:bg-gray-900 hover:text-white focus:outline-none transform shadow-navigation -translate-x-1/2 rounded-full lg:w-9 lg:h-9 xl:w-10 xl:h-10 3xl:w-12 3xl:h-12 lg:text-xl 3xl:text-2xl start-0 swiper-button-disabled swiper-button-lock"
							aria-label="prev-button" disabled="">
							<svg stroke="currentColor" fill="currentColor" stroke-width="0"
								viewBox="0 0 512 512" height="1em" width="1em"
								xmlns="http://www.w3.org/2000/svg">
								<path
									d="M217.9 256L345 129c9.4-9.4 9.4-24.6 0-33.9-9.4-9.4-24.6-9.3-34 0L167 239c-9.1 9.1-9.3 23.7-.7 33.1L310.9 417c4.7 4.7 10.9 7 17 7s12.3-2.3 17-7c9.4-9.4 9.4-24.6 0-33.9L217.9 256z"></path></svg>
						</button>
						<button
							class="w-7 h-7 lg:w-8 lg:h-8 text-sm md:text-base lg:text-lg text-black flex items-center justify-center rounded absolute transition duration-250 hover:bg-gray-900 hover:text-white focus:outline-none transform shadow-navigation translate-x-1/2 rounded-full lg:w-9 lg:h-9 xl:w-10 xl:h-10 3xl:w-12 3xl:h-12 lg:text-xl 3xl:text-2xl end-0 swiper-button-disabled swiper-button-lock"
							aria-label="next-button" disabled="">
							<svg stroke="currentColor" fill="currentColor" stroke-width="0"
								viewBox="0 0 512 512" height="1em" width="1em"
								xmlns="http://www.w3.org/2000/svg">
								<path
									d="M294.1 256L167 129c-9.4-9.4-9.4-24.6 0-33.9s24.6-9.3 34 0L345 239c9.1 9.1 9.3 23.7.7 33.1L201.1 417c-4.7 4.7-10.9 7-17 7s-12.3-2.3-17-7c-9.4-9.4-9.4-24.6 0-33.9l127-127.1z"></path></svg>
						</button>
					</div>
				</div>
				<div class="pt-4 lg:pt-0">
					<div class="pb-4">
						<div class="chawkbazarBreadcrumb w-full flex items-center">
							<ol class="flex items-center w-full">
								<li
									class="text-sm text-body px-2.5 transition duration-200 ease-in first:ps-0 last:pe-0 hover:text-heading"><a
									href="${pageContext.request.contextPath}/goods/board">홈</a></li>
								<li
									class="text-sm leading-5 text-body min-[480px]:px-1 max-[480px]:px-0">&gt;</li>
								<li
									class="text-sm text-body px-2.5 transition duration-200 ease-in first:ps-0 last:pe-0 hover:text-heading"><a
									class="capitalize" href="${pageContext.request.contextPath}/goods/board?category=${goodsDto.categoryId}">${goodsDto.categoryName}</a></li>
								<li
									class="text-sm leading-5 text-body min-[480px]:px-1 max-[480px]:px-0">&gt;</li>
								<li
									class="text-sm text-body px-2.5 transition duration-200 ease-in first:ps-0 last:pe-0 hover:text-heading"><a
									class="capitalize font-semibold text-heading text-xs sm:text-sm"
									href="#">${goodsDto.title}</a></li>							
							</ol>
							
						</div>
					</div>
					<div class="pb-4 border-b border-gray-300">
						<h1 class="flex justify-between mb-1 text-lg font-bold align-middle text-heading lg:text-xl 2xl:text-2xl hover:text-black">
							${goodsDto.title}
							<div>
								<button class="fa fa-heart-o" id="wishButton"></button>
							</div>
						</h1>
						<div class="flex items-center justify-between">
							<div
								class="text-jnGreen font-bold text-[40px] pe-2 md:pe-0 lg:pe-2 2xl:pe-0 mr-2">${goodsDto.price}
								<span class="text-base">원</span>
							</div>
						</div>
						<span class="underline underline-offset-4">판매중</span>
					</div>
					<div class="py-4 border-b border-gray-300 space-s-4">
						<div class="pb-1 space-y-5 text-sm">
							<div class="flex justify-between text-body">
							
								<span><script>
                                   var createdAt = "${goodsDto.createdAt}";
                                   var formattedPastDate = moment(createdAt).fromNow();
                                   document.write(formattedPastDate); 
                               </script>
								· 조회 ${goodsDto.viewCount} · 찜 ${goodsDto.wishcount}</span>
								
								<div class="flex">
								
								
									
								<a href="https://thecheat.co.kr/">
								<div class="flex items-center hover:text-gray-400">
										<svg stroke="currentColor" fill="currentColor"
											stroke-width="0" viewBox="0 0 16 16" height="1em" width="1em"
											xmlns="http://www.w3.org/2000/svg">
											<path fill-rule="evenodd"
												d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 100-6 3 3 0 000 6zm7 1.5a.5.5 0 01.5-.5h2a.5.5 0 010 1h-2a.5.5 0 01-.5-.5zm-2-3a.5.5 0 01.5-.5h4a.5.5 0 010 1h-4a.5.5 0 01-.5-.5zm0-3a.5.5 0 01.5-.5h4a.5.5 0 010 1h-4a.5.5 0 01-.5-.5zm2 9a.5.5 0 01.5-.5h2a.5.5 0 010 1h-2a.5.5 0 01-.5-.5z"
												clip-rule="evenodd"></path></svg>
										<span class="ml-2 mr-2 ">신고하기</span> 
									</div></a>
									
								<a href="https://thecheat.co.kr/">
								<div class="flex items-center hover:text-gray-400">
										<svg stroke="currentColor" fill="currentColor"
											stroke-width="0" viewBox="0 0 16 16" height="1em" width="1em"
											xmlns="http://www.w3.org/2000/svg">
											<path fill-rule="evenodd"
												d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 100-6 3 3 0 000 6zm7 1.5a.5.5 0 01.5-.5h2a.5.5 0 010 1h-2a.5.5 0 01-.5-.5zm-2-3a.5.5 0 01.5-.5h4a.5.5 0 010 1h-4a.5.5 0 01-.5-.5zm0-3a.5.5 0 01.5-.5h4a.5.5 0 010 1h-4a.5.5 0 01-.5-.5zm2 9a.5.5 0 01.5-.5h2a.5.5 0 010 1h-2a.5.5 0 01-.5-.5z"
												clip-rule="evenodd"></path></svg>
										<span class="ml-2 mr-2 ">사기조회</span> <!-- 더치트사이트로전송 -->
									</div></a>
									
								</div>	
									
									
							</div>
							<div>
								<span class="inline-block font-semibold text-heading pe-2">배송비:</span>배송비
								별도
							</div>
							<div>
								<span class="inline-block font-semibold text-heading pe-2">안전결제 :</span>
								<c:choose>
 									<c:when test="${goodsDto.safeTradingYn eq 'Y'}">
    								사용
  									</c:when>
  									<c:otherwise>
   									미사용
  									</c:otherwise>
								</c:choose>
							</div>
							<div class="flex">
								<span class="inline-block font-semibold text-heading pe-2">결제혜택:</span>
								<div>
									<button class="flex items-center">
										<div class="text-left">
											<div>수수료1% 혜택 (15시~18시)</div>
											<div>CU 알뜰택배 무제한 무료배송</div>
											<div>편의점 픽업 수수료 무료</div>
										</div>
										<span class="self-center ml-4 text-gray-400">&gt;</span>
									</button>
								</div>
							</div>
							<div class="flex">
								<span class="inline-block font-semibold text-heading pe-2">무이자혜택:</span>
								<div>
									<a href="https://web.joongna.com/event/detail/1082">1만원 이상
										무이자 할부<span class="self-center ml-4 text-gray-400">&gt;</span>
									</a>
								</div>
							</div>
							<div class="flex flex-wrap">
								<span class="inline-block font-semibold text-heading pe-2">거래방법:</span>
								<span class="px-2 py-1 mr-2 text-xs pointer-events-none bg-gray-150 rounded-xl">직거래</span>
								<c:choose>
       							 <c:when test="${goodsDto.safeTradingYn eq 'Y'}">
            					<span class="px-2 py-1 mr-2 text-xs pointer-events-none bg-gray-150 rounded-xl">안전거래</span>
            					</c:when>
            					</c:choose>
							</div>
							<div class="flex flex-wrap">
								<span class="inline-block font-semibold text-heading pe-2">판매상태:</span>
								<span class="px-2 py-1 mr-2 text-xs pointer-events-none bg-gray-150 rounded-xl">판매중</span>
							</div>
							
						</div>
					</div>
					<div class="flex items-center py-4 border-b border-gray-300 space-s-4">
					<c:choose>
					<c:when test="${goodsDto.safeTradingYn eq 'Y'}">
						<form action="${pageContext.request.contextPath}/payment/pay" method="GET"
						 class="text-[13px] md:text-sm leading-4 inline-flex items-center cursor-pointer transition ease-in-out duration-300 font-semibold font-body text-center justify-center border-0 border-transparent placeholder-white focus-visible:outline-none focus:outline-none rounded-md h-11 md:h-12 px-5 text-white py-2 transform-none normal-case hover:text-white hover:shadow-cart w-full xl:w-full bg-jnblack hover:bg-jnblack/90">
    					<input type="hidden" name="goodsId" value="${goodsDto.goodsId}">
    					<button data-variant="slim">
        				<span class="py-2 3xl:px-8">안전거래하기</span>
    					</button>
						</form>
					</c:when>
					</c:choose>
						<form action="${pageContext.request.contextPath}/chat/insertRoom" method="GET"
						class="text-[13px] md:text-sm leading-4 inline-flex items-center cursor-pointer transition ease-in-out duration-300 font-semibold font-body text-center justify-center border-0 border-transparent placeholder-white focus-visible:outline-none focus:outline-none rounded-md h-11 md:h-12 px-5 text-white py-2 transform-none normal-case hover:text-white hover:shadow-cart w-full xl:w-full bg-jnblack hover:bg-jnblack/90">
							<%-- <c:if test="${empty goodsDto.userId}">
								<input type="hidden" name="sellerId" value="">
    						</c:if>
							<c:if test="${not empty goodsDto.userId}"> --%>
        						<input type="hidden" name="sellerId" value="${goodsDto.userId}">
    						<%-- </c:if> --%>
							<input type="hidden" name="goodsId" value="${goodsDto.goodsId}">
							<button data-variant="slim">
								<span class="py-2 3xl:px-8">채팅하기</span>
							</button>
						</form>
						<br>
					</div>
					
					<c:if test="${loginId eq goodsDto.userId}">
    				<div class="flex items-center py-2 space-s-1">
        				<button id="pullUpGoods" class="text-[13px] md:text-sm leading-4 inline-flex items-center cursor-pointer transition ease-in-out duration-300 font-semibold font-body text-center justify-center border-0 border-transparent placeholder-white focus-visible:outline-none focus:outline-none rounded-md h-11 md:h-12 px-5 text-white py-2 transform-none normal-case hover:text-white hover:shadow-cart w-full xl:w-full bg-jnblack hover:bg-jnblack/90">
            			끌올
        				</button>
    					<button id="modifyGoods" class="text-[13px] md:text-sm leading-4 inline-flex items-center cursor-pointer transition ease-in-out duration-300 font-semibold font-body text-center justify-center border-0 border-transparent placeholder-white focus-visible:outline-none focus:outline-none rounded-md h-11 md:h-12 px-5 text-white py-2 transform-none normal-case hover:text-white hover:shadow-cart w-full xl:w-full bg-jnblack hover:bg-jnblack/90">
        				수정
    					</button>
        				<button id="deleteGoods" class="text-[13px] md:text-sm leading-4 inline-flex items-center cursor-pointer transition ease-in-out duration-300 font-semibold font-body text-center justify-center border-0 border-transparent placeholder-white focus-visible:outline-none focus:outline-none rounded-md h-11 md:h-12 px-5 text-white py-2 transform-none normal-case hover:text-white hover:shadow-cart w-full xl:w-full bg-jnblack hover:bg-jnblack/90">
            			삭제
        				</button>
    				</div>
					</c:if>
				</div>
			</div>
			<div class="z-[15]" style=" top: 80px;">
				<div
					class="mb-2 grid grid-cols-2 lg:grid-cols-5 list-none pl-0 w-full bg-white"
					data-nav-ref="true">
					<div class="col-span-1 lg:col-span-3 w-full">
						<a class="text-base py-2 px-4 border-b-[4px] border-b-transparent text-jnblack w-full lg:w-auto justify-center flex lg:block cursor-pointer false"
							aria-label="상품내용탭" aria-roledescription="상품내용탭" href="#">${goodsDto.description}</a>
							
					</div>
					<div role="presentation" class="col-span-1 lg:col-span-2 w-full">
						<a class="text-base py-2 px-4 border-b-[4px] border-b-transparent text-jnblack w-full justify-center flex lg:block cursor-pointer border-b-jnblack transition duration-300 ease-in lg:border-b-transparent"
							aria-label="가게정보탭" aria-roledescription="가게정보탭" href="#">유저정보</a>
					</div>
					<div id="kakaoMap" style="width: 300%; height: 200px;"></div>
				</div>
			</div>
			<div class="block grid-cols-5 lg:grid lg:mb-10">
				<div name="product-description"
					class="col-span-3 text-sm w-full data-[tab-active]:block">
					<div
						class="flex flex-col items-center justify-center w-full p-3 mb-2 space-y-2 bg-gray-200">
						<div class="flex space-x-2">
							<span class="flex items-center justify-center"><svg
									width="24" height="24" viewBox="0 0 24 24" fill="none"
									xmlns="http://www.w3.org/2000/svg">
									<path fill-rule="evenodd" clip-rule="evenodd"
										d="M12 21C16.9706 21 21 16.9706 21 12C21 7.02944 16.9706 3 12 3C7.02944 3 3 7.02944 3 12C3 16.9706 7.02944 21 12 21ZM12 13.9286C12.4691 13.9286 12.8577 13.5645 12.8882 13.0964L13.1989 8.32508L13.2429 7.25541C13.2662 6.68747 12.8121 6.21429 12.2437 6.21429H11.7563C11.1879 6.21429 10.7338 6.68747 10.7571 7.25541L10.8012 8.32508L11.1118 13.0964C11.1423 13.5645 11.5309 13.9286 12 13.9286ZM11.993 17.7857C12.3583 17.7857 12.6651 17.663 12.9133 17.4174C13.1616 17.1719 13.2857 16.8661 13.2857 16.5C13.2857 16.1339 13.1616 15.8281 12.9133 15.5826C12.6651 15.3371 12.3583 15.2143 11.993 15.2143C11.6276 15.2143 11.3232 15.3371 11.0796 15.5826C10.8361 15.8281 10.7143 16.1339 10.7143 16.5C10.7143 16.8661 10.8361 17.1719 11.0796 17.4174C11.3232 17.663 11.6276 17.7857 11.993 17.7857Z"
										fill="#FF5453"></path></svg></span><span
								class="text-base font-bold pt-[2px]">거래 전 주의사항 안내</span>
						</div>
						<div class="text-xs truncate">
							판매자가 별도의 메신저로 결제링크를 보내거나 직거래(직접송금)을 <br>유도하는 경우 사기일 가능성이 높으니
							거래를 자제해 주시고
						</div>
						<span class="text-xs font-bold underline truncate">중고나라
							고객센터로 신고해주시기 바랍니다.</span>
					</div>
					<article>
						<p class="px-4 py-10 break-words break-all whitespace-pre-line lg:py-2"></p>
					</article>
				</div>
				<div name="product-store"
					class="col-span-2 w-full py-10 lg:py-2 px-4">
					<div class="flex">
						<div class="flex w-full flex-col justify-around lg:ml-4">
							<a class="font-semibold text-base text-jnblack" href="${pageContext.request.contextPath}/goods/usergoods?userId=${goodsDto.userId}">${goodsDto.nickname}</a>
							
							<span class="font-medium text-sm flex text-jnGray-500">판매상품 ${goodsUserInfo.sellgoods} · 안전거래 ${goodsUserInfo.safetradecount} · 후기 ${goodsUserInfo.reviewcount}</span>
						</div>
						<button class="fa fa-heart-o" id="favoriteUser"></button>
					</div>
					<div class="lg:ml-4">
						<div class="flex justify-between mt-2 text-[#0CB650] font-medium">
							<strong>가지온도 ${goodsDto.ratingScore}</strong><span class="text-jnGray-500 text-sm">100</span>	<!-- 추가 신뢰지수값에 따라 게이지 조정 -->
						</div>
						<div class="w-full h-1.5 bg-[#CCF4DC] rounded overflow-hidden">
							<div class="h-full rounded bg-[#0DCC5A]" style="width: ${goodsDto.ratingScore}%;"></div>
						</div>
					</div>
					 <div class="pt-5">
						<div class="mb-10 2xl:pt-2">
							<div class="flex items-center justify-between w-full mb-4">
								<p
									class="font-semibold text-lg text-jnblack [&amp;>span]:text-jnGreen">
									${goodsDto.nickname} <span>${goodsUserInfo.sellgoods}</span>
								</p>
								<a class="text-sm font-medium text-gray-600"
									href="${pageContext.request.contextPath}/goods/usergoods?userId=${goodsDto.userId}">더 보기 &gt;</a> <!-- 해당 유저의 상품 모아보기 -->
							</div>
							<div class="carouselWrapper relative    ">
								<div
									class="swiper-initialized swiper-horizontal swiper-pointer-events swiper-backface-hidden"
									dir="ltr">
									<div class="swiper-wrapper"
										style="transform: translate3d(0px, 0px, 0px);">
										<c:forEach items="${userGoodsList}" var="userGoods"  begin="0" end="3">
										<div class="card"
											style="width: 117px; margin-right: 4px;">
											<a
												class="group box-border overflow-hidden flex rounded-md cursor-pointer bg-white pe-0 md:pb-1 flex-col items-start"
												title="${userGoods.title}" href="${pageContext.request.contextPath}/goods/get?goodsId=${userGoods.goodsId}"><div
													class="relative w-full rounded-md overflow-hidden pt-[100%] mb-3 pb-0">
													<img alt="${userGoods.title}" referrerpolicy="no-referrer"
														<c:choose>
								<c:when test="${not empty userGoods.url }">
									src="${userGoods.url}"
								</c:when>
								<c:otherwise>
									src="${pageContext.request.contextPath}/resources/img/no_photo.png"
								</c:otherwise>
								</c:choose>
														decoding="async" data-nimg="fill"
														class="bg-gray-300 object-cover w-full transition duration-200 ease-in rounded-md duration-150 ease-linear transform group-hover:scale-105"
														loading="lazy"
														style="position: absolute; height: 100%; width: 100%; inset: 0px; color: transparent;">
												</div>
												<div class="w-full overflow-hidden p-2 ps-0">
													<h2 class="line-clamp-2 text-sm h-10 text-heading">${userGoods.title}</h2>
													<div
														class="font-semibold space-s-2 mt-0.5 text-heading text-sm">${userGoods.price}</div>
												</div></a>
										</div>
										</c:forEach>
										<!-- <div class="card"
											style="width: 117px; margin-right: 4px;">
											<a
												class="group box-border overflow-hidden flex rounded-md cursor-pointer bg-white pe-0 md:pb-1 flex-col items-start"
												title="도수 수경 -2.0 / 물안경 미러 수영" href="/product/107965151"><div
													class="relative w-full rounded-md overflow-hidden pt-[100%] mb-3 pb-0">
													<img alt="도수 수경 -2.0 / 물안경 미러 수영"
														referrerpolicy="no-referrer"
														src="https://img2.joongna.com/media/original/2023/04/24/1682311015633kvQ_w4WmT.jpg"
														decoding="async" data-nimg="fill"
														class="bg-gray-300 object-cover w-full transition duration-200 ease-in rounded-md duration-150 ease-linear transform group-hover:scale-105"
														loading="lazy"
														style="position: absolute; height: 100%; width: 100%; inset: 0px; color: transparent;">
												</div>
												<div class="w-full overflow-hidden p-2 ps-0">
													<h2 class="line-clamp-2 text-sm h-10 text-heading">도수
														수경 -2.0 / 물안경 미러 수영</h2>
													<div
														class="font-semibold space-s-2 mt-0.5 text-heading text-sm">22,000원</div>
												</div></a>
										</div>
										<div class="card"
											style="width: 117px; margin-right: 4px;">
											<a
												class="group box-border overflow-hidden flex rounded-md cursor-pointer bg-white pe-0 md:pb-1 flex-col items-start"
												title="도수 수경 -3.5 / 물안경 미러 수영" href="/product/107966533"><div
													class="relative w-full rounded-md overflow-hidden pt-[100%] mb-3 pb-0">
													<img alt="도수 수경 -3.5 / 물안경 미러 수영"
														referrerpolicy="no-referrer"
														src="https://img2.joongna.com/media/original/2023/04/24/1682312100404D6Z_K07mD.jpg"
														decoding="async" data-nimg="fill"
														class="bg-gray-300 object-cover w-full transition duration-200 ease-in rounded-md duration-150 ease-linear transform group-hover:scale-105"
														loading="lazy"
														style="position: absolute; height: 100%; width: 100%; inset: 0px; color: transparent;">
												</div>
												<div class="w-full overflow-hidden p-2 ps-0">
													<h2 class="line-clamp-2 text-sm h-10 text-heading">도수
														수경 -3.5 / 물안경 미러 수영</h2>
													<div
														class="font-semibold space-s-2 mt-0.5 text-heading text-sm">25,000원</div>
												</div></a>
										</div> -->
									</div>
									
								</div>
							</div>
						</div>
					</div> 
				</div>
			</div>
		</div>

		<div class="Toastify"></div>
	</main>

	

	<!-- Footer Section Begin -->
	<footer>
		 <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</footer>
	<!-- Footer Section End -->


	<!-- Js Plugins -->
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
  	<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aec5b89790015b44669217946b7e53f3"></script>
  
  <script>
    // 페이지가 로드될 때 실행되는 함수
    /* console.log(typeof ${goodsDto.lat}); // goodsDto.lat의 타입 확인
	console.log(typeof ${goodsDto.lng}); // goodsDto.lng의 타입 확인

	var lat = 37.566826; // 위도
	var lng = 126.978656; // 경도
	console.log(typeof lat); // lat의 타입 확인
	console.log(typeof lng); // lng의 타입 확인 */
    
	 var lat = parseFloat("${goodsDto.lat}");
	 var lng = parseFloat("${goodsDto.lng}");
    
	 if (lat > -90 && lat < 90 && lng > -180 && lng < 180) {
	 
	kakao.maps.load(function() {
	   
	   /*  var lat = 37.566826; // 위도
		var lng = 126.978656; // 경도 */
		
		
	        var mapContainer = document.getElementById('kakaoMap'); // 지도를 표시할 div
	        var mapOption = {
	            center: new kakao.maps.LatLng(lat, lng), // 지도 중심 좌표
	            level: 1 // 지도 확대 레벨
	        };
		
	
	    // 지도를 표시할 div와 지도 옵션으로 지도를 생성
	    var map = new kakao.maps.Map(mapContainer, mapOption);

	    // 마커의 좌표를 설정
	    var markerPosition = new kakao.maps.LatLng(lat, lng);


	    // 마커를 생성
	    var marker = new kakao.maps.Marker({
	        position: markerPosition,
	    });

	    // 마커를 지도에 표시
	    marker.setMap(map);
	});
	
	 }
    </script>
    <script>
  new Swiper('.swiper'
		  , {
			  // Optional parameters
			 
			  

			  // If we need pagination
			  pagination: {
			    el: '.swiper-pagination',
			    clickable: true,
			    createElements: true,
			  },
			
			  slidesPerView: 1,
			  // Navigation arrows
			 
			  
			}	  
  );
  
  </script>
<script>
	$(document).ready(function () {
    checkWishlist(); // 찜 여부 확인
    checkFavoriteUser() // 글 작성유저 좋아요 확인
	});

	
	
$("#wishButton").click(function() {
    var goodsId = ${goodsDto.goodsId};
    var userId ="${loginId}"; // 로그인된 사용자의 ID 또는 세션에서 가져온 ID
	
    if(userId) {
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/goods/wish", // 찜 등록 또는 제거 처리할 컨트롤러 경로
        data: {
            goodsId: goodsId,
            userId: userId
        },
        success: function (data) {
            // 요청이 성공했을 때 실행할 코드
            if (data === "added") {
                // 찜하기 버튼 아이콘을 "찜됨"으로 변경
                $("#wishButton").removeClass("fa-heart-o").addClass("fa-heart");
                alert("해당 상품을 찜목록에 추가하였습니다.");
            } else if (data === "removed") {
                // 찜하기 버튼 아이콘을 "찜하기"로 변경
                $("#wishButton").removeClass("fa-heart").addClass("fa-heart-o");
                alert("해당 상품을 찜목록에 제거하였습니다.");
            }
        }
    });
    } else {
    	alert("로그인이 필요한 기능입니다. 먼저 로그인해주세요.");
    	window.location.href = '${pageContext.request.contextPath}/login'; 
    }
});

$("#favoriteUser").click(function() {
	var targetId = "${goodsDto.userId}"; // 해당 상품 등록자 ID
    var userId = "${loginId}"; // 로그인된 사용자의 ID 또는 세션에서 가져온 ID
    
	
    if(userId) {
    	$.ajax({
        	type: "POST",
        	url: "${pageContext.request.contextPath}/goods/favorite", // 찜 등록 또는 제거 처리할 컨트롤러 경로
      	 	data: {
      	 		targetId: targetId,
                userId: userId
        },
        success: function (data) {
            // 요청이 성공했을 때 실행할 코드
            if (data === "favoriteadd") {
                // 찜하기 버튼 아이콘을 "찜됨"으로 변경
                $("#favoriteUser").removeClass("fa-heart-o").addClass("fa-heart");
                alert("해당 유저를 모아보기목록에 추가하였습니다.");
            } else if (data === "favoriteremoved") {
                // 찜하기 버튼 아이콘을 "찜하기"로 변경
                $("#favoriteUser").removeClass("fa-heart").addClass("fa-heart-o");
                alert("해당 유저를 모아보기목록에 제거하였습니다.");
            }
        }
    });
    } else {
    	alert("로그인이 필요한 기능입니다. 먼저 로그인해주세요.");
    	window.location.href = '${pageContext.request.contextPath}/login'; 
    }
});

$("#pullUpGoods").click(function() {		// 등록사용자와 로그인사용자가 일치할경우에만 할것 TODO
	var goodsId = ${goodsDto.goodsId}; // 해당 상품 등록 id		
	var userId = "${loginId}";
    var goodsUserId = "${goodsDto.userId}";
	
    console.log(userId);
    console.log(goodsUserId);
    
    
    if(userId) {
    	$.ajax({
        	type: "POST",
        	url: "${pageContext.request.contextPath}/goods/pullup", 
      	 	data: {
      	 	 goodsId: goodsId
        },
        success: function (data) {
            // 요청이 성공했을 때 실행할 코드
            if(userId == goodsUserId){
            
            if (data === "update") {
                alert("해당 상품을 끌어올렸습니다 !!");
            } else if (data === "error") {
                alert("상품을 등록하거나 끌어올린지 1시간 지나야 가능합니다.");
            }
          }
        }
    });
    } else {
    	alert("로그인이 필요한 기능입니다. 먼저 로그인해주세요.");
    	window.location.href = '${pageContext.request.contextPath}/login'; 
    }
});

$("#deleteGoods").click(function() {		// 등록사용자와 로그인사용자가 일치할경우에만 할것 TODO
	var goodsId = ${goodsDto.goodsId}; // 해당 상품 등록 id
	var userId = "${loginId}"
	var goodsUserId = "${goodsDto.userId}";
	
    if(userId) {
    	$.ajax({
        	type: "POST",
        	url: "${pageContext.request.contextPath}/goods/deletegoods", 
      	 	data: {
      	 	 goodsId: goodsId
        },
        success: function (data) {
            // 요청이 성공했을 때 실행할 코드
            if(userId == goodsUserId){
	            if (data === "delete") {
    	            alert("해당 상품을 삭제했습니다 !!");
    	            window.location.href = '${pageContext.request.contextPath}/goods/board';
       	     } else if (data === "fail") {
       	         alert("상품을 삭제에 실패했습니다.");
        	    }
            } else {
            	alert("등록된 사용자가 아닙니다.");
            }
        }
    });
    } else {
    	alert("로그인이 필요한 기능입니다. 먼저 로그인해주세요.");
    	window.location.href = '${pageContext.request.contextPath}/login'; 
    }
});

$("#modifyGoods").click(function() {
	var goodsId = ${goodsDto.goodsId}; // 해당 상품 등록 id
	var userId = "${loginId}"		// 로그인한 id
	var goodsUserId = "${goodsDto.userId}";		//글 작성 id
	if(userId){
		if(userId == goodsUserId){
			window.location.href = '${pageContext.request.contextPath}/goods/modify?goodsId=' + goodsId;
		} else {
			alert("수정 권한이 없습니다.");
		}
	} else {
		alert("로그인이 필요한 기능입니다. 먼저 로그인해주세요.");
    	window.location.href = '${pageContext.request.contextPath}/login'; 
	}
)}



//찜 여부 확인 및 버튼 초기화
function checkWishlist() {
    var goodsId = ${goodsDto.goodsId}; // 해당 상품의 ID
    var userId = "${loginId}"; // 로그인된 사용자의 ID 또는 세션에서 가져온 ID
	
    // AJAX 요청 설정
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/goods/checkwishlist", // 찜 여부 확인을 처리할 컨트롤러 경로
        data: {
            goodsId: goodsId,
            userId: userId
        },
        success: function (data) {
            var wishButton = $("#wishButton");
            if (data === "added") {
                // 찜하기 버튼 아이콘을 "찜됨"으로 변경
                wishButton.removeClass("fa-heart-o").addClass("fa-heart");
            } else {
                // 찜하기 버튼은 기본 "찜하기"로 유지
                wishButton.removeClass("fa-heart").addClass("fa-heart-o");
            }
        }
    });
}
// 글 작성유저 좋아요 확인 및 버튼 초기화
function checkFavoriteUser() {
    var targetId = '${goodsDto.userId}'; // 해당 상품의 ID
    var userId = "${loginId}"; // 로그인된 사용자의 ID 또는 세션에서 가져온 ID
	
    // AJAX 요청 설정
    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/goods/checkfavoriteuser", // 찜 여부 확인을 처리할 컨트롤러 경로
        data: {
        	targetId: targetId,
            userId: userId
        },
        success: function (data) {
            var favoriteButton = $("#favoriteUser");
            if (data === "addedUser") {
                // 좋아요 버튼 아이콘을 "좋아요전"으로 변경
                favoriteButton.removeClass("fa-heart-o").addClass("fa-heart");
            } else {
                // 좋아요 버튼 아이콘을 기본 "좋아요상태"로 유지
                favoriteButton.removeClass("fa-heart").addClass("fa-heart-o");
            }
        }
    });
}


var msg = '${msg}';
if(msg){
	alert(msg);
}
</script>
	

</body>
</html>