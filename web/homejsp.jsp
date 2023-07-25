<%-- 
    Document   : homejsp
    Created on : 02.01.2023., 14:56:32
    Author     : Ivan
--%>



<%@page import="hr.algebra.model.Hashtag"%>
<%@page import="com.sun.javafx.scene.control.skin.VirtualFlow.ArrayLinkedList"%>
<%@page import="java.sql.Statement"%>
<%@page import="hr.algebra.model.Post"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.AbstractList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="hr.algebra.dal.sql.DataSourceSingleton"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Instagram Clone</title>
    <%
        List<Post> posts = new ArrayList();
        List<Hashtag> hashtags = new ArrayList();
        DataSource ds = DataSourceSingleton.getInstance();
     Connection con = ds.getConnection();
     Statement statement = con.createStatement();
     String queryPosts = "SELECT * FROM Post INNER JOIN _User ON Post.IDUser = _User.UserID  INNER JOIN UserInfo ON _User.UserID = UserInfo.IDUser";
    ResultSet rs = statement.executeQuery(queryPosts);
     while (rs.next()) {             
             posts.add(new Post(rs.getInt("PostId"),rs.getString("First_name"),
             rs.getString("Last_name"),rs.getString("Picture"),rs.getString("Info"),rs.getInt("IDUser") ));
         }   

         String queryPosts2 = "SELECT * FROM Post INNER JOIN Hashtag ON Post.PostID = Hashtag.PictureID";
    ResultSet rs2 = statement.executeQuery(queryPosts2);
     while (rs2.next()) {             
             hashtags.add(new Hashtag(rs2.getInt("HashtagID"),rs2.getString("Name"),rs2.getInt("PictureID")));
         }  
%>
             
      
</head>
 <title>NRAKO</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light shadow">
  <div class="container">
    <a class="navbar-brand" href="Home.html">NRAKO</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
       <ul class="navbar-nav ms-auto">
        <li class="nav-item active">
          <a class="nav-link" href="homejsp.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="userProfilejsp.jsp">Profile</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="yourposts.jsp">Your posts</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="addpost.jsp">Add post</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="postSearch.jsp">Search post</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="logViewer.jsp">Log view</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="LogoutServlet">Logout</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="viewAllUsers.jsp">All users for admin</a>
        </li>

      </ul>
    </div>
  </div>
</nav>

<!-- Full Page Image Header with Vertically Centered Content -->
<header class="masthead">
 <div class="container h-100">
    <div class="row h-100 align-items-center">
      <div class="row">
          <%
             for (Post p : posts) {%>
                
             <div class="card" style="width: 18rem;">
                 <img class="card-img-top" src="<% out.print(p.getPicture()); %>" alt="No picture" onclick="redirectToLink('<% out.print(p.getPicture()); %>')">
  <div class="card-body">
      <h5 class="card-title"><% out.print(p.getFirstName() + " " + p.getLastName());%></h5>
    <p class="card-text"><% out.print(p.getInfo()); %></p>
    <p class="card-text">Hashtags:<%
        for (Hashtag h : hashtags) {
                if (h.getPictureId() == p.getPostId()) {
                        out.print(h.getName() + " ");
                    }
            }
        
        %></p>
  </div>
</div>
             
    <%}%>

      </div>
    </div>
  </div>
</header>
    </body>
    <style>
        .masthead {
  height: 100%;
  background-image: url('https://source.unsplash.com/BtbjCFUvBXs/1920x1080');
  background-size: cover;
  background-position: center;
  background-repeat: repeat;
  background-attachment: fixed;
}

    </style>
</style>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script>
  function redirectToLink(link) {
    window.open(link, '_blank');
  }
</script>
</html>

