<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="mem" class="ch07.com.dao.Member"/>
    
<jsp:setProperty property="*" name="mem"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 결과 : <%= mem.result()%> --%>
	
	${mem.result()}
</body>
</html>