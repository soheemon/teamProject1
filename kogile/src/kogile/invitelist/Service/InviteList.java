package kogile.invitelist.Service;

public class InviteList {

	private int no;
	private String name;
	private String mail;
	private String grade;
	private int pjt_no;
	private int inv_no;

	public InviteList(){}

	public InviteList(int no, String name, String mail, String grade, int pjt_no, int inv_no) {
		super();
		this.no = no;
		this.name = name;
		this.mail = mail;
		this.grade = grade;
		this.pjt_no = pjt_no;
		this.inv_no = inv_no;
	}

	@Override
	public String toString() {
		return "InviteList [no=" + no + ", name=" + name + ", mail=" + mail + ", grade=" + grade + ", pjt_no=" + pjt_no
				+ ", inv_no=" + inv_no + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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

	public int getInv_no() {
		return inv_no;
	}

	public void setInv_no(int inv_no) {
		this.inv_no = inv_no;
	}
	
	

	
}
