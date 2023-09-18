<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	<script
	src="https://cdn.ckeditor.com/ckeditor5/12.4.0/classic/ckeditor.js"></script>
<style>
.ck.ck-editor {
	width: 80%;
	max-width: 800px;
	margin: 0 auto;
}

.ck-editor__editable {
	height: 80vh;
}
</style>
</head>
<body>
<h1>이미지 업로드</h1>
    <%-- <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" accept="image/*" required>
        <input type="submit" value="업로드">
    </form> --%>
    <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
		<div id="editor"></div>
		<input type="button" class="btn btn-secondary mt-3 mx-2" value="작성취소" />
		<input type="submit" class="btn btn-primary mt-3 mx-2" value="작성완료" />
	</form>
	<!-- CKEditor -->
	<script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
	<script>
		ClassicEditor
		.create(document.querySelector('#editor'), {
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
</body>
</html>