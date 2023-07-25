/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import hr.algebra.dal.sql.DataSourceSingleton;
import hr.algebra.dal.sql.UserDao;
import hr.algebra.model.User;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    
       static public String username;
    static public String password;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         username = request.getParameter("username");
         password = request.getParameter("password");
        try {
            DataSource ds = DataSourceSingleton.getInstance();
            Connection con = ds.getConnection();
            UserDao udao = new UserDao(con);
            User user = udao.userLogin(username, password);         
            if (user != null) {
				request.getSession().setAttribute("auth", user);
                                System.out.print("user logged in");
				response.sendRedirect("homejsp.jsp");}
        } catch (SQLException ex) {
            response.sendRedirect("LoginUser.html");
        }

     
    }
}
