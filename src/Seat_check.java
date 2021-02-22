import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Seat_check {

	private JFrame frame;
	private JTextField textField;
	static int seatnum;
	DAO dao = new DAO();
	
	
	public static void main(VO vo) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seat_check window = new Seat_check(vo);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Seat_check(VO vo) {
		initialize(vo);
	}

	
	private void initialize(VO vo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 338, 177);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setText(vo.getSeatnumber() + "\uBC88 \uC790\uB9AC\uB97C \uC120\uD0DD \uD558\uC168\uC2B5\uB2C8\uB2E4.");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(54, 38, 209, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	
		
		
		
		JButton btnNewButton = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnNewButton.addActionListener(new ActionListener() { //뒤로가기 누르면
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Seat_choice.main(null);
			}
		});
		btnNewButton.setBounds(54, 94, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uD655\uC778");
		btnNewButton_1.addActionListener(new ActionListener() {//확인버튼 누르면
			public void actionPerformed(ActionEvent arg0) {
				int cnt = dao.Seat_in(dao.search_member(LoginSystem.currentID), vo);
				vo.setSeat_id(cnt);
				frame.dispose();
				new Main(vo);
				//Main.main(null);
			}
		});
		btnNewButton_1.setBounds(163, 94, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
