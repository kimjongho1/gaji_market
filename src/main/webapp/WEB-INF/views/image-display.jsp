<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>업로드된 파일 목록</h2>
    <ul>
        <c:forEach var="imageUrl" items="${imageUrls}">
            <li><img src="${imageUrl}" alt="Uploaded Image"></li>
        </c:forEach>
    </ul>
</body>
</html>