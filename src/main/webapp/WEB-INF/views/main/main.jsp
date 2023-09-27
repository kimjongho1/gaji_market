<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<script>
<c:if test="${not empty msg}">
	alert("${msg}");
</c:if>
</script>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>

</body>
</html>