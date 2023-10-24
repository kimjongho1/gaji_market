<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
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
					<input type="text" placeholder="Search" /> <a href="javascript:;" class="search"></a>
				</div>
				<!-- 채팅중인 회원 list -->
				<div class="people_list">
					<ul class="people">
					    <c:forEach var="item1" items="${chatRoomList}" varStatus="status">
					        <input type="hidden" id="${item1.chatId}" value="${item1.chatId}">
					        <li class="person" data-chat="person${status.count}" data-chatid="${item1.chatId}">
					            <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/382994/dog.png" alt="" />
					            <span class="name">${item1.nickname}</span>
					            <c:forEach var="item2" items="${item1.chatInfo}">
					                <span class="time">
					                    <c:choose>
					                        <c:when test="${item2.createAt != null}">
					                            <script>
					                                var dateString = "${item2.createAt}";
					                                var date = new Date(dateString);
					                                var today = new Date();
					                                var year = date.getFullYear();
					                                var month = date.getMonth() + 1;
					                                var day = date.getDate();
					                                var hours = date.getHours();
					                                var minutes = date.getMinutes();
					                                if (today.getMonth() + 1 == month) {
					                                    if (today.getDate() == day) {
					                                        if (hours > 11) {
					                                            document.write("오후 " + (hours - 12) + ":" + minutes);
					                                        } else {
					                                            document.write("오전 " + hours + ":" + minutes);
					                                        }
					                                    }
					                                } else {
					                                    document.write(month + "월 " + day + "일");
					                                }
					                            </script>
					                        </c:when>
					                    </c:choose>
					                </span>
					                <span class="preview">${item2.message }</span>
					            </c:forEach>
					        </li>
					    </c:forEach>
					</ul>
				</div>
			</div>
			<div class="right">
				<div class="top">
					<!-- 현재 채팅중인 회원 이름 정보 -->
					<span>To: <span class="name"></span></span>
				</div>
				<c:forEach items="${chatRoomList}" var="item" varStatus="loop">
					<div class="chat" data-chat="person${loop.count}" style="overflow-y: scroll;">
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
						</c:forEach>
					</div>
				</c:forEach>
				<div class="write">
					<!-- template 적용하려고 label 태그 사용 -->
					<input type="file" id="file" name="file" style="display:none" accept="image/png, image/jpeg"/>
					<label class="write-link attach" for="file"></label>
					<div id="div-preview">
					
					</div>
					<input type="text" id="msg" /> <a
						href="javascript:;" class="write-link smiley"></a>
					<button class="write-link send" type="button" id="button-send"></button>
				</div>
			</div>
		</div>
	</div>
	<script>
	let activeChat;
	// chatId를 많이 사용하므로 전역변수 선언
	var chatId;
	// 현제 접속 된 계정
	var username = "${username}";
	// socket들을 담을 객체 생성
	var endPoint = "${pageContext.request.contextPath}/chat";
	var imgValue = null;

	$(document).ready(function () {
		function scrollToBottom() {
		    const activeChat = document.querySelector(".container .right .chat.active-chat");
		    activeChat.scrollTop = activeChat.scrollHeight;
		}

		$("#file").change(function () {
			  readImage( this );
        });
        $("#baseFile").trigger("change");
	
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
			console.log("friends.all.forEach");
			f.addEventListener('mousedown', () => {
				// 클릭한 noRoom값 전달
				chatId = parseInt(f.getAttribute('data-chatid'));
				if (!f.classList.contains('active')) {
					setActiveChat(f);
					var chatBox = document.querySelector(".right .chat");
					chatBox.scrollTop = chatBox.scrollHeight;
				}
			});
		});
		
		// 리스트에서 메시지 시간 체크
		function now() {
			var today = new Date();
			var hours = today.getHours();
			var minutes = today.getMinutes();

			if (hours > 12) {
				return "오후 " + (hours - 12) + ":" + minutes;
			} else {
				return "오전 " + hours + ":" + minutes;
			}
		}

		// 채팅 활성화 및 비활성화
		function setActiveChat(f) {
			if (chatId != null){
				if(stomp != null)
					stomp.disconnect();							
			}

			$.ajax({
				type: 'get',
				url: '${pageContext.request.contextPath}/chat/selectRoom',
				data: { "chatId": chatId },
				dataType: "json",
				success: function (result) { // 결과 성공 콜백함수
					console.log(result);
					friends.list.querySelector('.active')?.classList.remove('active');
					f.classList.add('active');
					chat.current = chat.container.querySelector('.active-chat');
					chat.person = f.getAttribute('data-chat');
					if (chat.current && chat.current.classList.contains('active-chat')) {
					    chat.current.classList.remove('active-chat');
					}
					chat.container.querySelector('[data-chat="' + chat.person + '"]').classList.add('active-chat');
					friends.name = f.querySelector('.name').innerText;
					chat.name.innerHTML = friends.name;
					// WebSocket 연결 생성 함수
					createWebSocketConnection(username);
					try {
						htmlVal = '		<div class="conversation-start"><span>' + createDate(result[0].createAt) + '</span></div>'; // TODO(1013 김종호 날짜 기록)
					} catch (err) {
						htmlVal = '		<div class="conversation-start"><span>' + createDate() + '</span></div>';
					}
					for (var i = 0; i < result.length; i++) {
					    var item1 = result[i];
					    if (item1.senderId == '${pageContext.request.userPrincipal.name}') {
					        if (item1.message.startsWith("https://res.cloudinary.com/")) {
					            // 이미지 URL로 시작하는 경우
					            htmlVal += `					<div class="bubble me"><img src="${item1.message}"></div>`;
					        } else {
					            // 이미지 URL로 시작하지 않는 경우
					            htmlVal += `					<div class="bubble me">\${item1.message}</div>`;
					        }
					    } else {
					        if (item1.message.startsWith("https://res.cloudinary.com/")) {
					            // 이미지 URL로 시작하는 경우
					            htmlVal += `					<div class="bubble you"><img src="${item1.message}"></div>`;
					        } else {
					            // 이미지 URL로 시작하지 않는 경우
					            htmlVal += `					<div class="bubble you">\${item1.message}</div>`;
					        }
					    }
					}
					//</div>
					chat.container.querySelector('[data-chat="' + chat.person + '"]').innerHTML = htmlVal;
					activeChat = document.querySelector('.chat.active-chat');
					
					scrollToBottom();

				}
			});
		}  // setActiveChat
		
		function createDate(date) {
			if(date != null) {
				var date = new Date(date);
				var result = date.getFullYear() + "년 " + (date.getMonth() + 1) + "월 " + date.getDate() + "일";
			} else {
				var date = new Date();
				var result = date.getFullYear() + "년 " + (date.getMonth() + 1) + "월 " + date.getDate() + "일";
			}
				return result;
		}
		
		let stomp;
		// socket 생성
		function createWebSocketConnection(person) {
			var ws = new SockJS(endPoint);
			stomp = Stomp.over(ws);

			$("#button-send").on("click", (e) => {
				send();
			}); // click event send 

			// 엔터 키 입력시 send() 실행F
			$("#msg").on("keydown", (e) => {
				if (e.key === "Enter") {
					e.preventDefault();
					e.stopPropagation();
					send();
				}
			}); // keydown event enter
			
			stomp.connect({}, function (frame) {
			    console.log('Connected: ' + frame);
			    stomp.subscribe("/sub/chat/room/" + chatId, function (chat) {
			        var content = JSON.parse(chat.body);

			        if (activeChat) {
			            if (content.message.startsWith("https://res.cloudinary.com/")) {
			            	// 메시지 내용이 이미지 URL로 시작하는 경우
			                const imageElement = document.createElement('img');
			                imageElement.src = content.message; // 이미지 URL을 설정합니다;

			                // 이미지를 화면에 추가합니다.
			                const containerDiv = document.createElement('div');
			                if (username == content.senderId) {
			                    containerDiv.className = 'bubble me';
			                } else {
			                    containerDiv.className = 'bubble you';
			                }
			                containerDiv.appendChild(imageElement);
			                activeChat.appendChild(containerDiv);
			            } else {
			                // 메시지 내용이 이미지 URL로 시작하지 않는 경우
			                const messageElement = document.createElement('div');
			                if (username == content.senderId) {
			                    messageElement.className = 'bubble me';
			                } else {
			                    messageElement.className = 'bubble you';
			                }
			                messageElement.textContent = content.message;
			                activeChat.appendChild(messageElement);
			            }
			            var personElement = document.querySelector('li[data-chatid="' + chatId + '"]');
		                if (personElement) {
		                    var timeElement = personElement.querySelector('.time');
		                    var previewElement = personElement.querySelector('.preview');

		                    // '.time' 및 '.preview' 요소 내용을 변경
		                    timeElement.textContent = now(); // 원하는 시간 값으로 변경
		                    // 이미지 파일인 경우 '첨부파일', 메시지일 경우에는 preview
		                    previewElement.textContent = content.message.startsWith("https://res.cloudinary.com/") ? "이미지" : content.message;
		                    scrollToBottom();
		                }
			        }
			    });
			});  // connect cb function

		}  // createWebSocketConnection
		// 메시지 보내기
		function send() {
			if (!activeChat) {
				return;
			}
			// 메시지 내용 message 변수에 저장
			const message = $("#msg").val().trim();

			if (message !== "") {
				// 메시지 정보를 /chat/room으로 보냄
				stomp.send("/pub/chat/message", {}, JSON.stringify({
					senderId: username,
					chatId: chatId,
					message: message
				}),
				
				)
				console.log("보내짐");
				$('#msg').val('');
			}
		} // send function	
		
		function readImage(input) {
	        if ( input.files && input.files[0] ) {
	            var FR= new FileReader();
	            FR.onload = function(e) {
	            	stomp.send("/pub/chat/file", {}, JSON.stringify({
	            		senderId: username, 
	            		chatId: chatId, 
	            		imgCode: e.target.result
	            		})); //receiver:participant,
	                //$('#source').text( e.target.result );
	            };
	            //console.log(FR.readAsDataURL( input.files[0] ));
	            FR.readAsDataURL( input.files[0] ); // 이거 없으면 작동 안되나???
	        }
	    }// readImage()
	});  // document ready
	</script>
</body>
</html>