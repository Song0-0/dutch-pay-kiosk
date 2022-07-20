package order;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.DBinventory;
import dao.DBordercheck;
import menu.Hansick;
import menu.Hansick1;
import menu.Hansick2;
import menu.Hansick3;
import menu.Joongsick;
import menu.Joongsick1;
import menu.Joongsick2;
import menu.Joongsick3;
import user.User;

public class Order extends JFrame implements User{
	// 메뉴 객체를 사용하기 위해 선언
	Hansick h1 = new Hansick1();
	Hansick h2 = new Hansick2();
	Hansick h3 = new Hansick3();
	
	Joongsick j1 = new Joongsick1();
	Joongsick j2 = new Joongsick2();
	Joongsick j3 = new Joongsick3();

	//JPanel op1 컴포넌트
	
	// 현재 날짜와 시간
	
	//주문 번호
	JLabel ordernum1;
	JLabel ordernum2;	
	private int id = 1;
	
	JLabel menuname;
	
	//처음화면으로 돌아가는 버튼
	JButton first;
	
	// 한식 메뉴 버튼
	JButton hansick1;
	JButton hansick2;
	JButton hansick3;

	// 중식 메뉴 버튼
	JButton joongsick1;
	JButton joongsick2;
	JButton joongsick3;
	
	//로고 이미지
	ImageIcon iml = new ImageIcon("src/images/logo_small.JPG");
	
	// 버튼 이미지
	ImageIcon im1 = new ImageIcon("src/images/food1.JPG");
	ImageIcon im2 = new ImageIcon("src/images/food2.JPG");
	ImageIcon im3 = new ImageIcon("src/images/food3.JPG");

	ImageIcon im4 = new ImageIcon("src/images/food4.JPG");
	ImageIcon im5 = new ImageIcon("src/images/food5.JPG");
	ImageIcon im6 = new ImageIcon("src/images/food6.JPG");
	
	ImageIcon im11 = new ImageIcon("src/images/food1.PNG");
	ImageIcon im22 = new ImageIcon("src/images/food2.PNG");
	ImageIcon im33 = new ImageIcon("src/images/food3.PNG");

	ImageIcon im44 = new ImageIcon("src/images/food4.PNG");
	ImageIcon im55 = new ImageIcon("src/images/food5.PNG");
	ImageIcon im66 = new ImageIcon("src/images/food6.PNG");
	
	ImageIcon imh = new ImageIcon("src/images/header.PNG");
	
	//메뉴 별 팔린 갯수
	int ihansick1;
	int ihansick2;	
	int ihansick3;
	
	int ijoongsick1;
	int ijoongsick2;
	int ijoongsick3;
	
	//메뉴 별 팔린 갯수 합
	int tamount;
	
	//메뉴 별 팔린 가격
	int phansick1;
	int phansick2;	
	int phansick3;
	
	int pjoongsick1;
	int pjoongsick2;
	int pjoongsick3;
	
	//메뉴 별 팔린 금액 합
	int tprice;
	
	//JPanel op2 컴포넌트
	
	//메뉴 선택 테이블
	JTable table;
	DefaultTableModel model;
	JScrollPane scroll;
	
	JLabel people;
	
	//인원 수 선택 라디오 번튼
	JRadioButton people1;
	JRadioButton people2;
	JRadioButton people3;
	JRadioButton people4;
	
	//인원 수 변수
	int peoplenum;
	
	//총 수량, 총 금액
	JLabel tamount1, tamount2;
	JLabel tprice1, tprice2;
	
	//결제하기 초기화 버튼
	JButton pay;
	JButton reset;
	
	//주문불가 설정하는 수
	int num;
		
	//폰트
	Font a = new Font("돋움", Font.BOLD, 20);
	Font b = new Font("돋움", Font.BOLD, 60);
	Font c = new Font("돋움", Font.BOLD, 30);
	Font d = new Font("돋움", Font.BOLD, 40);
	
	public Order() {
		first();
		display();
		Activebutton();
		showframe();
	}
	
