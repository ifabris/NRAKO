<%-- 
    Document   : downloadWithFilters
    Created on : 20.06.2023., 19:42:46
    Author     : Ivan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="hr.algebra.model.Post"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>
<%@page import="hr.algebra.dal.sql.DataSourceSingleton"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        int postId=0;
    try {
         postId =Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
           response.sendRedirect("seePostjsp.jsp");
        }
    String odabraniPost = new String();
     DataSource ds = DataSourceSingleton.getInstance();
     Connection con = ds.getConnection();
     List<String> urls = new ArrayList<String>();
     Statement statement = con.createStatement(); 
     String query = "select * from Post where PostID=" + postId;
     ResultSet rs = statement.executeQuery(query);
     while (rs.next()) {
             urls.add(new String(rs.getString("Picture")));      
     }
     String url = urls.get(0);
        %>
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

      </ul>
    </div>
  </div>
</nav>
 <header class="masthead">
        <div class="container h-100">
    <div class="row h-100 align-items-center">
      <div class="row">
<form action="PhotoFilter" method="post">
    Photo URL: <input type="text" name="photoUrl" value="<%=url%>" readonly class="disabled-input"/><br />
    <input type="checkbox" name="filters" value="blur" /> Blur<br />
    Radius for Blur: <input type="text" name="blurRadius" /><br />
    <input type="checkbox" name="filters" value="resize" /> Resize<br />
    Width: <input type="text" name="resizeWidth" />
    Height: <input type="text" name="resizeHeight" /><br />
    <input type="checkbox" name="filters" value="sepia" /> Sepia<br />
    <input type="submit" value="Download Photo" />
</form>
    <br>
   <br>
      </div>
    </div>
  </div>
  </header>
    </body>
      <style>
        .masthead {
  height: 100vh;
  min-height: 500px;
  background-image: url('https://source.unsplash.com/BtbjCFUvBXs/1920x1080');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;
}
.disabled-input {
    background-color: #f0f0f0;
    color: #888;
    cursor: not-allowed;
}
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</html>
