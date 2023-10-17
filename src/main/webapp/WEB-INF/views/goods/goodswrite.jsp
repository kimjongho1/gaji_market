<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--favicon  -->
	<link rel="icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/favicon.ico">


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

#container {
	width: 1000px;
	margin: 20px auto;
}

.ck-editor__editable[role="textbox"] {
	/* editing area */
	min-height: 200px;
}

.ck-content .image {
	/* block images */
	max-width: 80%;
	margin: 20px auto;
}

.ck.ck-dropdown__panel {
	max-height: 160px; /* or anything else, more likely ~300px or so */
	overflow-y: auto;
}
</style>
</head>
<body>
<div id="container">
	<h2>중고 거래 게시판 글 작성</h2>
	<form action="${pageContext.request.contextPath}/goods/write.do"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="userId" value="qordmlgjs">
		<input type="text" name="title" id="title" placeholder="제목"> <br>
		<!-- 카테고리 선택 드롭다운 -->
		<label for="selectedCategory">카테고리 선택:</label> <select
			name="categoryId" id="selectedCategory">
			<option value="">카테고리를 선택하세요</option>
			<c:forEach items="${categoryList}" var="category">
				<option value="${category.categoryId}">${category.categoryName}</option>
			</c:forEach>
		</select>
		<!-- 구 선택 드롭다운 -->
		<label for="selectedGu">구 선택:</label>
		 <select name="selectedGu"
			id="selectedGu" onchange="updateDongDropdown()">
			<option value="">구를 선택하세요</option>
			<c:forEach items="${guList}" var="gu">
				<option value="${gu.guId}">${gu.guName}</option>
			</c:forEach>
		</select>
		<!-- 동 선택 드롭다운 -->
		<label for="selectedDong">동 선택:</label> 
		<select name="dongId"
			id="selectedDong">
			<option value="">동을 선택하세요</option>
			<c:forEach items="${dongList}" var="dong">
				<option value="${dong.dongId}" data-gu="${dong.guId}">${dong.dongName}</option>
			</c:forEach>
		</select>
		 <input type="text" id="price" name="price" placeholder="판매가격">
		<br>

			<textarea name="description" id="editor"></textarea>
		
		<label for="safeTradingYn">안전결제</label>
		<input type="checkbox" name="safeTradingYn" id="safeTradingYn" value="N">

		<!-- 모달 열기 버튼 -->
		<br>
		<!-- 모달 열기 버튼 -->
		<button id="openMapModal" type="button">거래희망장소</button>
		<input type="file" name="files" multiple="multiple" accept="image/*">

		<!-- 모달 -->
		<div id="mapModal" class="modal">
			<div class="modal-content">
				<span class="close" id="closeMapModal">&times;</span>
				<!-- 카카오맵을 표시할 영역 -->
				<div id="kakaoMap" style="width: 700px; height: 300px;"></div>
				<p>
					<em>거래희망장소를 클릭해주세요!</em>
				</p>
				<button id="cancelButton" type="button">취소</button>
				<button id="confirmButton" type="button">확인</button>
				<div id="clickLatlng"></div>
			</div>
		</div>
		<input type="text" name="lat" id="latitudeInput" value=""> <input
			type="text" name="lng" id="longitudeInput" value=""> <br>
		<input type="submit" value="확인">
		</form>
