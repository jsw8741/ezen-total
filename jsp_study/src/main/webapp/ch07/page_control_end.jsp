<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	결과장
	<hr>
	이름 :	<%= request.getParameter("username") %>
	<br>
	전화 번호 :  <%= request.getParameter("tel") %>
	
</body>
</html>