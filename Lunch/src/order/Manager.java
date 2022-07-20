package order;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.DBordercheck;
import menu.Hansick;
import menu.Joongsick;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Manager extends JFrame{	
	
	//통신을 위해 필요한 것
	private String url = "jdbc:mysql://localhost:3306/food?serverTimezone=Asia/Seoul";
	private String user = "root";
	private String pwd = "my1234";
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs1 = null;
	private ResultSet rs2 = null;

	// ordercheck 테이블 구성
	JLabel orderhead;
	private JTable table1;
	private JScrollPane scrollPane1;
	private String colNames1[] = {"주문번호", "막국수", "묵밥", "칼국수", "쌀국수", "짬뽕", "연어덮밥", "총금액", "인당 가격 수", "결제한 사람 수", "별점"};
	private DefaultTableModel model1 = new DefaultTableModel(colNames1, 0) {
		public boolean isCellEditable(int rowIndex, int mColIndex) {
		return false;
		}
	};

	JButton del;
	
	// inventory 테이블 구성
	JLabel inhead;
	private JTable table2;
	private JScrollPane scrollPane2;
	private String colNames2[] = {"이름", "재고량", "팔린 수량"};
	private DefaultTableModel model2 = new DefaultTableModel(colNames2, 0) {
		public boolean isCellEditable(int rowIndex, int mColIndex) {
		return false;
		}
	};
	
	//메인 화면으로 돌아가는 버튼
	JButton first;
	
	// 폰트 서식
	Font c = new Font("돋움", Font.BOLD, 20);
	
	public Manager() {
		 setSize(1000,900);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setResizable(false);
		 setVisible(true);
		 
		 odisplay();
		 orderSelect();
		 inventorySelect();
		 buttonActive();
	}
	
	public void odisplay() {
		// ordercheck 패널
		JPanel jop1 = new JPanel();
		jop1.setPreferredSize(new Dimension(950, 450));
//		jop1.setBorder(new TitledBorder(new LineBorder(Color.orange, 2)));
		
		// ordercheck 테이블 제목
		JPanel jop1_1 = new JPanel();
		jop1_1.setPreferredSize(new Dimension(200, 50));
		jop1_1.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		orderhead = new JLabel("주문확인 목록");
		
		orderhead.setFont(c);
		jop1_1.add(orderhead);
		
		//테이블 들어가기
		JPanel jop1_2 = new JPanel();
		jop1_2.setPreferredSize(new Dimension(950, 320));
		
		table1 = new JTable(model1);
		scrollPane1 = new JScrollPane(table1);
		scrollPane1.setPreferredSize(new Dimension(900, 300));
		
		jop1_2.add(scrollPane1);
		
		JPanel jop1_3 = new JPanel();
		jop1_3.setPreferredSize(new Dimension(900, 50));
		del = new JButton("삭제하기");
		jop1_3.add(del);
		
		jop1.add(jop1_1);
		jop1.add(jop1_2);
		jop1.add(jop1_3);
		
		//inventory 패널
		JPanel jop2 = new JPanel();
		jop2.setPreferredSize(new Dimension(950, 400));
//		jop2.setBorder(new TitledBorder(new LineBorder(Color.orange, 2)));
		
		JPanel jop2_1 = new JPanel();
		jop2_1.setPreferredSize(new Dimension(900, 50));
		inhead = new JLabel("재고 수량 목록");
		inhead.setFont(c);
		jop2_1.add(inhead);
		
		JPanel jop2_2 = new JPanel();
		jop2_2.setPreferredSize(new Dimension(900, 250));
		
		table2 = new JTable(model2);
		scrollPane2 = new JScrollPane(table2);
		scrollPane2.setPreferredSize(new Dimension(900, 230));
		table2.setFont(c);
		table2.setRowHeight(30);
		
		jop2_2.add(scrollPane2);
		
		JPanel jop2_3 = new JPanel();
		jop2_3.setPreferredSize(new Dimension(900, 50));
		first = new JButton("메인화면");
		jop2_3.add(first);
		
		jop2.add(jop2_1);
		jop2.add(jop2_2);
		jop2.add(jop2_3);
		
		add(jop1, BorderLayout.NORTH);
		add(jop2, BorderLayout.SOUTH);
		
	}
	
	public void orderSelect() {
		String query = "select num, hansick1, hansick2, hansick3, joongsick1, joongsick2, joongsick3, tprice, tpeople, people, star from ordercheck;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(query);
			rs1 = pstmt.executeQuery();
			while(rs1.next()) { model1.addRow(new Object[] { rs1.getInt("num"), rs1.getInt("hansick1"), rs1.getInt("hansick2"), rs1.getInt("hansick3"), 
						rs1.getInt("joongsick1"), rs1.getInt("joongsick2"),rs1.getInt("joongsick3"),
						 rs1.getInt("tprice"), rs1.getInt("tpeople"), rs1.getInt("people"), rs1.getString("star")});
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}  finally {
			try {
					rs1.close();
					pstmt.close();
					con.close();
			} catch(Exception e2) {}
		}
	}
	
	public void inventorySelect() {
		String query = "select name, remain, sold from inventory;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(query);
			rs2 = pstmt.executeQuery();
			while(rs2.next()) { model2.addRow(new Object[] { rs2.getString("name"), rs2.getInt("remain"), rs2.getInt("sold")});
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}  finally {
			try {
					rs2.close();
					pstmt.close();
					con.close();
			} catch(Exception e2) {}
		}
	}
	
	public void orderdelete() throws ClassNotFoundException {
		String sql = "delete from ordercheck where num = ?";
		
		DefaultTableModel model2 = (DefaultTableModel)table1.getModel();
		int row = table1.getSelectedRow();
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, user, pwd);
		pstmt = con.prepareStatement(sql);
		} catch (SQLException e1) {
			
			System.out.println(e1.getMessage());
		}
		try {	
			pstmt.setInt(1, (int)model2.getValueAt(row, 0));
			pstmt.execute();
//			System.out.println((int)model2.getValueAt(row, 0));
			System.out.println("삭제 성공!!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}   finally {
			try {	rs1.close();
					pstmt.close();
					con.close();
			} catch(Exception e2) {
				
			}
		}
		
		model1.removeRow(row);
}
	
		public void buttonActive() {
			//버튼 누르면 삭제 메서드
			del.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						orderdelete();
					} catch (ClassNotFoundException e1) {
						System.out.println("주문 삭제 버튼 오류!");
					}
				}
			});
			
			//버튼 누르면 삭제 메서드
			first.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new Main();
					setVisible(false);
				}
			});
			
			
		}
	}
	

