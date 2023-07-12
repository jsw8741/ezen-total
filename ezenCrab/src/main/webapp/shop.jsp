<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<link rel="stylesheet" href="./css/shop.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
	crossorigin="anonymous" />
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String status = request.getParameter("status");

	if (status.equals("회원")) {
	%>
	<script>
		alert("${member.member_name} 회원님 환영합니다.");
	</script>
	<%
	} else {
	%>
	<script>
		alert("gest님 환영합니다.");
	</script>
	<%
	}
	%>


	<div class="wrap">
		<div class="header">

			<form name="frm" method="post"
				action="mypage?member_no=${member.member_no}"
				enctype="multipart/form-data">
				<div class="my_box">
					<a onclick="chkStatus('${status}'); return false;" >마이페이지</a>
				</div>
			</form>
		</div>

		<div class="section">

			<c:forEach var="p" items="${p_list}" varStatus="status">
				<div class="card" style="width: 22rem">
					<img src="${p.img}" class="card-img-top" alt="${p.name}" />
					<div class="card-body">
						<p class="card-text">세상에서 가장 맛있는 ${p.name}!</p>
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
	
	<script type="text/javascript" src="./script.js"></script>
</body>
</body>
</html>