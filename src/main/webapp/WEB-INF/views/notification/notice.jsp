<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/locale/ko.js"></script>
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
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/notice.css" type="text/css">
</head>
<body>
    <div class="notification-container">
        <div class="notification-card">
            <h2>거래 알림</h2>
            <div class="unread">읽지 않은 메시지 + ${notiCount}</div>
            <c:forEach items="${safeTradingNotice}" var="item">
                <form action="${pageContext.request.contextPath}/notice/read?refId=${item.referenceId}&readYn=${item.readYn}&notiId=${item.notiId}" method="post">
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
                </form>
            </c:forEach>
        </div>
    </div>
</body>
</html>
