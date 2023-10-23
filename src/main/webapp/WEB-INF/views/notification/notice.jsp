<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>알림</title>
    
    <!--favicon  -->
<link rel="icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/img/favicon.ico">
    
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/locale/ko.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css" type="text/css">
    <link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css">
    <style>
    
	
.page${currentPage}{
	color:#5715CC !important;
}

    
    </style>
    
</head>
<body>
    <div class="notification-container">
        <div class="notification-card">
            <h2>거래 알림</h2>
            <div class="d-flex justify-content-between unread"><span>읽지 않은 메시지 + ${notiCount}</span> 
            <button class="btn">123</button>
            </div>
            <c:forEach items="${safeTradingNotice}" var="item">
                <form action="${pageContext.request.contextPath}/notice/read?refId=${item.referenceId}&readYn=${item.readYn}&notiId=${item.notiId}" method="post">
                    <div>
                <ul>
                	<li class="d-flex justify-content-between">
                		<input type="radio">
                		<button class="btn">123</button>
                	</li>
                	<li>
                    <button type="submit" class="noticeButton">
                        <div class="message">${item.message}</div>
                        <div class="createdAt">
                            생성일:
                            <script>
                                var createdAt = "${item.createdAt}";
                                var formattedPastDate = moment(createdAt).fromNow();
                                document.write(formattedPastDate);
                            </script>
                        </div>
                        <div class="readYn">
                            <c:choose>
                                <c:when test="${item.readYn eq 'N'}">
                                    안읽음
                                </c:when>
                                <c:otherwise>
                                    읽음
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </button>
                    </li>
                </ul>
                	</div>
                </form>
            </c:forEach>
    <div class="paging">
				<c:if test="${startPageNum!=1}">
					<%--페이징 이전,번호,다음에 대한 코드 --%>
					<a
						href="<%=request.getContextPath()%>/notice?currentPage=${startPageNum-1}"><span>이전</span></a>
				</c:if>
				<c:forEach begin="${startPageNum}" end="${endPageNum}" var="i">
					<a class="page${i}"
						href="<%=request.getContextPath()%>/notice?currentPage=${i}"><span>${i}</span></a>
				</c:forEach>
				<c:if test="${endPageNum<totalPageNum}">
					<a
						href="<%=request.getContextPath()%>/notice?currentPage=${endPageNum+1}"><span>다음</span></a>
				</c:if>
	</div>          
        </div>
    </div>
    
</body>
</html>
