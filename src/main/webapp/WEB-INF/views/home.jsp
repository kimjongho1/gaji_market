<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>GaJi-main</title>

	<!--favicon  -->
	<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mainswiper.css" type="text/css">
   
  <c:if test="${not empty msg}">
    <script>
        alert("<c:out value='${msg}'/>");
    </script>
</c:if>
 
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

   <!-- header start -->      
<jsp:include page="header.jsp"></jsp:include>
   <!-- header end -->   
   			<section class="banner">  
                     <div class="hero__item set-bg" data-setbg="${pageContext.request.contextPath}/resources/img/hero/banner.jpg">
                        <div class="hero__text">
                            <span>Easy and Fast</span>
                            <h2>GaJi_Market <br />가지마켓</h2>
                            <a href="${pageContext.request.contextPath}/goods/board" class="primary-btn">상품 보기</a>
                        </div>
                    </div> 
			</section> 

	<!-- banner -->
	<section>
	

<div class="swiper">
    
    <!-- swiper slides -->
    <div class="swiper-wrapper">
        <div class="swiper-slide">
            <img src="https://source.unsplash.com/random?sig=24">
        </div>
        
        <div class="swiper-slide"> 
            <img src="https://source.unsplash.com/random?sig=53">
        </div>
        
        <div class="swiper-slide">
            <img src="https://source.unsplash.com/random?sig=52">
        </div>
        
        <div class="swiper-slide">
            <img src="https://source.unsplash.com/random?sig=21">
        </div>
        
        <div class="swiper-slide">
            <img src="https://source.unsplash.com/random?sig=53">
        </div>
        
        <div class="swiper-slide">
            <img src="https://source.unsplash.com/random?sig=57">
        </div>
        
        <div class="swiper-slide">
            <img src="https://source.unsplash.com/random?sig=26">
        </div>
        
        <div class="swiper-slide">
            <img src="https://source.unsplash.com/random?sig=29">
        </div>
        
        <div class="swiper-slide">
            <img src="https://source.unsplash.com/random?sig=30">
        </div>
        
        <div class="swiper-slide">
            <img src="https://source.unsplash.com/random?sig=35">
        </div>
        
        <div class="swiper-slide">
            <img src="https://source.unsplash.com/random?sig=31">
        </div>
    </div>
    <!-- !swiper slides -->
    
    
    <!-- pagination dots -->
    <div class="swiper-pagination"></div>
    <!-- !pagination dots -->
</div>
	
	</section>


    <!-- Latest Product Section Begin -->
    <section class="latest-product spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>디지털기기</h4>
                        <div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                            <c:forEach var="item" items="${cateGoods1}" begin="0" end="2">
                              <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                            <div class="latest-prdouct__slider__item">
                            <c:forEach var="item" items="${cateGoods1}" begin="3" end="5">
                                <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>가구/인테리어</h4>
                        <div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <c:forEach var="item" items="${cateGoods2}" begin="0" end="2">
                              <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                            <div class="latest-prdouct__slider__item">
                            <c:forEach var="item" items="${cateGoods2}" begin="3" end="5">
                                <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>생활/가전</h4>
                        <div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <c:forEach var="item" items="${cateGoods3}" begin="0" end="2">
                              <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                            <div class="latest-prdouct__slider__item">
                            <c:forEach var="item" items="${cateGoods3}" begin="3" end="5">
                                <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
                <!-- 두번ㅉ -->
                <div class="row">
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>생활/주방</h4>
                        <div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <c:forEach var="item" items="${cateGoods4}" begin="0" end="2">
                              <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                            <div class="latest-prdouct__slider__item">
                            <c:forEach var="item" items="${cateGoods4}" begin="3" end="5">
                                <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>취미/게임</h4>
                        <div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <c:forEach var="item" items="${cateGoods5}" begin="0" end="2">
                              <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                            <div class="latest-prdouct__slider__item">
                            <c:forEach var="item" items="${cateGoods5}" begin="3" end="5">
                                <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6">
                    <div class="latest-product__text">
                        <h4>기타</h4>
                        <div class="latest-product__slider owl-carousel">
                            <div class="latest-prdouct__slider__item">
                                <c:forEach var="item" items="${cateGoods6}" begin="0" end="2">
                              <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                            <div class="latest-prdouct__slider__item">
                            <c:forEach var="item" items="${cateGoods6}" begin="3" end="5">
                                <a href="${pageContext.request.contextPath}/goods/get?goodsId=${item.goodsId}" class="latest-product__item">
                                    <div class="latest-product__item__pic">
                                        <img src="${item.url}" alt="사진없음."  style="width:110px; height:110px;">
                                    </div>
                                    <div class="latest-product__item__text">
                                        <h6>${item.title}</h6>
                                        <span>${item.price}</span>
                                    </div>
                                </a>
                            </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
               </div>
        </div>
    </section>
    <!-- Latest Product Section End -->

	<section >
	<div class="dbanner">
	<img src="https://source.unsplash.com/random?sig=11">
	
	</div>
	</section>


    <!-- Footer Section Begin -->
    <jsp:include page="footer.jsp"></jsp:include>	
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.slicknav.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/mixitup.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/mainswiper.js"></script>
    

</body>

</html>