package com.bcits.JDBCApp.connection;

public class MainMethodClass {
	public static void main(String[] args) {
		String str="one";
		Connection con=DriverManager.getConnection(str);
		con.toString();
		con.print();
				
	}
}
