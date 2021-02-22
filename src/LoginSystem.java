import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginSystem {

	private JFrame frame;
	private JTextField txt_pw;
	private JTextField txt_phone;
	private DAO dao = new DAO();
	static int currentID = 0;
	static int cntt;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSystem window = new LoginSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginSystem() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 471, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 71, 127, 74);
		frame.getContentPane().add(panel_1);

		JLabel lb_pw = new JLabel("PW");
		lb_pw.setFont(new Font("±¼¸²", Font.PLAIN, 35));
		panel_1.add(lb_pw);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 170, 127, 73);
		frame.getContentPane().add(panel_2);

		JLabel lb_phone = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
		lb_phone.setFont(new Font("±¼¸²", Font.PLAIN, 22));
		panel_2.add(lb_phone);

		txt_pw = new JTextField();
		txt_pw.setBounds(158, 71, 275, 74);
		frame.getContentPane().add(txt_pw);
		txt_pw.setColumns(10);

		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(158, 170, 275, 74);
		frame.getContentPane().add(txt_phone);

		JButton btm_login = new JButton("\uB85C\uADF8\uC778\uD558\uAE30");
		btm_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pw = txt_pw.getText();
				String phone = txt_phone.getText();
				VO vo = new VO();
				vo.setMember_pw(pw);
				vo.setMember_phone(phone);
				vo.setP_recieve(cntt);
//			String str = dao.Login(vo);
				currentID = dao.Login(vo);
				if (currentID != 0) {
					JOptionPane.showMessageDialog(null, currentID + "´Ô ·Î±×ÀÎ µÇ¾ú½À´Ï´Ù.");
					frame.dispose();
					new Main(vo);
				} else {
					System.out.println("½ÇÆÐ");
				}

			}
		});
		btm_login.setFont(new Font("±¼¸²", Font.PLAIN, 36));
		btm_login.setBounds(12, 272, 358, 66);
		frame.getContentPane().add(btm_login);

		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Join_System.main(null);

			}
		});
		btnNewButton.setFont(new Font("±¼¸²", Font.PLAIN, 31));
		btnNewButton.setBounds(12, 365, 358, 58);
		frame.getContentPane().add(btnNewButton);
	}
	
	static void getVO(MemberVO vo) {
		
		cntt=vo.getP_RECEIVE();
		
	}
}
