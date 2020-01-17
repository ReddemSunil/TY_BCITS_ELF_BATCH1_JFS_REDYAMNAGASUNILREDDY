package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String empIdVal = req.getParameter("empId");
		String value = req.getParameter("value");
	
		EntityManager manager = null;
		EntityTransaction transaction = null;
		boolean isAdd = false;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "update EmployeePrimaryInfo set name=:vl where empId=:id";
			Query query = manager.createQuery(jpql);
			query.setParameter("id", Integer.parseInt(empIdVal));
			query.setParameter("vl", value);
			int count = query.executeUpdate();
			System.out.println("no of rows affected " + count);
			transaction.commit();
			isAdd = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		if (isAdd) {
			out.println("<h1 style='color:green'> employee record for id" + empIdVal + "updated </h1>");
		} else {
			out.println("<h1 style='color:red'> unable to update employee record </h1>");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
