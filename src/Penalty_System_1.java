import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Penalty_System_1 {
    VO vo = new VO();
     
	private JFrame frame;
	private JTextField tf_penalty;

	public static void main(VO vo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Penalty_System_1 window = new Penalty_System_1(vo);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Penalty_System_1(VO vo) {
		initialize(vo);
	}

	private void initialize(VO vo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		DAO dao = new DAO();

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);

		tf_penalty = new JTextField();
		tf_penalty.setHorizontalAlignment(SwingConstants.CENTER);
		tf_penalty.setText("\uACBD\uACE0\uB97C \uC8FC\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		tf_penalty.setBounds(42, 23, 350, 95);
		frame.getContentPane().add(tf_penalty);
		tf_penalty.setColumns(10);


		JButton btn_yes = new JButton("\uB124"); // 네 라는 버튼!-> 이때 경고를 받은사람에게 횟수를 +1 해줘야해.
		btn_yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "경고를 줬습니다!", "경고창", JOptionPane.ERROR_MESSAGE);
				new Main(vo);
				MemberVO currentLogin = dao.search_member(LoginSystem.currentID); // 현재 로그인한사람의 DB정보
				dao.Penalty_Rseat(vo.getSeatnumber(), currentLogin);
				dao.Penalty_Sseat(currentLogin);

			}
		});
		btn_yes.setBounds(42, 146, 138, 47);
		frame.getContentPane().add(btn_yes);

		JButton btn_no = new JButton("\uC544\uB2C8\uC694");
		btn_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "취소합니다", "경고창", JOptionPane.ERROR_MESSAGE);
				Penalty_System_main.main(null);
			}
		});
		btn_no.setBounds(252, 146, 138, 47);
		frame.getContentPane().add(btn_no);
	}
}
