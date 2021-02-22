import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Penalty_System_main {

	private JFrame frame;
	private AbstractButton btn_seat1_i;
	VO vo = new VO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Penalty_System_main window = new Penalty_System_main();
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
	public Penalty_System_main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		String url = this.getClass().getResource("").getPath(); // 밑에 주소기니까.. 짧게하는법?
		System.out.println(url);
		Image image = new ImageIcon(url + "penalty.png").getImage().getScaledInstance(650, 650, Image.SCALE_SMOOTH);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 700, 700);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbl_image = new JLabel("");
		
		lbl_image.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_image.setBounds(0, 5, 680, 680);
		panel.add(lbl_image);
		// lbl_image.setIcon(new ImageIcon(image));

		JRadioButton rb_p1 = new JRadioButton("\uD0A4\uBCF4\uB4DC \uBC0F \uBCFC\uD39C\uC18C\uB9AC");
		rb_p1.setHorizontalAlignment(SwingConstants.LEFT);
		rb_p1.setBounds(250, 375, 367, 23);
		panel.add(rb_p1);

		JRadioButton rb_p2 = new JRadioButton("\uD578\uB4DC\uD3F0 \uBCA8\uC18C\uB9AC");
		rb_p2.setHorizontalAlignment(SwingConstants.LEFT);
		rb_p2.setBounds(250, 415, 367, 23);
		panel.add(rb_p2);

		JRadioButton rb_p3 = new JRadioButton("\uC74C\uC2DD\uBB3C \uB0C4\uC0C8\uAC00 \uB098\uC694");
		rb_p3.setHorizontalAlignment(SwingConstants.LEFT);
		rb_p3.setBounds(250, 457, 367, 23);
		panel.add(rb_p3);

		JRadioButton rb_p4 = new JRadioButton("\uAE30\uD0C0");
		rb_p4.setHorizontalAlignment(SwingConstants.LEFT);
		rb_p4.setBounds(250, 493, 367, 23);
		panel.add(rb_p4);

		ButtonGroup rb = new ButtonGroup();
		rb.add(rb_p1);
		rb.add(rb_p2);
		rb.add(rb_p3);
		rb.add(rb_p4);

		JButton btn_home = new JButton("\uD648\uC73C\uB85C");
		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Main(vo);
			}
		});
		btn_home.setBounds(12, 606, 97, 23);
		panel.add(btn_home);

		JButton btn_back = new JButton("back \uB4A4\uB85C");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new Main(vo);
			}
		});
		btn_back.setBounds(570, 617, 97, 23);
		panel.add(btn_back);

		JButton btn_seat1_1 = new JButton("1\uBC88\uC88C\uC11D");
		btn_seat1_1.setBounds(27, 27, 97, 38);
		panel.add(btn_seat1_1);

		JButton btn_seat1_2 = new JButton("2\uBC88\uC88C\uC11D");
		btn_seat1_2.setBounds(163, 27, 97, 38);
		panel.add(btn_seat1_2);

		JButton btn_seat1_3 = new JButton("3\uBC88\uC88C\uC11D");
		btn_seat1_3.setBounds(304, 27, 97, 38);
		panel.add(btn_seat1_3);

		JButton btn_seat1_4 = new JButton("4\uBC88\uC88C\uC11D");
		btn_seat1_4.setBounds(435, 27, 97, 38);
		panel.add(btn_seat1_4);

		JButton btn_seat1_5 = new JButton("5\uBC88\uC88C\uC11D");
		btn_seat1_5.setBounds(27, 100, 97, 38);
		panel.add(btn_seat1_5);

		JButton btn_seat1_6 = new JButton("6\uBC88\uC88C\uC11D");
		btn_seat1_6.setBounds(163, 100, 97, 38);
		panel.add(btn_seat1_6);

		JButton btn_seat1_7 = new JButton("7\uBC88\uC88C\uC11D");
		btn_seat1_7.setBounds(304, 100, 97, 38);
		panel.add(btn_seat1_7);

		JButton btn_seat1_8 = new JButton("8\uBC88\uC88C\uC11D");
		btn_seat1_8.setBounds(435, 100, 97, 38);
		panel.add(btn_seat1_8);

		JButton btn_seat1_9 = new JButton("9\uBC88\uC88C\uC11D");
		btn_seat1_9.setBounds(27, 171, 97, 38);
		panel.add(btn_seat1_9);

		JButton btn_seat1_10 = new JButton("10\uBC88\uC88C\uC11D");
		btn_seat1_10.setBounds(163, 171, 97, 38);
		panel.add(btn_seat1_10);

		JButton btn_seat1_11 = new JButton("11\uBC88\uC88C\uC11D");
		btn_seat1_11.setBounds(304, 171, 97, 38);
		panel.add(btn_seat1_11);

		JButton btn_seat1_12 = new JButton("12\uBC88\uC88C\uC11D");
		btn_seat1_12.setBounds(435, 171, 97, 38);
		panel.add(btn_seat1_12);

		JButton btn_seat1_13 = new JButton("13\uBC88\uC88C\uC11D");
		btn_seat1_13.setBounds(27, 239, 97, 38);
		panel.add(btn_seat1_13);

		JButton btn_seat1_14 = new JButton("14\uBC88\uC88C\uC11D");
		btn_seat1_14.setBounds(163, 239, 97, 38);
		panel.add(btn_seat1_14);

		JButton btn_seat1_15 = new JButton("15\uBC88\uC88C\uC11D");
		btn_seat1_15.setBounds(304, 239, 97, 38);
		panel.add(btn_seat1_15);

		JButton btn_seat1_16 = new JButton("16\uBC88\uC88C\uC11D");
		btn_seat1_16.setBounds(435, 239, 97, 38);
		panel.add(btn_seat1_16);

		JButton btn_ok = new JButton("\uD655\uC778");   // 경고 좌석, 사유를 누른후 확인버튼!
		btn_ok.setBounds(270, 562, 97, 23);
		panel.add(btn_ok);
		btn_ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
				Penalty_System_1.main(vo);
				
			}
		});


		JButton[] JButtons = { btn_seat1_1, btn_seat1_2, btn_seat1_3, btn_seat1_4, btn_seat1_5, btn_seat1_6,
				btn_seat1_7, btn_seat1_8, btn_seat1_9, btn_seat1_10, btn_seat1_11, btn_seat1_12, btn_seat1_13,
				btn_seat1_14, btn_seat1_15, btn_seat1_16 };

		for (int i = 0; i < JButtons.length; i++) {
			final int j = i;
			JButtons[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					vo.setSeatnumber(j + 1);
					
					JButtons[j].setBackground(Color.green);
					new Penalty_System_1(vo);
					
//					VO vo = new VO();
//					if (j+1 == vo.getSeatnumber()) {
//						DAO dao= new DAO();
//						dao.Search_member_id(vo);
//						Penalty_System_1.main(vo);
//						
//					}
				}

			});
		}

	}
}
