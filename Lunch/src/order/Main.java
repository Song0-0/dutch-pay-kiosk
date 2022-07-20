package order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Main extends JFrame{
	//주문하기, 관리자
		JButton jb1; // 주문하기
		JButton jb2; // 관리자
		
		JLabel jl1; // 이미지를 넣을 라벨
		ImageIcon im; // 이미지를 넣을 객체
		
		public Main() {
			first();
			display();
			showframe();
		}
		
		public void first() {

			jb1 = new JButton("주문하기");
			jb1.setFont(new Font("돋움", Font.BOLD, 30));
			jb1.setBorderPainted(false);
			
			jb2 = new JButton("관리자 화면");
			jb2.setFont(new Font("돋움", Font.BOLD, 30));
			jb2.setBorderPainted(false);
			
			im = new ImageIcon("src/images/logo.JPG");
			jl1 = new JLabel(im);
		}
		
		public void display() {
			
			JPanel jp1 = new JPanel();
			jp1.setPreferredSize(new Dimension(1000, 600));
			jp1.setBackground(Color.white);
			jp1.add(jl1);
			
			JPanel jp2 = new JPanel();
			jp2.setPreferredSize(new Dimension(1000, 200));
			jp2.setBackground(Color.white);
			jp2.add(jb1);
			jp2.add(jb2);
			
			jb1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new Order();
					setVisible(false);
				}
			});
		
			jb1.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					jb1.setBackground(Color.orange);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					jb1.setBackground(Color.orange);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					jb1.setBackground(Color.orange);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					jb1.setBackground(Color.orange);
					
				}

				@Override
				public void mouseExited(MouseEvent e) {
					jb1.setBackground(Color.white);
					
				}
				
			});
			
			jb2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new InputPassword();
					setVisible(false);
//					String password = JOptionPane.showInputDialog("비밀번호를 입력하세요.");
//					if(password.equals("m1234")) {
//						new Order();
//						setVisible(false);
//					} else {
//						
//					}
				}
			});
			
			jb2.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					jb2.setBackground(Color.orange);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					jb2.setBackground(Color.orange);
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					jb2.setBackground(Color.orange);
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					jb2.setBackground(Color.orange);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					jb2.setBackground(Color.white);	
				}
				
			});
					
			add(jp1, BorderLayout.NORTH);
			add(jp2, BorderLayout.SOUTH);
			
		}
		
		
		
		public void showframe() {
			  setTitle("오늘 점심뭐먹지?");
		      setSize(1000,800);
		      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		      pack();
		      setResizable(false);
		      setVisible(true);
		}

		public static void main(String[] args) {
			new Main();
		}


}
