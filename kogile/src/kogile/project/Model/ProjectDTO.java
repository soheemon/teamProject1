package kogile.project.Model;

import java.io.Serializable;

public class ProjectDTO implements Serializable{
	int pjt_no;
	String pjt_date;
	String pjt_title;
	int total_m_no;
	String pjt_contents;
	
	public ProjectDTO() {}
	
	

	public ProjectDTO(int pjt_no, String pjt_date, String pjt_title, int total_m_no, String pjt_contents) {
		super();
		this.pjt_no = pjt_no;
		this.pjt_date = pjt_date;
		this.pjt_title = pjt_title;
		this.total_m_no = total_m_no;
		this.pjt_contents = pjt_contents;
	}



	public int getPjt_no() {
		return pjt_no;
	}

	public void setPjt_no(int pjt_no) {
		this.pjt_no = pjt_no;
	}

	public String getPjt_date() {
		return pjt_date;
	}

	public void setPjt_date(String pjt_date) {
		this.pjt_date = pjt_date;
	}

	public String getPjt_title() {
		return pjt_title;
	}

	public void setPjt_title(String pjt_title) {
		this.pjt_title = pjt_title;
	}

	
	
	public int getTotal_m_no() {
		return total_m_no;
	}

	public void setTotal_m_no(int total_m_no) {
		this.total_m_no = total_m_no;
	}

	public String getPjt_contents() {
		return pjt_contents;
	}

	public void setPjt_contents(String pjt_contents) {
		this.pjt_contents = pjt_contents;
	}

	@Override
	public String toString() {
		return "ProjectBoard [pjt_no=" + pjt_no + ", pjt_date=" + pjt_date + ", pjt_title=" + pjt_title
				+ ", pjt_writer=" + total_m_no + ", pjt_contents=" + pjt_contents + "]";
	}


	
	
}
