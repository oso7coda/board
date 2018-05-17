package board.model;

import java.util.Date;

public class BoardVo {
	private Integer board_seq;
	private Integer pboard_seq;
	private Integer board_pseq;
	private String board_title;
	private String board_content;
	private String board_reg_id;
	private Date board_reg_dt;
	private String board_del;
	private Integer board_reply;
	private Integer board_hit;
	private Integer board_group;
	public Integer getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(Integer board_seq) {
		this.board_seq = board_seq;
	}
	public Integer getPboard_seq() {
		return pboard_seq;
	}
	public void setPboard_seq(Integer pboard_seq) {
		this.pboard_seq = pboard_seq;
	}
	public Integer getBoard_pseq() {
		return board_pseq;
	}
	public void setBoard_pseq(Integer board_pseq) {
		this.board_pseq = board_pseq;
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
	public String getBoard_reg_id() {
		return board_reg_id;
	}
	public void setBoard_reg_id(String board_reg_id) {
		this.board_reg_id = board_reg_id;
	}
	public Date getBoard_reg_dt() {
		return board_reg_dt;
	}
	public void setBoard_reg_dt(Date board_reg_dt) {
		this.board_reg_dt = board_reg_dt;
	}
	public String getBoard_del() {
		return board_del;
	}
	public void setBoard_del(String board_del) {
		this.board_del = board_del;
	}
	public Integer getBoard_reply() {
		return board_reply;
	}
	public void setBoard_reply(Integer board_reply) {
		this.board_reply = board_reply;
	}
	public Integer getBoard_hit() {
		return board_hit;
	}
	public void setBoard_hit(Integer board_hit) {
		this.board_hit = board_hit;
	}
	public Integer getBoard_group() {
		return board_group;
	}
	public void setBoard_group(Integer board_group) {
		this.board_group = board_group;
	}
public BoardVo() {
	// TODO Auto-generated constructor stub
}
}
