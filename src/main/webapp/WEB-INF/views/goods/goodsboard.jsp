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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/goods/goods.css"
	type="text/css"> 
	
</head>
<body>

	<!-- header start -->
	<header>
		<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	</header>
	<!-- header end -->
	<h2>중고 거래 게시판</h2>

	<main class="relative flex-grow border-b-2"
		style="min-height: -webkit-fill-available; -webkit-overflow-scrolling: touch">
		<div
			class="flex pt-0 pb-16 bg-white lg:pt-8 lg:pb-20 mx-auto max-w-[1280px] px-4 md:px-8 2xl:px-16 box-content">
			<div class="flex-shrink-0 hidden pe-24 lg:block w-96">
				<div
					class="w-full overflow-y-auto overflow-x-hidden sticky top-[200px] bottom-5 search-filter">
					<div class="pt-1">
						<div class="block border-b border-gray-300 pb-7 mb-7">
							<div class="flex items-center justify-between mb-2.5">
								<h2 class="font-semibold text-heading text-xl md:text-2xl">필터</h2>
								<button
									class="flex-shrink text-xs mt-0.5 transition duration-150 ease-in focus:outline-none hover:text-heading"
									aria-label="Clear All">초기화</button>
							</div>
							<div class="flex flex-wrap -m-1.5 pt-2"></div>
						</div>
						<div class="block border-b border-gray-300 pb-7 mb-7">
							<h3 class="text-sm font-semibold text-heading md:text-base mb-7">카테고리</h3>
							<ul class="flex flex-col mt-2 space-y-4">
								<li><div class="relative flex items-center justify-between">
										<label
											class="flex items-center text-sm cursor-pointer group text-heading"><a
											href="/search?page=1&amp;category=1"><span
												class="relative text-sm ms-2 text-heading font-normal">수입명품</span></a></label>
							</ul>
						</div>
						<div class="block border-b border-gray-300 pb-7 mb-7">
							<h3 class="text-heading text-sm md:text-base font-semibold mb-7">가격</h3>
							<ul class="mt-2 flex flex-col space-y-4">
								<li><div class="relative flex items-center justify-between">
										<label
											class="flex items-center text-sm cursor-pointer group text-heading"><a
											href="/search?page=1&amp;minPrice=0&amp;maxPrice=100000"><input
												type="radio"
												class="w-5 h-5 transition duration-500 ease-in-out border border-gray-300 rounded-full cursor-pointer form-radio text-heading focus:ring-offset-0 hover:border-heading focus:outline-none focus:ring-0 focus-visible:outline-none checked:bg-heading"
												readonly="" name="price" value=""><span
												class="relative text-sm ms-2 text-heading">10만원 이하</span></a></label>
									</div></li>
								<li><div class="relative flex items-center justify-between">
										<label
											class="flex items-center text-sm cursor-pointer group text-heading"><a
											href="/search?page=1&amp;minPrice=100000&amp;maxPrice=300000"><input
												type="radio"
												class="w-5 h-5 transition duration-500 ease-in-out border border-gray-300 rounded-full cursor-pointer form-radio text-heading focus:ring-offset-0 hover:border-heading focus:outline-none focus:ring-0 focus-visible:outline-none checked:bg-heading"
												readonly="" name="price" value=""><span
												class="relative text-sm ms-2 text-heading">10만원 -
													30만원 이하</span></a></label>
									</div></li>
								<li><div class="relative flex items-center justify-between">
										<label
											class="flex items-center text-sm cursor-pointer group text-heading"><a
											href="/search?page=1&amp;minPrice=300000&amp;maxPrice=500000"><input
												type="radio"
												class="w-5 h-5 transition duration-500 ease-in-out border border-gray-300 rounded-full cursor-pointer form-radio text-heading focus:ring-offset-0 hover:border-heading focus:outline-none focus:ring-0 focus-visible:outline-none checked:bg-heading"
												readonly="" name="price" value=""><span
												class="relative text-sm ms-2 text-heading">30만원 -
													50만원 이하</span></a></label>
									</div></li>
								<li><div class="relative flex items-center justify-between">
										<label
											class="flex items-center text-sm cursor-pointer group text-heading"><a
											href="/search?page=1&amp;minPrice=500000&amp;maxPrice=2000000000"><input
												type="radio"
												class="w-5 h-5 transition duration-500 ease-in-out border border-gray-300 rounded-full cursor-pointer form-radio text-heading focus:ring-offset-0 hover:border-heading focus:outline-none focus:ring-0 focus-visible:outline-none checked:bg-heading"
												readonly="" name="price" value=""><span
												class="relative text-sm ms-2 text-heading">50만원 이상</span></a></label>
									</div></li>
							</ul>
						</div>
					</div>
					<div style="height: calc(100% + 1px); position: absolute;"></div>
				</div>
			</div>
			<div class="w-full lg:-ms-9">
				<div class="mb-4">
					<div class="chawkbazarBreadcrumb w-full flex items-center">
						<ol class="flex items-center w-full">
							<li
								class="text-sm text-body px-2.5 transition duration-200 ease-in first:ps-0 last:pe-0 hover:text-heading"><a
								class="false" href="/">홈</a></li>
							<li
								class="text-sm leading-5 text-body min-[480px]:px-1 max-[480px]:px-0">&gt;</li>
							<li
								class="text-sm text-body px-2.5 transition duration-200 ease-in first:ps-0 last:pe-0 hover:text-heading"><a
								class="false" href="/search">검색</a></li>
						</ol>
					</div>
				</div>
				<div
					class="sticky top-16 sm:top-20 lg:top-36 xl:top-40 bg-white z-10 pb-2 pt-2 mb-2">
					<div class="flex justify-between items-center mb-1 mt-1">
						<h1
							class="text-heading text-2xl font-bold hidden lg:inline-flex pb-1">검색
							결과</h1>
						<button
							class="lg:hidden text-heading text-sm px-4 py-2 font-semibold border border-gray-300 rounded-md flex items-center transition duration-200 ease-in-out focus:outline-none hover:bg-gray-200">
							<svg xmlns="http://www.w3.org/2000/svg" width="18px"
								height="14px" viewBox="0 0 18 14">
								<g id="Group_36196" data-name="Group 36196"
									transform="translate(-925 -1122.489)">
								<path id="Path_22590" data-name="Path 22590"
									d="M942.581,1295.564H925.419c-.231,0-.419-.336-.419-.75s.187-.75.419-.75h17.163c.231,0,.419.336.419.75S942.813,1295.564,942.581,1295.564Z"
									transform="translate(0 -169.575)" fill="currentColor"></path>
								<path id="Path_22591" data-name="Path 22591"
									d="M942.581,1951.5H925.419c-.231,0-.419-.336-.419-.75s.187-.75.419-.75h17.163c.231,0,.419.336.419.75S942.813,1951.5,942.581,1951.5Z"
									transform="translate(0 -816.512)" fill="currentColor"></path>
								<path id="Path_22593" data-name="Path 22593"
									d="M1163.713,1122.489a2.5,2.5,0,1,0,1.768.732A2.483,2.483,0,0,0,1163.713,1122.489Z"
									transform="translate(-233.213)" fill="currentColor"></path>
								<path id="Path_22594" data-name="Path 22594"
									d="M2344.886,1779.157a2.5,2.5,0,1,0,.731,1.768A2.488,2.488,0,0,0,2344.886,1779.157Z"
									transform="translate(-1405.617 -646.936)" fill="currentColor"></path></g></svg>
							<span class="ps-2.5">필터</span>
						</button>
						<div class="flex items-center justify-end">
							<div
								class="flex-shrink-0 text-body text-xs md:text-sm leading-4 pe-4 md:me-6 ps-2 hidden lg:block">26,901,720
								개의 상품</div>
							<div class="relative ms-2 z-10 min-w-[180px]">
								<button
									class="border border-gray-300 text-heading text-[13px] md:text-sm font-semibold relative w-full py-2 ps-3 pe-10 text-start bg-white rounded-lg shadow-md focus:outline-none focus-visible:ring-2 focus-visible:ring-opacity-75 focus-visible:ring-white focus-visible:ring-offset-orange-300 focus-visible:ring-offset-2 focus-visible:border-indigo-500 sm:text-sm cursor-pointer"
									id="headlessui-listbox-button-:r0:" type="button"
									aria-haspopup="listbox" aria-expanded="false"
									data-headlessui-state="">
									<span class="block truncate">추천순</span><span
										class="absolute inset-y-0 end-0 flex items-center pe-2 pointer-events-none"><svg
											stroke="currentColor" fill="none" stroke-width="0"
											viewBox="0 0 24 24" class="w-5 h-5 text-gray-400"
											aria-hidden="true" height="1em" width="1em"
											xmlns="http://www.w3.org/2000/svg">
											<path stroke-linecap="round" stroke-linejoin="round"
												stroke-width="2" d="M8 9l4-4 4 4m0 6l-4 4-4-4"></path></svg></span>
								</button>
								<ul class="absolute w-full py-1 mt-1 overflow-auto bg-white rounded-md shadow-lg max-h-60 ring-1 ring-black ring-opacity-5 focus:outline-none text-sm" aria-labelledby="headlessui-listbox-button-:r0:" aria-orientation="vertical" id="headlessui-listbox-options-:r1:" role="listbox" tabindex="0" data-headlessui-state="open" aria-activedescendant="headlessui-listbox-option-:r2:"><li class="text-amber-900 bg-gray-100
                          cursor-default select-none relative py-2 ps-10 pe-4" id="headlessui-listbox-option-:r2:" role="option" tabindex="-1" aria-selected="true" data-headlessui-state="active selected"><span class="font-medium block truncate">추천순</span><span class="text-amber-600
                                check-icon absolute inset-y-0 start-0 flex items-center ps-3"><svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 20 20" class="w-5 h-5" aria-hidden="true" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M16.707 5.293a1 1 0 010 1.414l-8 8a1 1 0 01-1.414 0l-4-4a1 1 0 011.414-1.414L8 12.586l7.293-7.293a1 1 0 011.414 0z" clip-rule="evenodd"></path></svg></span></li><li class="text-gray-900
                          cursor-default select-none relative py-2 ps-10 pe-4" id="headlessui-listbox-option-:r3:" role="option" tabindex="-1" aria-selected="false" data-headlessui-state=""><span class="font-normal block truncate">최신순</span></li><li class="text-gray-900
                          cursor-default select-none relative py-2 ps-10 pe-4" id="headlessui-listbox-option-:r4:" role="option" tabindex="-1" aria-selected="false" data-headlessui-state=""><span class="font-normal block truncate">낮은가격순</span></li><li class="text-gray-900
                          cursor-default select-none relative py-2 ps-10 pe-4" id="headlessui-listbox-option-:r5:" role="option" tabindex="-1" aria-selected="false" data-headlessui-state=""><span class="font-normal block truncate">높은가격순</span></li></ul>
							</div>
						</div>
					</div>
				</div>
				<div tabindex="0" aria-labelledby="product-list-price-title">
					<h4 class="mb-2 text-lg font-semibold">
						<span
							class="relative before:block before:absolute before:-inset-0 before:top-4 before:bg-jngreen"><span
							id="product-list-price-title" class="relative">현재 페이지의 상품
								가격을 비교해봤어요</span></span>
					</h4>
					<div
						class="flex bg-jngreen bg-opacity-10 p-4 border-solid border-[1px] border-jngreen mb-10
    max-[599px]:flex-col max-[599px]:space-y-3">
						<div class="flex flex-col flex-1"
							aria-labelledby="product-item-price-title-1" tabindex="0">
							<span id="product-item-price-title-1"
								class="font-semibold
    max-[599px]:text-sm ">평균 가격이에요</span><span
								tabindex="0"><span class="mr-1">평균</span><span
								class="font-bold text-2xl mr-1
    max-[599px]:text-xl">348,154</span>원</span>
						</div>
						<div class="flex flex-col flex-1"
							aria-labelledby="product-item-price-title-2" tabindex="0">
							<span id="product-item-price-title-2"
								class="font-semibold
    max-[599px]:text-sm ">가장 높은
								가격이에요</span><span tabindex="0" class="text-red-400"><span
								class="mr-1">최고</span><span
								class="font-bold text-2xl mr-1
    max-[599px]:text-xl">2,600,000</span>원</span>
						</div>
						<div class="flex flex-col flex-1"
							aria-labelledby="product-item-price-title-3" tabindex="0">
							<span id="product-item-price-title-3"
								class="font-semibold
    max-[599px]:text-sm ">가장 낮은
								가격이에요</span><span tabindex="0" class="text-blue-500"><span
								class="mr-1">최저</span><span
								class="font-bold text-2xl mr-1
    max-[599px]:text-xl">1,000</span>원</span>
						</div>
					</div>
				</div>
				
				
				
				
				
				
				
				
				
				
				<ul
					class="grid grid-cols-2 sm:grid-cols-3 xl:grid-cols-4 2xl:grid-cols-5 gap-x-3 lg:gap-x-5 xl:gap-x-7 gap-y-3 xl:gap-y-5 2xl:gap-y-8 search-results">
					<li class=""><a
						class="group box-border overflow-hidden flex rounded-md cursor-pointer pe-0 pb-2 lg:pb-3 flex-col items-start transition duration-200 ease-in-out transform hover:-translate-y-1 md:hover:-translate-y-1.5 hover:shadow-product bg-white"
						title="레이싱휠 풀세트 팝니다" href="/product/133570391"><div
								class="relative w-full rounded-md overflow-hidden pt-[100%] mb-3 md:mb-3.5">
								<img alt="레이싱휠 풀세트 팝니다" referrerpolicy="no-referrer"
									src="https://img2.joongna.com/media/original/2023/09/26/16957188091476Q2_NZ4JF.jpg?impolicy=thumb&amp;size=150"
									decoding="async" data-nimg="fill"
									class="bg-gray-300 object-cover w-full transition duration-200 ease-in rounded-md group-hover:rounded-b-none"
									style="position: absolute; height: 100%; width: 100%; inset: 0px; color: transparent;">
							</div>
							<div class="w-full overflow-hidden p-2 md:px-2.5 xl:px-4">
								<h2 class="line-clamp-2 text-sm md:text-base text-heading">레이싱휠
									풀세트 팝니다</h2>
								<div
									class="font-semibold space-s-2 mt-0.5 text-heading lg:text-lg lg:mt-1.5">1,300,000원</div>
								<div class="my-1">
									<span class="text-sm text-gray-400">온천제2동</span><span
										class="text-sm text-gray-400 mx-1">|</span><span
										class="text-sm text-gray-400">7초 전</span>
								</div>
								<div class="flex items-center">
									<svg width="30" height="17" viewBox="0 0 30 17" fill="none"
										xmlns="http://www.w3.org/2000/svg" class="mr-1">
										<rect y="-0.00012207" width="30" height="16.2857" rx="2.25"
											fill="#0DCC5A"></rect>
										<path
											d="M11.6626 6.31356V6.28956C11.6626 4.57356 10.4506 3.38556 8.44665 3.38556H5.01465V11.7856H6.86265V9.26556H8.26665C10.1506 9.26556 11.6626 8.25756 11.6626 6.31356ZM9.79065 6.34956C9.79065 7.06956 9.25065 7.62156 8.32665 7.62156H6.86265V5.05356H8.29065C9.21465 5.05356 9.79065 5.49756 9.79065 6.32556V6.34956Z"
											fill="white"></path>
										<path
											d="M18.2531 11.7856V8.05356C18.2531 6.31356 17.3771 5.28156 15.3851 5.28156C14.2931 5.28156 13.5971 5.48556 12.8891 5.79756L13.3451 7.18956C13.9331 6.97356 14.4251 6.84156 15.1211 6.84156C16.0331 6.84156 16.5011 7.26156 16.5011 8.01756V8.12556C16.0451 7.96956 15.5771 7.86156 14.9291 7.86156C13.4051 7.86156 12.3371 8.50956 12.3371 9.91356V9.93756C12.3371 11.2096 13.3331 11.9056 14.5451 11.9056C15.4331 11.9056 16.0451 11.5816 16.4891 11.0896V11.7856H18.2531ZM16.5251 9.51756C16.5251 10.1776 15.9491 10.6456 15.0971 10.6456C14.5091 10.6456 14.1011 10.3576 14.1011 9.86556V9.84156C14.1011 9.26556 14.5811 8.95356 15.3611 8.95356C15.8051 8.95356 16.2131 9.04956 16.5251 9.19356V9.51756Z"
											fill="white"></path>
										<path
											d="M25.7083 5.35356H23.8123L22.4083 9.73356L20.9443 5.35356H19.0123L21.5323 11.8096C21.3763 12.1336 21.2083 12.2296 20.8963 12.2296C20.6563 12.2296 20.3563 12.1216 20.1163 11.9776L19.5043 13.2976C19.9723 13.5736 20.4643 13.7416 21.1243 13.7416C22.2163 13.7416 22.7443 13.2496 23.2363 11.9416L25.7083 5.35356Z"
											fill="white"></path></svg>
								</div>
							</div></a></li>
				</ul>
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				<div class="bottom-0 py-3 m-auto text-center bg-white">
					<ul class="flex justify-center space-x-2 space-x-reverse">
						<a class="mr-2 w-4" href="/search?page=0"><svg
								stroke="currentColor" fill="currentColor" stroke-width="0"
								viewBox="0 0 24 24" class="hidden h-full" height="1em"
								width="1em" xmlns="http://www.w3.org/2000/svg">
								<path d="M15.41 16.09l-4.58-4.59 4.58-4.59L14 5.5l-6 6 6 6z"></path></svg></a>
						<li class="w-10 h-10 rounded-md shrink-0 bg-jngreen/80 text-white"><a
							class="block leading-10" href="/search?page=1">1</a></li>
						<li class="w-10 h-10 rounded-md shrink-0"><a
							class="block leading-10" href="/search?page=2">2</a></li>
						<li class="w-10 h-10 rounded-md shrink-0"><a
							class="block leading-10" href="/search?page=3">3</a></li>
						<li class="w-10 h-10 rounded-md shrink-0"><a
							class="block leading-10" href="/search?page=4">4</a></li>
						<li class="w-10 h-10 rounded-md shrink-0"><a
							class="block leading-10" href="/search?page=5">5</a></li>
						<li class="w-10 h-10 rounded-md shrink-0"><a
							class="block leading-10" href="/search?page=6">6</a></li>
						<li class="w-10 h-10 rounded-md shrink-0"><a
							class="block leading-10" href="/search?page=7">7</a></li>
						<li class="w-10 h-10 rounded-md shrink-0"><a
							class="block leading-10" href="/search?page=8">8</a></li>
						<li class="w-10 h-10 rounded-md shrink-0"><a
							class="block leading-10" href="/search?page=9">9</a></li>
						<li class="w-10 h-10 rounded-md shrink-0"><a
							class="block leading-10" href="/search?page=10">10</a></li>
						<li class="w-10 h-10 rounded-md shrink-0"><a
							class="block leading-10" href="/search?page=11">11</a></li>
						<a href="/search?page=2"><svg stroke="currentColor"
								fill="currentColor" stroke-width="0" viewBox="0 0 24 24"
								class="h-full block" height="1em" width="1em"
								xmlns="http://www.w3.org/2000/svg">
								<path d="M8.59 16.34l4.58-4.59-4.58-4.59L10 5.75l6 6-6 6z"></path></svg></a>
					</ul>
				</div>
				<div class="invisible w-full h-1"></div>
				<div class="pb-10 pt-10">
					<ul
						class="grid grid-cols-[repeat(auto-fit,minmax(240px,1fr))] overflow-hidden"></ul>
				</div>
				<div class="pb-8 max-w-[632px]">
					<ul></ul>
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
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/goods/framework.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/goods/app.js"></script>


</body>
</html>