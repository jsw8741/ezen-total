package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.*;

public class CrabDAO {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	// db연결 메소드
	public Connection open() {
		Connection conn = null; // 데이터베이스의 연결을 담당
		try {
			Class.forName(JDBC_DRIVER); // 드라이버 로드
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234"); // DB연결
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	// 로고 이미지
	public Product getSelect_user() throws Exception {
		Connection conn = open();
		Product p = new Product();
		String sql = "select * from product where no = 99";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				p.setImg(rs.getString("img"));
				p.setNo(rs.getInt("no"));
			}
		}

		return p;
	}

	// 상품 정보
	public ArrayList<Product> getP_List() throws Exception {
		Connection conn = open();
		ArrayList<Product> p_list = new ArrayList<>();
		String sql = "select * from product where no != 99";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				Product p = new Product();

				p.setNo(rs.getInt("no"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getInt("price"));
				p.setImg(rs.getString("img"));

				p_list.add(p);
			}

		}

		return p_list;
	}

	// 관리자 로그인
	public Manager getManager_login(String id, String pw) throws Exception {
		Connection conn = open();
		Manager m = new Manager();
		String sql = "select * from crab_Manager";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				if (rs.getString("manager_id").equals(id) && rs.getString("manager_pw").equals(pw)) {
					m.setManager_no(rs.getInt("manager_no"));
					m.setManager_id(rs.getString("manager_id"));
					m.setManager_pw(rs.getString("manager_pw"));
					m.setManager_name(rs.getString("manager_name"));
					m.setManager_rank(rs.getString("manager_rank"));
				}
			}
		}

		return m;
	}

	// 회원 로그인
	public Member getMember_login(String id, String pw) throws Exception {
		Connection conn = open();
		Member mem = new Member();
		String sql = "select * from crab_member where member_id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				if (rs.getString("member_id").equals(id) && rs.getString("member_pw").equals(pw)) {
					mem.setMember_no(rs.getInt("member_no"));
					mem.setMember_id(rs.getString("member_id"));
					mem.setMember_pw(rs.getString("member_pw"));
					mem.setMember_name(rs.getString("member_name"));
					mem.setMember_email(rs.getString("member_email"));
					mem.setMember_phone(rs.getString("member_phone"));
					mem.setMember_address(rs.getString("member_address"));
				}
			}
		}

		return mem;
	}

	// 회원 마이페이지
	public Member getMypage(int no) throws Exception {
		Connection conn = open();
		Member mem = new Member();
		String sql = "select * from crab_member where member_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		try (conn; pstmt; rs) {
			while (rs.next()) {
				mem.setMember_no(rs.getInt("member_no"));
				mem.setMember_id(rs.getString("member_id"));
				mem.setMember_pw(rs.getString("member_pw"));
				mem.setMember_name(rs.getString("member_name"));
				mem.setMember_email(rs.getString("member_email"));
				mem.setMember_phone(rs.getString("member_phone"));
				mem.setMember_address(rs.getString("member_address"));
			}
		}

		return mem;
	}
	
	// 개인정보 업데이트
	public void UpdateInfo(Member mem) throws Exception {
		Connection conn = open();
		String sql = "update crab_member set member_name = ?, member_email = ?, member_phone = ?, member_address = ? where member_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn;pstmt){
			pstmt.setString(1, mem.getMember_name());
			pstmt.setString(2, mem.getMember_email());
			pstmt.setString(3, mem.getMember_phone());
			pstmt.setString(4, mem.getMember_address());
			pstmt.setInt(5, mem.getMember_no());
			
			// 수정된 정보가 없을 경우
			if(pstmt.executeUpdate() != 1) {
				throw new Exception("수정된 정보가 없습니다.");
			}else {
				pstmt.executeUpdate();
			}
		}
		
	}
	
	// 회원 가입
	public void insertMember(Member mem) throws Exception {
		Connection conn = open();
		String sql = "insert into crab_member values(crab_members_seq.nextval, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn;pstmt){
			pstmt.setString(1, mem.getMember_id());
			pstmt.setString(2, mem.getMember_pw());
			pstmt.setString(3, mem.getMember_name());
			pstmt.setString(4, mem.getMember_email());
			pstmt.setString(5, mem.getMember_phone());
			pstmt.setString(6, mem.getMember_address());
			
			pstmt.executeUpdate();
		}
	}
	
	// 탈퇴
	public void deleteMember(int member_no) throws Exception {
		Connection conn = open();
		String sql = "delete from crab_member where member_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt){
			pstmt.setInt(1, member_no);
			
			if(pstmt.executeUpdate() != 1) {
				throw new Exception("탈퇴 실패.");
			}else {
				pstmt.executeUpdate();				
			}
		}
	}
	
}
