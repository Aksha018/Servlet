package com.chainsys.book;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
//@WebServlet("/UpdateBooks")  
public class UpdateBooks extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html"); 
        PrintWriter out=response.getWriter();  
          
        String bookId = request.getParameter("BOOK_ID");
        int bookId1 = Integer.parseInt(bookId);
         String bookName=request.getParameter("BOOK_NAME");  
         String author=request.getParameter("AUTHOR");  
         String publishingYear=request.getParameter("PUBLISHING_YEAR");  
         String price = request.getParameter("PRICE");
         int price1 = Integer.parseInt(price);
 
         Book e=new Book();
         
         e.setBookId(bookId1);
         e.setBookName(bookName);  
         e.setAuthor(author);  
         e.setPublishingYear(publishingYear);  
         e.setPrice(price1);  
           
        int status=BooksDao.update(e);  
        if(status>0){  
            response.sendRedirect("BookList");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}