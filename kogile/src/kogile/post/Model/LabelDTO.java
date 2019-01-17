package kogile.post.Model;

import java.io.Serializable;

public class LabelDTO implements Serializable {
	private int label_no;
	private String label_text;
	private int color_no;
//	private int p_no;
	private int pjt_no;
	
	public LabelDTO() {}

	public LabelDTO(int label_no, String label_text, int color_no, int pjt_no) {
		super();
		this.label_no = label_no;
		this.label_text = label_text;
		this.color_no = color_no;
//		this.p_no = p_no;
		this.pjt_no = pjt_no;
	}

	public int getLabel_no() {
		return label_no;
	}

	public void setLabel_no(int label_no) {
		this.label_no = label_no;
	}

	public String getLabel_text() {
		return label_text;
	}

	public void setLabel_text(String label_text) {
		this.label_text = label_text;
	}

	public int getColor_no() {
		return color_no;
	}

	public void setColor_no(int color_no) {
		this.color_no = color_no;
	}

//	public int getP_no() {
//		return p_no;
//	}
//
//	public void setP_no(int p_no) {
//		this.p_no = p_no;
//	}
//	

	public int getPjt_no() {
		return pjt_no;
	}

	public void setPjt_no(int pjt_no) {
		this.pjt_no = pjt_no;
	}

	@Override
	public String toString() {
		return "LabelDTO [label_no=" + label_no + ", label_text=" + label_text + ", color_no=" + color_no + ", pjt_no="
				+ pjt_no + "]";
	}
	
	


}
