package com.bcits.empwebapp.servlets;

import java.io.EOFException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;
@WebServlet("/getEmployee")
public class GetEmployeeServlet extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//validate the session
			HttpSession session=req.getSession(false);
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			if (session!=null) {
				//valid session
				// get the form data
				
				String empvalId=req.getParameter("empId");
				int empId=Integer.parseInt(empvalId);
				
				EntityManagerFactory emf=Persistence.createEntityManagerFactory("employee");
				EntityManager manager=emf.createEntityManager();
				
				EmployeePrimaryInfo employeePrimaryInfo=manager.find(EmployeePrimaryInfo.class, empId);
				
				
				if(employeePrimaryInfo!=null) {
					
					EmployeePrimaryInfo epf=(EmployeePrimaryInfo)session.getAttribute("ePrimaryInfo");
					
					out.println("<html>");
					out.println("<body>");
					
					out.println("<h1> Hello "+epf.getName()+"</h1>");
					
					out.println("<a href='./employeeHome.html'>Home</a>");
					out.println("<h1 style='color:green'>Employee ID"+empId+"found</h1>");
					out.println("<br>name ="+employeePrimaryInfo.getName());
					out.println("<br>designation ="+employeePrimaryInfo.getDesignation());
					out.println("<br>mobileno ="+employeePrimaryInfo.getMobileno());
					out.println("</body>");
					out.println("</html>");
					
				}else {
					out.println("<html>");
					out.println("<body>");
					out.println("<h1 style='color:green'>Employee ID"+empId+"Not found</h1>");
					out.println("</body>");
					out.println("</html>");
				}
				
				manager.close();
				emf.close();
				
			} else {
				//invalid session
				out.println("<html>");
				out.println("<body>");
				out.println("<h1 style='color:red'>please login first</h1>");
				req.getRequestDispatcher("./LoginForm.html").include(req, resp);
				out.println("</body>");
				out.println("</html>");
			}
			
			
		
		}
}
