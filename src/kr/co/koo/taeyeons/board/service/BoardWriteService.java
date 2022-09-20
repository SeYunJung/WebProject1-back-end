package kr.co.koo.taeyeons.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koo.taeyeons.board.model.BoardDAO;

public class BoardWriteService implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		//DAO를 통해 DB로직 처리~
		dao.write(bName, bTitle, bContent);
		
	}

}
