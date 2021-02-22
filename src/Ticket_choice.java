import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ticket_choice {

	private JFrame frame;
	private DAO dao = new DAO();
	static int member_id =0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket_choice window = new Ticket_choice();
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
	public Ticket_choice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 454, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel(LoginSystem.currentID+"\uC6D0\uD558\uC2DC\uB294 \uC774\uC6A9\uAD8C\uC744 \uC120\uD0DD\uD574\uC8FC\uC138\uC694");
		lblNewLabel.setBounds(42, 10, 315, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btm_ticket_1huor = new JButton("1\uC2DC\uAC04");
		btm_ticket_1huor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cnt = dao.UpdateTicket(1,LoginSystem.currentID);
				int cnt1 =dao.PlusTime(LoginSystem.currentID, 1);
				if(cnt1>0) {
					JOptionPane.showMessageDialog(null, "1시간 충전이 완료되었습니다.");
//					System.out.println("1시간 충전이 완료되었습니다.");
				}
				if(cnt>0) {
					JOptionPane.showMessageDialog(null, "1시간 구매가 완료되었습니다.");
				}
//				System.out.print(member_id);
				frame.dispose();
				new Main(null); 
			}
		});
		btm_ticket_1huor.setBounds(42, 117, 140, 51);
		frame.getContentPane().add(btm_ticket_1huor);
		
		JButton btm_ticket_3hour = new JButton("3\uC2DC\uAC04");
		btm_ticket_3hour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cnt = dao.UpdateTicket(3,LoginSystem.currentID);
				int cnt1 =dao.PlusTime(LoginSystem.currentID, 3);
				if(cnt1>0) {
					JOptionPane.showMessageDialog(null, "3시간 충전이 완료되었습니다.");
//					System.out.println("1시간 충전이 완료되었습니다.");
				}
				if(cnt>0) {
					JOptionPane.showMessageDialog(null, "3시간 구매가 완료되었습니다.");
				}
//				System.out.print(member_id);
				frame.dispose();
				new Main(null);
			}
		});
		btm_ticket_3hour.setBounds(217, 117, 140, 51);
		frame.getContentPane().add(btm_ticket_3hour);
		
		JButton btm_ticket_6hour = new JButton("6\uC2DC\uAC04");
		btm_ticket_6hour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cnt = dao.UpdateTicket(6,LoginSystem.currentID);
				int cnt1 =dao.PlusTime(LoginSystem.currentID, 6);
				if(cnt1>0) {
					JOptionPane.showMessageDialog(null, "6시간 충전이 완료되었습니다.");
//					System.out.println("1시간 충전이 완료되었습니다.");
				}
				if(cnt>0) {
					JOptionPane.showMessageDialog(null, "6시간 구매가 완료되었습니다.");
				}
//				System.out.print(member_id);
				frame.dispose();
				new Main(null);
			}
		});
		btm_ticket_6hour.setBounds(42, 212, 140, 51);
		frame.getContentPane().add(btm_ticket_6hour);
		
		JButton btm_ticket_12hour = new JButton("12\uC2DC\uAC04");
		btm_ticket_12hour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int cnt = dao.UpdateTicket(12,LoginSystem.currentID);
				int cnt1 =dao.PlusTime(LoginSystem.currentID, 12);
				if(cnt1>0) {
					JOptionPane.showMessageDialog(null, "12시간 충전이 완료되었습니다.");
//					System.out.println("1시간 충전이 완료되었습니다.");
				}
				if(cnt>0) {
					JOptionPane.showMessageDialog(null, "12시간 구매가 완료되었습니다.");
				}
//				System.out.print(member_id);
				frame.dispose();
				new Main(null);
			}
		});
		btm_ticket_12hour.setBounds(217, 212, 140, 51);
		frame.getContentPane().add(btm_ticket_12hour);
	}

}
