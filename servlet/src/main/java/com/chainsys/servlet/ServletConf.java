package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;  


/**
 * Servlet implementation class ServletConfig
 */
public class ServletConf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConf() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out = response.getWriter();  
	      
		    ServletConfig config=getServletConfig();  
		    String phone=config.getInitParameter("phone");  
		    out.println("phone no is: "+phone); 
		    out.println();
		    ServletContext context=getServletContext();  
			String driverName=context.getInitParameter("name");  
			out.println("name is="+driverName);  
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
}
