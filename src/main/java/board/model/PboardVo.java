package board.model;

public class PboardVo {
	private Integer pboard_seq;
	private String pboard_name;
	private String pboard_reg_id;
	private String pboard_date;
	private String pboard_del;
	
	public PboardVo() {
		// TODO Auto-generated constructor stub
	}
	
	public PboardVo(String pboard_name, String pboard_reg_id, String pboard_del) {
		super();
		this.pboard_name = pboard_name;
		this.pboard_reg_id = pboard_reg_id;
		this.pboard_del = pboard_del;
	}

	public Integer getPboard_seq() {
		return pboard_seq;
	}
	public void setPboard_seq(Integer pboard_seq) {
		this.pboard_seq = pboard_seq;
	}
	public String getPboard_name() {
		return pboard_name;
	}
	public void setPboard_name(String pboard_name) {
		this.pboard_name = pboard_name;
	}
	public String getPboard_reg_id() {
		return pboard_reg_id;
	}
	public void setPboard_reg_id(String pboard_reg_id) {
		this.pboard_reg_id = pboard_reg_id;
	}
	public String getPboard_date() {
		return pboard_date;
	}
	public void setPboard_date(String pboard_date) {
		this.pboard_date = pboard_date;
	}
	public String getPboard_del() {
		return pboard_del;
	}
	public void setPboard_del(String pboard_del) {
		this.pboard_del = pboard_del;
	}
	
}
