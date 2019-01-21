package kogile.module;

import java.io.Serializable;

public class TotalMemInfo implements Serializable {
	private String member_email,
					member_name;
	
	public TotalMemInfo(){};
	
	public String getMember_email() {
		return member_email;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	
	
}
