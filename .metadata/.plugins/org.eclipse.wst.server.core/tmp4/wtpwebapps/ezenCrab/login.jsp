<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>

	<div class=wrap>
		<form name="frm" method="post"
			action="check?status=${status}&result=${result}"
			enctype="multipart/form-data">

			<h2>${status} 로그인</h2>
			<div class="input_box">
				<div class="id">
					<label for="id">아이디</label> <input type="text" name="id" />
				</div>

				<div class="pw">
					<label for="pw">비밀번호</label> <input type="password" name="pw" />
				</div>
			</div>

			<div class="btn_box">
				<a onclick="chkForm(); return false;" class="on">로그인</a> 
				<a href="selectUser">취소</a>
			</div>

		</form>
	</div>

	<script type="text/javascript" src="./script.js"></script>
	
</body>
</html>