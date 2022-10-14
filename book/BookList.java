package com.chainsys.book;


import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
//@WebServlet("/BookList")  
public class BookList extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        
        out.println("<a href='books.html'>Add New Books</a>");  
        out.println("<h1>Book List</h1>");  
          
        List<Book> list=BooksDao.getAllBooks();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>BookId</th><th>BookName</th><th>Author</th><th>PublishingYear</th><th>Price</th><th>Update</th><th>Delete</th></tr>");  
  
        for(Book e:list){  
            out.print("<tr><td>"+e.getBookId()+"</td><td>"+e.getBookName()+"</td><td>"+e.getAuthor()+"</td><td>"+e.getPublishingYear()+"</td><td>"+e.getPrice()+"</td><td><a href='UpdateBookServlet?BOOK_ID="+e.getBookId()+"'>Update</a></td><td><a href='DeleteBooks?BOOK_ID="+e.getBookId()+"'>delete</a></td></tr>");  
           }  
        
        out.print("</table>");  
          
        out.close();  
    }  
}  