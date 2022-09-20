package kr.co.koo.taeyeons.board.service;

// java파일은 jsp파일과 달리 request객체를 내장객체로 가지고 있지 않아 HttpServletRequest/Response 객체
// 로 가져와야 함
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// BoardService 객체는 인터페이스
// 인터페이스를 구현하는 클래스는 인터페이스의 메서드를 반드시 구현해야 한다.
public interface BoardService {
	
	void execute(HttpServletRequest request, HttpServletResponse response);

}
