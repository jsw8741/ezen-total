<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Cookie[] c = request.getCookies();
if(session.getAttribute("id") != null){ // 쿠키가 존재하면
		%>
			<h1>메인 화면</h1>
			<p><%=session.getAttribute("id") %> 님, 환영합니다.</p>
			<p>세션 id : <%=session.getId() %></p>
			
			<form action="logout.jsp" method="post">
				<input type="submit" value ="로그아웃">
			
			</form>
		<%
	}else{
		%>
		<script>
			alert("로그인이 필요합니다.");
			location.href = "index.jsp";
		</script>	
	<%
}
	
%>
</body>
</html>