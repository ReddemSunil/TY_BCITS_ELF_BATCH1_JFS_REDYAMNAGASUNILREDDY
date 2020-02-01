package com.bcits.discomusecase.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.discomusecase.bean.ConsumerInfo;

@WebServlet("/signinservlet")
public class SignInServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName= req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String meterNumber=req.getParameter("meterNumber");
		long contactNumber=Long.parseLong(req.getParameter("contactNumber"));
		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		String region=req.getParameter("region");
		String typeOfConsumer=req.getParameter("typeOfConsumer");
		String address1=req.getParameter("address1");
		String address2=req.getParameter("address2");
		int pincode=Integer.parseInt(req.getParameter("pincode"));
		
		ConsumerInfo consumerInfo=new ConsumerInfo();
		consumerInfo.setAddress1(address1);
		consumerInfo.setAddress2(address2);
		consumerInfo.setContactNumber(contactNumber);
		consumerInfo.setFirstName(firstName);
		consumerInfo.setLastName(lastName);
		consumerInfo.setMail(mail);
		consumerInfo.setRrNumber(meterNumber);
		consumerInfo.setPassword(password);
		consumerInfo.setPincode(pincode);
		consumerInfo.setRegion(region);
		consumerInfo.setTypeOfConsumer(typeOfConsumer);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		boolean isAdd = false;
		try {
			transaction.begin();
			manager.persist(consumerInfo);
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
			out.println("<h1 style='color:green'>Successfully signed By using meterno :- " + meterNumber + " </h1>");
		} else {
			out.println("<h1 style='color:red'>signin failed try again</h1>");
		}
		out.println("</body>");
		out.println("</html>");
		
		req.getRequestDispatcher("./ConsumerLogin.jsp").include(req, resp);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
