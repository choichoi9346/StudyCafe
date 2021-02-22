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

public class Join_System {

	private JFrame frame;
	private JTextField txt_name;
	private JTextField txt_pw;
	private JTextField txt_phone;
	private DAO dao = new DAO();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join_System window = new Join_System();
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
	public Join_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	//name pw phone
			String name = txt_name.getText();
			String pw = txt_pw.getText();
			String phone = txt_phone.getText();
			VO vo = new VO(phone,name,pw);
			int cnt = dao.Join(vo);
			if(cnt>0) {
				JOptionPane.showMessageDialog(null, name+"님 회원가입이 완료되었습니다.");
				frame.dispose();
				LoginSystem.main(null);
			}
			
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 29));
		btnNewButton.setBounds(0, 10, 162, 75);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 117, 86, 59);
		frame.getContentPane().add(panel);
		
		JLabel lb_name = new JLabel("\uC774\uB984");
		panel.add(lb_name);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 202, 86, 59);
		frame.getContentPane().add(panel_1);
		
		JLabel lb_pw = new JLabel("pw");
		panel_1.add(lb_pw);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 283, 86, 59);
		frame.getContentPane().add(panel_2);
		
		JLabel lb_phone = new JLabel("\uD734\uB300\uD3F0\uBC88\uD638");
		panel_2.add(lb_phone);
		
		txt_name = new JTextField();
		txt_name.setBounds(110, 114, 293, 62);
		frame.getContentPane().add(txt_name);
		txt_name.setColumns(10);
		
		txt_pw = new JTextField();
		txt_pw.setColumns(10);
		txt_pw.setBounds(110, 199, 293, 62);
		frame.getContentPane().add(txt_pw);
		
		txt_phone = new JTextField();
		txt_phone.setColumns(10);
		txt_phone.setBounds(110, 280, 293, 62);
		frame.getContentPane().add(txt_phone);
		
		JButton btnNewButton_1 = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			frame.dispose();
			LoginSystem.main(null);
			}
		});
		btnNewButton_1.setBounds(184, 10, 162, 75);
		frame.getContentPane().add(btnNewButton_1);
	}

}
