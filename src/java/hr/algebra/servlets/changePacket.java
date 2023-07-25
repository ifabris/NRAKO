/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.servlets;

import hr.algebra.dal.sql.DataSourceSingleton;
import hr.algebra.model.PackageFactory;
import hr.algebra.model.User;
import hr.algebra.model.UserPackage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Ivan
 */
@WebServlet("/changePacket")
public class changePacket extends HttpServlet {

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    String newPackageType = req.getParameter("packet");
    HttpSession session = req.getSession();
    User user = (User) session.getAttribute("user");
if (user == null) {
    throw new ServletException("User is not logged in");
}
    Date now = new Date();
    if (user.getLastPacketChange() == null || (now.getTime() - user.getLastPacketChange().getTime()) > 24 * 60 * 60 * 1000) {
        UserPackage newPackage = PackageFactory.getPackage(newPackageType);
        user.setUserPackage(newPackage);
        user.setLastPacketChange(now);
        session.setAttribute("user", user);
        
        try {
            DataSource ds = DataSourceSingleton.getInstance();
            Connection con = ds.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE _User SET Package = ?, lastPacketChange = ? WHERE UserID = ?");
            preparedStatement.setString(1, newPackage.toString());
            preparedStatement.setTimestamp(2, new Timestamp(now.getTime()));
            preparedStatement.setInt(3, user.getId());
            preparedStatement.executeUpdate();
            response.sendRedirect("userProfilejsp.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error updating user", e);
        }
    } else {
        req.setAttribute("errorMessage", "You can only change your packet once a day. Please try again tomorrow.");
        req.getRequestDispatcher("/errorPage.jsp").forward(req, response);
    }
}




}
