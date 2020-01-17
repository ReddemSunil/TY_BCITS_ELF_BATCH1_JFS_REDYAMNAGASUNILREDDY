package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get the form data
		int empId = Integer.parseInt(req.getParameter("empId"));
		String password = req.getParameter("password");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();

		String jpql = "from EmployeePrimaryInfo where empId=:ed and password=:pd";
		Query query = manager.createQuery(jpql);
		query.setParameter("ed", empId);
		query.setParameter("pd", password);

		EmployeePrimaryInfo employeePrimaryInfo = null;
		try {
			employeePrimaryInfo = (EmployeePrimaryInfo) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (employeePrimaryInfo != null) {
			// valid details
			// create the session
			HttpSession session = req.getSession(true);
			session.setMaxInactiveInterval(30);//used to set max inactive time for session
			session.setAttribute("ePrimaryInfo", employeePrimaryInfo);

			out.println("<h1 style='color:navy'> welcome " + employeePrimaryInfo.getName() + "</h1>");
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("./employeeHome.html");
			dispatcher.include(req, resp);

		} else {
			// invalid details
			out.println("<h1 style='color:red'>invalid credentials!!!</h1>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("./LoginForm.html");
			dispatcher.include(req, resp);
		}

		out.println("</body>");
		out.println("</html>");
		manager.close();
		factory.close();

	}// end of doPost()
}// end of class
