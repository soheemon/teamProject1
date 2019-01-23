package kogile.post.DTO;

import java.io.Serializable;

public class DescriptionDTO implements Serializable {
	private int d_no;
	private String d_contents;
	private int p_no;
	
	public DescriptionDTO () {}

	public DescriptionDTO(int d_no, String d_contents, int p_no) {
		super();
		this.d_no = d_no;
		this.d_contents = d_contents;
		this.p_no = p_no;
	}

	public int getD_no() {
		return d_no;
	}

	public void setD_no(int d_no) {
		this.d_no = d_no;
	}

	public String getD_contents() {
		return d_contents;
	}

	public void setD_contents(String d_contents) {
		this.d_contents = d_contents;
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	
	
}
