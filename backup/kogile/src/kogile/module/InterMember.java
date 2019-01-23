package kogile.module;

import java.io.Serializable;

public class InterMember implements Serializable {
	
	private String member_name,
				   password,
				   email;
	private int member_no;
	
	public InterMember() {
	}
	
	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}



	public String getMember_name() {
		return member_name;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
