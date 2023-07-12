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
	[<a href="/jsp_study/registController3">새로고침</a>]
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
				<td>${regist.id}</td>
				<td>
					<a href="/jsp_study/registController3?action=info&id=${regist.id}">${regist.username}</a>
				</td>
				<td>${regist.phone}</td>
				<td>${regist.grade}</td>
			</tr>
		</c:forEach>
	</table>
	
	<h2>고객 등록</h2>		
	<hr>
	<form action="/jsp_study/registController3?action=insert" method="post">
		<label>이름</label><input type="text" name="username" /><br />
		<label>주소</label><input type="text" name="address" /><br />
		<label>등급</label><input type="text" name="grade" /><br />
		<label>핸드폰 번호</label><input type="text" name="phone" /><br />
		<button type="submit">등록</button>
	</form>		
	
</body>
</html>