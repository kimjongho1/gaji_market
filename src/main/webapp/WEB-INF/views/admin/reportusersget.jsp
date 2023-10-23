<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<h2>유저 신고내역 상세보기</h2>
	<table border="1">
		<tr>
			<th>상품 넘버</th>
			<td>${userReportInfo.refId}</td>
		</tr>
		<tr>
			<th>사용자 ID</th>
			<td>${userReportInfo.userId}</td>
		</tr>
		<tr>
			<th>신고자 ID</th>
			<td>${userReportInfo.reporterId}</td>
		</tr>
		<tr>
			<th>신고 내용</th>
			<td>${userReportInfo.content}</td>
		</tr>
		<tr>
			<th>신고 카테고리</th>
			<td><c:choose>
					<c:when test="${userReportInfo.reportCategory eq 1}">광고</c:when>
					<c:when test="${userReportInfo.reportCategory eq 2}">욕설/비방</c:when>
					<c:when test="${userReportInfo.reportCategory eq 3}">음란물</c:when>
					<c:when test="${userReportInfo.reportCategory eq 4}">사기</c:when>
					<c:when test="${userReportInfo.reportCategory eq 5}">기타</c:when>
				</c:choose></td>
		</tr>
		<tr>
			<th>신고된 날짜</th>
			<td>${userReportInfo.createdAt}</td>
		</tr>
		<tr>
			<th>상품 제목</th>
			<td>${userReportInfo.title}</td>
		</tr>
	</table>
	<div>
		<button id="reviewButton">검토</button>
		<button id="banUserButton">유저 정지</button>
		<button id="unBanUserButton">유저 정지해제</button>
	</div>
	
	
	
	<script>
        // 검토 버튼 클릭 이벤트
        $("#reviewButton").click(function() {
            var refId = ${userReportInfo.refId};
            console.log(refId);
            $.ajax({
            	type: 'post',
            	url:"${pageContext.request.contextPath}/admin/report/review",
            	data:{refId : refId},
            	success: function(review){
            		if(review == 'success'){
            			alert("검토완료");
            		}else if(review =='rvComplete'){
            			alert("이미 검토된 사안입니다.");
            		}else {
            			alert("오류발생");
            		}
            	}
            })
            
        });

        // 유저 정지 버튼 클릭 이벤트
        $("#banUserButton").click(function() {
			var userId = '${userReportInfo.userId}';    
            console.log(userId);
            $.ajax({
            	type: 'post',
            	url:"${pageContext.request.contextPath}/admin/report/ban",
            	data:{userId : userId},
            	success: function(ban){
            		if(ban == 'banSuccess'){
            			alert("유저 정지 완료");
            		}else if(ban == 'banExist'){
            			alert("이미 정지된 유저입니다.");
            		}else {
            			alert("오류발생했습니다.");
            		}
            	}
            	
            	
            })
        });
        $("#unBanUserButton").click(function() {
			var userId = '${userReportInfo.userId}';    
            console.log(userId);
            $.ajax({
            	type: 'post',
            	url:"${pageContext.request.contextPath}/admin/report/unban",
            	data:{userId : userId},
            	success: function(unban){
            		if(unban == 'unBanSuccess'){
            			alert("유저 정지해제 완료");
            		}else if(unban == 'unBanExist'){
            			alert("이미 정지해제된 유저입니다.");
            		}else{
            			alert("오류발생");
            		}
            	}
            	
            	
            })
        });
    </script>
</body>
</html>