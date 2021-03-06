package com.bridgelabz.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.BankDAO.BankDAO;
import com.bridgelabz.Model.UserDetails;

//@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = ("<br>" + "Your registration is successful...." + "</br>");
		out.println(title);
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirmpassword = req.getParameter("password");
		String number = req.getParameter("mobilenumber");
		UserDetails user = new UserDetails();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setConfirmpassword(confirmpassword);
		user.setMobilenumber(number);
		
		if(BankDAO.saveRegistration(user) > 0)
		{	
			out.print("<p>Record Saved Successfully</p>");
			req.getRequestDispatcher("registrationform.jsp").include(req, resp);		
		}
		else
		{
			out.println("Sorry unable to save record");
		}	
		resp.sendRedirect("login.jsp");
	}

}
