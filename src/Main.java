import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	DAO dao = new DAO();
//	static String loginID = null;
//	static String phone;
//	static String pw;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		loginID = args[0];
//		pw = args[1];
//		phone = args[2];
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main window = new Main(null);
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Main(VO vo) {
		initialize(vo);
		frame.setVisible(true);
	}

	private void initialize(VO vo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 685, 761);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 645, 44);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel(LoginSystem.currentID + "\uB2D8 \uC785\uC2E4\uCC98\uB9AC");
		lblNewLabel.setBounds(12, 64, 261, 35);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC2DC\uC2A4\uD15C\uC2DC\uAC04");
		lblNewLabel_1.setBounds(330, 64, 327, 35);
		frame.getContentPane().add(lblNewLabel_1);

		JButton btm_ticketchoice = new JButton("\uC774\uC6A9\uAD8C");
		btm_ticketchoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Ticket_choice.main(null);

			}
		});
		btm_ticketchoice.setBounds(47, 129, 165, 127);
		frame.getContentPane().add(btm_ticketchoice);

		JButton btm_seatchoice = new JButton("\uC88C\uC11D\uC120\uD0DD");
		btm_seatchoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Seat_choice.main(null);

			}
		});
		btm_seatchoice.setBounds(330, 129, 165, 127);
		frame.getContentPane().add(btm_seatchoice);

		JButton btm_warning = new JButton("\uACBD\uACE0");
		btm_warning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Penalty_System_main.main(null);
			}
		});
		btm_warning.setBounds(47, 341, 165, 127);
		frame.getContentPane().add(btm_warning);

		JButton btm_out = new JButton("\uD1F4\uC2E4");
		btm_out.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				new Exit_Check(new VO());
				System.out.println("퇴실 성공");
			}
		});

		btm_out.setBounds(330, 341, 165, 127);
		frame.getContentPane().add(btm_out);

		JButton btn_enter = new JButton("\uC785\uC2E4");// 입실버튼을 누를때...
		btn_enter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				new Enter_Check();
				System.out.println("입실 성공");
				frame.dispose();
				//
				
////				int cnt1 = dao.search_member(LoginSystem.currentID);
////				int cnt = dao.Seat_in(dao.search_member(LoginSystem.currentID), vo);
//				if (cnt >= 3) {
//					System.out.println(vo.getP_recieve());
//					JOptionPane.showMessageDialog(null, LoginSystem.currentID + "조용히 해주세요~!!");
//				}

			}
		});
		btn_enter.setBounds(529, 279, 97, 81);
		frame.getContentPane().add(btn_enter);

		JButton btm_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btm_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Logout_System.main(null);

			}
		});
		btm_logout.setBounds(255, 621, 181, 75);
		frame.getContentPane().add(btm_logout);
	}
}