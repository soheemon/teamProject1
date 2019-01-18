package kogile.post.Model;

import java.io.Serializable;

public class DdateDTO implements Serializable {

	private int d_day_no;
	private String d_date;
	private int p_no;
	
	public DdateDTO() {}
	
	
	
	public DdateDTO(int d_day_no, String d_date, int p_no) {
		super();
		this.d_day_no = d_day_no;
		this.d_date = d_date;
		this.p_no = p_no;
	}



	public int getD_day_no() {
		return d_day_no;
	}
	public void setD_day_no(int d_day_no) {
		this.d_day_no = d_day_no;
	}
	public String getD_date() {
		return d_date;
	}
	public void setD_date(String d_date) {
		this.d_date = d_date;
	}
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}


	@Override
	public String toString() {
		return "DdateDTO [d_day_no=" + d_day_no + ", d_date=" + d_date + ", p_no=" + p_no + "]";
	}
	
	
}
