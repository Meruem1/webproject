package com.web;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Loginbean;
import com.database.Logindatabase;


@WebServlet("/login")
public class Loginservlet extends HttpServlet {
   // private static final long serialVersionUID = 1 L;
    private Logindatabase Logindatabase;

    public void init() {
    	Logindatabase = new Logindatabase();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Loginbean loginbean = new Loginbean();
        loginbean.setUsername(username);
        loginbean.setPassword(password);
        
        
        

        try {
            if (Logindatabase.validate(loginbean)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                
                
                
                response.setContentType("text/html"); // Setting the content type to text 
                PrintWriter out = response.getWriter(); 
               String n= request.getParameter("username");
                
                HttpSession session = request.getSession(); /* Creating a new session*/
                
                session.setAttribute("uname", n); 
                response.sendRedirect("loginsuccess.jsp");
                
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                //response.sendRedirect("login.jsp");
                response.sendRedirect("error1.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}