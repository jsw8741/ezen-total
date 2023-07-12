function chkForm(){
	var f = document.frm; // form 태그를 가져온다.
	
	if(frm.title.value == ''){
		alert("제목을 입력해주세요.");
		return false;
	}
	
	if(frm.user_id.value == ''){
		alert("아이디를 입력해주세요.");
		return false;
	}
	
	if(frm.content.value == ''){
		alert("글 내용을 입력해주세요.");
		return false;
	}
	
	f.submit(); // 폼 태그 전송
};

function chkDelete(board_no){
	const result = confirm("삭제하시겠습니까?");
	
	if(result){
		const url = location.origin;
		location.href = url + "/board/delete?board_no=" + board_no;
	}else{
		false;
	}
	
	
}

