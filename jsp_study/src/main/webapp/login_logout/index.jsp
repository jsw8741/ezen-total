<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
html, body {
	height: 100%;
	margin: 0;
}

form {
	height: 100%;
	display: flex;
	align-items: center;
}

div {
	width: 300px;
	margin: 0 auto;
}

label {
	width: 70px;
	display: inline-block;
}

h2 {
	font-size: 20px;
}
</style>
<!-- jquery -->

<script src="https://code.jquery.com/jquery-3.6.3.min.js"
	integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
	crossorigin="anonymous">
	
</script>

</head>
<body>
	<%
	Cookie[] c = request.getCookies();
	if (c != null) { // 쿠키가 존재하면
		for (Cookie cf : c) {
			if (cf.getName().equals("loginChk") && cf.getValue().equals("Y")) { // 체크한 경우
	%>
	<script>
		$(function() {
			$("#loginChk").prop("checked", true); // 체크
		});
	</script>
	<%
	} else {
	%>
	<script>
		$(function() {
			$("#loginChk").prop("checked", false); // 체크해제
		});
	</script>
	<%
	}
	}
	}
	%>

	<form action="login.jsp" method="post">
		<div>
			<h2>관리 시스템 로그인</h2>
			<label for="id">아이디</label> <input type="text" name="id" id="id" /> <br />
			<label for="pw">비밀번호</label> <input type="password" name="pw" id="pw" />
			<br /> <br /> <input type="checkbox" name="loginChk" /> 아이디 기억 <br />
			<input type="submit" value="로그인" /> <input type="reset" value="취소" />
		</div>

	</form>

</body>
</html>