package com.database;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Contactbean;
import com.bean.Loginbean;
import com.email.durgesh.Email;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/Contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 
		
		 String fname=request.getParameter("fname");
		 String emailid=request.getParameter("emailid");
	     String phone=request.getParameter("phone");
	     String message=request.getParameter("message");
		    
		    
		    
		    
		    if(fname.isBlank()==false&& emailid.isBlank()==false && phone.isBlank()==false && message.isBlank()==false)
		    {
		    try 
		    {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cake","root","root");  
		//Class.forName("com.mysql.jdbc.Driver");
		//java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/cake","root", "root");
		Statement st=con.createStatement();
		ResultSet rs;
		int i=st.executeUpdate("insert into contact values('"+fname+"','"+emailid+"','"+phone+"','"+message+"')");

		System.out.println ("database successfully opened.");
		
		try {
			Email email= new Email("vishalsmulti3@gmail.com","");
			
			email.setFrom("Thank you","vishalsmulti3@gmail.com");
			
			email.setSubject("Thank you for contacting NOOR DELIGHTS.");
			
			System.out.println("otp generating");
			 
		
			email.setContent("Thank you for contacting us, our supportive will surely give reply in sometime...."
					+ "1.Go to contact.java and you have to put proper mail and password..."
					+ "2.Also turn on less secure app from which email u passing mail..."
					+"Have a great day...", "text/html");

			

			email.addRecipient(emailid);
			email.send();
			
			response.sendRedirect("index1.html");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	
		
		}
		catch(SQLException e) {
		System.out.println("SQLException caught: " +e.getMessage());
		}

		    }
		    else
		    {
		    	
		    	response.sendRedirect("regerror.jsp");
		    }
}
		
		
}
