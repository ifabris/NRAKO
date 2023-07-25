<%-- 
    Document   : addpost
    Created on : 20.06.2023., 13:32:49
    Author     : Ivan
--%>

<%@page import="hr.algebra.model.PackageFactory"%>
<%@page import="java.sql.Statement"%>
<%@page import="hr.algebra.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.AbstractList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="hr.algebra.dal.sql.DataSourceSingleton"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
        User auth = (User) request.getSession().getAttribute("auth");
if (auth == null) {
    response.sendRedirect("LoginUser.html");
    return;
}
User user = new User();
         List<User> users = new ArrayList(); 
        DataSource ds = DataSourceSingleton.getInstance();
     Connection con = ds.getConnection();
     Statement statement = con.createStatement();
     String queryPosts = "SELECT * FROM _User";
    ResultSet rs = statement.executeQuery(queryPosts);
    while (rs.next()) {
                 String pack = rs.getString("Package");
         if (pack.matches("FREE")) {
        user.setUserPackage(PackageFactory.getPackage("FREE"));
}else if(pack.matches("PRO")){
    user.setUserPackage(PackageFactory.getPackage("PRO"));
}else{
    user.setUserPackage(PackageFactory.getPackage("GOLD"));
     }
                 
          users.add(new User(rs.getInt("UserID"),rs.getString("LoginName"),rs.getString("Email"), user.getUserPackage()));
}
    
for (User c : users) {
             if (c.getId()== auth.getId()) {
                     user=c;
                 }
         }%>
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
<form action="AddPost" method="post">              
             <div class="" style="width: 18rem;">                
  <div class="card-body">
    <div class="form-field">
    <label for="poc-fname">UserId:</label>
    <input type="text" id="poc-fname" name="pUserId" value="<%=user.getId()%>" readonly class="disabled-input"/>
  </div>
  <div class="form-field">
    <label for="poc-fname">Picture URL:</label>
    <input type="text" id="poc-fname" name="pPicture"/>
  </div>
       <div class="form-field">
    <label for="poc-fname">Post Descripiton</label>
    <input type="text" id="poc-fDesc" name="pDesc"/>
  </div>
<input type="submit" class="fadeIn fourth" value="Add">
</form>
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
