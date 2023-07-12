<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>가격</th>		
		</tr>
		
		<c:forEach var="p" varStatus="i" items="${products}">
			<tr>
				<td>${i.count}</td>
				<td>
					<a href="/jsp_study/productController?action=info&id=${p.id}">${p.name}</a>
				</td>
				<td>${p.price}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>