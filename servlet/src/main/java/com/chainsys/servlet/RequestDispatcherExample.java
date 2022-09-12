package com.chainsys.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class RequestDispatcher
 */
//@WebServlet("RequestDispatcherExample")
public class RequestDispatcherExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDispatcherExample() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		out.println("This is request dispatcher");
//		RequestDispatcher rd=request.getRequestDispatcher("RequestForward");
//		rd.forward(request, response);
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(true);
		String option = request.getParameter("submit");
		System.out.println("id: "+session.getId());
        if(option.equals("logout")){
            session.invalidate();
            return;
        }
		String userName = request.getParameter("username");
        String password = request.getParameter("password");
		LoginSession login = LoginDao.getLoginSession(userName,password);
		
		session.setAttribute("username", login.getUserName());
		session.setAttribute("password", login.getPassword());
		PrintWriter out = response.getWriter();
		out.println("This is request dispatcher");
		RequestDispatcher rd=request.getRequestDispatcher("RequestForward");
		rd.forward(request, response);
      }
	
	}


