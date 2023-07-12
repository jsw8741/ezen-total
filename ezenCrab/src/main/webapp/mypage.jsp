<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/mypage.css" />
</head>
<body>
	<h2>마이페이지</h2>
	<hr>
	<ul>
		<li>회원번호: ${member.member_no}</li>
		<li>아이디: ${member.member_id}</li>
		<li>이름: ${member.member_name}</li>
		<li>이메일: ${member.member_email}</li>
		<li>전화번호: ${member.member_phone}</li>
		<li>주소: ${member.member_address}</li>
	</ul>
<hr>
	<div class="bt_wrap">
		<a
			href="check?status=회원&member_no=${member.member_no}&member_name=${member.member_name}"
			class="on">뒤로가기</a> <a
			href="updatePage?member_no=${member.member_no}" class="on">수정</a> <a
			onclick="chkDelete(${member.member_no}); return false;" class="on">탈퇴</a>
	</div>

	<script type="text/javascript" src="./script.js"></script>
</body>
</html>