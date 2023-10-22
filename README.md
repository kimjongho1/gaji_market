# Gaji_Market (가지마켓) 

<br>

## 2023.08.20~2023.10.31 (프로젝트 진행 중, README 작성 중)
<br>

##  📣 팀 프로젝트
- 팀장 : 김종호
- 팀원 : 천영준, 신정훈, 백의헌 
<br>


## 개발환경
|Category|Detail|
|--------|------|
|FrontEnd|HTML5, CSS, JavaScript, JQuery|
|BackEnd|Java(JDK 11.0.2), Spring Framework(5.3.19)|
|OS|Windows 10|
|IDE|SpringToolSuite3, VSCode ,SQL Developer|
|Server|Tomcat 9.0|
|DateBase|Oracle(21c)|
|API|IamPort, CK Editor, Kakao Map, cloudinary, Geolocation|
|Library|AspectJ 1.9.19<br>ojdbc8 23.2.0.0<br>commons-lang3 3.8.1<br>slf4j 1.6.6<br>mybatis 3.5.9<br>spring-session 2.3.3.RELEASE<br>log4j 1.2.15<br>mybatis-spring 2.0.6<br>inject 1.0.0<br>lombok 1.18.28<br>Servlet API 4.0.1<br>spring-security 5.7.5<br>jackson 2.14.2<br>JSP API2.1<br>gson2.8.9<br>JSTL1.2<br>DBCP1.4<br>jackson2.10.2

#
## [ERD Cloud 링크 이동](https://www.erdcloud.com/d/Lm5qwJ8DbtZ92bk3R)
![](https://github.com/bellho/gaji_market/assets/135290607/48f40a1f-4f0c-4be5-a271-8a7d726f2a78)

<br>

## 메인 페이지, 상품 리스트 페이지
#### 화면구현- (신정훈), 기능구현- (백의헌)

### 메인 페이지 
<img src="https://github.com/bellho/gaji_market/assets/135290607/36b400fe-e7c8-49ef-921d-73d97ce22d9e">
<br>

### 상품 리스트 페이지 
<img src="https://github.com/bellho/gaji_market/assets/135290607/bb9a295a-d2b6-4bb6-b02b-d99819c6884f"><br>



#
## 결제 페이지 주소 변경, 결제 진행, 리뷰작성 (추가 기능 ajax 구현)
#### 화면구현 - (신정훈, 백의헌) 기능구현- (백의헌)  
<br>

### 주소 변경
<img src="https://github.com/bellho/gaji_market/assets/135290607/13c3a2fb-9cbc-41a0-a2bd-5c786c461385">

### 결제 진행
<img src="https://github.com/bellho/gaji_market/assets/135290607/c80ada47-991e-438a-b36e-1956bda96da5"><br>

### 리뷰 작성
<img src="https://github.com/bellho/gaji_market/assets/135290607/18f935e1-8afb-437f-920e-f9bf13cabfe8"><br>


#
## 🧑‍🤝‍🧑 프로젝트 기능구현
|담당자|내용|
|------|----|
|**팀장 김종호**|Spring Framework 초기 셋팅<br>Spring Sercurity 적용 <br> URL Mapping<br>요구사항 정의서 초안 작성 <br>채팅 화면/기능 구현|
|팀원 천영준||
|팀원 신정훈||
|팀원 백의헌|회의록 작성<br>ERD 다이어그램 초안 작성<br>mapper, Service, Dao 초안 작성<br>페이징 처리<br> 안전거래(결제, 결제취소, 결제수락, 결제확정)<br>거래상태 변경에 따른 상품상태 변경<br>안전거래 알림생성 및 조회<br>상품 신고<br>주소(추가, 변경, 삭제)<br>리뷰 및 유저평점 업데이트 기능(프로시저 사용)<br>판매내역 조회<br>구매내역 조회<br>특정 유저 상품 조회<br>모아보기 페이지<br>찜 페이지<br>|
#
## 📌 주요기능
- 여러가지 검색 조건 및 페이징을 적용한 상품리스트 조회
- 채팅을 통한 직거래
- 안전거래
- 사진업로드 및 텍스트 설정 가능한 글 작성
#
