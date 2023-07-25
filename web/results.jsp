<%-- 
    Document   : results
    Created on : 21.06.2023., 13:37:56
    Author     : Ivan
--%>

<%@page import="hr.algebra.model.Hashtag"%>
<%@page import="hr.algebra.model.Post"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- results.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Search Results</title>
    <%
    List<Post> results = (List<Post>) request.getAttribute("searchResults");    
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
    <h1>Search Results:</h1>      
        <% for (Post photo : results) { %>
            <header class="masthead">
        <div class="container h-100">
    <div class="row h-100 align-items-center">
      <div class="row">
    <div class="" style="width: 18rem;">
                 <img class="card-img-top" src="<% out.print(photo.getPicture()); %>" alt="No picture" style="max-width:600px;width:100%">
  <div class="card-body">
      <div class="form-field">
    <label for="poc-fname">Post ID</label>
    <input type="text" id="poc-fname" name="pId" value="<%=photo.getPostId()%>" readonly class="disabled-input"/>
  </div>
       <div class="form-field">
    <label for="poc-fname">Publisher name</label>
    <input type="text" id="poc-fname" name="pName" value="<%=photo.getFirstName()%>" readonly class="disabled-input"/>
  </div>
       <div class="form-field">
    <label for="poc-fname">Publisher lastname</label>
    <input type="text" id="poc-fname" name="pLastName" value="<%=photo.getLastName()%>" readonly class="disabled-input"/>
  </div>
       <div class="form-field">
    <label for="poc-fname">Description</label>
    <input type="text" id="poc-fname" name="pDescription" value="<%=photo.getInfo()%>"/>
  </div>
<input type="hidden" name="pictureID" value="<%=photo.getPostId()%>"/>
        <br>
    </div>
    <br>
      </div>
    </div>
  </div>
  </header>
        <% } %>
    
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

