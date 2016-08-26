<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/lib/jquery-1.10.2.js"></script>
<script src="../js/main.js"></script>
<style type="text/css">
input {
	margin: 5px;
}

div.line {
	margin: 5px;
	width: 100%;
	height: 2px;
	background-color: red;
}
</style>
</head>
<body>
	<div style="border: 1px solid red">
		<input type="button" value="获取" id="btn" /><br />
		<input type="button" value="传递对象" id="btnObj" /><br />
	</div>

	<form action="../Hello/SubmitPersonInfo" method="post">
		姓名：<input type="text" name="name" /><br /> 年龄：<input type="text"
			name="age" /><br /> <input type="submit" value="提交" />
	</form>
	<div class="line"></div>
	<form action="../Hello/upload" method="post"
		enctype="multipart/form-data">
		文件：<input type="file" name="filename" /><br /> <input type="submit"
			value="上传" />
	</form>
	<div class="line"></div>
	<a href="../Hello/download">下载</a>
</body>
</html>