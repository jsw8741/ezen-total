
function chkForm(){
	var f = document.frm;
	
	if(frm.id.value == ''){
		alert("아이디를 입력해주세요.");
		return false;
	}
	
	if(frm.pw.value == ''){
		alert("비밀번호를 입력해주세요.");
		return false;
	}
	
	f.submit();
};

function chkInfo(){
	var f = document.frm;
	
	if(frm.member_name.value == ''){
		alert("이름을 입력해주세요.");
		return false;
	}
	
	if(frm.member_email.value == ''){
		alert("이메일을 입력해주세요.");
		return false;
	}
	
	if(frm.member_phone.value == ''){
		alert("전화번호를 입력해주세요.");
		return false;
	}
	
	if(frm.member_address.value == ''){
		alert("주소를 입력해주세요.");
		return false;
	}
	
	f.submit(); // 폼 태그 전송
};

function chkStatus(status){
		var f = document.frm;
		
		if(status == "gest"){
			alert("회원만 이용 가능합니다.");
			const url = location.origin;
			location.href = url + "/ezenCrab/join?status=" + status;
		}else{
			
		f.submit();
		}
		
	}
	
function chkDelete(member_no){
	const result = confirm("삭제하시겠습니까?");
	
	if(result){
		const url = location.origin;
		location.href = url + "/ezenCrab/delete?member_no=" + member_no;
	}else{
		false;
	}
	
}
