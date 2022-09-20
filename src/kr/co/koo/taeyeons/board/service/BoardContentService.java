package kr.co.koo.taeyeons.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koo.taeyeons.board.model.BoardDAO;
import kr.co.koo.taeyeons.board.model.BoardVO;

public class BoardContentService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		String bId = request.getParameter("bId");
		//dao메서드를 통해 선택된 게시물 정보를 select해서 리턴받으세요.
		BoardVO board = dao.getBoardContent(bId);
		//request객체에 조회된 게시글 정보를 저장하세요. EL변수: "contents"라는 이름으로 쓸 수 있게. 
		request.setAttribute("contents", board);//EL 내부에서 contents로 VO를 사용할 수 있음.
		System.out.println("contents 생성");
		
	}

}
