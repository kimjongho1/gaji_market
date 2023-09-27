document.querySelector('.chat[data-chat=person2]').classList.add('active-chat')
document.querySelector('.person[data-chat=person2]').classList.add('active')

/**
 * friends, chat 객체 생성
 */
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
  }

/** 김종호(230922)
'mousedown' 이벤트가 발생할 때, 해당 요소(f)가 'active' 클래스를 포함하고 있지 않은 경우에만 
setActiveChat 함수를 호출하여 요소를 활성화
*/
friends.all.forEach(f => {
  f.addEventListener('mousedown', () => {
    f.classList.contains('active') || setAciveChat(f)
  })
});

/** 김종호(230922)
1. 현재 활성화된 친구를 찾아 'active' 클래스를 제거 - 이전에 활성화된 친구 표시 비활성화
2. 선택한 친구 요소('f')에 'active' 클래스 추가 - 새로운 친구 표시 활성화
3. 현재 활성화된 채팅 창 저장
4. 선택한 친구 요소('f')의 'data-chat' 속성을 읽어와서 'chat.person' 변수에 저장
5. 현재 활성화된 채팅 창의 'active-chat' 클래스를 제거 - 이전 채팅 비활성화
6. 새로운 친구롸 연결된 채팅 창을 찾아서 'active-chat' 클래스 추가 - 새로운 채팅 활성화
7. 선택한 친구 요소('f')에서 이름을 가져와 'friends.name' 변수에 저장
8. 저장괸 이름을 채팅 창의 이름 부분에 표시
*/
function setAciveChat(f) {
  friends.list.querySelector('.active').classList.remove('active')
  f.classList.add('active')
  chat.current = chat.container.querySelector('.active-chat')
  chat.person = f.getAttribute('data-chat')
  chat.current.classList.remove('active-chat')
  chat.container.querySelector('[data-chat="' + chat.person + '"]').classList.add('active-chat')
  friends.name = f.querySelector('.name').innerText
  chat.name.innerHTML = friends.name
}


$(function () {
  const websocket = new WebSocket("ws://localhost:8090/gaji/echo");

  websocket.onopen = function (e) {
    console.log('WebSocket 연결이 열렸습니다.');
  };

  websocket.onmessage = function (e) {
    console.log('WebSocket 메시지 수신:', e.data);
    // 서버에서 수신한 메시지를 화면에 표시
    displayReceivedMessage(e.data);
  };

  websocket.onclose = function (e) {
    console.log('WebSocket 연결이 닫혔습니다.');
  };

  websocket.onerror = function (e) {
    console.error('WebSocket 오류:', e);
  };

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
    const msgInput = document.getElementById("msg");
    const message = msgInput.value.trim(); // 입력된 메시지를 가져옴

    if (message === "") {
      // 메시지가 비어있으면 전송하지 않음
      return;
    }
    
    const fullMessage = username + ":" + message;

    // 현재 활성화된 채팅 창을 찾음
    const activeChat = document.querySelector('.chat.active-chat');

    if (!activeChat) {
      // 현재 활성화된 채팅 창이 없으면 아무 작업도 수행하지 않음
      return;
    }

    // 메시지를 채팅 창에 추가 (자신이 보낸 메시지)
    const messageElement = document.createElement('div');
    messageElement.className = 'bubble me'; // 여기서는 자신이 보낸 메시지로 가정
    messageElement.textContent = message;

    activeChat.appendChild(messageElement);

    // 입력된 메시지 초기화
    msgInput.value = '';

    // WebSocket을 통해 메시지 서버로 전송
    websocket.send(fullMessage);
  }

  // WebSocket을 통해 받은 메시지를 화면에 표시하는 함수
  function displayReceivedMessage(message) {
    // 현재 활성화된 채팅 창을 찾음
    const activeChat = document.querySelector('.chat.active-chat');

    if (!activeChat) {
      // 현재 활성화된 채팅 창이 없으면 아무 작업도 수행하지 않음
      return;
    }

    // 메시지를 채팅 창에 추가 (상대방이 보낸 메시지)
    const messageElement = document.createElement('div');
    messageElement.className = 'bubble you'; // 상대방이 보낸 메시지
    messageElement.textContent = message;

    activeChat.appendChild(messageElement);
  }
});