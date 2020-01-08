package com.bcits.JDBCApp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FindEmployee {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			/*
			 * Driver d = new Driver(); DriverManager.registerDriver(d);
			 */
			Class.forName("com.mysql.jdbc.Driver");

//			String url = "jdbc:mysql://localhost :3306/employee_management?user=root&password=root";
//			con = DriverManager.getConnection(url);
			String url = "jdbc:mysql://localhost :3306/employee_management?";
			con = DriverManager.getConnection(url, "root", "root");

			String qry = " select * from employee_primary_info " 
			                + " where empid=101";
			stmt = con.createStatement();
			rs = stmt.executeQuery(qry);

			while (rs.next()) {
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

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
