<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%! 
	String str = "Hello,Java Server Pages";
	
	String getString(){
		return str;
	}
%>   
 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	   <h2><%=getString() %></h2>
</body>
</html>