<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매내역</title>
</head>

<body>
<button id="inFace" onclick="viewInface()">직거래</button>
<button id="safeTrading" onclick="safeTrading()">안전거래</button>
<table class="purchaseView">
	<c:forEach var="safePurchaseInfo"  items="${safePurchaseList}">
		<tr><th>상품명:</th><td>${safePurchaseInfo.goodsTitle}</td></tr>
		<tr>
		<th>거래상태:</th>
				<td>
					<c:choose>
						<c:when test="${safePurchaseInfo.tradingStatus eq 1}">입금완료</c:when>
						<c:when test="${safePurchaseInfo.tradingStatus eq 2}">상품준비중</c:when>
						<c:when test="${safePurchaseInfo.tradingStatus eq 3}">배송중</c:when>
						<c:when test="${safePurchaseInfo.tradingStatus eq 4}">거래완료</c:when>
						<c:when test="${safePurchaseInfo.tradingStatus eq 5}">결제취소</c:when>
					</c:choose>
				</td>
		</tr>
		<tr><th>가격:</th><td>${safePurchaseInfo.price}</td></tr>
		<tr><th>거래일자:</th><td>${safePurchaseInfo.tradingDate}</td></tr>
	</c:forEach>
</table>

<script>
	const viewInface=()=>{
		$.ajax({
			url:"${pageContext.request.contextPath}/mypage/getInFaceView",
			data:{userId:"qordmlgjs"}, //이후 userId로 바꿔야함
			type:"POST",
			dataType:"Json",
			success:getInFaceView
		});
	}
	const safeTrading=()=>{
		$.ajax({
			url:"${pageContext.request.contextPath}/mypage/getSafeTradingView",
			data:{userId:"qordmlgjs"}, //이후 userId로 바꿔야함
			type:"POST",
			dataType:"Json",
			success:getSafeView
		});
	}
	
	var getInFaceView=(data)=>{	//직거래 버튼 클릭시 직거래내역 보이게하기.
		console.log("getInFaceView");
		console.log(data);
		var table=$("<table class='purchaseView'><table>");
		
		for(var i=0; i<data.length; i++){
			let item=data[i];
			var html='';
			
			html+="<tr><th>상품명</th>"
			html+="<td>"+item.goodsTitle+"</td></tr>";
			
			html+="<tr><th>거래상태</th>";	
			if(item.tradingStatus ==1)
				html+="<td>예약중</td></tr>";
			else if(item.tradingStatus ==2)
				html+="<td>거래완료</td></tr>";
			else
				html+="<td>(거래취소)</td></tr>";
			
			html+="<tr><th>가격</th>";
			html+="<td>"+item.price+"</td></tr>";
			
			html+="<tr><th>거래일자</th>";
			html+="<td>"+item.tradingDate+"</td></tr>";
			html.appendTo(table);
		}
		$(".purchaseView").replaceWith(table);
	}
	
	var getSafeView=(data)=>{	//직거래 버튼 클릭시 직거래내역 보이게하기.
		console.log(data);
		console.log("getSafeView");
		var table="<table class='purchaseView'>";
		
		for(var i=0; i<data.length; i++){
			let item=data[i];
			var html="";
			
			html+="<tr><th>상품명</th>"
			html+="<td>"+item.goodsTitle+"</td></tr>";
			
			html+="<tr><th>거래상태</th>";	
			if(item.tradingStatus ==1)
				html+="<td>입금완료</td></tr>";
			else if(item.tradingStatus ==2)
				html+="<td>상품준비중</td></tr>";
			else if(item.tradingStatus ==3)
				html+="<td>(배송중)</td></tr>";
			else if(item.tradingStatus ==3)
				html+="<td>(거래완료)</td></tr>";
			else
				html+="<td>(결제취소)</td></tr>";
			html+="<tr><th>가격</th>";
			html+="<td>"+item.price+"</td></tr>";
			
			html+="<tr><th>거래일자</th>";
			html+="<td>"+item.tradingDate+"</td></tr>";
			table+=html;
		}
		table+="<table>";
		$(".purchaseView").replaceWith(table);
	}
</script>
</body>
</html>