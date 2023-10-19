<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
<link href="${pageContext.request.contextPath}/resources/css/mypage/buyer.css" rel='stylesheet' type='text/css'>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<title>판매내역 상세조회</title>
</head>
<body>


<c:if test="${not empty msg}">	<!-- 메세지가있다면 alert으로 알림 -->
<script>
	alert("${msg}");
</script>
</c:if>

<h1>안전거래 상세조회</h1>
<div class="container">
    <c:if test="${safePurchaseInfoDto.tradingStatus ne 5}">
        <button type="button" onclick="cancel('${safePurchaseInfoDto.buyerId}','${safePurchaseInfoDto.transactionId}','${safePurchaseInfoDto.goodsId }')">결제취소</button>
    </c:if>
    <c:if test="${safePurchaseInfoDto.tradingStatus eq 1}">
    <button onclick="accept('${safePurchaseInfoDto.sellerId}','${safePurchaseInfoDto.transactionId}','${safePurchaseInfoDto.goodsId }')">안전결제 수락</button>
	</c:if>
    
	<c:if test="${safePurchaseInfoDto.tradingStatus eq 2}">
    <form action="${pageContext.request.contextPath}/mypage/deal/safe/seller/insert/trackingnumber" method="post">
   		<select name="shippingCompany">
    		<option value="1">대한통운</option>
    		<option value="2">우체국택배</option>
    		<option value="3">한진택배</option>
    		<option value="4">로젠택배</option>
    	</select>
    	<input type="hidden" value="${safePurchaseInfoDto.transactionId}" name="transactionId">
    	<div><span>운송장번호</span><input type="text" name="trackingNumber" pattern="^\d{13}$" title="13자리 입력" required></div>
    	<button type="submit">운송장 등록</button>    
    </form>
    </c:if>
    
    <a href="${pageContext.request.contextPath}/goods/get?goodsId=${safePurchaseInfoDto.goodsId}"><p>상품명:${safePurchaseInfoDto.goodsTitle}</p></a>
    <p>판매자명:${safePurchaseInfoDto.sellerName}</p>
    <p>구매자명:${safePurchaseInfoDto.buyerName}</p>
    <p>휴대폰번호:${safePurchaseInfoDto.mobileNumber}</p>
    <p>배송지:${safePurchaseInfoDto.roadAddress}, ${safePurchaseInfoDto.detailAddress}</p>
    <p>거래일자:${safePurchaseInfoDto.tradingDate}</p>

    <c:choose>
        <c:when test="${safePurchaseInfoDto.tradingStatus eq 1}"><p>거래상태:입금완료</p></c:when>
        <c:when test="${safePurchaseInfoDto.tradingStatus eq 2}"><p>거래상태:상품준비중</p></c:when>
        <c:when test="${safePurchaseInfoDto.tradingStatus eq 3}"><p>거래상태:배송중</p></c:when>
        <c:when test="${safePurchaseInfoDto.tradingStatus eq 4}"><p>거래상태:거래완료</p></c:when>
        <c:when test="${safePurchaseInfoDto.tradingStatus eq 5}"><p>거래상태:결제취소</p></c:when>
    </c:choose>

    <c:if test="${not empty safePurchaseInfoDto.trackingNumber}">
        운송장번호:
        <c:choose>
        <c:when test="${safePurchaseInfoDto.shippingCompany eq 1}">
        	대한통운
        </c:when>
        <c:when test="${safePurchaseInfoDto.shippingCompany eq 2}">
        	우체국택배
        </c:when>
        <c:when test="${safePurchaseInfoDto.shippingCompany eq 3}">
        	한진택배
        </c:when>
        <c:when test="${safePurchaseInfoDto.shippingCompany eq 4}">
        	로젠택배
        </c:when>
        </c:choose>
         ${safePurchaseInfoDto.trackingNumber}</p>
    </c:if>
</div>

<script>
    var cancel=(userId1,transactionId1,goodsId)=>{
        $.ajax({
            url:"${pageContext.request.contextPath}/payment/cancel",
            data:{userId:userId1, transactionId:transactionId1, goodsId:goodsId},
            method: "post",
            dataType:"json",
            success:cancelCallBack,
    		error : (request,status,error)=>{
    			console.log(request);
    			console.log(status);
    			console.log(error);
    			alert("code:"+request.status+"\n"+"message"+request.responseText+"\n"+error+":error");
    		}
        });
    }
    function cancelCallBack(data){
        console.log(data);
        if(data.response.status=="cancelled"){
            alert("거래가 취소되었습니다");
            window.location.href="${pageContext.request.contextPath}/mypage/salestatus/safe";
        }
        else
            alert("거래 취소에 실패하였습니다.");
    }
    
    var accept=(sellerId,transactionId)=>{
    	 $.ajax({
             url:"${pageContext.request.contextPath}/payment/changestatus",
             data:{transactionId:transactionId , status:2},
             method: "post",
             dataType:"json",
             success:acceptCallback,
     		error : (request,status,error)=>{
    			console.log(request);
    			console.log(status);
    			console.log(error);
    			alert("code:"+request.status+"\n"+"message"+request.responseText+"\n"+error+":error");
    		}
         });
    }
    
    var acceptCallback=(data)=>{
    	if(data=='1'){
    		alert('안전결제가 수락되었습니다.');
    		window.location.href="${pageContext.request.contextPath}/mypage/deal/safe/seller?transactionId=${safePurchaseInfoDto.transactionId}";
    	}
    	else
    		alert("안전결제 수락에 실패했습니다.");
    }
    
</script>
</body>
</html>