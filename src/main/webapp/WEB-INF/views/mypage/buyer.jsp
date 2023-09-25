<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${request.getContextPath}/payment/cancel" method="POST">
<input type="hidden" name=transactionId/>
<button type="submit">결제취소</button>
</form>

${safePurchaseInfoDto.goodsTitle}
${safePurchaseInfoDto.}
${safePurchaseInfoDto.Title}
${safePurchaseInfoDto.goodsTitle}
${safePurchaseInfoDto.goodsTitle}
${safePurchaseInfoDto.goodsTitle}

</body>
</html>