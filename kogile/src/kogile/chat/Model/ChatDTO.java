package kogile.chat.Model;

import java.io.Serializable;

public class ChatDTO implements Serializable {
	
	private int chat_no;
	private int info_no;
	private	String chat_contents;
	private	String chat_date;
	
	public ChatDTO() {}
	
	public ChatDTO(int chat_no, int info_no, String chat_contents, String chat_date) {
		super();
		this.chat_no = chat_no;
		this.info_no = info_no;
		this.chat_contents = chat_contents;
		this.chat_date = chat_date;
	}

	public int getChat_no() {
		return chat_no;
	}
	public void setChat_no(int chat_no) {
		this.chat_no = chat_no;
	}

	public int getInfo_no() {
		return info_no;
	}

	public void setInfo_no(int info_no) {
		this.info_no = info_no;
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
		return "ChatDTO [chat_no=" + chat_no + ", chat_name=" + info_no + ", chat_contents=" + chat_contents
				+ ", chat_date=" + chat_date + "]";
	}
}
