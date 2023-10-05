<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h2>아이디 찾기 결과</h2>
    <% if (request.getAttribute("foundId") != null) { %>
        <p>찾은 아이디: <%= request.getAttribute("foundId") %></p>
        <a href="<%= request.getContextPath() %>/login">로그인하러 가기</a>
    	<a href="<%= request.getContextPath() %>/pwInquiry">비밀번호 찾기</a>
		   	
    <% } else { %>
        <p>일치하는 정보로 등록된 아이디를 찾을 수 없습니다.</p>
        <a href="javascript:history.back();">전 페이지로 돌아가기</a>
    	<a href="<%= request.getContextPath() %>/signup">회원가입</a> 
    <% } %>
</body>
</html>