import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Seat_choice {

	private JFrame frame;
	private DAO dao = new DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seat_choice window = new Seat_choice();
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
	public Seat_choice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 524, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC6D0\uD558\uB294 \uC88C\uC11D\uC744 \uC120\uD0DD\uD558\uC138\uC694");
		lblNewLabel.setBounds(12, 20, 484, 29);
		frame.getContentPane().add(lblNewLabel);

		JButton btm_seat1 = new JButton("1");
		btm_seat1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Seat_check.main(null);
			}
		});
		btm_seat1.setBounds(12, 80, 60, 59);
		frame.getContentPane().add(btm_seat1);

		JButton btnNewButton_1 = new JButton("2");
		btnNewButton_1.setBounds(112, 80, 60, 59);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(214, 80, 60, 59);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("4");
		btnNewButton_3.setBounds(318, 80, 60, 59);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.setBounds(12, 162, 60, 59);
		frame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.setBounds(112, 162, 60, 59);
		frame.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("7");
		btnNewButton_6.setBounds(214, 162, 60, 59);
		frame.getContentPane().add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("8");
		btnNewButton_7.setBounds(318, 162, 60, 59);
		frame.getContentPane().add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("9");
		btnNewButton_8.setBounds(12, 245, 60, 59);
		frame.getContentPane().add(btnNewButton_8);

		JButton btnNewButton_9 = new JButton("10");
		btnNewButton_9.setBounds(112, 245, 60, 59);
		frame.getContentPane().add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("11");
		btnNewButton_10.setBounds(214, 245, 60, 59);
		frame.getContentPane().add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton("12");
		btnNewButton_11.setBounds(318, 245, 60, 59);
		frame.getContentPane().add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("13");
		btnNewButton_12.setBounds(12, 330, 60, 59);
		frame.getContentPane().add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton("14");
		btnNewButton_13.setBounds(112, 330, 60, 59);
		frame.getContentPane().add(btnNewButton_13);

		
		JButton btnNewButton_14 = new JButton("15");
		btnNewButton_14.setBounds(214, 330, 60, 59);
		frame.getContentPane().add(btnNewButton_14);

		JButton btnNewButton_15 = new JButton("16");
		btnNewButton_15.setBounds(318, 330, 60, 59);
		frame.getContentPane().add(btnNewButton_15);

		JButton[] JButtons = { btm_seat1, btnNewButton_1, btnNewButton_2, btnNewButton_3, btnNewButton_4,
				btnNewButton_5, btnNewButton_6, btnNewButton_7, btnNewButton_8, btnNewButton_9, btnNewButton_10,
				btnNewButton_11, btnNewButton_12, btnNewButton_13, btnNewButton_14, btnNewButton_15 };
		
		int[] seatYN = dao.getSeatYN();
		
		for (int i = 0; i < JButtons.length; i++) {
			final int j = i;
			
			if (seatYN[i] == 1) {
				JButtons[i].setEnabled(false);
			}else {
				JButtons[i].setEnabled(true);
			}
			
			
			
			JButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					VO vo = new VO();
					vo.setSeatnumber(j + 1);
					JButtons[j].setBackground(Color.green);
					new Seat_check(vo);
					frame.dispose();
					Seat_check.main(vo);
					
				}

			});
		}

	}
}
