<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="gugu" class="ch07.com.dao.GuGuDan"/>
    
<jsp:setProperty property="*" name="gugu"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>구구단 출력하기</h4>
	<%=gugu.process(5) %>
	<%=gugu.getT1() %>
	<%=gugu.getT2() %>
</body>
</html>