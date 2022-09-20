package kr.co.koo.taeyeons.member.model;

import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// DAO는 DB를 처리해주는 객체!
// Singleton 패턴으로 하나의 객체만으로 처리하여 메모리를 절약한다. 
public class MemberDAO {
	
	// 로그인 성공과 실패시 sql함수는 -1,1,0을 반환함. 
	// 반환되는 숫자에 따라 의미를 부여하여 변수에 초기화!
	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_FAIL_ID = -1;
	public static final int LOGIN_FAIL_PW = 0;
	
	private static MemberDAO dao = new MemberDAO();
	private DataSource ds;
	
	private MemberDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		if(dao == null) {
			dao = new MemberDAO();
		}
		return dao;
	}
	
	// 로그인 검증
	public int userCheck(String id, String pw) {
		
		int resultNum = 0;
		
		String sql = "SELECT userPw FROM member WHERE userId=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // id가 존재한다면
				String dbPw = rs.getString("userPw");
				if(pw.equals(dbPw)) { // pw가 일치
					resultNum = LOGIN_SUCCESS;
				} else { // pw가 불일치
					resultNum = LOGIN_FAIL_ID;
				}
			} else { // id가 존재하지 않는다면
				resultNum = LOGIN_FAIL_PW;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return resultNum;// resultNum 값에 따라 로그인 성공여부를 판별
		
	}
	
	//ID 중복확인 메서드
	public boolean confirmId(String id) {
		
		boolean flag = false;
		
		String sql = "SELECT userId FROM member WHERE userId=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				flag = true; // id중복
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
	
	// 회원가입
	public boolean insertMember(MemberVO members) {
		boolean flag = false;
		
		String sql = "INSERT INTO member (userId, userPw, userName, userEmail) VALUES (?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, members.getUserId());
			pstmt.setString(2, members.getUserPw());
			pstmt.setString(3, members.getUserName());
			pstmt.setString(4, members.getUserEmail());
			
			int i = pstmt.executeUpdate();
			
			if(i == 1) { // 회원가입 성공
				flag = true;
			} else {
				flag = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
	
	// 로그인한 회원 정보 조회
	public MemberVO getMemberInfo(String id){
		
		MemberVO user = null;
		
		String sql = "SELECT * FROM member WHERE userId=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //
				user = new MemberVO();
				user.setUserName(rs.getString("userName"));
				user.setUserId(rs.getString("userId"));
				user.setUserPw(rs.getString("userPw"));
				user.setUserEmail(rs.getString("userEmail"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return user;
		
	}

}
