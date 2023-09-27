<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>판매내역</title>
        <!-- Favicon-->
<!--         <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <script src="${pageContext.request.contextPath}/resources/js/orderstatus.js"></script>
		<link href="${pageContext.request.contextPath}/resources/css/orderstatus.css" rel='stylesheet' type='text/css'>
		<style>
		.personal1{
			  position:absolute;
			  left:850px;
			  top:35px;
		}
		.personal2{
			  position:absolute;
			  left:980px;
			  top:35px;
		}
		.btn{
			  background-color: #007BFF; /* 파란색 배경 */
			  color: white; /* 흰색 글자색 */
		}
		.btn-top{
			  
			  display:flex;
			  justify-content: center;		
			  padding-top: 35px;
		}
		.personal{
			  margin: 0 50px 0 50px ;
		}
		</style>
    </head>
    
    
    <body>
    
  
        <!-- Section-->

        <div class="btn-top">
        	<button class="btn btn-outline-dark personal" id="onSale" onclick="onSale()">판매중</button>
			<button class="btn btn-outline-dark personal" id="closed" onclick="closed1()">판매완료</button>
			<button class="btn btn-outline-dark personal" id="hide" onclick="hide()">숨김</button>
        </div>
    
        
        <section class="py-1">
            <div class="container px-4 px-lg-5 mt-5">
                <div id="replacePoint" class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                   <c:forEach var="myGoodsDto"  items="${myGoodsList}">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
								<c:choose>
									<c:when test="${myGoodsDto.status eq 1}">판매중</c:when>
									<c:when test="${myGoodsDto.status eq 2}">예약중</c:when>
									<c:when test="${myGoodsDto.status eq 3}">판매완료</c:when>
									<c:when test="${myGoodsDto.status eq 4}">숨김</c:when>
								</c:choose>
							</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${myGoodsDto.title}</h5>
                                    <!-- Product price-->
                                    끌올일자:${myGoodsDto.refreshedAt}<br>
                                    가격:${myGoodsDto.price}
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${pageContext.request.contextPath}/goods/get?goodsId=${myGoodsDto.goodsId}">상품정보</a></div> 
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

<script>
	var onSale=()=>{
		$.ajax({
			url:"${pageContext.request.contextPath}/mypage/getonsale",
			data:{userId:"cjsdudwns",currentPageNum:1}, //이후 userId로 바꿔야함
			type:"POST",
			dataType:"Json",
			success:getOnSaleView
			});
		}
	
	var closed1=()=>{
		$.ajax({
			url:"${pageContext.request.contextPath}/mypage/getclosed",
			data:{userId:"cjsdudwns",currentPageNum:1}, //이후 userId로 바꿔야함
			type:"POST",
			dataType:"Json",
			success:getClosedView
			});
		}
	
	var hide=()=>{
		$.ajax({
			url:"${pageContext.request.contextPath}/mypage/gethide",
			data:{userId:"cjsdudwns",currentPageNum:1}, //이후 userId로 바꿔야함
			type:"POST",
			dataType:"Json",
			success:getHideView
			});
	}
	
	var getOnSaleView=(data)=>{
	var table="<div id='replacePoint' class='row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center'>";
		for(var i=0; i<data.length; i++){
			let item=data[i];
			var html="<div class='col mb-5'><div class='card h-100'><div class='badge bg-dark text-white position-absolute' style='top: 0.5rem; right: 0.5rem'>";
			if(item.status ==1)
				html+="판매중";
			else if(item.status ==2)
				html+="예약중";
			
			html+="</div><img class='card-img-top' src='https://dummyimage.com/450x300/dee2e6/6c757d.jpg' alt=''...'' /><div class='card-body p-4'><div class='text-center'><h5 class='fw-bolder'>"
				+item.title+"</h5>";
			
			html+="끌올일자:"
            +item.refreshedAt+
            "<br>가격:"+item.price+"</div></div><div class='card-footer p-4 pt-0 border-top-0 bg-transparent'>"
            +"<div class='text-center'><a class='btn btn-outline-dark mt-auto' href="+"${pageContext.request.contextPath}/goods/get?goodsId="+item.goodsId+">상품정보</a></div></div></div></div>";
            table+=html;	
		}
		html+="</div>";
		
		$("#replacePoint").replaceWith(table);
	}
	
	var getClosedView=(data)=>{
		var table="<div id='replacePoint' class='row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center'>";
		for(var i=0; i<data.length; i++){
			let item=data[i];
			var html="<div class='col mb-5'><div class='card h-100'><div class='badge bg-dark text-white position-absolute' style='top: 0.5rem; right: 0.5rem'>";
				html+="판매완료";
			
			html+="</div><img class='card-img-top' src='https://dummyimage.com/450x300/dee2e6/6c757d.jpg' alt=''...'' /><div class='card-body p-4'><div class='text-center'><h5 class='fw-bolder'>"
				+item.title+"</h5>";
			
			html+="끌올일자:"
            +item.refreshedAt+
            "<br>가격:"+item.price+"</div></div><div class='card-footer p-4 pt-0 border-top-0 bg-transparent'>"
            +"<div class='text-center'><a class='btn btn-outline-dark mt-auto' href="+"${pageContext.request.contextPath}/goods/get?goodsId="+item.goodsId+">상품정보</a></div></div></div></div>";
            table+=html;	
		}
		html+="</div>";
		
		$("#replacePoint").replaceWith(table);
	}
	
	var getHideView=(data)=>{
		var table="<div id='replacePoint' class='row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center'>";
		for(var i=0; i<data.length; i++){
			let item=data[i];
			var html="<div class='col mb-5'><div class='card h-100'><div class='badge bg-dark text-white position-absolute' style='top: 0.5rem; right: 0.5rem'>";
				html+="숨김";
			
			html+="</div><img class='card-img-top' src='https://dummyimage.com/450x300/dee2e6/6c757d.jpg' alt=''...'' /><div class='card-body p-4'><div class='text-center'><h5 class='fw-bolder'>"
				+item.title+"</h5>";
			
			html+="끌올일자:"
            +item.refreshedAt+
            "<br>가격:"+item.price+"</div></div><div class='card-footer p-4 pt-0 border-top-0 bg-transparent'>"
            +"<div class='text-center'><a class='btn btn-outline-dark mt-auto' href="+"${pageContext.request.contextPath}/goods/get?goodsId="+item.goodsId+">상품정보</a></div></div></div></div>";
            table+=html;	
		}
		html+="</div>";
		
		$("#replacePoint").replaceWith(table);
	}
</script>