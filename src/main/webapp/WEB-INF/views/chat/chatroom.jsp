<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/chat.css"
	rel='stylesheet' type='text/css'>
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
						<input type="hidden" id="${item1.chatId }" value="${item1.chatId }">
						<li class="person" data-chat="person${status.count}" data-chatid="${item1.chatId}">
						<img
							src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/382994/dog.png"
							alt="" /> <span class="name">${item1.nickname}</span> <c:forEach
								var="item2" items="${item1.chatInfo}">
								<span class="time"> <script>
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
							</c:forEach></li>
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
						<span>Today, 5:38 PM</span>
					</div>
					<c:forEach var="item1" items="${chatMessage}">
						<div class="bubble you">${item1.senderId }</div>
						<c:choose>
							<c:when test="${item1.senderId eq pageContext.request.userPrincipal.name}">
								<div class="bubble me">${item1.message}</div>
							</c:when>
							<c:otherwise>
								<div class="bubble you">${item1.message}</div>
							</c:otherwise>
						</c:choose>
						<!-- <div class="bubble you">${item1.senderId }</div> -->
					</c:forEach>
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
						type="text" id="msg" /> <a href="javascript:;"
						class="write-link smiley"></a>
					<button class="write-link send" type="button" id="button-send"></button>
				</div>
			</div>
		</div>
	</div>

	<script>
	$(document).ready(function() {
		// 리스트에서 메시지 시간 체크
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
	
	  	// 활성 채팅 설정 및 friends, chat 객체 생성
	  	document.querySelector('.chat[data-chat=person2]').classList.add('active-chat');
	  	document.querySelector('.person[data-chat=person2]').classList.add('active');
	
	  	let friends = {
		    list: document.querySelector('ul.people'),
		    all: document.querySelectorAll('.left .person'),
			name: ''
		},
	    chat = {
	      container: document.querySelector('.container .right'),
	      current: null,
	      person: null,
	      name: document.querySelector('.container .right .top .name')
	    };
	
	  // 친구 클릭 이벤트 처리
	  friends.all.forEach(f => {
	    f.addEventListener('mousedown', () => {
	    	// 클릭한 noRoom값 전달
	   		const chatId = f.getAttribute('data-chatid');
	      	if (!f.classList.contains('active')) {
	    		setAciveChat(f, chatId)
	      	}
	    });
	  });
	
	  // 채팅 활성화 및 비활성화
	  function setAciveChat(f, chatId) {
		  
	  	$.ajax({
	  		type:'get',
	  		url:'${pageContext.request.contextPath}/selectRoom',
	  		data: {"chatId" : chatId},
	  		dataType:"json",
	  		success : function(result) { // 결과 성공 콜백함수
	  			console.log(result);
	    friends.list.querySelector('.active').classList.remove('active');
	    f.classList.add('active');
	    chat.current = chat.container.querySelector('.active-chat');
	    chat.person = f.getAttribute('data-chat');
	    chat.current.classList.remove('active-chat');
	    chat.container.querySelector('[data-chat="' + chat.person + '"]').classList.add('active-chat');
	    friends.name = f.querySelector('.name').innerText;
	    chat.name.innerHTML = friends.name;

	    //<div class="chat" data-chat="person1">
	    htmlVal = '		<div class="conversation-start"><span>Today, 5:38 PM</span> </div>';
		for(var i=0; i<result.length; i++) {
			var item1 = result[i];
			if(item1.senderId == '${pageContext.request.userPrincipal.name}'){
				htmlVal +=  `					<div class="bubble me">\${item1.message}</div>`;
			} else{
				htmlVal +=  `					<div class="bubble you">\${item1.message}</div>`;
			}
		}
		//</div>
	    chat.container.querySelector('[data-chat="' + chat.person + '"]').innerHTML= htmlVal;
	    
	    
	    
	  		},
	  	    error : function(request, status, error) { // 결과 에러 콜백함수
	  	        console.log(error)
	  	    }
	  	})
	  	
	  }
	
	  $(function () {
	    const websocketConnections = {};
	    const username = "${pageContext.request.userPrincipal.name}";
	
	    // WebSocket 연결 생성 함수
	    function createWebSocketConnection(person) {
	      const ws = new WebSocket("ws://localhost:8090/gaji/echo");
	
	      ws.onopen = function (e) {
	        console.log('WebSocket 연결이 열렸습니다.');
	      };
	
	      ws.onmessage = function (e) {
	        console.log('WebSocket 메시지 수신:', e.data);
	        displayReceivedMessage(e.data);
	      };
	
	      ws.onclose = function (e) {
	        console.log('WebSocket 연결이 닫혔습니다.');
	      };
	
	      ws.onerror = function (e) {
	        console.error('WebSocket 오류:', e);
	      };
	
	      return ws;
	    }
	
	    $("#button-send").on("click", (e) => {
	      send();
	    });
	
	    // 엔터 키 입력시 send() 실행
	    $("#msg").on("keydown", (e) => {
	      if (e.key === "Enter") {
	        send();
	      }
	    });
	
	    function send() {
	      const activeChat = document.querySelector('.chat.active-chat');
	
	      if (!activeChat) {
	        return;
	      }
	
	      const msgInput = document.getElementById("msg");
	      const message = msgInput.value.trim();
	      if (message === "") {
	        return;
	      }
	
	      const websocket = websocketConnections[activeChat.getAttribute('data-chat')];
	      if (websocket) {
	        websocket.send(message);
	      }
	
	      const messageElement = document.createElement('div');
	      messageElement.className = 'bubble me';
	      messageElement.textContent = message;
	
	      activeChat.appendChild(messageElement);
	
	      msgInput.value = '';
	    }
	
	    function displayReceivedMessage(message) {
	      const activeChat = document.querySelector('.chat.active-chat');
	
	      if (!activeChat) {
	        return;
	      }
	
	      const messageElement = document.createElement('div');
	      messageElement.className = 'bubble you';
	      messageElement.textContent = message;
	
	      activeChat.appendChild(messageElement);
	    }
	  });
	});
	</script>

	<!-- ajax -->
	<script>
	/* 채팅 리스트에서 방 눌렀을 때 */

	</script>
	
	

</body>
</html>