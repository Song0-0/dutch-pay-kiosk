package order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPassword extends JFrame{
	JLabel jl1;
	private JPasswordField jpa = new JPasswordField();
	JButton jb1;
	
	public InputPassword() {
		  setTitle("관리자 화면 암호");
	      setSize(300,200);
	      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	      setAlwaysOnTop(true);
	      setResizable(false);
	      setVisible(true);
	      
	      JPanel jp1 = new JPanel();
	      jp1.setPreferredSize(new Dimension(200, 150));
	      jl1 = new JLabel("< 관리자 비밀번호를 입력하세요 >");
	      jl1.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
	      jpa.setPreferredSize(new Dimension(150, 30));
	      jb1 = new JButton("확인");
	     
	      jp1.add(jl1);
	      jp1.add(jpa);
	      jp1.add(jb1);
	      add(jp1);
	      
	      jb1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String pw = new String(jpa.getPassword());
					
						if(pw.equals("m1234")) {
							new Manager();
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "비밀번호가 틀립니다.", "비밀번호 오류" ,JOptionPane.ERROR_MESSAGE);
							System.out.println(jpa.getPassword());
						}
				}
			});
	}

}
