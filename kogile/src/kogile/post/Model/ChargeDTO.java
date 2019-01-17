package kogile.post.Model;

import java.io.Serializable;

public class ChargeDTO implements Serializable {
	
	private int charge_info_no;
	private int p_no;
	private int info_no;
	
	public ChargeDTO() {}

	public int getCharge_info_no() {
		return charge_info_no;
	}

	public void setCharge_info_no(int charge_info_no) {
		this.charge_info_no = charge_info_no;
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

	public ChargeDTO(int charge_info_no, int p_no, int info_no) {
		super();
		this.charge_info_no = charge_info_no;
		this.p_no = p_no;
		this.info_no = info_no;
	}

	@Override
	public String toString() {
		return "ChargeDTO [charge_info_no=" + charge_info_no + ", p_no=" + p_no + ", info_no=" + info_no + "]";
	}
	
	
}
