package kogile.post.DTO;

import java.io.Serializable;

public class TagDTO implements Serializable{
	private int tag_no;
	private int r_no;
	private int info_no;
	private String name;
	private int invite_no;
	private int pjt_no;
	private int total_m_no;
	
	public TagDTO() {}

	public TagDTO(int tag_no, int r_no, int info_no, String name, int invite_no, int pjt_no, int total_m_no) {
		super();
		this.tag_no = tag_no;
		this.r_no = r_no;
		this.info_no = info_no;
		this.name = name;
		this.invite_no = invite_no;
		this.pjt_no = pjt_no;
		this.total_m_no = total_m_no;
	}

	public int getTag_no() {
		return tag_no;
	}

	public void setTag_no(int tag_no) {
		this.tag_no = tag_no;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
	}

	public int getInfo_no() {
		return info_no;
	}

	public void setInfo_no(int info_no) {
		this.info_no = info_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInvite_no() {
		return invite_no;
	}

	public void setInvite_no(int invite_no) {
		this.invite_no = invite_no;
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
