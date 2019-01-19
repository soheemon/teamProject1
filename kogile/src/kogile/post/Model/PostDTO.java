package kogile.post.Model;

import java.io.Serializable;

public class PostDTO implements Serializable{
	
	// 포스트 넘버
	private int p_no;
	// 포스트 제목
	private String p_title;
	// 포스트 위치
	private int p_position;
	// 카드 넘버
	private int c_no;
	// 마감일 날짜
	private String d_date;
	
	public PostDTO() {}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public int getP_position() {
		return p_position;
	}

	public void setP_position(int p_position) {
		this.p_position = p_position;
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getD_date() {
		return d_date;
	}

	public void setD_date(String d_date) {
		this.d_date = d_date;
	}

	public PostDTO(int p_no, String p_title, int p_position, int c_no, String d_date) {
		super();
		this.p_no = p_no;
		this.p_title = p_title;
		this.p_position = p_position;
		this.c_no = c_no;
		this.d_date = d_date;
	}

	@Override
	public String toString() {
		return "PostDTO [p_no=" + p_no + ", p_title=" + p_title + ", p_position=" + p_position + ", c_no=" + c_no
				+ ", d_date=" + d_date + "]";
	}
	
	
	
	
	
}