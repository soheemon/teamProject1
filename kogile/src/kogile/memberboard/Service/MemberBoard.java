package kogile.memberboard.Service;

public class MemberBoard {
	private int no;
	private String name;
	private String mail;
	private String interNum;
	private int pjt_no;
	private int inv_no;
	
	public MemberBoard(){}

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

	@Override
	public String toString() {
		return "MemberBoard [no=" + no + ", name=" + name + ", mail=" + mail + ", interNum=" + interNum + ", pjt_no="
				+ pjt_no + ", inv_no=" + inv_no + "]";
	}

	public MemberBoard(int no, String name, String mail, String interNum, int pjt_no, int inv_no) {
		super();
		this.no = no;
		this.name = name;
		this.mail = mail;
		this.interNum = interNum;
		this.pjt_no = pjt_no;
		this.inv_no = inv_no;
	}

	
}
