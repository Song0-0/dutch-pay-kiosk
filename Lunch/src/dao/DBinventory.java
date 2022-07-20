package dao;

import javax.swing.*;

import menu.Hansick;
import menu.Joongsick;

import java.sql.*;

public class DBinventory {
		private String url = "jdbc:mysql://localhost:3306/food?serverTimezone=Asia/Seoul";
		private String user = "root";
		private String pwd = "my1234";
		
		private Connection con = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
	public void inventoryInsert(Hansick h1) {
			String sql = "INSERT INTO inventory(name, remain, sold) VALUES(?,?,?)";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver"); // 6.0 버전 이후
				con = DriverManager.getConnection(url, user, pwd);
				pstmt = con.prepareStatement(sql);
			} catch (SQLException e1) {
				System.out.println("inventory 테이블 sql오류발생");
			} catch (ClassNotFoundException e) {
				System.out.println("inventory 테이블 관련된 클래스 오류 발생");
			}
			
			try {
			pstmt = con.prepareStatement(sql);		
			pstmt.setString(1, h1.getName());
			pstmt.setInt(2, h1.getLeftNum());
			pstmt.setInt(3, h1.getTsalesNum());
			pstmt.execute();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("데이터 추가 실패!");
			} finally {
				try {
					if(pstmt != null)
						pstmt.close();
					if(con != null)
						con.close();
				} catch(Exception e2) {}
			}

		}
	
	public void inventoryInsert(Joongsick j1) throws ClassNotFoundException {
		String sql = "INSERT INTO inventory(name, remain, sold) VALUES(?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
		pstmt = con.prepareStatement(sql);		
		pstmt.setString(1, j1.getName());
		pstmt.setInt(2, j1.getLeftNum());
		pstmt.setInt(3, j1.getTsalesNum());
		pstmt.execute();
		} catch (SQLException e) {
//			System.out.println(e.getMessage());
			System.out.println("inventory 테이블 데이터 추가 실패!");
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch(Exception e2) {}
		}

	}
	
	public void inventoryUpdate(Hansick h1) throws ClassNotFoundException {
		String sql = "UPDATE inventory SET remain = ?, sold = ? where name = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
		pstmt = con.prepareStatement(sql);		
		pstmt.setInt(1, h1.getLeftNum());
		pstmt.setInt(2, h1.getTsalesNum());
		pstmt.setString(3, h1.getName());
		pstmt.execute();
		} catch (SQLException e) {
//			System.out.println(e.getMessage());
			System.out.println("inventory 수정 실패!");
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(con != null)
					con.close();
			} catch(Exception e2) {}
		}
	}
	
	public void inventoryUpdate(Joongsick j1) throws ClassNotFoundException {
		String sql = "UPDATE inventory SET remain = ?, sold = ? where name = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
		pstmt = con.prepareStatement(sql);		
		pstmt.setInt(1, j1.getLeftNum());
		pstmt.setInt(2, j1.getTsalesNum());
		pstmt.setString(3, j1.getName());
		pstmt.execute();
		} catch (SQLException e) {
			System.out.println("inventory 수정 실패!");
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

