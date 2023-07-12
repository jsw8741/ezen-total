package ch09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// model : 데이터베이스와 직접적으로 대화, StudentController에 데이터 전달
public class StudentDAO {
	Connection conn = null;	// 데이터베이스의 연결을 담당
	PreparedStatement pstmt; // 쿼리문의 실행 담당
	
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	// db연결 메소드
	public void open() {
		try {
			Class.forName(JDBC_DRIVER); // 드라이버 로드
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234"); // DB 연결
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// db연결 닫는 메소드
	public void close() {
		try {
			// pstmt, conn은 리소스이므로(데이터를 읽고 쓰는 객체)사용 후 반드시 닫아줘야한다.
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 학생 정보를 다 불러오는 메소드
	public ArrayList<Student> getAll(){
		open(); // db오픈
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement("select * from student");
			
			// ResultSet : 데이터베이스 데이터를 받는 역할
			ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행(select문 사용시)
			
			while(rs.next()) {	// 한 행씩 값이 있는지 없는지 판단.
				Student s = new Student();
								
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setUniv(rs.getString("univ"));
				s.setBirth(rs.getDate("birth"));
				s.setEmail(rs.getString("email"));
			
				students.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		
		return students;
	}
	
	// 학생 정보를 등록하는 메소드
	public void insert(Student s){
		open(); // db오픈
		
		try {
			pstmt = conn.prepareStatement("insert into student values(id_seq.nextval, ?, ?, ?, ?)");
			
			pstmt.setString(1, s.getUsername()); 
			pstmt.setString(2, s.getUniv());
			pstmt.setDate(3, s.getBirth());
			pstmt.setString(4, s.getEmail());
			
			pstmt.executeUpdate(); // insert, delete, update 실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	
	}
	
	// remove
	public void delete(Student s) {
		open(); // db오픈
		
		try {
			pstmt = conn.prepareStatement("delete from student where username = ?");
			
			pstmt.setString(1, s.getUsername()); 
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
}
