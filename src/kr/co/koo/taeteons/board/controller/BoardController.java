package kr.co.koo.taeteons.board.controller;

import java.util.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koo.taeyeons.board.service.BoardContentService;
import kr.co.koo.taeyeons.board.service.BoardDeleteService;
import kr.co.koo.taeyeons.board.service.BoardUpdateService;
import kr.co.koo.taeyeons.board.service.BoardWriteService;
import kr.co.koo.taeyeons.board.service.BoardListService;
import kr.co.koo.taeyeons.board.service.BoardService;

// URL 매핑
@WebServlet("*.taeyeon")

// 모든 요청, 응답을 총괄적으로 관리해주는 클래스 
public class BoardController extends HttpServlet {
	
	public BoardController() {
		super();
	}
	
	// get요청이 들어오면 실행되는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get요청 발생!! doGet메서드가 호출");
		doRequest(request, response); // doRequest메서드로 요청 위임
	}
	
	// post요청이 들어오면 실행되는 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post요청 발생!! doPost메서드가 호출");
		doRequest(request, response); // doRequest메서드로 요청 위임
	}
	
	// throws ServeltException, IOException은 예외처리는 서블릿 컨테이너(톰캣?)에게 전달하는 구문 
	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("요청이 위임되었습니다. doRequest메서드가 호출");
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI(); // request객체에 실린 URI를 가져온다 (어떤 주소인지 확인하기 위함)
		//System.out.println("uri : " + uri); // OK 
		
		String viewPage = null; // Controller가 안내해줄 UI페이지의 경로정보를 담을 변수
		
		BoardService boardservice = null; // 서비스(리스트, 페이징 처리 등)를 처리해줄 인터페이스 선언
		
		if(uri.equals("/WebProject/menu/Blist.taeyeon")) { // 게시판을 클릭했다면
			boardservice = new BoardListService(); // 게시판 서비스(BoardListService) 객체를 가져와서
			boardservice.execute(request, response); // 게시판 서비스 처리 로직 실행
			viewPage = "/menu/board.jsp";
		} 
		else if(uri.equals("/WebProject/menu/BWriteView.taeyeon")) {
			viewPage = "/menu/board-write.jsp";
		} 
		else if(uri.equals("/WebProject/menu/BWrite.taeyeon")) {
			boardservice = new BoardWriteService();
			boardservice.execute(request, response);
			viewPage = "/menu/Blist.taeyeon";//글쓰기가 완료되면 글 목록으로 돌아감. list로 안내. 
		} 
		else if(uri.equals("/WebProject/menu/BContent.taeyeon")) {
			boardservice = new BoardContentService();
			boardservice.execute(request, response);
			viewPage = "/menu/board_content_view.jsp";
		} 
		else if(uri.equals("/WebProject/menu/BUpdateView.taeyeon")) {
			boardservice = new BoardContentService();
			boardservice.execute(request, response);
			viewPage = "/menu/board_update_view.jsp";
		} 
		else if(uri.equals("/WebProject/menu/BUpdate.taeyeon")) {
			boardservice = new BoardUpdateService();
			boardservice.execute(request, response);
			viewPage = "/menu/Blist.taeyeon";
		}
		else if(uri.equals("/WebProject/menu/BDelete.taeyeon")) {
			boardservice = new BoardDeleteService();
			boardservice.execute(request, response);
			viewPage = "/menu/Blist.taeyeon";
		} 
//		System.out.println("if문 통과"); // OK
		
		// 페이지 강제이동 메서드: forward 
		// => jsp action tag: <jsp:forward page=""> 
		// viewPage로 강제 이동
		RequestDispatcher dp = request.getRequestDispatcher(viewPage);
		dp.forward(request, response);
		
	}

}
