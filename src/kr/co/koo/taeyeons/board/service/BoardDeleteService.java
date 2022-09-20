package kr.co.koo.taeyeons.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koo.taeyeons.board.model.BoardDAO;

public class BoardDeleteService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String bId = request.getParameter("bId");
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteArticle(bId);
		
	}

}