</div>
	
	<!--
            The "super-build" of CKEditor&nbsp;5 served via CDN contains a large set of plugins and multiple editor types.
            See https://ckeditor.com/docs/ckeditor5/latest/installation/getting-started/quick-start.html#running-a-full-featured-editor-from-cdn
        -->
	<script
		src="https://cdn.ckeditor.com/ckeditor5/37.0.0/super-build/ckeditor.js"></script>
	<!--
            Uncomment to load the Spanish translation
        -->
	<script
		src="https://cdn.ckeditor.com/ckeditor5/40.0.0/super-build/translations/ko.js"></script>
	<script>
	var msg = '${msg}';
	if(msg){
		alert(msg);
	}
            // This sample still does not showcase all CKEditor&nbsp;5 features (!)
            // Visit https://ckeditor.com/docs/ckeditor5/latest/features/index.html to browse all the features.
            CKEDITOR.ClassicEditor.create(document.getElementById("editor"), {
                // https://ckeditor.com/docs/ckeditor5/latest/features/toolbar/toolbar.html#extended-toolbar-configuration-format
                toolbar: {
                    items: [
                        'exportPDF','exportWord', '|',
                        'findAndReplace', 'selectAll', '|',
                        'heading', '|',
                        'bold', 'italic', 'strikethrough', 'underline', 'code', 'subscript', 'superscript', 'removeFormat', '|',
                        'bulletedList', 'numberedList', 'todoList', '|',
                        'outdent', 'indent', '|',
                        'undo', 'redo',
                        '-',
                        'fontSize', 'fontFamily', 'fontColor', 'fontBackgroundColor', 'highlight', '|',
                        'alignment', '|',
                        'link', 'insertImage', 'blockQuote', 'insertTable', 'mediaEmbed', 'codeBlock', 'htmlEmbed', '|',
                        'specialCharacters', 'horizontalLine', 'pageBreak', '|',
                        'textPartLanguage', '|',
                        'sourceEditing'
                    ],
                    shouldNotGroupWhenFull: true
                },
                // Changing the language of the interface requires loading the language file using the <script> tag.
                 language: 'ko',
                list: {
                    properties: {
                        styles: true,
                        startIndex: true,
                        reversed: true
                    }
                },
                // https://ckeditor.com/docs/ckeditor5/latest/features/headings.html#configuration
                heading: {
                    options: [
                        { model: 'paragraph', title: 'Paragraph', class: 'ck-heading_paragraph' },
                        { model: 'heading1', view: 'h1', title: 'Heading 1', class: 'ck-heading_heading1' },
                        { model: 'heading2', view: 'h2', title: 'Heading 2', class: 'ck-heading_heading2' },
                        { model: 'heading3', view: 'h3', title: 'Heading 3', class: 'ck-heading_heading3' },
                        { model: 'heading4', view: 'h4', title: 'Heading 4', class: 'ck-heading_heading4' },
                        { model: 'heading5', view: 'h5', title: 'Heading 5', class: 'ck-heading_heading5' },
                        { model: 'heading6', view: 'h6', title: 'Heading 6', class: 'ck-heading_heading6' }
                    ]
                },
                // https://ckeditor.com/docs/ckeditor5/latest/features/editor-placeholder.html#using-the-editor-configuration
                placeholder: '안녕하세요',
                // https://ckeditor.com/docs/ckeditor5/latest/features/font.html#configuring-the-font-family-feature
                fontFamily: {
                    options: [
                        'default',
                        'Arial, Helvetica, sans-serif',
                        'Courier New, Courier, monospace',
                        'Georgia, serif',
                        'Lucida Sans Unicode, Lucida Grande, sans-serif',
                        'Tahoma, Geneva, sans-serif',
                        'Times New Roman, Times, serif',
                        'Trebuchet MS, Helvetica, sans-serif',
                        'Verdana, Geneva, sans-serif'
                    ],
                    supportAllValues: true
                },
                // https://ckeditor.com/docs/ckeditor5/latest/features/font.html#configuring-the-font-size-feature
                fontSize: {
                    options: [ 10, 11, 11.3514, 12, 13, 14, 15, 16,  'default', 17, 18, 19, 20, 21, 22 ],
                    supportAllValues: true
                },
                // Be careful with the setting below. It instructs CKEditor to accept ALL HTML markup.
                // https://ckeditor.com/docs/ckeditor5/latest/features/general-html-support.html#enabling-all-html-features
                htmlSupport: {
                    allow: [
                        {
                            name: /.*/,
                            attributes: true,
                            classes: true,
                            styles: true
                        }
                    ]
                },
                // Be careful with enabling previews
                // https://ckeditor.com/docs/ckeditor5/latest/features/html-embed.html#content-previews
                htmlEmbed: {
                    showPreviews: true
                },
                // https://ckeditor.com/docs/ckeditor5/latest/features/link.html#custom-link-attributes-decorators
                link: {
                    decorators: {
                        addTargetToExternalLinks: true,
                        defaultProtocol: 'https://',
                        toggleDownloadable: {
                            mode: 'manual',
                            label: 'Downloadable',
                            attributes: {
                                download: 'file'
                            }
                        }
                    }
                },
                // https://ckeditor.com/docs/ckeditor5/latest/features/mentions.html#configuration
                mention: {
                    feeds: [
                        {
                            marker: '@',
                            feed: [
                                '@apple', '@bears', '@brownie', '@cake', '@cake', '@candy', '@canes', '@chocolate', '@cookie', '@cotton', '@cream',
                                '@cupcake', '@danish', '@donut', '@dragée', '@fruitcake', '@gingerbread', '@gummi', '@ice', '@jelly-o',
                                '@liquorice', '@macaroon', '@marzipan', '@oat', '@pie', '@plum', '@pudding', '@sesame', '@snaps', '@soufflé',
                                '@sugar', '@sweet', '@topping', '@wafer'
                            ],
                            minimumCharacters: 1
                        }
                    ]
                },
                // The "super-build" contains more premium features that require additional configuration, disable them below.
                // Do not turn them on unless you read the documentation and know how to configure them and setup the editor.
                removePlugins: [
                    // These two are commercial, but you can try them out without registering to a trial.
                    // 'ExportPdf',
                    // 'ExportWord',
                    'CKBox',
                    'EasyImage',
                    // This sample uses the Base64UploadAdapter to handle image uploads as it requires no configuration.
                    // https://ckeditor.com/docs/ckeditor5/latest/features/images/image-upload/base64-upload-adapter.html
                    // Storing images as Base64 is usually a very bad idea.
                    // Replace it on production website with other solutions:
                    // https://ckeditor.com/docs/ckeditor5/latest/features/images/image-upload/image-upload.html
                    // 'Base64UploadAdapter',
                    'RealTimeCollaborativeComments',
                    'RealTimeCollaborativeTrackChanges',
                    'RealTimeCollaborativeRevisionHistory',
                    'PresenceList',
                    'Comments',
                    'TrackChanges',
                    'TrackChangesData',
                    'RevisionHistory',
                    'Pagination',
                    'WProofreader',
                    // Careful, with the Mathtype plugin CKEditor will not load when loading this sample
                    // from a local file system (file://) - load this site via HTTP server if you enable MathType.
                    'MathType',
                    // The following features are part of the Productivity Pack and require additional license.
                    'SlashCommand',
                    'Template',
                    'DocumentOutline',
                    'FormatPainter',
                    'TableOfContents',
                    'PasteFromOfficeEnhanced'
                ],
                ckfinder: {
    				uploadUrl : '${pageContext.request.contextPath}/upload'
    			}
    		})
    		.then(editor => {
    			console.log('Editor was initialized');
    		})
    		.catch(error => {
    			console.error(error);
            });
        </script>
	<script
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aec5b89790015b44669217946b7e53f3"></script>
	<script>
	// 체크박스 요소 가져오기
	const safeTradingCheckbox = document.getElementById("safeTradingYn");

	// 체크박스 상태가 변경될 때 실행되는 함수
	safeTradingCheckbox.addEventListener("change", function() {
	    if (safeTradingCheckbox.checked) {
	        // 체크되었을 때 'Y'로 설정
	        safeTradingCheckbox.value = "Y";
	    } else {
	        // 체크 해제됐을 때 'N'로 설정
	        safeTradingCheckbox.value = "N";
	    }
	});
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
            
            
            
            // 폼에 위도와 경도 추가
            document.getElementById('latitudeInput').value = lat.toFixed(6);
			document.getElementById('longitudeInput').value = lng.toFixed(6);
            
           /*  document.getElementById('latitudeInput').value = lat;
            document.getElementById('longitudeInput').value = lng;
            lat = parseFloat(lat.toFixed(10)); // 위도를 소수점 10자리까지 저장
            lng = parseFloat(lng.toFixed(10)); */
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
