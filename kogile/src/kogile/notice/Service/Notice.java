package kogile.notice.Service;

public class Notice {
	private int no;
	private String contents;
	private String day;
	private int inv_no;
	
	public Notice(){}

	public Notice(int no, String contents, String day, int inv_no) {
		super();
		this.no = no;
		this.contents = contents;
		this.day = day;
		this.inv_no = inv_no;
	}

	@Override
	public String toString() {
		return "Notice [no=" + no + ", contents=" + contents + ", day=" + day + ", inv_no=" + inv_no + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getInv_no() {
		return inv_no;
	}

	public void setInv_no(int inv_no) {
		this.inv_no = inv_no;
	}

	
}
