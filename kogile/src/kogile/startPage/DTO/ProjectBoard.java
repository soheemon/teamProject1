package kogile.startPage.DTO;

import java.io.Serializable;

public class ProjectBoard implements Serializable{
	int pjt_no;
	String pjt_date;
	String pjt_title;
	String pjt_writer;
	String pjt_contents;
	
	public ProjectBoard() {}

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

	public String getPjt_writer() {
		return pjt_writer;
	}

	public void setPjt_writer(String pjt_writer) {
		this.pjt_writer = pjt_writer;
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
				+ ", pjt_writer=" + pjt_writer + ", pjt_contents=" + pjt_contents + "]";
	}


	
	
}
