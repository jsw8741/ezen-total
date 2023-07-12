<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, th, td{
		border: 1px solid black;
	}
	
	
</style>
</head>
<body>
	<h2>고객 목록</h2>
	<hr>
	
	<table>
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>전화번호</th>	
			<th>고객등급</th>			
		</tr>
		
		<c:forEach var="regist" varStatus="i" items="${regists}">
			<tr>
				<td>${i.count}</td>
				<td>
					<a href="/jsp_study/registController?action=info&id=${regist.id}">${regist.name}</a>
				</td>
				<td>${regist.phone}</td>
				<td>${regist.grade}</td>
			</tr>
		</c:forEach>
	</table>
			
	
</body>
</html>