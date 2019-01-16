package kogile.Module;

import java.io.Serializable;

public class ReplyUpdateSearch implements Serializable{
	private int search_r_no;
	private int search_info_no;
	
	public ReplyUpdateSearch() {}

	public ReplyUpdateSearch(int search_r_no, int search_info_no) {
		super();
		this.search_r_no = search_r_no;
		this.search_info_no = search_info_no;
	}

	public int getSearch_r_no() {
		return search_r_no;
	}

	public void setSearch_r_no(int search_r_no) {
		this.search_r_no = search_r_no;
	}

	public int getSearch_info_no() {
		return search_info_no;
	}

	public void setSearch_info_no(int search_info_no) {
		this.search_info_no = search_info_no;
	}
	
}