import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	private Connection conn = null;
	private PreparedStatement psmt = null;
	private ResultSet rs = null;
	int scnt = 3;
	int rcnt = 0;
	// ���պ�

	// �޼ҵ� �̸� : getConnection()
	// ����Ÿ���� ����
	// �Ű����� ����
	private void getConnection() {

		// 1. ����̹� �ε�
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. Connection��ü ����
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// �޼ҵ� �̸��� getClose()
	// ����Ÿ�� ����
	// �Ű����� ����

	private void getClose() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int Join(VO vo) { // ȸ������
		getConnection();
		// 1.����̹��ε� 2. Connection ��ü ���� ��~
		int result = 0;
		try {
			String sql = "insert into member (member_id, member_name, member_pw, member_phone, p_send,p_receive) values(member_id_seq.nextval,?,?,?,3,0)"; // name
																																		// pw
																																		// phone
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMember_name());
			psmt.setString(2, vo.getMember_pw());
			psmt.setString(3, vo.getMember_phone());

			result = psmt.executeUpdate();
			if (result == 1) {
				String sql1 = "insert into remain (member_id, total_time) " + "values(member_id_seq.currval,0)";
				psmt = conn.prepareStatement(sql1);
				psmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();

		}

		return result;
	}

	// �α��θ޼ҵ�

	public int Login(VO vo) { // �̸���ȯ
		getConnection();
		// phone,pw
		int result = 0;
		try {
			String sql = "select member_id from member where Member_phone =? and Member_pw =?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMember_phone());
			psmt.setString(2, vo.getMember_pw());
			psmt.executeQuery();
			rs = psmt.executeQuery(); // select�� ���� ����Ÿ�� ->ResultSet

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			getClose();
		}
		return result;
	}

	public int UpdateTicket(int hour, int member_id) {
		getConnection();
		int result = 0;
		int result1 = 0;
		try {
			String sql = "insert into ticket values(ticket_id_seq.nextval, ?)";
			psmt = conn.prepareStatement(sql);
			if (hour == 1) {
				psmt.setString(1, "hour_1");
			} else if (hour == 3) {
				psmt.setString(1, "hour_3");
			} else if (hour == 6) {
				psmt.setString(1, "hour_6");
			} else if (hour == 12) {
				psmt.setString(1, "hour_6");
			}
			result = psmt.executeUpdate();
			if (result == 1) {
				String sql1 = "update remain set ticket_id =(ticket_id_seq.currval) where member_id = ?";
				psmt = conn.prepareStatement(sql1);
				psmt.setInt(1, member_id);
				result1 = psmt.executeUpdate();
				if (result1 == 1) {
					String sql2 = "update member set ticket_id =(ticket_id_seq.currval) where member_id =?";
					psmt = conn.prepareStatement(sql2);
					psmt.setInt(1, member_id);
					psmt.executeUpdate();
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}

		return result;
	}

	public int PlusTime(int member_id, int time) {
		getConnection();
		int result = 0;
		try {
			String sql = "update remain set total_time = (? + (select total_time from remain where member_id =?)) where member_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, (time * 60));
			psmt.setInt(2, member_id);
			psmt.setInt(3, member_id);
			result = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getClose();
		}

		return result;

	}

	public void Enter(MemberVO vo) {
		getConnection();

		try {
			String sql = "update member set member_in = sysdate where member_phone = ? and member_pw = ?";
			psmt = conn.prepareStatement(sql);
			System.out.println("MEMBERID : " + vo.getMEMBER_ID());
			System.out.println("PHONE : " + vo.getMEMBER_PHONE());
			psmt.setString(1, vo.getMEMBER_PHONE());
			psmt.setString(2, vo.getMEMBER_PW());
			int cnt = psmt.executeUpdate();
//			if (cnt > 0) {
//				System.out.println("����?");
//			} else {
//				System.out.println("�ȵ���...�������̤�");
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getClose();
	}



	public int Seat_in(MemberVO member, VO vo) { // �Խ� �¼����� �� ��ȣ�ޱ�, MemberVO -> ȸ���� ����, vo -> seatNUM
		getConnection();
		int cnt = 0;
		int cnt2 =0;
		try {
			String sql = "update seat set seat_yn = 1 where seat_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getSeatnumber());
			cnt = psmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("��������!11");
				String sql2 ="Update member set seat_id =? where member_id =?";	//���⼭����
				psmt = conn.prepareStatement(sql2);
				
				System.out.println(vo.getSeatnumber() + " , " + member.getMEMBER_ID());
				
				psmt.setInt(1, vo.getSeatnumber());
				psmt.setInt(2, member.getMEMBER_ID());
				cnt2 =psmt.executeUpdate();
				if(cnt2>0) {
					System.out.println("��������!22");
					String sql3 ="update seat set member_id =? where seat_id =?";
					psmt = conn.prepareStatement(sql3);
					psmt.setInt(1, member.getMEMBER_ID());
					psmt.setInt(2, vo.getSeatnumber());
					psmt.executeUpdate();	//�������
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	public void Seat_out(MemberVO vo) { // ��� �¼����� �� ��ȣ��ȯ
		getConnection();
		int result =0;
		int result2 =0;
		try {
			String sql = "update seat set seat_yn=0, member_id = null where seat_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getSEAT_ID());
			result = psmt.executeUpdate();
			if (result > 0) {
				String sql3 = "update member set member_out = sysdate, seat_id =null where member_id =?";
				psmt = conn.prepareStatement(sql3);
				psmt.setInt(1, vo.getMEMBER_ID());
				result2 = psmt.executeUpdate();
				System.out.println(result2 + "����?");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Penalty_Sseat(MemberVO vo) { // ��� �ִ� ����� ���� ��!
		getConnection();
		// System.out.println(vo.getSeatnumber());

		if (vo.getP_SEND() > 0) { // �ٻ���� ���� ��� Ƚ��check
		
				try {
					String sql = "update member set p_send =((select P_send from member where member_id=?)-1) where member_id=?";
					// String sql = "Update Member set p_send =? "; /// **********SQL����
					psmt = conn.prepareStatement(sql);
					psmt.setInt(1, vo.getMEMBER_ID());
					psmt.setInt(2, vo.getMEMBER_ID());
					psmt.executeUpdate();

				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					getClose();
				}

			
		}

	}

	public void Search_member_id(VO vo) { // ��� �޴� ����� ���Ѱ�!=> �̰� �׳� �ڸ��� ���� ����� ���̵� ã�°�!!!!
		getConnection();
		if (vo.getSeat_id() == vo.getSeatnumber()) {
			try {
				String sql = "select member_id from member where seat_id=?";
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, vo.getSeat_id());
				psmt.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public MemberVO search_member(int memberID) {
		getConnection();
		MemberVO vo = null;
		try {
			String sql = "select * from member where member_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memberID);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO(rs.getString(1), rs.getInt(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), 
						rs.getInt(9), rs.getString(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	public void Penalty_Rseat(int re, MemberVO vo) { // ��� �޴� ����� Ƚ���� �ø��°�!!!!
		getConnection();
		try {
			//String sql = "Update Member set p_receive=? where member id=?  ";
			String sql ="update member set p_receive =(1+(select p_receive from member where seat_id =?)) where seat_ID =?";
			psmt = conn.prepareStatement(sql);
			System.out.println("����¼� : "+re);
			System.out.println("seat_ID : "+re);
			psmt.setInt(1, re);	//member_id ���ߵ�
			psmt.setInt(2, re);	//member_id ���ߵ�
			//psmt.setInt(1, );  ///���⿩��
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Join_input(VO vo) { // ��� �޴� ����� Ƚ���� �ø��°�!!!!
		getConnection();
		try {
			String sql = "insert into Member(member_name, member_phone, member_pw) values (?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMember_name());
			psmt.setString(2, vo.getMember_phone());
			psmt.setString(3, vo.getMember_pw());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int[] getSeatYN() { // �ڸ� �ߺ��� ���� ���ؼ� ��Ȱ��ȭ��Ų��!! (������ �� ��������)
		getConnection();

		int[] seat = new int[16];
		String sql = "select seat_YN from seat";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			for (int i = 0; i < seat.length; i++) {
				if (rs.next()) {
					seat[i] = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getClose();
		return seat;
	}
	
//	public int Warning() { // �̸���ȯ
//		getConnection();
//		// phone,pw
//		int result = 0;
//		try {
//			String sql = "select p_recieve from member where member_id =?";
//			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, LoginSystem.currentID);
//			
//			psmt.executeQuery();
//			rs = psmt.executeQuery(); // select�� ���� ����Ÿ�� ->ResultSet
//
//			if (rs.next()) {
//				result = rs.getInt(1);
//			}
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//		} finally {
//			getClose();
//		}
//		return result;
//	}
	public void p_r() {
		getConnection();
		
		getClose();
	}
}
