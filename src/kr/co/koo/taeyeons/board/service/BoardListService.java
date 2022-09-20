package kr.co.koo.taeyeons.board.service;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koo.taeyeons.board.model.BoardDAO;
import kr.co.koo.taeyeons.board.model.BoardVO;

// BoardListService 객체에서 사용할 변수들
/*
	req_page						request객체의 page속성 값을 저장할 변수
	
	currentPageNumber				현재 위치한 페이지번호
	messageTotalCount				총 게시글 수
	List<BoardVO> messageList		DB로부터 전달받은 게시글 목록
	pageTotalCount					총 페이지 수
	messageCountPerPage				한 페이지당 들어갈 게시글 수
	firstRow						첫행
	endRow							마지막 행	
 */

public class BoardListService implements BoardService {
	
	// 한 페이지당 들어갈 게시글 수
	private static final int MESSAGE_COUNT_PER_PAGE = 5;

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String req_page = request.getParameter("page");
		int currnetPageNumber = 1; // 첫 요청시 현재 위치한 페이지번호는 1 (page속성 값에는 null값이 저장)
		
		if(req_page != null) { // page속성 값이 존재한다면 (다른 페이지 번호를 눌렀다면)
			currnetPageNumber = Integer.parseInt(req_page); // 현재 위치한 페이지번호 변경
		}
		
		// 페이지 처리 서비스(BoardPageService)로 currentPageNumber(현재 페이지 번호)의 게시물 객체(페이징 객체)를 가져온다 
		BoardPageService articles = getBoardArticle(currnetPageNumber);
		request.setAttribute("articles", articles); // 페이지 정보 객체(articles)를 request객체에 저장
	}
	
	// 페이징 객체(BoardPageService) 생성
	private BoardPageService getBoardArticle(int currentPageNumber) {
		BoardPageService articles = null; // 페이징 객체
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int messageTotalCount = dao.selectCount(); // 총 게시글 수
		int firstRow = 0; 
		int endRow = 0;
		
		List<BoardVO> articleList = null; // BoardVO(게시글 하나)를 담을 List객체 선언
		
		if(messageTotalCount > 0) { // 총 게시글 수가 0보다 크다면
			firstRow = (currentPageNumber -1) * MESSAGE_COUNT_PER_PAGE + 1; // 현재 페이지의 첫행 번호
			endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1; // 현재 페이지의 마지막 행번호
			articleList = dao.getBoardArticles(firstRow, endRow); // firstRow행부터 endRow행까지 게시글을 가져와 articleList객체에 대입
		} else { // 총 게시글 수가 없다면 (게시글이 없다면)
			currentPageNumber = 0;
		}
		
		// BoardPageService객체에 지금까지 받은 페이지 정보를 전달해 객체를 초기화
		articles = new BoardPageService(messageTotalCount, 
				currentPageNumber,
				articleList,
				MESSAGE_COUNT_PER_PAGE,
				firstRow,
				endRow);
		
		return articles; // 페이지 정보 객체
		
		/*
		    articleList : 한 페이지의 게시글에 대한 객체
			BoardPageService : 페이지 정보 객체 (i번 게시글부터 j번 게시글까지의 정보 객체)
		 */
		
	}

}
