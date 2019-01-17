package kogile.chat.DTO;

import java.io.Serializable;

public class ChatDTO implements Serializable {
	
	private int chat_no;
	private String chat_name;
	private	String chat_contents;
	private	String chat_date;
	
	public ChatDTO() {}
	
	public ChatDTO(int chat_no, String chat_name, String chat_contents, String chat_date) {
		super();
		this.chat_no = chat_no;
		this.chat_name = chat_name;
		this.chat_contents = chat_contents;
		this.chat_date = chat_date;
	}

	public int getChat_no() {
		return chat_no;
	}
	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}
	public String getChat_name() {
		return chat_name;
	}
	public void setChat_name(String chat_name) {
		this.chat_name = chat_name;
	}
	public String getChat_contents() {
		return chat_contents;
	}
	public void setChat_contents(String chat_contents) {
		this.chat_contents = chat_contents;
	}
	public String getChat_date() {
		return chat_date;
	}
	public void setChat_date(String chat_date) {
		this.chat_date = chat_date;
	}
	
	@Override
	public String toString() {
		return "ChatDTO [chat_no=" + chat_no + ", chat_name=" + chat_name + ", chat_contents=" + chat_contents
				+ ", chat_date=" + chat_date + "]";
	}
}