	public void first() {
		
		//JPanel op1 컴포넌트 초기화
		
		// 현재 날짜와 시간
		
		// 주문번호
		ordernum1 = new JLabel("< 주문번호 >");
		ordernum2 = new JLabel(String.valueOf(getId()));
		ordernum1.setFont(a);
		ordernum2.setFont(b);
		
		menuname = new JLabel(imh);
		
		// 한식 버튼 초기화
		hansick1 = new JButton(im1);
		hansick2 = new JButton(im2);
		hansick3 = new JButton(im3);
		
		// 중식 버튼 초기화
		joongsick1 = new JButton(im4);
		joongsick2 = new JButton(im5);
		joongsick3 = new JButton(im6);
		
		first = new JButton("처음화면");
		
		//JPaenl op2 컴포넌트 초기화
		
		// 인원 수 라디오 버튼
		people1 = new JRadioButton("1명");
		people2 = new JRadioButton("2명");
		people3 = new JRadioButton("3명");
		people4 = new JRadioButton("4명");
		
		// 결제하기, 리셋 초기화
		pay = new JButton("결제하기");
		reset = new JButton("초기화");
		
		people1.setFont(c);
		people2.setFont(c);
		people3.setFont(c);
		people4.setFont(c);
		
		pay.setFont(c);
		reset.setFont(c);
		
	}
	
	public void display() {
		
		//JPanel op1 컴포넌트 
		JPanel op1 = new JPanel();
		op1.setPreferredSize(new Dimension(490, 795));
//		op1.setBorder(new TitledBorder(new LineBorder(Color.orange, 2)));
		op1.setBackground(Color.white);
		
		//로고 이미지 & 주문번호
		JPanel mm = new JPanel();
		mm.setPreferredSize(new Dimension(490, 130));
		mm.setBackground(Color.white);
//		mm.setBorder(new TitledBorder(new LineBorder(Color.blue, 1)));
		
		//로고 이미지
		JPanel mm1 = new JPanel();
		mm1.setPreferredSize(new Dimension(250, 130));
		mm1.setBackground(Color.white);
		JLabel mm1_1 = new JLabel(iml);
		mm1.add(mm1_1);
		
//		mm1.setBorder(new TitledBorder(new LineBorder(Color.orange, 3)));
		
		//주문번호
		JPanel mm2 = new JPanel();
		mm2.setPreferredSize(new Dimension(230, 120));
		mm2.setBackground(Color.white);
//		mm2.setBorder(new TitledBorder(new LineBorder(Color.orange, 3)));
		
		JPanel mm21 = new JPanel();
		mm21.setPreferredSize(new Dimension(200, 30));
		mm21.setBackground(Color.white);
		mm21.add(ordernum1);
		
		JPanel mm22 = new JPanel();
		mm22.setPreferredSize(new Dimension(200, 70));
		mm22.setBackground(Color.white);
		mm22.add(ordernum2);
		
		mm2.add(mm21);
		mm2.add(mm22);
		
		mm.add(mm1);
		mm.add(mm2);
		
		//음식 주문 버튼
		JPanel mop1 = new JPanel();
		
		mop1.setPreferredSize(new Dimension(480, 190));
		mop1.setBackground(Color.white);

		hansick1.setPreferredSize(new Dimension(150, 180));
		hansick2.setPreferredSize(new Dimension(150, 180));
		hansick3.setPreferredSize(new Dimension(150, 180));	
		
		//버튼에 마우스가 올라갈 때 이미지 변환
		hansick1.setRolloverIcon(im11);
		hansick2.setRolloverIcon(im22);
		hansick3.setRolloverIcon(im33);
		
		joongsick1.setRolloverIcon(im44);
		joongsick2.setRolloverIcon(im55);
		joongsick3.setRolloverIcon(im66);
		
		JPanel mop2 = new JPanel();
		
		mop2.setPreferredSize(new Dimension(480, 190));
		mop2.setBackground(Color.white);
		
		joongsick1.setPreferredSize(new Dimension(150, 180));
		joongsick2.setPreferredSize(new Dimension(150, 180));
		joongsick3.setPreferredSize(new Dimension(150, 180));
		
		mop1.add(hansick1);
		mop1.add(hansick2);
		mop1.add(hansick3);
		
		mop2.add(joongsick1);
		mop2.add(joongsick2);
		mop2.add(joongsick3);		
		
		//홈으로 버튼 크기 조정
		JPanel one = new JPanel();
		one.setBackground(Color.white);
		one.setPreferredSize(new Dimension(200, 200));
//		one.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		first.setPreferredSize(new Dimension(200, 100));
		first.setFont(c);
		one.add(first);
		
		// JPanel op2 컴포넌트
		JPanel op2 = new JPanel();
		op2.setPreferredSize(new Dimension(490, 790));
		op2.setBackground(Color.white);
//		op2.setBorder(new TitledBorder(new LineBorder(Color.blue, 1)));
		
		// 오른쪽 메뉴 위 - JTable로 작성
		JPanel rop1 = new JPanel();
		rop1.setPreferredSize(new Dimension(480, 395));
		rop1.setBackground(Color.white);
//		rop1.setBorder(new TitledBorder(new LineBorder(Color.BLACK)));
		
		String[] header = {"메   뉴", "수   량", "가  격"};
		model = new DefaultTableModel(header, 0) {
			public boolean isCellEditable(int rowIndex, int mColIndex) {
			return false;
			}
		};
		table = new JTable(model);
		
		scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(470, 360));
		
		
		//테이블 서식
		table.setFont(a);
		table.setRowHeight(30);
		
