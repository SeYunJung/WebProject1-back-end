package kr.co.koo.taeyeons.board.model;

import java.util.*;

public class BoardVO {
	
	//board_id, board_name, board_title, board_content, board_date, board_hit
		//VO클래스
		
		private int board_id;
		private String board_writer; 
		private String board_title;
		private String board_content;
		private Date board_date;
		private int board_hit;
		
		public BoardVO() {}
		
		public BoardVO(int board_id, String board_writer, String board_title, String board_content, Date board_date,
				int board_hit) {
			super();
			this.board_id = board_id;
			this.board_writer = board_writer;
			this.board_title = board_title;
			this.board_content = board_content;
			this.board_date = board_date;
			this.board_hit = board_hit;
		}



		public int getBoard_id() {
			return board_id;
		}

		public void setBoard_id(int board_id) {
			this.board_id = board_id;
		}

		public String getBoard_writer() {
			return board_writer;
		}

		public void setBoard_writer(String board_writer) {
			this.board_writer = board_writer;
		}

		public String getBoard_title() {
			return board_title;
		}

		public void setBoard_title(String board_title) {
			this.board_title = board_title;
		}

		public String getBoard_content() {
			return board_content;
		}

		public void setBoard_content(String board_content) {
			this.board_content = board_content;
		}

		public Date getBoard_date() {
			return board_date;
		}

		public void setBoard_date(Date board_date) {
			this.board_date = board_date;
		}

		public int getBoard_hit() {
			return board_hit;
		}

		public void setBoard_hit(int board_hit) {
			this.board_hit = board_hit;
		}

}
