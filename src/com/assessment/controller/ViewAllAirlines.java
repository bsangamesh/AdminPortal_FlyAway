package com.assessment.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.assessment.model.Flight;
import com.assessment.util.HibernateUtil;

@WebServlet("/viewAllAirlines")
public class ViewAllAirlines extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Flight> flights = session.createQuery("from Flight").list();
		transaction.commit();
		req.setAttribute("flights", flights);
		req.getRequestDispatcher("showAllAirlines.jsp").forward(req, resp);
		
	}
}
