package kogile.project.Model;

import java.io.Serializable;

public class InviteDTO implements Serializable {
	int invite_no;
	String grade;
	int pjt_no;
	int total_m_no;
	
	public InviteDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public InviteDTO(int invite_no, String grade, int pjt_no, int total_m_no) {
		super();
		this.invite_no = invite_no;
		this.grade = grade;
		this.pjt_no = pjt_no;
		this.total_m_no = total_m_no;
	}

	public int getInvite_no() {
		return invite_no;
	}

	public void setInvite_no(int invite_no) {
		this.invite_no = invite_no;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPjt_no() {
		return pjt_no;
	}

	public void setPjt_no(int pjt_no) {
		this.pjt_no = pjt_no;
	}

	public int getTotal_m_no() {
		return total_m_no;
	}

	public void setTotal_m_no(int total_m_no) {
		this.total_m_no = total_m_no;
	}
	
	
	

}
