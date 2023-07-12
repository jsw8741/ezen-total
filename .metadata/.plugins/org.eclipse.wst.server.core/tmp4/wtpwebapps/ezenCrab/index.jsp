<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
	<c:if test="${product.img == null && error == null}">
		<jsp:forward page="selectUser" />
	</c:if>

	<div class="wrap">
		<div class="index_box">
			<div class="logo">
				<h1>이젠 게장</h1>
				<div class="logo_img">
					<img src="${product.img}" alt="로그 이미지" />
				</div>
			</div>

			<div class="select-group">
					<div class="select">
						<a href="login?status=회원">회원</a>
					</div>
					<div class="select">
						<a href="join?status=gest">비회원</a>
					</div>
					<div class="select">
						<a href="login?status=관리자">관리자</a>
					</div>
			</div>
		</div>
	</div>




</body>
</html>