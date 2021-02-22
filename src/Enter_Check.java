import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Enter_Check {

	private JFrame frame;
	private DAO dao = new DAO();
//	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Enter_Check window = new Enter_Check();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	
	public Enter_Check() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Enter_Check = new JLabel("\uC785\uC2E4 \uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		lbl_Enter_Check.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Enter_Check.setBounds(78, 43, 294, 48);
		panel.add(lbl_Enter_Check);
		
		JButton btn_Enter_Ok = new JButton("\uB124");
		
		btn_Enter_Ok.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// "네" 선택했을 때
				// 입실 column에 sysdate 들어가게 만들기
				
				MemberVO vo = dao.search_member(LoginSystem.currentID);
				
				int cntt = vo.getP_RECEIVE();
				System.out.println("확인!!!"+cntt);
				//new Main(cnt);
				String phone = vo.getMEMBER_PHONE();
				String pw = vo.getMEMBER_PW();
				dao.Enter(vo);
				frame.dispose();
			//	LoginSystem.main(null);
				
				if (cntt >= 3) {
					JOptionPane.showMessageDialog(null, LoginSystem.currentID + "조용히 해주세요~!!");
				}

				
				JOptionPane.showMessageDialog(null, "입실 확인되었습니다", "OK", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
				LoginSystem.getVO(vo);
				LoginSystem.main(null);
				
			}
		});
		btn_Enter_Ok.setBounds(99, 149, 97, 23);
		panel.add(btn_Enter_Ok);
		
		JButton btn_Enter_Cancle = new JButton("\uC544\uB2C8\uC624");
		btn_Enter_Cancle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frame.dispose();
				
			}
		});
		btn_Enter_Cancle.setBounds(242, 149, 97, 23);
		panel.add(btn_Enter_Cancle);
	}

}
