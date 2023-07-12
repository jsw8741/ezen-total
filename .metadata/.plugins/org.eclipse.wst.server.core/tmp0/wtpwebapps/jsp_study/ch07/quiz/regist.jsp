<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="regist_action.jsp">
		<label>Email</label>
		<input type="email" name="email" size="30" placeholder="이메일 형식으로 작성해주세요."/>
		
		<label>Tell</label>
		<input type="tel" name="tel" size="30" placeholder="010-0000-0000"/>
		
		<input type="submit" value="실행" />
	</form>
</body>
</html>