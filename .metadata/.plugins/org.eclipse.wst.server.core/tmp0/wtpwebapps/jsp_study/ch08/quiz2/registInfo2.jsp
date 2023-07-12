<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>고객정보 조회</h2>
	<hr>
	<ul>
		<li>고객 아이디: ${regist.username}</li>
		<li>고객명: ${regist.id}</li>
		<li>주소: ${regist.address}</li>
		<li>등급: ${regist.grade}</li>
		<li>전화번호: ${regist.phone}</li>
	</ul>
	
	<h3><a href="/jsp_study/registController3">뒤로가기</a></h3>
	
	
</body>
</html>