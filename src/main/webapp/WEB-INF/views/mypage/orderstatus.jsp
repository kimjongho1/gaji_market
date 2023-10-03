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
        <title>구매내역</title>
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
        	<button class="btn btn-outline-dark personal" id="inFace" onclick="viewInface()">직거래</button>
			<button class="btn btn-outline-dark personal" id="safeTrading" onclick="safeTrading()">안전거래</button>
        </div>
    
        
        <section class="py-1">
            <div class="container px-4 px-lg-5 mt-5">
                <div id="replacePoint" class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                   <c:forEach var="safePurchaseInfo"  items="${safePurchaseList}">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
								<c:choose>
									<c:when test="${safePurchaseInfo.tradingStatus eq 1}">입금완료</c:when>
									<c:when test="${safePurchaseInfo.tradingStatus eq 2}">상품준비중</c:when>
									<c:when test="${safePurchaseInfo.tradingStatus eq 3}">배송중</c:when>
									<c:when test="${safePurchaseInfo.tradingStatus eq 4}">거래완료</c:when>
									<c:when test="${safePurchaseInfo.tradingStatus eq 5}">결제취소</c:when>
								</c:choose>
							</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${safePurchaseInfo.goodsTitle}</h5>
                                    <!-- Product price-->
                                    거래일자:${safePurchaseInfo.tradingDate}<br>
                                    가격:${safePurchaseInfo.price}
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="${pageContext.request.contextPath}/mypage/deal/safe/buyer?transactionId=${safePurchaseInfo.transactionId}">구매정보</a></div> <!-- 추후${safePurchaseInfo.goodsTitle} 를 담아서 상세정보이동 -->
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- <script>$(".pagingForInface").hide();</script> 페이지 진입시에는 안전거래 페이지번호만 보이게하는코드 -->
    </body>
</html>

<script>

	const safeTrading=()=>{
		$.ajax({
		url:"${pageContext.request.contextPath}/mypage/getSafeTradingView",
		data:{userId:"qordmlgjs",currentPageNum:1}, //이후 userId로 바꿔야함
		type:"POST",
		dataType:"Json",
		success:getSafeView
		});
	}
	
	const viewInface=()=>{
		$.ajax({
			url:"${pageContext.request.contextPath}/mypage/getInFaceView",
			data:{userId:"qordmlgjs",currentPageNum:1}, //이후 userId로 바꿔야함
			type:"POST",
			dataType:"Json",
			success:getInFaceView
		});
	}

	
	var getInFaceView=(data)=>{	//직거래 버튼 클릭시 직거래내역 보이게하기.
		console.log("getInFaceView");
		console.log(data);
		var table="<div id='replacePoint' class='row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center'>";
		
		for(var i=0; i<data.length; i++){
			let item=data[i];
			var html="<div class='col mb-5'><div class='card h-100'><div class='badge bg-dark text-white position-absolute' style='top: 0.5rem; right: 0.5rem'>";
			if(item.tradingStatus ==1)
				html+="예약중";
			else if(item.tradingStatus ==2)
				html+="거래완료";
			else
				html+="거래취소";
			
			html+="</div><img class='card-img-top' src='https://dummyimage.com/450x300/dee2e6/6c757d.jpg' alt=''...'' /><div class='card-body p-4'><div class='text-center'><h5 class='fw-bolder'>"
				+item.goodsTitle+"</h5>";
			
			html+="거래일자:"
		    +item.tradingDate+
		    "<br>가격:"+item.price+"</div></div><div class='card-footer p-4 pt-0 border-top-0 bg-transparent'>"
            +"<div class='text-center'><a class='btn btn-outline-dark mt-auto' href="+"${pageContext.request.contextPath}/mypage/deal/safe/buyer?transactionId="+item.goodsId+">상품정보</a></div></div></div></div>";
            table+=html;	
		}
		html+="</div>";
		
		$("#replacePoint").replaceWith(table);
/* 		$(".pagingForSafe").hide();
		$(".pagingForInface").show(); */
	}
	
	    var getSafeView=(data)=>{	//안전거래 버튼 클릭시 안전거래내역 불러오기.
		console.log(data);
		console.log("getSafeView");
				var table="<div id='replacePoint' class='row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center'>";
		
		for(var i=0; i<data.length; i++){
			let item=data[i];
			var html="<div class='col mb-5'><div class='card h-100'><div class='badge bg-dark text-white position-absolute' style='top: 0.5rem; right: 0.5rem'>";
			if(item.tradingStatus ==1)
				html+="입금완료"; 
			else if(item.tradingStatus ==2)
				html+="상품준비중";
			else if(item.tradingStatus ==3)
				html+="배송중";
			else if(item.tradingStatus ==4)
				html+="거래완료";
			else
				html+="결제취소";
			
			html+="</div><img class='card-img-top' src='https://dummyimage.com/450x300/dee2e6/6c757d.jpg' alt=''...'' /><div class='card-body p-4'><div class='text-center'><h5 class='fw-bolder'>"
			+item.goodsTitle+"</h5>";
			
			
			html+="거래일자:"
			+item.tradingDate+
			"<br>가격:"+item.price+"</div></div><div class='card-footer p-4 pt-0 border-top-0 bg-transparent'>"
            +"<div class='text-center'><a class='btn btn-outline-dark mt-auto' href="+"${pageContext.request.contextPath}/mypage/deal/safe/buyer?transactionId="+item.transactionId+">구매정보</a></div></div></div></div>";
            table+=html;
		}
		html+="</div>";
		$("#replacePoint").replaceWith(table);
/*		$(".pagingForInface").hide();
		$(".pagingForSafe").show(); */
	}
	
	var changePage=(currentPage,type)=>{	//안전거래 
		if(type==1){	
		$.ajax({
			url:"${pageContext.request.contextPath}/mypage/getSafeTradingView",
			data:{userId:"qordmlgjs",currentPageNum:currentPage}, //이후 userId로 바꿔야함
			type:"POST",
			dataType:"Json",
			success:getSafeView
		});
		}
		else
			$.ajax({						//직거래
				url:"${pageContext.request.contextPath}/mypage/getInFaceView",
				data:{userId:"qordmlgjs",currentPageNum:currentPage}, //이후 userId로 바꿔야함
				type:"POST",
				dataType:"Json",
				success:getInFaceView
		});
	}
	
</script>