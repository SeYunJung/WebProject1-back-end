package kr.co.koo.taeyeons.board.service;

import java.util.*;

import kr.co.koo.taeyeons.board.model.BoardVO;

public class BoardPageService {
	
	private int messageTotalCount; 		// 총 게시글 수 
	private int currentPageNumber;		// 현재 위치한 페이지번호
	private List<BoardVO> messageList;	// DB로부터 전달받은 게시글 목록
	private int pageTotalCount;			// 총 페이지 수
	private int messageCountPerPage;	// 한 페이지당 들어갈 게시물 수
	private int firstRow;				// 첫 행
	private int endRow;					// 마지막 행
	
	public BoardPageService(int messageTotalCount, int currentPageNumber, List<BoardVO> messageList,
			int messageCountPerPage, int firstRow, int endRow) {
		super();
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageList = messageList;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = firstRow;
		this.endRow = endRow;
		
		calculatePageTotalCount();
	}
	
	// 총 페이지 수 계산 메서드
	private void calculatePageTotalCount() {
		if(messageTotalCount == 0) { // 게시글이 없다면
			pageTotalCount = 0; // 총 페이지 수는 0
		} else {
			pageTotalCount = messageTotalCount / messageCountPerPage; // 총 페이지수 = 총 게시글 수 / 페이지당 들어간 게시글 수
			if(messageTotalCount % messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}
	}

	public int getMessageTotalCount() {
		return messageTotalCount;
	}

	public void setMessageTotalCount(int messageTotalCount) {
		this.messageTotalCount = messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

	public List<BoardVO> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<BoardVO> messageList) {
		this.messageList = messageList;
	}

	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}
	
	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setMessageCountPerPage(int messageCountPerPage) {
		this.messageCountPerPage = messageCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	

}
