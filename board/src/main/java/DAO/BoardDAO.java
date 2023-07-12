package DAO;

import java.sql.*;
import java.util.ArrayList;

import DTO.Board;

public class BoardDAO {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	//db연결 메소드
	public Connection open() {
		Connection conn = null; // 데이터베이스의 연결을 담당
		try {
			Class.forName(JDBC_DRIVER); //드라이버 로드
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234"); //DB연결
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return conn;
	}
	
	// 게시판 리스트 가져오기
	public ArrayList<Board> getList() throws Exception{
		Connection conn = open();
		
		ArrayList<Board> boardList = new ArrayList<>();
		String sql = "select board_no, title, user_id, to_char(reg_date, 'yyyy.mm.dd') reg_date, views from board";
		PreparedStatement pstmt = conn.prepareStatement(sql); // 쿼리문 등록
		ResultSet rs = pstmt.executeQuery(); // 쿼리 실행
		
		try(conn; pstmt; rs) {
			while (rs.next()) {
				Board b = new Board();
				
				b.setBoard_no(rs.getInt("board_no"));
				b.setTitle(rs.getString("title"));
				b.setUser_id(rs.getString("user_id"));
				b.setReg_date(rs.getString("reg_date"));
				b.setViews(rs.getInt("views"));
				
				boardList.add(b);
			}
			
		}
		
		return boardList;
	}
	
	// 게시물 내용 가져오기
	public Board getView(int board_no) throws Exception {
		Connection conn = open();
		Board b = new Board();
		String sql = "select board_no, title, user_id, to_char(reg_date, 'yyyy.mm.dd') reg_date, views, content, img from board where board_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, board_no);
		ResultSet rs = pstmt.executeQuery();
		
		try(conn; pstmt; rs){
			while(rs.next()) {
				b.setBoard_no(rs.getInt("board_no"));
				b.setTitle(rs.getString("title"));
				b.setUser_id(rs.getString("user_id"));
				b.setReg_date(rs.getString("reg_date"));
				b.setViews(rs.getInt("views"));
				b.setContent(rs.getString("content"));
				b.setImg(rs.getString("img"));
			}
		}
		
		return b;
	}
	
	// 조회수 증가
	public void updateViews(int board_no) throws Exception {
		Connection conn = open();
		String sql = "update board set views = (views + 1) where board_no = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt){
			pstmt.setInt(1, board_no);
			pstmt.executeUpdate();
		}
	}
	
	// 게시글 등록
	public void insertBoard(Board b) throws Exception {
		Connection conn = open();
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate2, 0, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn;pstmt){
			pstmt.setString(1, b.getUser_id());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getImg());
			
			pstmt.executeUpdate();
		}
	}
	
	// 게시글 수정 화면 보여주기
	public Board getViewForEdit(int board_no) throws Exception {
		Connection conn = open();
		Board b = new Board();
		String sql = "select board_no, title, user_id, to_char(reg_date, 'yyyy.mm.dd') reg_date, views, content, img from board where board_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, board_no);
		ResultSet rs = pstmt.executeQuery();
		
		try(conn; pstmt){
			while(rs.next()) {
				b.setBoard_no(rs.getInt("board_no"));
				b.setTitle(rs.getString("title"));
				b.setUser_id(rs.getString("user_id"));
				b.setReg_date(rs.getString("reg_date"));
				b.setViews(rs.getInt("views"));
				b.setContent(rs.getString("content"));
				b.setImg(rs.getString("img"));
			}
		}
		
		return b;
	}
	
	// 게시글 수정
	public void updateBoard(Board b) throws Exception {
		Connection conn = open();
		String sql = "update board set title = ?, user_id = ?, content = ?, img = ? where board_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn;pstmt){
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getUser_id());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getImg());
			pstmt.setInt(5, b.getBoard_no());
			
			// 수정된 글이 없을 경우
			if(pstmt.executeUpdate() != 1) {
				throw new Exception("수정된 글이 없습니다.");
			}else {
				pstmt.executeUpdate();
			}
		}
	}
	
	//게시글 삭제
	public void deleteBoard(int board_no) throws Exception {
		Connection conn = open();
		String sql = "delete from board where board_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		try(conn; pstmt){
			pstmt.setInt(1, board_no);
			
			if(pstmt.executeUpdate() != 1) {
				throw new Exception("삭제된 글이 없습니다.");
			}else {
				pstmt.executeUpdate();				
			}
		}
	}
	
	
}
