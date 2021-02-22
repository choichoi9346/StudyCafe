
public class VO {
	private String member_phone;
	private String member_name;
	private String member_pw;
	private int member_id;
	private int p_recieve;
	private int p_send;
	private int seatnumber;

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	private int seat_id;

	public int getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	public int getP_recieve() {
		return p_recieve;
	}

	public void setP_recieve(int p_recieve) {
		this.p_recieve = p_recieve;
	}

	public int getP_send() {
		return p_send;
	}

	public void setP_send(int p_send) {
		this.p_send = p_send;
	}


	public VO() {
	}

	public VO(String member_phone, String member_name, String member_pw) {
		super();
		this.member_phone = member_phone;
		this.member_name = member_name;
		this.member_pw = member_pw;
	}

	public VO(String member_phone, String member_pw) {
		super();
		this.member_phone = member_phone;
		this.member_pw = member_pw;
	}

	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}

	public String getMember_phone() {
		return member_phone;
	}

	public String getMember_name() {
		return member_name;
	}

	public String getMember_pw() {
		return member_pw;
	}

	public int getSeatnumber() {
		return seatnumber;
	}

	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}

}
