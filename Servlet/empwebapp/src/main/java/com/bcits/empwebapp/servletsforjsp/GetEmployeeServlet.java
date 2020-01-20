package com.bcits.empwebapp.servletsforjsp;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;
@WebServlet("/getEmp")
public class GetEmployeeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// get the form data
		String empvalId=req.getParameter("empId");
		int empId=Integer.parseInt(empvalId);
		//search record in db
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("employee");
		EntityManager manager=emf.createEntityManager();
		
		EmployeePrimaryInfo employeePrimaryInfo=manager.find(EmployeePrimaryInfo.class, empId);
		
		//send data to jsp
		req.setAttribute("empInfo", employeePrimaryInfo);
		
		manager.close();
		emf.close();
		
		req.getRequestDispatcher("./searchEmployee.jsp").forward(req, resp);
	}//end of doGet()
}//end of main
