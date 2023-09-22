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


$(function(){

  $("#button-send").on("click", (e) => {
  console.log("send 버튼 활성화");
  });
});

const websocket = new WebSocket("ws://localhost:8090/spring1/echo");