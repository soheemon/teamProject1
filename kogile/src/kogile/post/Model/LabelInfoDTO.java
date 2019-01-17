package kogile.post.Model;

import java.io.Serializable;

public class LabelInfoDTO implements Serializable{
	
	private int label_info_no;
	private int label_no;
	private int p_no;
	
	public LabelInfoDTO() {}

	public LabelInfoDTO(int label_info_no, int label_no, int p_no) {
		super();
		this.label_info_no = label_info_no;
		this.label_no = label_no;
		this.p_no = p_no;
	}

	public int getLabel_info_no() {
		return label_info_no;
	}

	public void setLabel_info_no(int label_info_no) {
		this.label_info_no = label_info_no;
	}

	public int getLabel_no() {
		return label_no;
	}

	public void setLabel_no(int label_no) {
		this.label_no = label_no;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	@Override
	public String toString() {
		return "LabelInfoDTO [label_info_no=" + label_info_no + ", label_no=" + label_no + ", p_no=" + p_no + "]";
	}
	
	

}
