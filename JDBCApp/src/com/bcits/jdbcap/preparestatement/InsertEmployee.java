package com.bcits.jdbcap.preparestatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertEmployee {
	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			// 1.load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.get db connection via driver
			String url = "jdbc:mysql://localhost:3306/employee_management";
			con=DriverManager.getConnection(url,"root","root");
			
			// 3.issue sql querie via connection
			String qry="insert into employee_primary_info values(?,?,?,?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			pstmt.setString(2, args[1]);
			pstmt.setLong(3, Long.parseLong(args[2]));
			pstmt.setString(4, args[3]);
			pstmt.setDate(5, Date.valueOf(args[4]));
			pstmt.setDate(6, Date.valueOf(args[5]));
			pstmt.setString(7, args[6]);
			pstmt.setString(8,args[7]);
			pstmt.setDouble(9, Double.parseDouble(args[8]));
			pstmt.setInt(10, Integer.parseInt(args[9]));
			pstmt.setInt(11, Integer.parseInt(args[10]));
			int i=pstmt.executeUpdate();
			
			
			//4.process the sql query
			System.out.println(i+" rows effected");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

			// 5.close all JDBC objects

			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} // end of inner try-catch block
		} // end of final
	}//end of main
}//end of class
