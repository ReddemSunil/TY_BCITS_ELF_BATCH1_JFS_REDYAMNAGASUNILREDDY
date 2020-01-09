package com.bcits.jdbcap.preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteEmployee {
public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			//1.load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.get the db connection via driver
			String url = "jdbc:mysql://localhost:3306/employee_management";
			con=DriverManager.getConnection(url,"root","root");
			
			//3.issue the sql query via db connection
			String qry="delete from employee_primary_info where empid=?";
			pstmt=con.prepareStatement(qry);
			pstmt.setInt(1, Integer.parseInt(args[0]));
			
			int n=pstmt.executeUpdate();
			
			//4.process the sql query
			System.out.println(n+" rows are deleted");
			
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
}
