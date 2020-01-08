package com.bcits.JDBCApp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 1.load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.get db connection via driver
			String str = "jdbc:mysql://localhost:3306/employee_management";
			con = DriverManager.getConnection(str, "root", "root");

			// 3.issue sql querie via connection
			String query = "select * from employee_primary_info" + "where empid="+args[0];
//			" where empid=?";
			pstmt = con.prepareStatement(query);
//	         pstmt.setInt(1, Integer.parseInt(args[0]));
			rs = pstmt.executeQuery();

			// 4.process the sql query

			if (rs.next()) {
				int employee_id = rs.getInt("empid");
				String name = rs.getString("name");
				long mobileno = rs.getLong("mobileno");
				String officialmail = rs.getString("official_mail");
				Date date_of_birth = rs.getDate("date_of_birth");
				Date date_of_joining = rs.getDate("date_of_joining");
				String designation = rs.getString("designation");
				String bloodgroup = rs.getString("blood_group");
				double salary = rs.getDouble("salary");
				int deptid = rs.getInt("deptid");
				int managerid = rs.getInt("manager_id");

				System.out.println("employee_id = " + employee_id);
				System.out.println("name = " + name);
				System.out.println("mobileno = " + mobileno);
				System.out.println("officialmail = " + officialmail);
				System.out.println("date_of_birth = " + date_of_birth);
				System.out.println("date_of_joining = " + date_of_joining);
				System.out.println("designation = " + designation);
				System.out.println("bloodgroup = " + bloodgroup);
				System.out.println("salary = " + salary);
				System.out.println("deptid = " + deptid);
				System.out.println("managerid = " + managerid);
				System.out.println("--------------------------------------------");
			} else {
				System.err.println("employee data not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			//5.close all JDBC objects
			
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}//end of inner try-catch block
		}//end of final
		
	}//end of main
}//end of class
