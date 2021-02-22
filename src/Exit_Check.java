import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exit_Check {

	private JFrame frame;
	private DAO dao = new DAO();
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Exit_Check window = new Exit_Check();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	public Exit_Check(VO vo) {
		initialize(vo);
		frame.setVisible(true);
	}

	
	private void initialize(VO vo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 261, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 434, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lbl_Exit_Check = new JLabel("\uD1F4\uC2E4 \uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		sl_panel.putConstraint(SpringLayout.NORTH, lbl_Exit_Check, 69, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lbl_Exit_Check, 158, SpringLayout.WEST, panel);
		panel.add(lbl_Exit_Check);
		
		JButton btn_Exit_Ok = new JButton("\uB124");
		btn_Exit_Ok.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// "네" 선택했을 때
				// 퇴실 column에 sysdate 들어가게 만들기
				MemberVO vo = dao.search_member(LoginSystem.currentID);
				dao.Seat_out(vo);
				JOptionPane.showMessageDialog(null, "퇴실 확인되었습니다", "OK", JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
				
			}
		});
		
		
		sl_panel.putConstraint(SpringLayout.WEST, btn_Exit_Ok, 75, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btn_Exit_Ok, -93, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btn_Exit_Ok, 158, SpringLayout.WEST, panel);
		panel.add(btn_Exit_Ok);
		
		JButton btn_Exit_Cancle = new JButton("\uC544\uB2C8\uC624");
		btn_Exit_Cancle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, btn_Exit_Cancle, 61, SpringLayout.SOUTH, lbl_Exit_Check);
		sl_panel.putConstraint(SpringLayout.WEST, btn_Exit_Cancle, -191, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btn_Exit_Cancle, -94, SpringLayout.EAST, panel);
		panel.add(btn_Exit_Cancle);
	}

}
