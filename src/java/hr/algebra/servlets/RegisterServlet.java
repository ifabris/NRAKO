/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.servlets;

import hr.algebra.dal.sql.DataSourceSingleton;
import hr.algebra.dal.sql.UserDao;
import hr.algebra.model.PackageFactory;
import hr.algebra.model.UserPackage;
import hr.algebra.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

     
    static public String username;
    static public String password;
    static public String email;
    static public String first_name;
    static public String last_name;
    static public int id;
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         username = request.getParameter("username");
         password = request.getParameter("password");
         email = request.getParameter("email");
      //   first_name = request.getParameter("firstName");
     //    last_name = request.getParameter("lastName");
         UserPackage userPackage = PackageFactory.getPackage("FREE");
        try {
            DataSource ds = DataSourceSingleton.getInstance();
        Connection con = ds.getConnection();
        User user = new User(username, password, email, userPackage);
            UserDao udao = new UserDao(con);
            udao.userRegister(username, password, email,2, userPackage);
            PreparedStatement stmt = null;
            String sql = "SELECT _User.UserID FROM _User WHERE _User.Email = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery(); 
            if(rs.next()){
                 id = rs.getInt("UserID");
            }
            
            String query = "EXEC AddUserInfo '" + username + "' , " + id + " , '" +email + "' ;";
            Statement statement = con.createStatement();
            ResultSet rs2 = statement.executeQuery(query);  
            
            response.sendRedirect("LoginUser.html");
        }       
         catch (SQLException ex) {
            response.sendRedirect("LoginUser.html");
        }

     
    }

}
