package ch07.com.dao;

import java.util.regex.Pattern;

public class Member {
	//이메일 정규식
	public static final String pattern1 = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
	//전화번호 정규식
	public static final String pattern2 = "(02|010)-\\d{3,4}-\\d{4}";

	private String email;
	private String tel;
	private String result = "유효성 검사에 통과하지 못했습니다.";
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String result() {
		
		if(Pattern.matches(pattern1, email) && Pattern.matches(pattern2, tel)) {
			result = "환영합니다.";
		}
		
		
		return result;
	}
	
}
