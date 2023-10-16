<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
  <title>스와이퍼 예제</title>
</head>
<body>
  <div class="swiper-container">
    <div class="swiper-wrapper">
      <div class="swiper-slide">
          1번 슬라이드입니다.<br>마우스로 움직여보세요.
      </div>
      <div class="swiper-slide">
          2번 슬라이드입니다.<br>
          레이아웃만 제대로 설정되어 있다면 슬라이드에 어떤 것이든 넣을 수 있습니다.
      </div>
      <div class="swiper-slide">
          <img src="https://image.flaticon.com/icons/png/128/1933/1933588.png" alt=""><br>
          이렇게 이미지도 넣을 수 있습니다.
      </div>
        
        ...
    </div>
  </div>
  
  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
  <script>
  new Swiper('.swiper-container');
  </script>
</body>
</html>