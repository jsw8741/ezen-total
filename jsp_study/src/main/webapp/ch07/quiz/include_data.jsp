<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% int num = Integer.parseInt(request.getParameter("quiz1"));
	
		for(int i=1;i<=9;i++){
			out.print(num + " * " + i + " = " + num*i + "<br>" );
		}
	%>
	
</body>
</html>