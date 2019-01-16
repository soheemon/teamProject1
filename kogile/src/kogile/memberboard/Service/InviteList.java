package kogile.memberboard.Service;

public class InviteList {

	private int no;
	private String name;
	private String mail;
	private String grade;

	
	public InviteList(){}


	public InviteList(int no, String name, String mail, String grade) {
		super();
		this.no = no;
		this.name = name;
		this.mail = mail;
		this.grade = grade;
	}


	@Override
	public String toString() {
		return "InviteList [no=" + no + ", name=" + name + ", mail=" + mail + ", grade=" + grade + "]";
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

	
	
	
}
