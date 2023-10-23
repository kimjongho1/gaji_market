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
|Library|AspectJ 1.9.19<br>ojdbc8 23.2.0.0<br>commons-lang3 3.8.1<br>slf4j 1.6.6<br>mybatis 3.5.9<br>spring-session 2.3.3.RELEASE<br>log4j 1.2.15<br>mybatis-spring 2.0.6<br>inject 1.0.0<br>lombok 1.18.28<br>Servlet API 4.0.1<br>spring-security 5.7.5<br>jackson 2.14.2<br>JSP API2.1<br>gson2.8.9<br>JSTL1.2<br>DBCP1.4<br>jackson2.10.2<br>iamport0.2.14

#
## [ERD Cloud 링크 이동](https://www.erdcloud.com/d/Lm5qwJ8DbtZ92bk3R)
![](https://github.com/bellho/gaji_market/assets/135290607/48f40a1f-4f0c-4be5-a271-8a7d726f2a78)

<br>

## 메인 페이지, 상품 리스트 페이지
#### 화면구현- (신정훈), 기능구현- (백의헌)

### 메인 페이지 
<img src="https://github.com/bellho/gaji_market/assets/135290607/36b400fe-e7c8-49ef-921d-73d97ce22d9e">
<br><br>

### 상품 리스트 페이지 
<img src="https://github.com/bellho/gaji_market/assets/135290607/bb9a295a-d2b6-4bb6-b02b-d99819c6884f"><br>

<details>
  <summary>검색 조건에 따른 데이터를 불러오기 위한 동적 쿼리문</summary>

    <select id="getGoodsList" parameterType="map"
		resultType="GoodsListDto">
		select list2.*,(select f.url from goods_file f where
		f.goods_id=list2.goods_id and rownum between 0 and 1) url from
		(select
		list.*,rownum rn from(
		(select
		g.view_count,g.title,g.price,g.goods_Id,u.nickname,g.status,g.safe_Trading_Yn,d.dong_Name,g.refreshed_at,
		g.created_at,

		(select count(*) from wishList w where
		g.goods_id=w.goods_id) likeCount
		from goods g join users u
		using(user_id) join dong d on g.dong_id=d.dong_id
		where
		active_status='Y'
		<if test="category!=-1">
			and category_id=#{category}
		</if>
		<if test='searchWord!=""'>
			and title like #{searchWord}
		</if>
		<choose>
			<when test="priceCeiling==100000">
				and price &lt;= 100000
			</when>
			<when test="priceCeiling==300000">
				and price &gt;= 100000 and price &lt;= 300000
			</when>
			<when test="priceCeiling==500000">
				and price &gt;= 300000 and price &lt;= 500000
			</when>
			<when test="priceCeiling==700000">
				and price &gt;= 500000
			</when>
		</choose>
				<choose>
		<when test="onsale!=-1">
			and g.status=1
		</when>
		<otherwise>
			and g.status!=4
		</otherwise>
		</choose>
		<if test="dongId!=-1">
			and g.dong_id=#{dongId}
		</if>
		<choose>
			<when test="sort==1">
				order by likeCount desc, g.refreshed_at desc
			</when>
			<when test="sort==3">
				order by price asc, g.refreshed_at desc
			</when>
			<when test="sort==4">
				order by price desc, g.refreshed_at desc
			</when>
			<otherwise>
				order by g.refreshed_at desc
			</otherwise>
		</choose>
		)
		list)
		)list2 where list2.rn between #{startRownum} and #{endRownum}
	</select>

</details>
<br>

#
## 결제 페이지 주소 변경, 결제 진행, 리뷰작성 (추가 기능 ajax 구현)
<br>

#### 화면구현 - (신정훈, 백의헌) 기능구현- (백의헌)  
<br>

### 주소 변경
<img src="https://github.com/bellho/gaji_market/assets/135290607/13c3a2fb-9cbc-41a0-a2bd-5c786c461385">

<br>
<details>
  <summary>주소 변경, 삭제, 추가를 위한 Mapper코드</summary>

>    

    <!-------------------------------------------대표주소 변경을 위한 mapper--------------------------------------->
     <!-- 대표주소를 변경하기위해 주소순서를 하나씩 뒤로 민다 -->
    <update id="updateMainAddressNo" parameterType="string">	
		update user_address set address_no=address_no+1 where user_id=#{userId}
	</update>
	
	<update id="updateMainAddress" parameterType="map">	<!--주소순서를 1로 바꿈으로써 대표주소 변경 -->
		update user_address set address_no=1 where user_id=#{userId} and address_no=#{addressNo}+1
	</update>
	
	<update id="updateMainAddress2" parameterType="map"> <!-- 대표주소가 된 주소보다 높은순서들을 다시 1씩 내려주기. -->
		update user_address set address_no=address_no-1 where user_id=#{userId} and address_no &gt; #{addressNo}
	</update>

    <!------------------------------------------------주소 추가 mapper -------------------------------------------->
	<!-- 새로입력된 주소를 count+1 주소순서에 추가한다 -->
	<insert id="insertAddress" parameterType="UserInsertAddressDto">	
		insert into user_address values(#{detailAddress},#{postCode},#{userId},#{roadAddress},#{address},#{addressNickname},(select count(*) from user_address where user_id=#{userId})+1)
	</insert>
    
	 <!-----------------------------------------------주소 삭제 mapper -------------------------------------------->
     <!-- 주소삭제 1단계 작업(주소삭제)-->
	<delete id="deleteAddress1" parameterType="map">	
		delete from user_address where address_no=#{addressNo} and user_id=#{userId}
	</delete>

	<!-- 주소삭제 2단계 작업(삭제된 주소순서보다 작은 주소들 -1)  -->
	<update id="deleteAddress2" parameterType="map">	
		update user_address set Address_no=Address_no-1 where Address_no &gt; #{addressNo} and user_id=#{userId}
	</update>
</details>
<br>

### 결제 진행
<img src="https://github.com/bellho/gaji_market/assets/135290607/c80ada47-991e-438a-b36e-1956bda96da5">



<details>
  <summary>안전거래 유효성 검사 코드</summary>

> 

  안전거래의 핵심은 `유효성 검사`입니다. <br>JSP에서 아임포트 API를 통해 결제가 이루어지면 <br>`Controller`에서는 `Database`에 저장된 정보와 `API`에서 결제된 정보를 `대조`합니다.<br>
  이 결과에 따라 `Database`에 안전결제에 대한 데이터를 삽입한 후 <br>
  최종적으로 안전결제 성공여부를 `클라이언트`에게 전달합니다.

  
>   

    @PostMapping("payment/callback")
	@ResponseBody
	public IamportResponse<Payment> callback(String impUid,InsertSafeTradingDto insertSafeTradingDto,Integer goodsId,HttpServletRequest request,Principal principal) {
		IamportResponse<Payment> result=null;
		String userId=principal.getName();
		try {
			result= api.paymentByImpUid(impUid);
			int amount =(int)Math.round(payServiceImpl.getAmount(goodsId) * 1.035);
			String goodTitle=result.getResponse().getName();
			if(result.getResponse().getStatus().equals("paid")&&amount==result.getResponse().getAmount().intValue()) {	// 금액이 일치하고 지불이 완료되었다면.
				insertSafeTradingDto.setTransactionId(impUid);
				insertSafeTradingDto.setGoodsTitle(goodTitle);
				insertSafeTradingDto.setPrice(amount);
				insertSafeTradingDto.setPurchaseMethod(result.getResponse().getPayMethod());
				insertSafeTradingDto.setBuyerId(userId);
				
				int addResult = payServiceImpl.addSafeTrading(insertSafeTradingDto); 
                //데이터베이스에 안전거래에 대한 데이터를 넣음
				
				if(addResult==1) { // 가지 데이터베이스에 값이 정상적으로 들어갔다면
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("status", 2);
					map.put("goodsId",goodsId);
					if(payServiceImpl.updateStatus(map)==1) {
						TitleBuyerDto titleBuyerDto=payServiceImpl.getIdFromTransactionId(impUid);
						insertNotificationDto.setBuyerId(titleBuyerDto.getBuyerId());  
						insertNotificationDto.setSellerId(titleBuyerDto.getSellerId()); 
						insertNotificationDto.setType(2);
						insertNotificationDto.setReferenceId(impUid);
						insertNotificationDto.setMessage(titleBuyerDto.getGoodsTitle()+"의 안전거래가 신청되었습니다.");
						payServiceImpl.insertNoti(insertNotificationDto);
						return result;	// 거래정보 반환.
					}
				}
				else			// 가지 데이터베이스에 값이 입력되지 않았거나 거래중으로 변경이 안되었다면 거래취소함.
				{
					cancelData=new CancelData(impUid, true); 
					api.cancelPaymentByImpUid(cancelData);
					return result;	//거래 정보 반환
				}
			}
			
			else {
				cancelData=new CancelData(impUid, true); // imp_uid를 이용하여 거래취소함수에 인자가될 객체생성
				api.cancelPaymentByImpUid(cancelData);	// api의 취소함수에 cancelData를 인자로하여 거래취소.
				return result;	//거래 정보 반환
			}
		} catch (IamportResponseException | IOException e) {
			e.printStackTrace();
		}
		return result;
	}
</details>
<br>
    

### 리뷰 작성
<img src="https://github.com/bellho/gaji_market/assets/135290607/18f935e1-8afb-437f-920e-f9bf13cabfe8"><br>

<details>
  <summary>리뷰작성 프로시저 코드</summary>

>   `프로시저`를 활용하여 리뷰작성과 유저평점 업데이트를 `Transactional`하게 처리 

    CREATE OR REPLACE PROCEDURE updateRatingScore(
    goodsId IN NUMBER,
    userId IN VARCHAR,
    message IN VARCHAR,
    mannerPoint IN NUMBER,
    timePoint IN NUMBER,
    goodsPoint IN NUMBER,
    result1 OUT NUMBER
    ) AS 
    BEGIN
    BEGIN
        INSERT INTO deal_review VALUES (goodsId, userId, message, mannerPoint, timePoint, goodsPoint);
        result1 := 1; -- 성공
    EXCEPTION
        WHEN OTHERS THEN
            result1 := 0; -- 실패
    END;
    -- rating_score 업데이트
    IF result1 = 1 THEN
        BEGIN
            UPDATE users
            SET rating_score = rating_score + (mannerPoint + timePoint + goodsPoint - 11) / 5
            WHERE user_Id = (select user_Id from goods where goods_Id=goodsId);
            COMMIT;
        EXCEPTION
            WHEN OTHERS THEN
                result1 := 0; -- 실패
                ROLLBACK;
        END;
    END IF;
    END;
</details>
<br>

#
## 🧑‍🤝‍🧑 프로젝트 기능구현
|담당자|내용|
|------|----|
|**팀장 김종호**|Spring Framework 초기 셋팅<br>Spring Sercurity 적용 <br> URL Mapping<br>요구사항 정의서 초안 작성 <br>채팅 화면/기능 구현|
|팀원 천영준||
|팀원 신정훈||
|팀원 백의헌|회의록 작성<br>ERD 다이어그램 초안 작성<br>mapper, Service, Dao 초안 작성<br>페이징 처리<br> 안전거래(결제, 결제취소, 결제수락, 결제확정)<br>거래상태 변경에 따른 상품상태 변경<br>안전거래 알림 생성, 삭제, 조회<br>상품 신고<br>주소(추가, 변경, 삭제)<br>리뷰 및 유저평점 업데이트 기능(프로시저 사용)<br>판매내역 조회<br>구매내역 조회<br>특정 유저 상품 조회<br>모아보기 페이지<br>찜 페이지<br>|
#
## 📌 주요기능
- 여러가지 검색 조건 및 페이징을 적용한 상품리스트 조회
- 채팅을 통한 직거래
- 안전거래
- 사진업로드 및 텍스트 설정 가능한 글 작성
#
