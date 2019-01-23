package kogile.module;

import java.io.Serializable;

public class ExterMember implements Serializable{
	private int exter_m_no,
				interlinked_info; //userId
	
	private String exter_mem_name,
				   exter_m_email;
	
	public enum interlinked_type {KAKAO, GOOGLE, NAVER};
	private interlinked_type interlinked_type;
	
	public int getExter_m_no() {
		return exter_m_no;
	}
	public String getExter_mem_name() {
		return exter_mem_name;
	}
	public String getExter_m_email() {
		return exter_m_email;
	}
	public String getType() {
		return interlinked_type.toString();
	}
	public void setExter_m_no(int exter_m_no) {
		this.exter_m_no = exter_m_no;
	}
	public void setExter_mem_name(String exter_mem_name) {
		this.exter_mem_name = exter_mem_name;
	}
	public void setExter_m_email(String exter_m_email) {
		this.exter_m_email = exter_m_email;
	}
	public void setType(interlinked_type interlinked_type) {
		this.interlinked_type = interlinked_type;
	}
	public int getInterlinked_info() {
		return interlinked_info;
	}
	public void setInterlinked_info(int interlinked_info) {
		this.interlinked_info = interlinked_info;
	}
	
	
}
