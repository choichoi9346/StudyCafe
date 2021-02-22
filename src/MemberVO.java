
public class MemberVO {
	private String MEMBER_NAME;
	private int MEMBER_ID;
	private String MEMBER_PHONE;
	private String MEMBER_IN;
	private String MEMBER_OUT;
	private int P_RECEIVE;
	private int P_SEND;
	private int SEAT_ID;
	private int TICKET_ID;
	private String MEMBER_PW;
	
	public MemberVO(String mEMBER_NAME, int mEMBER_ID, String mEMBER_PHONE, String mEMBER_IN, String mEMBER_OUT,
			int p_RECEIVE, int p_SEND, int sEAT_ID, int tICKET_ID, String mEMBER_PW) {
		super();
		MEMBER_NAME = mEMBER_NAME;
		MEMBER_ID = mEMBER_ID;
		MEMBER_PHONE = mEMBER_PHONE;
		MEMBER_IN = mEMBER_IN;
		MEMBER_OUT = mEMBER_OUT;
		P_RECEIVE = p_RECEIVE;
		P_SEND = p_SEND;
		SEAT_ID = sEAT_ID;
		TICKET_ID = tICKET_ID;
		MEMBER_PW = mEMBER_PW;
	}

	public String getMEMBER_NAME() {
		return MEMBER_NAME;
	}

	public int getMEMBER_ID() {
		return MEMBER_ID;
	}

	public String getMEMBER_PHONE() {
		return MEMBER_PHONE;
	}

	public String getMEMBER_IN() {
		return MEMBER_IN;
	}

	public String getMEMBER_OUT() {
		return MEMBER_OUT;
	}

	public int getP_RECEIVE() {
		return P_RECEIVE;
	}

	public int getP_SEND() {
		return P_SEND;
	}

	public int getSEAT_ID() {
		return SEAT_ID;
	}

	public int getTICKET_ID() {
		return TICKET_ID;
	}

	public String getMEMBER_PW() {
		return MEMBER_PW;
	}
	
	
	
}
