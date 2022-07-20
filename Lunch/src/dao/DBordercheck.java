package dao;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

import menu.Hansick;
import menu.Hansick1;
import menu.Hansick2;
import menu.Hansick3;
import menu.Joongsick;
import menu.Joongsick1;
import menu.Joongsick2;
import menu.Joongsick3;

import javax.swing.JFrame;

public class DBordercheck {
	
	private String url = "jdbc:mysql://localhost:3306/food?serverTimezone=Asia/Seoul";
	private String user = "root";
	private String pwd = "my1234";
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public void orderInsert(int num, Hansick h1, Hansick h2, Hansick h3, Joongsick j1, Joongsick j2, Joongsick j3, int tprice, int divprice, int people, String star) throws ClassNotFoundException {
		String sql = "INSERT INTO ordercheck(num,hansick1,hansick2,hansick3,joongsick1,joongsick2,joongsick3,tprice,tpeople,people,star) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e1) {
			System.out.println("ordercheck 테이블 sql문 오류 발생!");
		}
		
		try {
		pstmt = con.prepareStatement(sql);		
		pstmt.setInt(1, num);
		pstmt.setInt(2, h1.getSalesNum());
		pstmt.setInt(3, h2.getSalesNum());
		pstmt.setInt(4, h3.getSalesNum());
		pstmt.setInt(5, j1.getSalesNum());
		pstmt.setInt(6, j2.getSalesNum());
		pstmt.setInt(7, j3.getSalesNum());
		pstmt.setInt(8, tprice);
		pstmt.setDouble(9, divprice);
		pstmt.setInt(10, people);
		pstmt.setString(11, star);
		pstmt.execute();
		System.out.println("orderTable 데이터 추가 성공!");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "!");
			System.out.println("orderTable 데이터 추가 실패!!");
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch(Exception e2) {}
		}

	}
	
	
	
}

