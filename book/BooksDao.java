package com.chainsys.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BooksDao {
	
	 public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshacsys18");  
	        }catch(Exception e){
	        	System.out.println(e);
	        	}  
	        return con;  
	    }  
//Insert	 
	 public static int save(Book e){  
	        int status=0;  
	        try{  
	            Connection con=BooksDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("Insert into BOOK(BOOK_ID,BOOK_NAME,AUTHOR,PUBLISHING_YEAR,PRICE)values(?,?,?,?,?)");  
	            ps.setInt(1, e.getBookId());
	            ps.setString(2,e.getBookName()); 
	            ps.setString(3,e.getAuthor());  
	            ps.setString(4,e.getPublishingYear()); 
	            ps.setInt(5,e.getPrice());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        	}  
	          
	        return status;  
	    }  
	 
//Update 
	 public static int update(Book e){  
	        int status=0;  
	        try{  
	            Connection con=BooksDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	            		"update BOOK set BOOK_ID=?,BOOK_NAME=?,AUTHOR=?,PUBLISHING_YEAR=?,PRICE=? where BOOK_ID=?");  
	            
	            ps.setString(1,e.getBookName()); 
	            ps.setString(2,e.getAuthor());  
	            ps.setString(3,e.getPublishingYear());  
	            ps.setInt(4,e.getPrice()); 
	            ps.setInt(5, e.getBookId());
	            
	            status=ps.executeUpdate(); 
	            
	            con.close();  
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        	}  
	          
	        return status;  
	    }  
	 
//Delete
	  public static int delete(int bookId){  
	        int status=0;  
	        try{  
	            Connection con=BooksDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("Delete from BOOK where BOOK_ID=?");  
	            ps.setInt(1,bookId);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){
	        	e.printStackTrace();
	        	}  
	          
	        return status;  
	    }  
//List 
	  public static List<Book> getAllBooks(){  
	        List<Book> list=new ArrayList<Book>();  
	          
	        try{  
	            Connection con=BooksDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("SELECT BOOK_ID,BOOK_NAME,AUTHOR,PRICE,PUBLISHING_YEAR FROM BOOK");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	            	Book e=new Book();  
	                e.setBookId(rs.getInt(1));  
	                e.setBookName(rs.getString(2)); 
	                e.setAuthor(rs.getString(3));  
	                e.setPublishingYear(rs.getString(4)); 
	                e.setPrice(rs.getInt(5));
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){
	        	e.printStackTrace();
	        	}  
	         return list;  
	    } 
//Find By Id	  
	  public static Book getBookById(int bookId){  
		  Book e=new Book();  
	          
	        try{  
	            Connection con=BooksDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("SELECT BOOK_ID,BOOK_NAME,AUTHOR,PUBLISHING_YEAR,PRICE FROM BOOK where BOOK_ID=?");  
	            ps.setInt(1,bookId);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	            	e.setBookId(rs.getInt(1));  
	                e.setBookName(rs.getString(2)); 
	                e.setAuthor(rs.getString(3));  
	                e.setPublishingYear(rs.getString(4)); 
	                e.setPrice(rs.getInt(5)); 
	            }  
	            con.close();  
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        	}       
	        return e;  
	    }  
}
