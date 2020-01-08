package com.bcits.JDBCApp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MyFirstjdbcProgram {

	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);

			String dburl = "jdbc:mysql://localhost:3306/employee_management?user=root&password=root";
			con = DriverManager.getConnection(dburl);

			String qry = "select * from employee_primary_info";
			stmt = con.createStatement();
			rs = stmt.executeQuery(qry);

			while (rs.next()) {
				int employeeID = rs.getInt("empid");
				String employeeNM = rs.getString("name");
				long mobileno = rs.getLong("mobileno");
				String official_mail = rs.getString("official_mail");
				Date date_of_birth = rs.getDate("date_of_birth");
				Date date_of_joining = rs.getDate("date_of_joining");
				String designation = rs.getString("designation");
				String blood_group = rs.getString("blood_group");
				Double salary = rs.getDouble("salary");
				int deptid = rs.getInt("deptid");
				int manager_id = rs.getInt("manager_id");

				System.out.println("employeeID ==> " + employeeID);
				System.out.println("employeeNM ==> " + employeeNM);
				System.out.println("mobileno ==> " + mobileno);
				System.out.println("official_mail ==>" + official_mail);
				System.out.println("date_of_birth ==> " + date_of_birth);
				System.out.println("date_of_joining ==> " + date_of_joining);
				System.out.println("designation ==> " + designation);
				System.out.println("blood_group ==> " + blood_group);
				System.out.println("salary ==> " + salary);
				System.out.println("deptid ==> " + deptid);
				System.out.println("manager_id ==> " + manager_id);
				System.out.println("-------------------------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 
//			finally {
//			// 5. close all "jdbc objects"
//			try {
//				if (con != null) {
//					con.close();
//				}
//				if (rs != null) {
//					rs.close();
//				}
//				if (stmt != null) {
//					stmt.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

//		}
	}
}
