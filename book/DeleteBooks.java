package com.chainsys.book;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
//@WebServlet("/DeleteBooks")  
public class DeleteBooks extends HttpServlet { 
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String sid=request.getParameter("BOOK_ID");  
        int bookId=Integer.parseInt(sid);  
       BooksDao.delete(bookId);
        response.sendRedirect("BookList");  
    }  
}  