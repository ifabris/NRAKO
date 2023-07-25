<%-- 
    Document   : postSearch
    Created on : 21.06.2023., 13:36:14
    Author     : Ivan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- search.jsp -->
<!DOCTYPE html>
<html>
<head>
    
    <title>Photo Search</title>
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
    <form action="searchServlet" method="post">
        Hashtag: <input type="text" name="hashtag"><br>
        Author First Name: <input type="text" name="authorFirstName"><br>
        Author Last Name: <input type="text" name="authorLastName"><br>
        <input type="submit" value="Search">
    </form>
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

