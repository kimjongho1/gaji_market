<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>	
<html>
<head>
<meta charset="UTF-8">
<title>거래후기</title>

<style>
/* 전체 페이지 스타일링 */
body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    text-align: center;
}

/* 폼 스타일링 */
form {
    background-color: #fff;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
    margin: 20px auto;
    max-width: 400px;
}

/* 입력 요소 스타일링 */
span {
    display: block;
    margin-bottom: 10px;
    font-weight: bold;
}

input[type="text"], textarea {
    text-align: center;
    width: 40%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

textarea {
    width: 90%;
    padding: 10px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

textarea {
    resize: none;
    height: 150px;
}

/* 버튼 스타일링 */
button[type="submit"] {
    background-color: #007bff;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
}

button[type="submit"]:hover {
    background-color: #0056b3;
}
</style>

</head>
<body>
    <form action="${pageContext.request.contextPath}/mypage/dealreview.do" method="post">
        <span>매너점수</span><input type="text" name="mannerPoint" placeholder="1~5사이 값을 입력하세요" required>
        <span>상품점수</span><input type="text" name="goodsPoint" placeholder="1~5사이 값을 입력하세요" required>
        <span>시간약속 점수</span><input type="text" name="timePoint" placeholder="1~5사이 값을 입력하세요" required>
        <textarea name="message" placeholder="리뷰를 입력하세요"></textarea>
        <input type="hidden" name="transactionId" value="${transactionId}">
        <button type="submit">리뷰작성</button>
    </form>
</body>
</html>