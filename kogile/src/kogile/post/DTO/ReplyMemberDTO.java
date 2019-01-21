package kogile.post.DTO;

import java.io.Serializable;

public class ReplyMemberDTO implements Serializable {
	private int r_no;
	private String r_contents;
	private String r_date;
	private int p_no;
	private int info_no;
	private String name;
	
	public ReplyMemberDTO() {}

	public ReplyMemberDTO(int r_no, String r_contents, String r_date, int p_no, int info_no, String name) {
		super();
		this.r_no = r_no;
		this.r_contents = r_contents;
		this.r_date = r_date;
		this.p_no = p_no;
		this.info_no = info_no;
		this.name = name;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public String getR_contents() {
		return r_contents;
	}

	public void setR_contents(String r_contents) {
		this.r_contents = r_contents;
	}

	public String getR_date() {
		return r_date;
	}

	public void setR_date(String r_date) {
		this.r_date = r_date;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public int getInfo_no() {
		return info_no;
	}

	public void setInfo_no(int info_no) {
		this.info_no = info_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}
