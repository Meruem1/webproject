package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reg
 */
@WebServlet("/reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		    String fname=request.getParameter("fname");
		    String lname=request.getParameter("lname");
		    String emailid=request.getParameter("emailid");
		    String phone=request.getParameter("phone");
		    String username=request.getParameter("username");
		    String password=request.getParameter("password");
		    
		    
		    
		    if(fname.isBlank()==false&& lname.isBlank()==false&& emailid.isBlank()==false && phone.isBlank()==false && username.isBlank()==false && password.isBlank()==false)
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
		int i=st.executeUpdate("insert into cake values('"+fname+"','"+lname+"','"+emailid+"','"+phone+"','"+username+"','"+password+"')");

		System.out.println ("database successfully opened.");
		 response.sendRedirect("reg1.jsp");
		
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
