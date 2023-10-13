<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
	<h2>회원 정보</h2>
	<nav>
		<a href=""></a>
	</nav>
	<c:forEach items="${userMypage}" var="user">
	<div>
	<span>
		<label>이름 : </label> 
		<input type="text" name="name" id="name" value="${user.name}">
		<button type="button" id="nameUpdate">변경</button>
	</span>
	</div>
	<div>
	<span>
		<label>가지온도 :</label> 
		<input type="text" name="ratingScore" id="ratingScore" value="${user.ratingScore}">
	</span>
	</div>
	<div>
	<span>
		<label>닉네임 :</label> 
		<input type="text" name="nickname" id="nickname" value="${user.nickname}">
		<button type="button" id="nicknameUpdate">변경</button>
	</span>
	</div>
	<div>
	<span>
		<label>이메일 :</label> 
		<input type="text" name="email" id="email" value="${user.email}">
		<button type="button" id="emailUpdate">변경</button>
	</span>
	</div>
	<div>
	<span>
		<label>연락처 :</label> 
		<input type="text" name="mobileNumber" id="mobileNumber" value="${user.mobileNumber}">
		<button type="button" id="mobileNumberUpdate">변경</button>
	</span>
	</div>
	<div>
	<span>
	<label>주소 : </label> 
		<input type="text" name="name" id="name" value="${user.address} ${user.detailAddress}">
		<button type="button">변경</button>
	</span>
	
	</div>
	</c:forEach>
	<script>
	$(document).ready(function() {
	    // 버튼 클릭 시 서버에 이름 업데이트 요청 보내기
	    $("#nameUpdate").click(function() {
	    	console.log("버튼클릭확인");
	        var userId = "asdf"; // 사용자 아이디
	        var name = $("#name").val(); // 입력된 이름
	        $.ajax({
	            url: "${pageContext.request.contextPath}/mypage/updatename",
	            type: "POST",
	            data: {
	                userId: userId,
	                name: name
	            },
	            success: function(data) {
	                if (data.status === "1") {
	                    // 성공 메시지를 alert 창으로 표시
	                    alert(data.message);
	                } else {
	                    // 오류 메시지를 alert 창으로 표시
	                    alert(data.message);
	                }
	            },
	            error: function() {
	                // 서버 오류 메시지를 alert 창으로 표시
	                alert("서버 오류");
	            }
	        });
	    });
	    
	 // 버튼 클릭 시 서버에 이름 업데이트 요청 보내기
	    $("#nicknameUpdate").click(function() {
	    	console.log("버튼클릭확인");
	        var userId = "asdf"; // 사용자 아이디
	        var nickname = $("#nickname").val(); // 입력된 닉네임
	        $.ajax({
	            url: "${pageContext.request.contextPath}/mypage/updatenickname",
	            type: "POST",
	            data: {
	                userId: userId,
	                nickname: nickname
	            },
	            success: function(data) {
	                if (data.status === 1) {
	                    // 성공 메시지를 alert 창으로 표시
	                    alert(data.message);
	                } else if (data.status === -1) {
	                    // 중복 메시지를 alert 창으로 표시
	                    alert(data.message);
	                } else {
	                    // 오류 메시지를 alert 창으로 표시
	                    alert(data.message);
	                }
	            },
	            error: function() {
	                // 서버 오류 메시지를 alert 창으로 표시
	                alert("서버 오류");
	            }
	        });
	    });
	 
	 // 버튼 클릭 시 서버에 이름 업데이트 요청 보내기
	    $("#emailUpdate").click(function() {
	    	console.log("버튼클릭확인");
	        var userId = "asdf"; // 사용자 아이디
	        var email = $("#email").val(); // 입력된 이름
	        $.ajax({
	            url: "${pageContext.request.contextPath}/mypage/updateemail",
	            type: "POST",
	            data: {
	                userId: userId,
	                email: email
	            },
	            success: function(data) {
	                if (data.status === 1) {
	                    // 성공 메시지를 alert 창으로 표시
	                    alert(data.message);
	                } else if (data.status === -1) {
	                    // 중복 메시지를 alert 창으로 표시
	                    alert(data.message);
	                } else {
	                    // 오류 메시지를 alert 창으로 표시
	                    alert(data.message);
	                }
	            },
	            error: function() {
	                // 서버 오류 메시지를 alert 창으로 표시
	                alert("서버 오류");
	            }
	        });
	    });
	    
	 // 버튼 클릭 시 서버에 이름 업데이트 요청 보내기
	    $("#mobileNumberUpdate").click(function() {
	    	console.log("버튼클릭확인");
	        var userId = "asdf"; // 사용자 아이디
	        var mobileNumber = $("#mobileNumber").val(); // 입력된 이름
	        $.ajax({
	            url: "${pageContext.request.contextPath}/mypage/updatemobilenumber",
	            type: "POST",
	            data: {
	                userId: userId,
	                mobileNumber: mobileNumber
	            },
	            success: function(data) {
	                if (data.status === 1) {
	                    // 성공 메시지를 alert 창으로 표시
	                    alert(data.message);
	                } else if (data.status === -1) {
	                    // 중복 메시지를 alert 창으로 표시
	                    alert(data.message);
	                } else {
	                    // 오류 메시지를 alert 창으로 표시
	                    alert(data.message);
	                }
	            },
	            error: function() {
	                // 서버 오류 메시지를 alert 창으로 표시
	                alert("서버 오류");
	            }
	        });
	    });	 
	});
	</script>
</body>
</html>