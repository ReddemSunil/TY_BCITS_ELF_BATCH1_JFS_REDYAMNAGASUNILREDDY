package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/retrieveEmployeeServlet")
public class RetrieveEmployeeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		String jpql = "from EmployeePrimaryInfo";
		Query query = manager.createQuery(jpql);
		List<EmployeePrimaryInfo> list = query.getResultList();
		for (EmployeePrimaryInfo employeePrimaryInfo : list) {
			PrintWriter out = resp.getWriter();

			out.println("<html>");
			out.println("<body>");
			out.println("<br>empid-->" + employeePrimaryInfo.getEmpId());
			out.println("<br>bloodgroup-->" + employeePrimaryInfo.getBloodGroup());
			out.println("<br>deptid-->" + employeePrimaryInfo.getDeptid());
			out.println("<br>designation-->" + employeePrimaryInfo.getDesignation());
			out.println("<br>mangerid-->" + employeePrimaryInfo.getManagerId());
			out.println("<br>mobileno-->" + employeePrimaryInfo.getMobileno());
			out.println("<br>name-->" + employeePrimaryInfo.getName());
			out.println("<br>mail-->" + employeePrimaryInfo.getOfficialMail());
			out.println("<br>salary-->" + employeePrimaryInfo.getSalary());
			out.println("<br>date of birth-->" + employeePrimaryInfo.getDateOfBirth());
			out.println("<br>date of joining-->" + employeePrimaryInfo.getDateOfJoining());
			out.println("<br>-------------------------------------");
			out.println("</body>");
			out.println("</html>");
			
		}
	
	
	}

}
