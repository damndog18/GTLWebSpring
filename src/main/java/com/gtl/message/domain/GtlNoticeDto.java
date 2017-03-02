package com.gtl.message.domain;

public class GtlNoticeDto {
	
	private int board_notice_no;
	private int board_notice_counter;
	private int board_notice_pos;
	private int board_notice_depth;
	
	private String sawon_id;
	private String board_notice_title;
	private String board_notice_note;
	private String board_notice_input_time;
	private String board_notice_update_time;
	
	public String getBoard_notice_input_time() {
		return board_notice_input_time;
	}
	public String getBoard_notice_update_time() {
		return board_notice_update_time;
	}
	public int getBoard_notice_no() {
		return board_notice_no;
	}
	public void setBoard_notice_no(int board_notice_no) {
		this.board_notice_no = board_notice_no;
	}
	public int getBoard_notice_counter() {
		return board_notice_counter;
	}
	public void setBoard_notice_counter(int board_notice_counter) {
		this.board_notice_counter = board_notice_counter;
	}
	public int getBoard_notice_pos() {
		return board_notice_pos;
	}
	public void setBoard_notice_pos(int board_notice_pos) {
		this.board_notice_pos = board_notice_pos;
	}
	public int getBoard_notice_depth() {
		return board_notice_depth;
	}
	public void setBoard_notice_depth(int board_notice_depth) {
		this.board_notice_depth = board_notice_depth;
	}
	public String getSawon_id() {
		return sawon_id;
	}
	public void setSawon_id(String sawon_id) {
		this.sawon_id = sawon_id;
	}
	public String getBoard_notice_title() {
		return board_notice_title;
	}
	public void setBoard_notice_title(String board_notice_title) {
		this.board_notice_title = board_notice_title;
	}
	public String getBoard_notice_note() {
		return board_notice_note;
	}
	public void setBoard_notice_note(String board_notice_note) {
		this.board_notice_note = board_notice_note;
	}	
}
