package kr.co.koo.taeyeons.member.model;

import java.sql.*;

public class MemberVO {
	
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private Timestamp userRegDate;
	
	public MemberVO() {}
	
	public MemberVO(String userId, String userPw, String userName, String userEmail, Timestamp userRegDate) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userRegDate = userRegDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Timestamp getUserRegDate() {
		return userRegDate;
	}

	public void setUserRegDate(Timestamp userRegDate) {
		this.userRegDate = userRegDate;
	}
	
	

}
