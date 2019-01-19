package kogile.post.Model;

import java.io.Serializable;

public class CardDTO implements Serializable{
	
	private int c_no;
	private String c_title;
	private int c_position;
	private int pjt_no;
	
	public CardDTO() {}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public String getC_title() {
		return c_title;
	}

	public void setC_title(String c_title) {
		this.c_title = c_title;
	}

	public int getC_position() {
		return c_position;
	}

	public void setC_position(int c_position) {
		this.c_position = c_position;
	}

	public int getPjt_no() {
		return pjt_no;
	}

	public void setPjt_no(int pjt_no) {
		this.pjt_no = pjt_no;
	}

	public CardDTO(int c_no, String c_title, int c_position, int pjt_no) {
		super();
		this.c_no = c_no;
		this.c_title = c_title;
		this.c_position = c_position;
		this.pjt_no = pjt_no;
	}

	@Override
	public String toString() {
		return "CardDTO [c_no=" + c_no + ", c_title=" + c_title + ", c_position=" + c_position + ", pjt_no=" + pjt_no
				+ "]";
	}

	
	
}