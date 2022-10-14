package com.chainsys.book;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
//@WebServlet("/UpdateBookServlet")  
public class UpdateBookServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        
    	response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Books</h1>");  
        String sid=request.getParameter("BOOK_ID");  
        int bookId=Integer.parseInt(sid);  
          
        Book e= BooksDao.getBookById(bookId);  
          
        out.print("<form action='UpdateBooks' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td>BookId:</td><td><input type='hidden' name='bookId' value='"+e.getBookId()+"'/></td></tr>");  
        out.print("<tr><td>BookName:</td><td><input type='text' name='bookName' value='"+e.getBookName()+"'/></td></tr>");  
        out.print("<tr><td>Author:</td><td><input type='text' name='author' value='"+e.getAuthor()+"'/></td></tr>");  
        out.print("<tr><td>PublishingYear:</td><td><input type='text' name='publishingYear' value='"+e.getPublishingYear()+"'/></td></tr>"); 
        out.print("<tr><td>Price:</td><td><input type='text' name='price' value='"+e.getPrice()+"'/></td></tr>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  