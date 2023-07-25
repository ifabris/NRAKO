/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.servlets;

import hr.algebra.dal.sql.DataSourceSingleton;
import hr.algebra.observer.ActionLogObserver;
import hr.algebra.observer.Logger;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Ivan
 */
@WebServlet("/AddPost")
public class AddPost extends HttpServlet {

  @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String pUserId = request.getParameter("pUserId");
        String pPicture = request.getParameter("pPicture");
        String postDescription = request.getParameter("pDesc");
        Logger logger = new Logger();
        logger.attach(new ActionLogObserver());
        logger.logAction(pUserId, "AddPost");
         try {
            DataSource ds = DataSourceSingleton.getInstance();
            Connection con = ds.getConnection();
            String query = "EXEC AddPost '" + postDescription + "' , " +pUserId+ " , '" +pPicture + "' ;";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);  
                       response.sendRedirect("yourposts.jsp"); 
        } catch (SQLException ex) {
            response.sendRedirect("yourposts.jsp"); 
        }
      
    }

}
