package com.chainsys.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
	private static Connection getconnection() {
        Connection con = null;
        String drivername="oracle.jdbc.OracleDriver";
        String dburl="jdbc:oracle:thin:@localhost:1521:xe";
        String user="system";
        String password="akshacsys18";
        try {
            Class.forName(drivername);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(dburl,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
	public static LoginSession getLoginSession(String userName, String password) {
        Connection mycon = getconnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        LoginSession app=null;
        try {
            pstmt = mycon.prepareStatement("select user_name,password from registration where user_name=? and password=? ");
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            app=new LoginSession();
            if(rs.next()) {
                app.setUserName(rs.getString(1));
                app.setPassword(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                mycon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return app;
    }

}


