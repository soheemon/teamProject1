package kogile.module;

import java.io.Serializable;

public class IsInterMem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String exter_m_no, member_no;

	public String getExter_m_no() {
		return exter_m_no;
	}

	public String getMember_no() {
		return member_no;
	}

	public void setExter_m_no(String exter_m_no) {
		this.exter_m_no = exter_m_no;
	}

	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}

	public IsInterMem() {
	}
	
	
}
