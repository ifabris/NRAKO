


<%@page import="hr.algebra.model.PackageFactory"%>
<%@page import="hr.algebra.model.UserPackage"%>
<%@page import="hr.algebra.model.User"%>
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
                 
         users.add(new User(rs.getInt("UserID"),rs.getString("LoginName"),rs.getString("Email"), user.getUserPackage(),rs.getDate("lastPacketChange")));
}
    
for (User c : users) {
             if (c.getId()== auth.getId()) {
                     user=c;
                 }
         }
session.setAttribute("user", user);

    
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

      </ul>
    </div>
  </div>
</nav>
<header class="masthead">
  <div class="container h-100">
    <div class="row h-100 align-items-center">
      <div class="col-12 text-center">
          <table id="myTable" class="table table-striped table-hover">
				<thead>
					<tr>

						<th>ID</th>
						<th>Username</th>
						<th>Email</th>
						<th>Package</th>
						<th>LastPacketChange</th>
                                                
					</tr>
				</thead>
				<tbody>
					<tr>

                                            <td><%=user.getId()%></td>
                                            <td><%=user.getUsername()%></td>
                                            <td><%=user.getEmail()%></td>
                                            <td><%=user.getUserPackage()%></td>
                                            <td><%=user.getLastPacketChange()%></td>
					</tr>
				</tbody>
			</table>
      </div>
    </div>
   <form action="changePacket" method="post">
    <select name="packet">
        <option value="FREE">FREE</option>
        <option value="PRO">PRO</option>
        <option value="GOLD">GOLD</option>
    </select>
    <input type="submit" value="Change Packet">
</form>

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
</html>

