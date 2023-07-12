<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/join.css" />
</head>
<body>
	<script>
		const result = confirm("회원가입하기");

		if (result) {

		} else {
			const url = location.origin;
			location.href = url + "/ezenCrab/check?status=gest"
		}
	</script>
	<div class="wrap">
	<form name="frm" method="post"
			action="insert" enctype="multipart/form-data">
		<div class="join">
			<label for="exampleFormControlInput1" class="form-label">아이디</label>
			<input type="text" class="form-control" name = "member_id"
				placeholder="영문자로 시작하는 영문자, 숫자인 6~15글자" />
		</div>

		<div class="join">
			<label for="exampleFormControlInput2" class="form-label">비밀번호</label>
			<input type="password" class="form-control" name = "member_pw"
				placeholder="특수문자 / 문자 / 숫자 포함 형태의 8~15자리" />
		</div>

		<div class="join">
			<label for="exampleFormControlInput2" class="form-label">비밀번호
				확인</label> <input type="password" class="form-control" name = "password_ch" />
		</div>


		<div class="join">
			<label for="exampleFormControlInput3" class="form-label">이름</label> <input
				type="text" class="form-control" name = "member_name" />
		</div>

		<div class="join">
			<label for="exampleFormControlInput3" class="form-label">이메일</label>
			<input type="email" class="form-control" name = "member_email" />
		</div>

		<div class="join">
			<label for="exampleFormControlInput6" class="form-label">휴대전화</label>
			<input type="tel" class="form-control" name = "member_phone"
				placeholder="'-'를 포함한 전화번호를 입력하세요." />
		</div>

		<div class="join">
			<label for="exampleFormControlInput6" class="form-label">주소</label> <input
				type="text" class="form-control" name = "member_address"/>
		</div>

		<div class="bt_wrap">
			<!-- <button type="button" class="register">가입하기</button> -->
			<a onclick="regist(); return false;" class="register">가입하기</a>
		</div>
		</form>
	</div>

	<script type="text/javascript" src="./join.js"></script>
	
</body>
</html>