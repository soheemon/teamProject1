package kogile.memberboard.Service;

public class MemberBoard {
	private int no;
	private String name;
	private String mail;
	private String interNum;
	
	public MemberBoard(){}

	public MemberBoard(int no, String name, String mail, String interNum) {
		super();
		this.no = no;
		this.name = name;
		this.mail = mail;
		this.interNum = interNum;
	}

	@Override
	public String toString() {
		return "MemberBoard [no=" + no + ", name=" + name + ", mail=" + mail + ", interNum=" + interNum + "]";
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

	public String getInterNum() {
		return interNum;
	}

	public void setInterNum(String interNum) {
		this.interNum = interNum;
	}

}
