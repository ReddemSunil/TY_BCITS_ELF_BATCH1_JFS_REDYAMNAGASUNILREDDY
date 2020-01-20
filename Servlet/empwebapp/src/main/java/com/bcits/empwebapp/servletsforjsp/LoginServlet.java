package com.bcits.empwebapp.servletsforjsp;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/login2")
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
		if (employeePrimaryInfo != null) {
			//valid credentials
			HttpSession session=req.getSession(true);
			session.setAttribute("loggedInfo", employeePrimaryInfo);
			
			req.getRequestDispatcher("./HomePage.jsp").forward(req, resp);
		}else {
			//invalid credentials
			
			req.setAttribute("msg", "invalid employee id / password");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
		
	}
}
