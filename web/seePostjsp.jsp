<%-- 
    Document   : seePostjsp
    Created on : 17.01.2023., 16:21:08
    Author     : Ivan
--%>

<%@page import="hr.algebra.model.User"%>
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
<%
    User auth = (User) request.getSession().getAttribute("auth");
if (auth == null) {
    response.sendRedirect("LoginUser.html");
    return;
}   
int postId=0;
    try {
         postId =Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
           response.sendRedirect("seePostjsp.jsp");
        }
    List<Hashtag> hashtags = new ArrayList();
      Post odabraniPost = new Post();
      DataSource ds = DataSourceSingleton.getInstance();
     Connection con = ds.getConnection();
     Statement statement = con.createStatement();
     List<Post> posts = new ArrayList<Post>();     
     String query = "SELECT * FROM Post INNER JOIN _User ON Post.IDUser = _User.UserID  INNER JOIN UserInfo ON _User.UserID = UserInfo.IDUser; ";
     ResultSet rs = statement.executeQuery(query);    
     while (rs.next()) {
             posts.add(new Post(rs.getInt("PostId"),rs.getString("First_name"),
             rs.getString("Last_name"),rs.getString("Picture"),rs.getString("Info"),rs.getInt("IDUser") ));      
     }
     for (Post p : posts) {
             if (p.getPostId()== postId) {
                     odabraniPost=p;
                 }
         }
     String queryPosts2 = "SELECT * FROM Post INNER JOIN Hashtag ON Post.PostID = Hashtag.PictureID where PostID = " + odabraniPost.getPostId();
    ResultSet rs2 = statement.executeQuery(queryPosts2);
     while (rs2.next()) {             
             hashtags.add(new Hashtag(rs2.getInt("HashtagID"),rs2.getString("Name"),rs2.getInt("PictureID")));
         }  
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>NRAKO</title>
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
<form action="EditPost" method="POST">
    <div class="" style="width: 18rem;">
                 <img class="card-img-top" src="<% out.print(odabraniPost.getPicture()); %>" alt="No picture" style="max-width:600px;width:100%">
  <div class="card-body">
      <div class="form-field">
    <label for="poc-fname">Post ID</label>
    <input type="text" id="poc-fname" name="pId" value="<%=odabraniPost.getPostId()%>" readonly class="disabled-input"/>
  </div>
       <div class="form-field">
    <label for="poc-fname">Publisher name</label>
    <input type="text" id="poc-fname" name="pName" value="<%=odabraniPost.getFirstName()%>" readonly class="disabled-input"/>
  </div>
       <div class="form-field">
    <label for="poc-fname">Publisher lastname</label>
    <input type="text" id="poc-fname" name="pLastName" value="<%=odabraniPost.getLastName()%>" readonly class="disabled-input"/>
  </div>
       <div class="form-field">
    <label for="poc-fname">Description</label>
    <input type="text" id="poc-fname" name="pDescription" value="<%=odabraniPost.getInfo()%>"/>
  </div>
<input type="hidden" name="pictureID" value="<%=odabraniPost.getPostId()%>"/>
        <br>
        <input type="submit" class="fadeIn fourth" value="Edit">
    </div>
</form>
    <br>
<% for (Hashtag h : hashtags) { %>
<form action="EditHashtags" method="POST">
    <div class="form-field">
    <label for="poc-fname">UserId</label>
    <input type="text" id="poc-fname" name="pUserId" value="<%=auth.getId()%>" readonly class="disabled-input"/>
  </div>
    <div style="display: flex; gap: 10px;">
        <label for="poc-fname-<%=h.getHashtagId()%>">Hashtag ID</label>
        <input type="text" id="poc-fname-<%=h.getHashtagId()%>" name="pHashtagId" value="<%=h.getHashtagId()%>" readonly class="disabled-input"/>
    </div>
    <div style="display: flex; gap: 10px;">
        <label for="poc-fname-<%=h.getName()%>">Hashtag</label>
        <input type="text" id="poc-fname-<%=h.getName()%>" name="pHashtag" value="<%=h.getName()%>"/>
    </div>
    <input type="submit" value="Edit">
</form>
<% } %>

    <br>
   <label for="outputFormat">Select output format : </label>
   <a href="ImageProcessorServlet?url=<%=odabraniPost.getPicture()%>&format=png">Process and Save PNG</a> <br>
    <a href="ImageProcessorServlet?url=<%=odabraniPost.getPicture()%>&format=jpeg">Process and Save JPEG</a><br>
    <a href="ImageProcessorServlet?url=<%=odabraniPost.getPicture()%>&format=bmp">Process and Save BMP</a>
   <br>
<a class="nav-link" href="downloadWithFilters.jsp?id=<%=odabraniPost.getPostId()%>">Add filters and download</a>

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
