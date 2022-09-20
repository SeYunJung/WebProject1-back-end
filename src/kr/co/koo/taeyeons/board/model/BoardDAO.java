package kr.co.koo.taeyeons.board.model;

import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.DataSource;

import kr.co.koo.taeyeons.board.model.BoardVO;

public class BoardDAO {
	
	private static BoardDAO dao = new BoardDAO();
	
	private DataSource ds;
	
	private BoardDAO() { 
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance() {
		if(dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	// 총 게시글 수 반환 함수
	public int selectCount() {
		int num = 0;
		
		String sql = "SELECT COUNT(*) FROM board_list";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next(); // sql이 한행만 검색됨
			num = rs.getInt(1); // 1행의 데이터를 가져온다. count집계 함수는 int형을 반환함 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return num; // 총 게시물 수 반환 
		
	}
	
	public List<BoardVO> getBoardArticles(int firstRow, int endRow) {
		
		List<BoardVO> articleList = new ArrayList<>();
		
		String sql = "SELECT * FROM board_list ORDER BY board_id desc LIMIT ?, ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, firstRow - 1);
			pstmt.setInt(2, endRow - firstRow + 1);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO article = new BoardVO(rs.getInt("board_id"),
											  rs.getString("board_writer"),
											  rs.getString("board_title"),
											  rs.getString("board_content"),
											  rs.getTimestamp("board_date"),
											  rs.getInt("board_hit"));
				articleList.add(article);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return articleList;
		
	}
	
	//////////////////////////////////////
	//게시글 내용을 DB에 저장하는 메서드
		public void write(String bName, String bTitle, String bContent) {
			
			String sql = "insert into board_list (board_writer, board_title, board_content) values (?,?,?)";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bName);
				pstmt.setString(2, bTitle);
				pstmt.setString(3, bContent);
				
				int i = pstmt.executeUpdate();
				if(i == 1) {
					System.out.println("게시글 등록 성공!");
				} else {
					System.out.println("게시글 등록 실패!");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		
		//선택된 게시물의 정보를 DB로부터 조회하는 메서드
		public BoardVO getBoardContent(String bId) {
			
			upHit(bId);//게시글 정보 보기 전에 조회수 올리기. 
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select * from board_list where board_id=?";
			
			BoardVO board = null;
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(bId));
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					board = new BoardVO(rs.getInt("board_id"),
										  rs.getString("board_writer"),
										  rs.getString("board_title"),
										  rs.getString("board_content"),
										  rs.getTimestamp("board_date"),
										  rs.getInt("board_hit"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
					rs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return board;
		}
		
		//글 제목을 클릭할 때마다 조회수를 1 상승시키는 메서드
		private void upHit(String bId) {
			
			String sql = "update board_list set board_hit=board_hit+1 where board_id=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(bId));
				
				pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		
		public void updateArticle(String bTitle, String bContent, String bId){
			
			String sql = "update board_list set board_title=?, board_content=? where board_id=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);//pstmt 객체 초기화
				pstmt.setString(1, bTitle);
				pstmt.setString(2, bContent);
				pstmt.setInt(3, Integer.parseInt(bId));
				pstmt.executeUpdate();
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		
		//게시판 글을 삭제처리하는 메서드
		public void deleteArticle(String bId) {
			
			String sql = "DELETE FROM board_list WHERE board_id=?";
			
			Connection conn = null;
			PreparedStatement pstmt = null;

			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(bId));

				pstmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
					pstmt.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}

}
