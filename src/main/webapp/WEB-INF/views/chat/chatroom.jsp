<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/chat.css" rel='stylesheet' type='text/css'>
<link rel="icon" href="favicon.ico" type="image/x-icon">
</head>
<body>
	<div class="wrapper">
		<div class="container">
			<div class="left">
				<div class="top">
					<!-- 채팅중인 회원 검색 기능 -->
					<input type="text" placeholder="Search" /> <a href="javascript:;"
						class="search"></a>
				</div>
				<!-- 채팅중인 회원 list -->
				<ul class="people">
					<c:forEach var="item1" items="${chatRoomList}" varStatus="status">
						<li class="person" data-chat="person${status.count}">
					    <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/382994/dog.png" alt="" />
					    <span class="name">${item1.nickname}</span>
					    <c:forEach var="item2" items="${item1.chatInfo}">
			    	 		<span class="time">
			    	 			<script>
							       var dateString = "${item2.createAt}";
							       var date = new Date(dateString);
							       var today = new Date();
							       
							       var year = date.getFullYear();
							       var month = date.getMonth() + 1;
							       var day = date.getDate();
							       var hours = date.getHours();
							       var minutes = date.getMinutes();
							       
								   if(today.getMonth() == month){
									   if(today.getDate() == day){
										   if(hours > 12){
											   document.write("오후 " + (hours - 12) + ":" + minutes);
										   } else {
											   document.write("오전 " + hours + ":" + minutes);
										   }
									   }
								   } else {
									   document.write(month + 1 + "월 " + day + "일");
								   }
							    </script>
			    	 		</span>
						    <span class="preview">${item2.message }</span>
					    </c:forEach>
					    </li>
				  	</c:forEach>
				</ul>
			</div>
			<div class="right">
				<div class="top">
					<!-- 현재 채팅중인 회원 이름 정보 -->
					<span>To: <span class="name">Dog Woofson</span></span>
				</div>
				<div class="chat" data-chat="person1">
					<div class="conversation-start">
						<span>Today, 6:48 AM</span>
					</div>
					<div class="bubble you">Hello,</div>
					<div class="bubble you">it's me.</div>
					<div class="bubble you">I was wondering...</div>
				</div>
				<div class="chat" data-chat="person2">
					<div class="conversation-start">
						<span>Today, 5:38 PM</span>
					</div>
					<div class="bubble you">Hello, can you hear me?</div>
					<div class="bubble you">I'm in California dreaming</div>
					<div class="bubble me">... about who we used to be.</div>
					<div class="bubble me">Are you serious?</div>
					<div class="bubble you">When we were younger and free...</div>
					<div class="bubble you">I've forgotten how it felt before</div>
					<div class="bubble me">I've forgotten how it felt before</div>
				</div>
				<div class="chat" data-chat="person3">
					<div class="conversation-start">
						<span>Today, 3:38 AM</span>
					</div>
					<div class="bubble you">Hey human!</div>
					<div class="bubble you">Umm... Someone took a shit in the
						hallway.</div>
					<div class="bubble me">... what.</div>
					<div class="bubble me">Are you serious?</div>
					<div class="bubble you">I mean...</div>
					<div class="bubble you">Itâs not that bad...</div>
					<div class="bubble you">But weâre probably gonna need a new
						carpet.</div>
					<div class="bubble you">But weâre probably gonna need a new
						carpet.</div>
					<div class="bubble you">But weâre probably gonna need a new
						carpet.</div>
					<div class="bubble you">But weâre probably gonna need a new
						carpet.</div>
				</div>
				<div class="chat" data-chat="person4">
					<div class="conversation-start">
						<span>Yesterday, 4:20 PM</span>
					</div>
					<div class="bubble me">Hey human!</div>
					<div class="bubble me">Umm... Someone took a shit in the
						hallway.</div>
					<div class="bubble you">... what.</div>
					<div class="bubble you">Are you serious?</div>
					<div class="bubble me">I mean...</div>
					<div class="bubble me">Itâs not that bad...</div>
				</div>
				<div class="chat" data-chat="person5">
					<div class="conversation-start">
						<span>Today, 6:28 AM</span>
					</div>
					<div class="bubble you">Wasup</div>
					<div class="bubble you">Wasup</div>
					<div class="bubble you">
						Wasup for the third time like is <br />you blind bitch
					</div>

				</div>
				<div class="chat" data-chat="person6">
					<div class="conversation-start">
						<span>Monday, 1:27 PM</span>
					</div>
					<div class="bubble you">So, how's your new phone?</div>
					<div class="bubble you">You finally have a smartphone :D</div>
					<div class="bubble me">Drake?</div>
					<div class="bubble me">Why aren't you answering?</div>
					<div class="bubble you">howdoyoudoaspace</div>
				</div>
				<div class="write">
					<a href="javascript:;" class="write-link attach"></a> <input
						type="text" id="msg"/> <a href="javascript:;" class="write-link smiley"></a>
					<button class="write-link send" type="button" id="button-send"></button>
				</div>
			</div>
		</div>
	</div>
	
	<script src="${pageContext.request.contextPath}/resources/js/chat.js"></script>
	<script>
		const username = "${pageContext.request.userPrincipal.name}"
		
			$(document).ready(function() {
				function formatDate(dateString) {
				    var date = new Date(dateString);
				    var today = new Date();

				    var year = date.getFullYear();
				    var month = date.getMonth() + 1;
				    var day = date.getDate();
				    var hours = date.getHours();
				    var minutes = date.getMinutes();

				    if (today.getMonth() == month) {
				        if (today.getDate() == day) {
				            if (hours > 12) {
				                return "오후 " + (hours - 12) + ":" + minutes;
				            } else {
				                return "오전 " + hours + ":" + minutes;
				            }
				        }
				    } else {
				        return month + 1 + "월 " + day + "일";
				    }
				}
				// 스크롤 컨테이너 선택
			    var chatContainer = $(".chat.active-chat");
			    // 스크롤을 가장 아래로 이동
			    chatContainer.scrollTop(chatContainer[0].scrollHeight);
			    // 새로운 메시지를 추가할 때 스크롤을 자동으로 아래로 이동
			    function scrollToBottom() {
			        chatContainer.scrollTop(chatContainer[0].scrollHeight);
			    }
			    // 예를 들어, 새 메시지를 추가하는 코드
			    // ...
			    // 메시지를 추가한 후
			    scrollToBottom();
			}			
	</script>
</body>
</html>