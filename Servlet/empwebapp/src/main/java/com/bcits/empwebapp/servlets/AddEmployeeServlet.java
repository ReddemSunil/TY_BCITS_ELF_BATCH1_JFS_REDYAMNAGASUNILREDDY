package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get the form data
		String empIdVal = req.getParameter("empId");
		String nameVal = req.getParameter("name");
		String designationVal = req.getParameter("designation");
		String salaryVal = req.getParameter("salary");
		String mobileVal = req.getParameter("mobileno");
		String passwordVal = req.getParameter("password");
		String dateOfJoiningVal = req.getParameter("dateOfJoining");

		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		Date joiningDate=null;
		try {
			joiningDate = dateFormat.parse(dateOfJoiningVal);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		EmployeePrimaryInfo employeePrimaryInfo = new EmployeePrimaryInfo();
		employeePrimaryInfo.setEmpId(Integer.parseInt(empIdVal));
		employeePrimaryInfo.setName(nameVal);
		employeePrimaryInfo.setDesignation(designationVal);
		employeePrimaryInfo.setSalary(Double.parseDouble(salaryVal));
		employeePrimaryInfo.setMobileno(Long.parseLong(mobileVal));
		employeePrimaryInfo.setPassword(passwordVal);
		employeePrimaryInfo.setDateOfJoining(joiningDate);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdd = false;
		try {
			transaction.begin();
			manager.persist(employeePrimaryInfo);
			transaction.commit();
			isAdd = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		factory.close();
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		if (isAdd) {
			out.println("<h1 style='color:green'> employee record for id" + empIdVal + "inserted </h1>");
		} else {
			out.println("<h1 style='color:red'> unable to add employee record </h1>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
