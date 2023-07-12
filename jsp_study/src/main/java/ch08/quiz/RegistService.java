package ch08.quiz;

import java.util.*;

public class RegistService {
	Map<String, Regist> regists = new HashMap<>();
	
	public RegistService() {
		Regist regist1 = new Regist("101", "김지우", "서울시", "silver", "010-1111-1111");
		Regist regist2 = new Regist("102", "홍길동", "인천시", "gold", "010-2222-2222");
		Regist regist3 = new Regist("103", "율곡", "김포시", "vip", "010-3333-3333");
		
		regists.put("101", regist1);
		regists.put("102", regist2);
		regists.put("103", regist3);
	}
	
	// 전체 고객 목록
	public ArrayList<Regist> findAll(){
		return new ArrayList<>(regists.values());
	}
	
	// 고객 상세 정보
	public Regist find(String id) {
		return regists.get(id);
	}
}
