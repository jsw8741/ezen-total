package ch08.quiz3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




public class RegistDAO2 {
	Connection conn = null;	// 데이터베이스의 연결을 담당
	PreparedStatement pstmt; // 쿼리문의 실행 담당
	Map<String, Regist2> regists = new HashMap<>();
	
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public void open() {
		try {
			Class.forName(JDBC_DRIVER); // 드라이버 로드
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234"); // DB 연결
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			// pstmt, conn은 리소스이므로(데이터를 읽고 쓰는 객체)사용 후 반드시 닫아줘야한다.
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 회원 정보 전부
	public ArrayList<Regist2> getAll(){
		open(); // db오픈
		ArrayList<Regist2> regists = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select * from Regist");
			
			// ResultSet : 데이터베이스 데이터를 받는 역할
			ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행(select문 사용시)
			
			while(rs.next()) {	// 한 행씩 값이 있는지 없는지 판단.
				Regist2 r = new Regist2();
								
				r.setId(rs.getInt("id"));
				r.setUsername(rs.getString("username"));
				r.setAddress(rs.getString("address"));
				r.setGrade(rs.getString("grade"));
				r.setPhone(rs.getString("phone"));
			
				regists.add(r);
				
				this.regists.put(Integer.toString(rs.getInt("id")) , r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return regists;
	}
	
	// 고객 상세 정보
		public Regist2 find(String id) {
			return regists.get(id);
		}
		
	// 회원 등록
	public void insert(Regist2 r){
		open(); // db오픈
		
		try {
			pstmt = conn.prepareStatement("insert into regist values(registId_seq.nextval, ?, ?, ?, ?)");
			
			pstmt.setString(1, r.getUsername()); 
			pstmt.setString(2, r.getAddress());
			pstmt.setString(3, r.getGrade());
			pstmt.setString(4, r.getPhone());
			
			pstmt.executeUpdate(); // insert, delete, update 실행
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	
	}
	
}
