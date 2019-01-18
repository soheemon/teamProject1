package kogile.notice.Service;

public class Notice {
	private String giveMan;
	private String takeMan;
	private String contents;
	private String day;
	
	public Notice(){}

	
	
	@Override
	public String toString() {
		return "Notice [giveMan=" + giveMan + ", takeMan=" + takeMan + ", contents=" + contents + ", day=" + day + "]";
	}



	public Notice(String giveMan, String takeMan, String contents, String day) {
		super();
		this.giveMan = giveMan;
		this.takeMan = takeMan;
		this.contents = contents;
		this.day = day;
	}



	public String getGiveMan() {
		return giveMan;
	}

	public void setGiveMan(String giveMan) {
		this.giveMan = giveMan;
	}

	public String getTakeMan() {
		return takeMan;
	}

	public void setTakeMan(String takeMan) {
		this.takeMan = takeMan;
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
	
	
	
}
