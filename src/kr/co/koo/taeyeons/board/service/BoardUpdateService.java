package kr.co.koo.taeyeons.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koo.taeyeons.board.model.BoardDAO;
import kr.co.koo.taeyeons.board.model.BoardVO;

public class BoardUpdateService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bId = request.getParameter("bId");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateArticle(bTitle, bContent, bId);
		
	}

}
