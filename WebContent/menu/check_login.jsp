<%@page import="kr.co.koo.taeyeons.member.model.MemberVO"%>
<%@page import="kr.co.koo.taeyeons.member.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- signin.jsp의 form태그에서 받은 로그인 정보를 처리하는 페이지 --%>
<%

	// 요청 파라미터 처리
	String id = (String)request.getParameter("userId");
	String pw = (String)request.getParameter("userPw");
	String btn = (String)request.getParameter("signup-btn");
	
	// MemberDAO 객체로 DB처리
	MemberDAO dao = MemberDAO.getInstance();
	int rn = dao.userCheck(id, pw); // form태그로부터 받은 로그인 정보가 DB에 저장된 정보인지 userCheck메서드로 확인
	String str = "";
	
	// DB처리 결과(rn값에 따라)에 따라 로그인 여부 결정
	if(rn == MemberDAO.LOGIN_SUCCESS){ // id, pw가 일치한다면
		
		MemberVO user = dao.getMemberInfo(id); // id(primary key)값으로 자바빈 객체를 가져오고
		session.setAttribute("userId", id); // user_id라는 이름으로 세션 생성 (회원임을 증명하기 위함)
		session.setAttribute("userName", user.getUserName()); // user_name라는 이름으로 세션 생성
		response.sendRedirect("/WebProject"); // 홈으로 이동시키기.
%>		
<%	} else if(rn == MemberDAO.LOGIN_FAIL_PW){ // pw가 불일치하다면%>     
		<script>
			alert("패스워드 불일치");
			history.back();
		</script>
 
<%	} else { // id가 불일치하다면%> 

		<script>
			alert("아이디 불일치");
			history.back();
		</script>
<% 	} %>

