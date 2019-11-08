package com.drmodi.j2e.jms.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drmodi.j2e.jms.MyMessageProducer;

@WebServlet(urlPatterns = "/getMessage")
public class MyServlet extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	
	@EJB
	MyMessageProducer producer;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = "Hello Message from J2EE server usnig JMS!!";
		producer.sendMessage(message);
		resp.getWriter().write("Published the message @ Servlet: "+message);
	}
	

}
