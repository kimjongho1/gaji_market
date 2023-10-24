<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/mypage/dealreview.css" rel='stylesheet' type='text/css'>
<meta charset="UTF-8">
<title>거래후기</title>
    <!--favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
    

</head>
<body>
    <form action="${pageContext.request.contextPath}/mypage/dealreview.do" method="post">
        <span>매너점수</span><input type="text" name="mannerPoint" placeholder="1~5사이 값을 입력하세요" required>
        <span>상품점수</span><input type="text" name="goodsPoint" placeholder="1~5사이 값을 입력하세요" required>
        <span>시간약속 점수</span><input type="text" name="timePoint" placeholder="1~5사이 값을 입력하세요" required>
        <textarea name="message" placeholder="리뷰를 입력하세요"></textarea>
        <input type="hidden" name="transactionId" value="${transactionId}">
        <button type="submit">리뷰작성</button>
        <button onclick="href1()">다음에 작성하기</button>
    </form>
</body>

<script>
	function href1(){
		window.location.href="${pageContext.request.contextPath}/goods/board";
	}
</script>
</html>