		rop1.add(scroll);
		
		// 버튼 그룹화
		JPanel rop2 = new JPanel();
		rop2.setPreferredSize(new Dimension(480, 250));
		rop2.setBackground(Color.white);
		
		JPanel rop21 = new JPanel();
		rop21.setBackground(Color.white);
		people = new JLabel("< 결제할 인원 수 >");
		people.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		
		people.setFont(c);
		rop21.add(people);
			
		JPanel rop22 = new JPanel();
		rop22.setBackground(Color.white);
		
		people1.setBackground(Color.white);
		people2.setBackground(Color.white);
		people3.setBackground(Color.white);
		people4.setBackground(Color.white);
	
		ButtonGroup peo = new ButtonGroup();
		peo.add(people1);
		peo.add(people2);
		peo.add(people3);
		peo.add(people4);
		
		rop22.add(people1);
		rop22.add(people2);
		rop22.add(people3);
		rop22.add(people4);
		

		//총 수량 & 총 금액
		JPanel rop23 = new JPanel();
		rop23.setPreferredSize(new Dimension(480, 50));
		rop23.setBackground(Color.white);
		tamount1 = new JLabel("총 수량    : ");
		tamount1.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 100));
		tamount2 = new JLabel(String.valueOf(tamount));
		tamount1.setFont(d);
		tamount2.setFont(d);
		
		JPanel rop24 = new JPanel();
		rop24.setPreferredSize(new Dimension(480, 50));
		rop24.setBackground(Color.white);
		tprice1 = new JLabel("총 금액    : ");
		tprice1.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 100));
		tprice2 = new JLabel(String.valueOf(tprice));
		tprice1.setFont(d);
		tprice2.setFont(d);
		
		rop23.add(tamount1);
		rop23.add(tamount2);
		
		rop24.add(tprice1);
		rop24.add(tprice2);

		//결제 & 초기화 버튼
		JPanel rop25 = new JPanel();
		rop25.setPreferredSize(new Dimension(480, 80));
		rop25.setBackground(Color.white);
		
		pay.setPreferredSize(new Dimension(200, 60));
		reset.setPreferredSize(new Dimension(200, 60));
		
		
		rop25.add(pay);
		rop25.add(reset);
		
		rop2.add(rop23);
		rop2.add(rop24);		
		
		rop2.add(rop21);
		rop2.add(rop22);
		
		op1.add(mm);
		op1.add(menuname);
		op1.add(mop1);
		op1.add(mop2);
		op1.add(one);
		
		op2.add(rop1);
		op2.add(rop2);
		op2.add(rop25);
		
		add(op1, BorderLayout.WEST);
		add(op2, BorderLayout.EAST);
		
	}
	
	//버튼 메서드
	public void Activebutton() {
				
		hansick1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = h1.getName();
				String num = String.valueOf(1);
				String price = String.valueOf(h1.getunitPrice());
				
				String[] row = new String[3];
				
				if(h1.getLeftNum() - ihansick1 == 0) {
					JOptionPane.showMessageDialog(null, h1.getName() + "수량이 부족합니다.", "재고 수량 부족" ,JOptionPane.ERROR_MESSAGE);
					
				} else {
					row[0] = name;
					row[1] = num;
					row[2] = price;
					
					model.addRow(row);
					
					//주문 당 팔린 갯수
					int count = 1;
					ihansick1 += count;
					h1.setSalesNum(ihansick1);
					
					// 팔린 가격
					phansick1 += h1.getunitPrice();
					
					int amount = count + Integer.parseInt(tamount2.getText());
					tamount2.setText(String.valueOf(amount));
					
					int pri = h1.getunitPrice() + Integer.parseInt(tprice2.getText());
					tprice2.setText(String.valueOf(pri));
					 
				}
				
			}
		});
		
		hansick2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = h2.getName();
				String num = String.valueOf(1);
				String price = String.valueOf(h2.getunitPrice());
				
				String[] row = new String[3];
				 

				
				if(h2.getLeftNum() - ihansick2 == 0) {
					JOptionPane.showMessageDialog(null, h2.getName() + "수량이 부족합니다.", "재고 수량 부족" ,JOptionPane.ERROR_MESSAGE);
					
				} else {
					row[0] = name;
					row[1] = num;
					row[2] = price;
				
					//주문 당 팔린 갯수
					int count = 1;
					ihansick2 += count;
					h2.setSalesNum(ihansick2);
				
					// 팔린 가격
					phansick2 += h2.getunitPrice();
				
					int amount = count + Integer.parseInt(tamount2.getText());
					tamount2.setText(String.valueOf(amount));
				
					int pri = h2.getunitPrice() + Integer.parseInt(tprice2.getText());
					tprice2.setText(String.valueOf(pri));
				 
					model.addRow(row);
				}
				
			}
		});
		
		hansick3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = h3.getName();
				String num = String.valueOf(1);
				String price = String.valueOf(h3.getunitPrice());
				
				String[] row = new String[3];
				
				if(h3.getLeftNum() - ihansick3 == 0) {
					JOptionPane.showMessageDialog(null, h3.getName() + "수량이 부족합니다.", "재고 수량 부족" ,JOptionPane.ERROR_MESSAGE);				
				} else {
					row[0] = name;
					row[1] = num;
					row[2] = price;
				
					//주문 당 팔린 갯수
					int count = 1;
					ihansick3 += 1;
					h3.setSalesNum(ihansick3);
				
					// 팔린 가격
					phansick3 += h3.getunitPrice();
				
					int amount = count + Integer.parseInt(tamount2.getText());
					tamount2.setText(String.valueOf(amount));
				
					int pri = h3.getunitPrice() + Integer.parseInt(tprice2.getText());
					tprice2.setText(String.valueOf(pri));
				 
					model.addRow(row);
				}
				
			}
		});
		
		joongsick1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = j1.getName();
				String num = String.valueOf(1);
				String price = String.valueOf(j1.getunitPrice());
				
				String[] row = new String[3];

				if(j1.getLeftNum() - ijoongsick1 == 0) {
					JOptionPane.showMessageDialog(null, j1.getName() + "수량이 부족합니다.", "재고 수량 부족" ,JOptionPane.ERROR_MESSAGE);
						
				} else {
					row[0] = name;
					row[1] = num;
					row[2] = price;
				
					//주문 당 팔린 갯수
					int count = 1;
					ijoongsick1 += 1;
					j1.setSalesNum(ijoongsick1);
				
					// 팔린 가격
					pjoongsick1 += j1.getunitPrice();
				
					int amount = count + Integer.parseInt(tamount2.getText());
					tamount2.setText(String.valueOf(amount));
				
					int pri = j1.getunitPrice() + Integer.parseInt(tprice2.getText());
					tprice2.setText(String.valueOf(pri));
				
					model.addRow(row);
				}
			}
		});
		
		joongsick2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = j2.getName();
				String num = String.valueOf(1);
				String price = String.valueOf(j2.getunitPrice());
				
				String[] row = new String[3];

				if(j2.getLeftNum() - ijoongsick2 == 0)  {
					JOptionPane.showMessageDialog(null, j2.getName() + "수량이 부족합니다.", "재고 수량 부족" ,JOptionPane.ERROR_MESSAGE);
							
				} else {
					row[0] = name;
					row[1] = num;
					row[2] = price;
				
					//주문 당 팔린 갯수
					int count = 1;
					ijoongsick2 += 1;
					j2.setSalesNum(ijoongsick2);
				
					// 팔린 가격
					pjoongsick2 += j2.getunitPrice();
				 
					model.addRow(row);
				
					int amount = count + Integer.parseInt(tamount2.getText());
					tamount2.setText(String.valueOf(amount));
				
					int pri = j2.getunitPrice() + Integer.parseInt(tprice2.getText());
					tprice2.setText(String.valueOf(pri));
				}
			}
		});
		
		joongsick3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = j3.getName();
				String num = String.valueOf(1);
				String price = String.valueOf(j3.getunitPrice());
				
				String[] row = new String[3];
				 
				if(j3.getLeftNum() - ijoongsick3 == 0) {
					JOptionPane.showMessageDialog(null, j3.getName() + "수량이 부족합니다.", "재고 수량 부족" ,JOptionPane.ERROR_MESSAGE);		
								
				} else {
					row[0] = name;
					row[1] = num;
					row[2] = price;
				
					//주문 당 팔린 갯수
					int count = 1;
					ijoongsick3 += 1;
					j3.setSalesNum(ijoongsick3);
				
					// 팔린 가격
					pjoongsick3 += j3.getunitPrice();
				 
					model.addRow(row);
				
					int amount = count + Integer.parseInt(tamount2.getText());
					tamount2.setText(String.valueOf(amount));
				
					int pri = j3.getunitPrice() + Integer.parseInt(tprice2.getText());
					tprice2.setText(String.valueOf(pri));		
								
				}
			}
		});
		
		// 인원 수 체크
		ItemListener listener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(people1.isSelected())
					peoplenum = 1;
				else if(people2.isSelected())
					peoplenum = 2;
				else if(people3.isSelected())
					peoplenum = 3;
				else peoplenum = 4;
			}
			
		};
		
		people1.addItemListener(listener);
		people2.addItemListener(listener);
		people3.addItemListener(listener);
		people4.addItemListener(listener);
		
		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String list = "메뉴 이름     주문 수량    합계 \n";
				String h11, h22, h33, j11, j22, j33;
			
					h11 = h1.getName() + "              " + ihansick1 + "          " + phansick1 + "\n";
					h22 = h2.getName() + "                  " + ihansick2 + "          " + phansick2 + "\n";
					h33 = h3.getName() + "              " + ihansick3 + "          " + phansick3 + "\n";
					j11 = j1.getName() + "              " + ijoongsick1 + "          " + pjoongsick1 + "\n";
					j22 = j2.getName() + "                  " + ijoongsick2 + "          " + pjoongsick2 + "\n";
					j33 = j3.getName() + "          " + ijoongsick3 + "          " + pjoongsick3 + "\n";
				 
				String s = "주문한 총 수량 :  " + Integer.parseInt(tamount2.getText()) + "개 \n" + 
						   "주문한 총 액수 : " + Integer.parseInt(tprice2.getText()) + "원\n";
				
				String ss = "결제할 인원 수 :  " + peoplenum + "명\n";
				
				String[] answer = {"계산 진행", "되돌아가기"};
				
				if(peoplenum == 1) {
				int divprice = Integer.parseInt(tprice2.getText()) / 1;
				
				int ans = JOptionPane.showOptionDialog(null, list + h11 + h22 + h33 + j11 + j22 + j33 + ss + s, "주문 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]); 
				if(ans == JOptionPane.CLOSED_OPTION) {
					
				} else if(ans == JOptionPane.YES_OPTION) {
					String[] stars = {"★", "★★", "★★★", "★★★★", "★★★★★"};
					String star = (String)JOptionPane.showInputDialog(null, "별점을 입력 해 주세요", "별점", JOptionPane.QUESTION_MESSAGE, null ,stars, stars[0]);
					
//					actionInven();
					
					DBordercheck db = new DBordercheck();
						try {
							db.orderInsert(id, h1, h2, h3, j1, j2, j3, Integer.parseInt(tprice2.getText()), divprice, peoplenum, star);
						} catch (NumberFormatException e1) {
							System.out.println("주문 추가 실패!!");
						} catch (ClassNotFoundException e1) {
							System.out.println("주문 추가 실패!!");
						} 
					JOptionPane.showMessageDialog(null, "결제 완료!!", null ,JOptionPane.INFORMATION_MESSAGE);
					
					ihansick1 = 0;
					ihansick2 = 0;
					ihansick3 = 0;
					
					ijoongsick1 = 0;
					ijoongsick2 = 0;
					ijoongsick3 = 0;
					
					phansick1 = 0;
					phansick2 = 0;
					phansick3 = 0;
					
					pjoongsick1 = 0;
					pjoongsick2 = 0;
					pjoongsick3 = 0;					
					
					tprice2.setText(String.valueOf(0));
					tamount2.setText(String.valueOf(0));
					setId();
					ordernum2.setText(String.valueOf(getId()));
					
					h1.setSalesNum(0);
					h2.setSalesNum(0);
					h3.setSalesNum(0);
					
					j1.setSalesNum(0);
					j2.setSalesNum(0);
					j3.setSalesNum(0);
					
					people1.setSelected(false);
					people2.setSelected(false);
					people3.setSelected(false);
					people4.setSelected(false);
					
					model.setRowCount(0);
					
				} else {
					
				}
				// 인원 수가 2명일 때
				} else if(peoplenum == 2){
					int divprice = Integer.parseInt(tprice2.getText()) / 2;
					
					int ans = JOptionPane.showOptionDialog(null, list + h11 + h22 + h33 + j11 + j22 + j33 + s + ss, "주문 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]); 
					
					if(ans == JOptionPane.CLOSED_OPTION) {
						
					} else if(ans == JOptionPane.YES_OPTION) {
						String[] next = { "결제", "취소"};
						
						String message2 = "1인 당 가격은 " + divprice + "입니다.";
						int result2 = JOptionPane.showOptionDialog(null, message2 , "주문 확인",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]); 
						
						if(result2 == JOptionPane.YES_OPTION) {
							String[] next2 = { "완료", "취소"};
							
							String message21 = "1인 당 가격은 " + divprice + "입니다.";
							int result21 = JOptionPane.showOptionDialog(null, message2 , "주문 확인",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next2, next2[0]); 
							
							if(result21 == JOptionPane.YES_OPTION) {
								JOptionPane.showMessageDialog(null, "결제 완료!!", null ,JOptionPane.INFORMATION_MESSAGE);
								String[] stars = {"★", "★★", "★★★", "★★★★", "★★★★★"};
								String star = (String)JOptionPane.showInputDialog(null, "별점을 입력 해 주세요", "별점", JOptionPane.QUESTION_MESSAGE, null ,stars, stars[0]);
								//DB에 저장하는 코드 작성
								try {
									actionInven();
								} catch (ClassNotFoundException e2) {
									System.out.println("재고 저장 실패!!");
								}
								
								DBordercheck db = new DBordercheck();
								try {
									db.orderInsert(id, h1, h2, h3, j1, j2, j3, Integer.parseInt(tprice2.getText()), divprice, peoplenum, star);
								} catch (NumberFormatException | ClassNotFoundException e1) {
									System.out.println("데이터 추가 실패!!");
								}
								
								ihansick1 = 0;
								ihansick2 = 0;
								ihansick3 = 0;
								
								ijoongsick1 = 0;
								ijoongsick2 = 0;
								ijoongsick3 = 0;
								
								phansick1 = 0;
								phansick2 = 0;
								phansick3 = 0;
								
								pjoongsick1 = 0;
								pjoongsick2 = 0;
								pjoongsick3 = 0;					
								
								tprice2.setText(String.valueOf(0));
								tamount2.setText(String.valueOf(0));
								setId();
								ordernum2.setText(String.valueOf(getId()));
								
								h1.setSalesNum(0);
								h2.setSalesNum(0);
								h3.setSalesNum(0);
								
								j1.setSalesNum(0);
								j2.setSalesNum(0);
								j3.setSalesNum(0);
								
								people1.setSelected(false);
								people2.setSelected(false);
								people3.setSelected(false);
								people4.setSelected(false);

								model.setRowCount(0);
								
							} else {
								JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null ,JOptionPane.ERROR_MESSAGE);
							}
							
						} else {
							JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null , JOptionPane.ERROR_MESSAGE);
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null , JOptionPane.ERROR_MESSAGE);
					}
				
				  //인원 수가 3일 때
				}
				
				else if(peoplenum == 3) {
					int divprice =(int)Math.ceil((Double.parseDouble(tprice2.getText()) / 3));
					
					int ans = JOptionPane.showOptionDialog(null, list + h11 + h22 + h33 + j11 + j22 + j33 + s + ss, "주문 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]); 
					
					if(ans == JOptionPane.CLOSED_OPTION) {
						
					} else if(ans == JOptionPane.YES_OPTION) {
						String[] next = { "결제", "취소"};
						
						String message3 = "1인 당 가격은 " + divprice + "입니다.";
						int result3 = JOptionPane.showOptionDialog(null, message3 , "주문 확인",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]); 
						
						if(result3 == JOptionPane.YES_OPTION) {
							
							String message31 = "1인 당 가격은 " + divprice + "입니다.";
							int result32 = JOptionPane.showOptionDialog(null, message31 , "주문 확인",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]); 
							
							if(result32 == JOptionPane.YES_OPTION) {
								
								String[] next3 = { "결제완료", "취소"};
								
								String message32 = "1인 당 가격은 " + divprice + "입니다.";
								
								int result33 = JOptionPane.showOptionDialog(null, message32 , "주문 확인",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next3[0]); 
								
								if(result33 == JOptionPane.YES_OPTION) {
									JOptionPane.showMessageDialog(null, "결제 완료!!", null ,JOptionPane.INFORMATION_MESSAGE);
									String[] stars = {"★", "★★", "★★★", "★★★★", "★★★★★"};
									String star = (String)JOptionPane.showInputDialog(null, "별점을 입력 해 주세요", "별점", JOptionPane.QUESTION_MESSAGE, null ,stars, stars[0]);
									
									try {
										actionInven();
									} catch (ClassNotFoundException e1) {
										System.out.println("재고 오류!!");
									}
									
									DBordercheck db = new DBordercheck();
									try {
										db.orderInsert(id, h1, h2, h3, j1, j2, j3, Integer.parseInt(tprice2.getText()), divprice, peoplenum, star);
									} catch (NumberFormatException e1) {
										System.out.println("데이터 추가 실패!!");
									} catch (ClassNotFoundException e1) {
										System.out.println("데이터 추가 실패!!");
									}
									
									ihansick1 = 0;
									ihansick2 = 0;
									ihansick3 = 0;
									
									ijoongsick1 = 0;
									ijoongsick2 = 0;
									ijoongsick3 = 0;
									
									phansick1 = 0;
									phansick2 = 0;
									phansick3 = 0;
									
									pjoongsick1 = 0;
									pjoongsick2 = 0;
									pjoongsick3 = 0;	
									
									h1.setSalesNum(0);
									h2.setSalesNum(0);
									h3.setSalesNum(0);
									
									j1.setSalesNum(0);
									j2.setSalesNum(0);
									j3.setSalesNum(0);
									
									tprice2.setText(String.valueOf(0));
									tamount2.setText(String.valueOf(0));
									setId();
									ordernum2.setText(String.valueOf(getId()));
									
									model.setRowCount(0);
									
								} else {
									JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null ,JOptionPane.ERROR_MESSAGE);
								}
								
							} else {
								JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null ,JOptionPane.ERROR_MESSAGE);
							}
							
						} else {
							JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null , JOptionPane.ERROR_MESSAGE);
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null , JOptionPane.ERROR_MESSAGE);
					}
					
				} else if(peoplenum == 4) {
					int divprice = Integer.parseInt(tprice2.getText()) / 4;
					
					int ans = JOptionPane.showOptionDialog(null, list + h11 + h22 + h33 + j11 + j22 + j33 + s + ss, "주문 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer[0]); 
					
					if(ans == JOptionPane.CLOSED_OPTION) {
						
					} else if(ans == JOptionPane.YES_OPTION) {
						String[] next = { "결제", "취소"};
						
						String message4 = "1인 당 가격은 " + divprice + "입니다.";
						
						int result4 = JOptionPane.showOptionDialog(null, message4 , "주문 확인",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]); 
						
						if(result4 == JOptionPane.YES_OPTION) {
							
							int result42 = JOptionPane.showOptionDialog(null, message4 , "주문 확인",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]); 
							
							if(result42 == JOptionPane.YES_OPTION) {
								
								int result44 = JOptionPane.showOptionDialog(null, message4 , "주문 확인",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next[0]); 
								
								if(result44 == JOptionPane.YES_OPTION) {
									String[] next4 = {"결제완료", "취소"};
									
									int result45 = JOptionPane.showOptionDialog(null, message4 , "주문 확인",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, next, next4[0]); 
									
									if(result45 == JOptionPane.YES_OPTION) {
									JOptionPane.showMessageDialog(null, "결제 완료!!", null ,JOptionPane.INFORMATION_MESSAGE);
									String[] stars = {"★", "★★", "★★★", "★★★★", "★★★★★"};
									String star = (String)JOptionPane.showInputDialog(null, "별점을 입력 해 주세요", "별점", JOptionPane.QUESTION_MESSAGE, null ,stars, stars[0]);
									
									try {
										actionInven();
									} catch (ClassNotFoundException e1) {
										System.out.println("재고 저장 실패!!");
									}
									
									DBordercheck db = new DBordercheck();
									try {
										db.orderInsert(id, h1, h2, h3, j1, j2, j3, Integer.parseInt(tprice2.getText()), divprice, peoplenum, star);
									} catch (NumberFormatException e1) {
										System.out.println("데이터 추가 실패!!");
									} catch (ClassNotFoundException e1) {
										System.out.println("데이터 추가 실패!!");
									}
									
									ihansick1 = 0;
									ihansick2 = 0;
									ihansick3 = 0;
									
									ijoongsick1 = 0;
									ijoongsick2 = 0;
									ijoongsick3 = 0;
									
									phansick1 = 0;
									phansick2 = 0;
									phansick3 = 0;
									
									pjoongsick1 = 0;
									pjoongsick2 = 0;
									pjoongsick3 = 0;					
									
									tprice2.setText(String.valueOf(0));
									tamount2.setText(String.valueOf(0));
									setId();
									ordernum2.setText(String.valueOf(getId()));
									
									h1.setSalesNum(0);
									h2.setSalesNum(0);
									h3.setSalesNum(0);
									
									j1.setSalesNum(0);
									j2.setSalesNum(0);
									j3.setSalesNum(0);
									
									model.setRowCount(0);
									
									} else { 
										JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null ,JOptionPane.ERROR_MESSAGE);
									}
									
								} else {
									JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null ,JOptionPane.ERROR_MESSAGE);
								}
								
							} else {
								JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null ,JOptionPane.ERROR_MESSAGE);
							}
							
						} else {
							JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null , JOptionPane.ERROR_MESSAGE);
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "결제에 실패했습니다.", null , JOptionPane.ERROR_MESSAGE);
					}	
					
				} else {
					JOptionPane.showMessageDialog(null, "인원 수를 선택하세요.", null, JOptionPane.ERROR_MESSAGE);
				} 
			}
								
		});
		
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				ihansick1 = 0;
				ihansick2 = 0;
				ihansick3 = 0;
				
				ijoongsick1 = 0;
				ijoongsick2 = 0;
				ijoongsick3 = 0;
				
				phansick1 = 0;
				phansick2 = 0;
				phansick3 = 0;
				
				pjoongsick1 = 0;
				pjoongsick2 = 0;
				pjoongsick3 = 0;		
				
				model.setRowCount(0);
				
				people1.setSelected(false);
				people2.setSelected(false);
				people3.setSelected(false);
				people4.setSelected(false);
				
				tprice2.setText(String.valueOf(0));
				tamount2.setText(String.valueOf(0));
				
				h1.setSalesNum(0);
				h2.setSalesNum(0);
				h3.setSalesNum(0);
				
				j1.setSalesNum(0);
				j2.setSalesNum(0);
				j3.setSalesNum(0);
			}
			
		});
	
	
	first.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			new Main();
			setVisible(false);
			
		}
	});

	}
	
	public void actionInven() throws ClassNotFoundException {	

		DBinventory in = new DBinventory();	
		
		h1.setLeftNum(ihansick1);
		h2.setLeftNum(ihansick2);
		h3.setLeftNum(ihansick3);

		j1.setLeftNum(ijoongsick1);
		j2.setLeftNum(ijoongsick2);
		j3.setLeftNum(ijoongsick3);
				
		h1.setTsalesNum(ihansick1);
		h2.setTsalesNum(ihansick2);
		h3.setTsalesNum(ihansick3);
				
		j1.setTsalesNum(ijoongsick1);
		j2.setTsalesNum(ijoongsick2);
		j3.setTsalesNum(ijoongsick3);	

		if(getId() == 1) {
	
		in.inventoryInsert(h1);
		in.inventoryInsert(h2);
		in.inventoryInsert(h3);
		
		in.inventoryInsert(j1);
		in.inventoryInsert(j2);
		in.inventoryInsert(j3);
		
		} else {
		
		in.inventoryUpdate(h1);	
		in.inventoryUpdate(h2);	
		in.inventoryUpdate(h3);	
		
		in.inventoryUpdate(j1);	
		in.inventoryUpdate(j2);	
		in.inventoryUpdate(j3);	
	
		}
	}

	public void showframe() {
		 setSize(1000,800);
		 setTitle("오늘 점심뭐먹지? - 주문하기");
		 getContentPane().setBackground(Color.white);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setResizable(false);
		 setVisible(true);
	}

	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId() {
		id++;
	}

}