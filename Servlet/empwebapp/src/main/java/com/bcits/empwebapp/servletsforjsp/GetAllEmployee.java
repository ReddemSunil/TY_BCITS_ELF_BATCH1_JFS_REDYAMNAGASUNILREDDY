package com.bcits.empwebapp.servletsforjsp;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;
@WebServlet("/seeAllEmployees")
public class GetAllEmployee extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		String jpql = "from EmployeePrimaryInfo";
		Query query = manager.createQuery(jpql);
		List<EmployeePrimaryInfo> employeePrimaryInfo = query.getResultList();
		
		req.setAttribute("employeePrimaryInfo", employeePrimaryInfo);
		
		manager.close();
		factory.close();
		
		req.getRequestDispatcher("/SeeAllEmployees.jsp").forward(req, resp);
	
	}
}//end of class
