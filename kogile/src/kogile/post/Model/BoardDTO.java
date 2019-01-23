package kogile.post.Model;

import java.io.Serializable;

public class BoardDTO implements Serializable {

	private int checklist_no;
	private String check_title;
	private int p_no;
	
	private int list_no;
	private String list_info;
	private int checked;
	
	
	public BoardDTO() {
		super();
	}


	public BoardDTO(int checklist_no, String check_title, int p_no, int list_no, String list_info, int checked) {
		super();
		this.checklist_no = checklist_no;
		this.check_title = check_title;
		this.p_no = p_no;
		this.list_no = list_no;
		this.list_info = list_info;
		this.checked = checked;
	}


	public int getChecklist_no() {
		return checklist_no;
	}


	public void setChecklist_no(int checklist_no) {
		this.checklist_no = checklist_no;
	}


	public String getCheck_title() {
		return check_title;
	}


	public void setCheck_title(String check_title) {
		this.check_title = check_title;
	}


	public int getP_no() {
		return p_no;
	}


	public void setP_no(int p_no) {
		this.p_no = p_no;
	}


	public int getList_no() {
		return list_no;
	}


	public void setList_no(int list_no) {
		this.list_no = list_no;
	}


	public String getList_info() {
		return list_info;
	}


	public void setList_info(String list_info) {
		this.list_info = list_info;
	}


	public int getChecked() {
		return checked;
	}


	public void setChecked(int checked) {
		this.checked = checked;
	}


	@Override
	public String toString() {
		return "Board [checklist_no=" + checklist_no + ", check_title=" + check_title + ", p_no=" + p_no + ", list_no="
				+ list_no + ", list_info=" + list_info + ", checked=" + checked + "]";
	}

	
}
