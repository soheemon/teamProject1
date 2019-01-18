package kogile.post.Model;

import java.io.Serializable;

public class PostMemberDTO implements Serializable {

	private int p_no;
	private int info_no;
	private int total_m_no;
	private String name;
	
	
	public PostMemberDTO() {}
	
	
	public PostMemberDTO(int p_no, int info_no, int total_m_no, String name) {
		super();
		this.p_no = p_no;
		this.info_no = info_no;
		this.total_m_no = total_m_no;
		this.name = name;
	}

	
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public int getInfo_no() {
		return info_no;
	}
	public void setInfo_no(int info_no) {
		this.info_no = info_no;
	}
	public int getTotal_m_no() {
		return total_m_no;
	}
	public void setTotal_m_no(int total_m_no) {
		this.total_m_no = total_m_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "PostMemberDTO [p_no=" + p_no + ", info_no=" + info_no + ", total_m_no=" + total_m_no + ", name=" + name
				+ "]";
	}
	
	
	}
	
