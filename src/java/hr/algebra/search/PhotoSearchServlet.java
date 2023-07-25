/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.search;

import hr.algebra.model.Post;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
@WebServlet("/searchServlet")
public class PhotoSearchServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String hashtag = request.getParameter("hashtag");
           String size = request.getParameter("size");
            String authorFirstName = request.getParameter("authorFirstName");
            String authorLastName = request.getParameter("authorLastName");
            
            PhotoSearchBuilder searchBuilder = new PhotoSearchBuilder();
            
            if (hashtag != null && !hashtag.isEmpty()) {
                searchBuilder.setHashtag(hashtag);
            }
            if (authorFirstName != null && !authorFirstName.isEmpty()) {
                searchBuilder.setAuthorFirstName(authorFirstName);
            }
            if (authorLastName != null && !authorLastName.isEmpty()) {
                searchBuilder.setAuthorLastName(authorLastName);
            }
            
            List<Post> results = searchBuilder.search();
            
            // Save results in request scope
            request.setAttribute("searchResults", results);
            
            // Forward the request to the JSP to display the results
            RequestDispatcher dispatcher = request.getRequestDispatcher("results.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PhotoSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

