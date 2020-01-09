package com.bcits.JDBCApp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteEmployeeDetail {

	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		try {
			
			// 1.load the Driver
			
			Class.forName("com.mysql.jdbc.Driver");

			// 2.get db connection via driver
			
			String str = "jdbc:mysql://localhost:3306/employee_management";
			con = DriverManager.getConnection(str, "root", "root");

			// 3.issue sql query via connection
			
			String qry = "delete from employee_primary_info where empid=104";
			stmt = con.createStatement();
			int rs = stmt.executeUpdate(qry);

			// 4.process the sql query
			
			System.out.println(rs + " number of rows affected");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 5.close all JDBC objects

			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} // end of inner try-catch block
		} // end of final
	}// end of main
}// end of class
