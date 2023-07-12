<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/update.css" />
</head>
<body>
	<h2>마이페이지</h2>
	<hr>
	<form name="frm" method="post"
		action="update?member_no=${member.member_no}"
		enctype="multipart/form-data">
		<ul>
			<li>이름: <input type="text" name="member_name"
				value="${member.member_name}" />
			</li>
			<li>이메일: <input type="text" name="member_email"
				value="${member.member_email}" /></li>
			<li>전화번호: <input type="text" name="member_phone"
				value="${member.member_phone}" /></li>
			<li>주소: <input type="text" name="member_address"
				value="${member.member_address}" /></li>
		</ul>
	</form>

	<div class="bt_wrap">
		<a onclick="chkInfo(); return false;" class="on">수정</a>
	</div>
	
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>