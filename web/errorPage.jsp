<%-- 
    Document   : errorPage
    Created on : 23.06.2023., 00:32:15
    Author     : Ivan
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<body>
<%
    String errorMessage = (String)request.getAttribute("errorMessage");
    if(errorMessage != null){
%>
        <div class="alert alert-danger" role="alert">
            <%= errorMessage %>
        </div>
<%
    }
%>
<button onclick="location.href='userProfilejsp.jsp'">Back to Profile</button>
</body>
</html>


