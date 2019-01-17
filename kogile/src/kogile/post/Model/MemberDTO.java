package kogile.post.Model;

import java.io.Serializable;

public class MemberDTO implements Serializable {
	
	private int total_no;
	private String name;
	private String email;
	
	public MemberDTO() {}

	public int getTotal_no() {
		return total_no;
	}

	public void setTotal_no(int total_no) {
		this.total_no = total_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MemberDTO(int total_no, String name, String email) {
		super();
		this.total_no = total_no;
		this.name = name;
		this.email = email;
	}
	
	
}
