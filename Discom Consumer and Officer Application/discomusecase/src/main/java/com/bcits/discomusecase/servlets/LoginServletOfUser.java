package com.bcits.discomusecase.servlets;

import java.io.Console;
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

import com.bcits.discomusecase.bean.ConsumerInfo;

@WebServlet("/loginservletofuser")
public class LoginServletOfUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get the form data
				long  meterNumber= Long.parseLong(req.getParameter("meterNumber"));
				String password = req.getParameter("password");

				EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");
				EntityManager manager = factory.createEntityManager();

				String jpql = "from ConsumerInfo where meterNumber=:ed and password=:pd";
				Query query = manager.createQuery(jpql);
				query.setParameter("ed", meterNumber);
				query.setParameter("pd", password);
				ConsumerInfo consumerInfo=null;
				try {
					 consumerInfo=(ConsumerInfo) query.getSingleResult();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(consumerInfo!=null) {
					//valid details
					HttpSession session=req.getSession(true);
					session.setAttribute("consumerinfo", consumerInfo);
					req.getRequestDispatcher("/Home.html").forward(req, resp);;
				}else {
					//invalid details
					req.setAttribute("invalid", "invalid meterno / password");
					req.getRequestDispatcher("/ConsumerLogin.jsp").forward(req, resp);
				}

	}
}
