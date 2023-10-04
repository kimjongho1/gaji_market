<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 모달 스타일 */
.modal {
	display: none; /* 초기에는 숨김 상태 */
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgba(0, 0, 0, 0.7); /* 배경을 어둡게 표시 */
}

/* 모달 내용 스타일 */
.modal-content {
	background-color: #fefefe;
	margin: 10% auto; /* 중앙 정렬을 위해 상단 여백을 조정 */
	padding: 20px;
	border: 1px solid #888;
	max-width: 800px; /* 최대 너비 설정 */
	width: 80%; /* 최대 너비의 80%로 지정 */
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

/* 모달 닫기 버튼 스타일 */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}
</style>
</head>
<body>
	<h2>중고 거래 게시판 글 작성</h2>
	<form action="your_action_url" method="post">
		<input type="text" name="title" id="title" placeholder="제목"> <br>
		<!-- 카테고리 선택 드롭다운 -->
		<label for="selectedCategory">카테고리 선택:</label> <select
			name="selectedCategory" id="selectedCategory">
			<option value="">카테고리를 선택하세요</option>
			<c:forEach items="${categoryList}" var="category">
				<option value="${category.categoryId}">${category.categoryName}</option>
			</c:forEach>
		</select>
		<!-- 구 선택 드롭다운 -->
		<label for="selectedGu">구 선택:</label> <select name="selectedGu"
			id="selectedGu" onchange="updateDongDropdown()">
			<option value="">구를 선택하세요</option>
			<c:forEach items="${guList}" var="gu">
				<option value="${gu.guId}">${gu.guName}</option>
			</c:forEach>
		</select>
		<!-- 동 선택 드롭다운 -->
		<label for="selectedDong">동 선택:</label> <select name="selectedDong"
			id="selectedDong">
			<option value="">동을 선택하세요</option>
			<c:forEach items="${dongList}" var="dong">
				<option value="${dong.dongId}" data-gu="${dong.guId}">${dong.dongName}</option>
			</c:forEach>
		</select> <input type="text" id="price" name="price" placeholder="판매가격">
		<br>

		<!-- 모달 열기 버튼 -->
		<button id="openMapModal" type="button">거래희망장소</button>

		<!-- 모달 -->
		<div id="mapModal" class="modal">
			<div class="modal-content">
				<span class="close" id="closeMapModal">&times;</span>
				<!-- 카카오맵을 표시할 영역 -->
				<div id="kakaoMap" style="width: 700px; height: 300px;"></div>
				<p>
					<em>지도를 클릭해주세요!</em>
				</p>
				<button id="cancelButton">취소</button>
				<button id="confirmButton">확인</button>
				<div id="clickLatlng"></div>
			</div>
		</div>
		<!-- 기존 확인 버튼은 숨김 처리 -->
		<input type="submit" id="submitButton" value="확인" style="display: none;">
	</form>
	<script
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aec5b89790015b44669217946b7e53f3"></script>
	<script>
    // 모달 열기 버튼 클릭 시 모달 열기
    document.getElementById("openMapModal").addEventListener("click", function () {
        document.getElementById("mapModal").style.display = "block";
        initializeKakaoMap(); // 카카오맵 초기화 함수 호출
    });
    
    // 취소 버튼 클릭 시 모달 닫기
    document.getElementById("cancelButton").addEventListener("click", function () {
        document.getElementById("mapModal").style.display = "none";
    });

    // 모달 닫기 버튼 클릭 시 모달 닫기
    document.getElementById("closeMapModal").addEventListener("click", function () {
        document.getElementById("mapModal").style.display = "none";
    });

    // 카카오맵 초기화 함수
    function initializeKakaoMap() {
        // 카카오맵 API를 사용하여 지도를 생성하고 설정합니다.
        var container = document.getElementById('kakaoMap');
        var options = {
            center: new kakao.maps.LatLng(37.5665, 126.9780), // 지도의 중심 좌표 (서울)
            level: 8 // 지도의 확대 레벨
        };
        var map = new kakao.maps.Map(container, options);
        
        // 지도를 클릭한 위치에 마커를 추가합니다.
        var marker = new kakao.maps.Marker({
            map: map
        });
        
        // 지도를 클릭한 위치 정보를 가져와서 출력하는 함수
        function displayLatLng(lat, lng) {
            var resultDiv = document.getElementById('clickLatlng');
            resultDiv.innerHTML = '선택한 위치의 위도: ' + lat + ', 경도: ' + lng;
        }
        
        // 지도 클릭 이벤트 리스너 등록
        kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
            var latlng = mouseEvent.latLng;
            var lat = latlng.getLat(); // 위도
            var lng = latlng.getLng(); // 경도
            
            // 클릭한 위치에 마커 표시
            marker.setPosition(latlng);
            
            // 선택한 위치 정보 출력
            displayLatLng(lat, lng);
        });
        
        // 확인 버튼 클릭 시 마커의 위치 정보 가져오기
        document.getElementById('confirmButton').addEventListener('click', function () {
            var position = marker.getPosition();
            var lat = position.getLat(); // 마커의 위도
            var lng = position.getLng(); // 마커의 경도
            
            // 가져온 위치 정보를 활용하여 원하는 동작 수행
            console.log('선택한 마커의 위도: ' + lat + ', 경도: ' + lng);
            
            // 모달 닫기
            document.getElementById('mapModal').style.display = 'none';
        });
    }
</script>
<script>
	
    function updateDongDropdown() {
        const selectedGu = document.getElementById("selectedGu").value;
        const dongDropdown = document.getElementById("selectedDong");
        
        // 모든 동 옵션 숨기기
        Array.from(dongDropdown.options).forEach(option => {
            option.style.display = "none";
        });
        
        // 선택한 구에 맞는 동 옵션 보이기
        Array.from(dongDropdown.options).forEach(option => {
            if (option.getAttribute("data-gu") === selectedGu || option.value === "") {
                option.style.display = "block";
            }
        });
    }
    
    // 페이지 로드 시 호출하여 초기화
    updateDongDropdown();
</script>
</body>
</html>
