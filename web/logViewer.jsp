<%-- 
    Document   : logViewer
    Created on : 21.06.2023., 14:17:26
    Author     : Ivan
--%>

<%@page import="hr.algebra.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="java.util.regex.Pattern" %>
<!DOCTYPE html>
<html>
<head>
    <title>Log Viewer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px 12px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        h1 {
            text-align: center;
        }
    </style>
    <%
    User auth = (User) request.getSession().getAttribute("auth");
    if (auth == null) {
    response.sendRedirect("LoginUser.html");
    return;
} 
if (auth.getId() != 8) {
    response.sendRedirect("homejsp.jsp");
    return;
}
    %>
</head>
<body>
    
    <h1>Log Entries</h1>
    <table>
        <tr>
            <th>Time</th>
            <th>User</th>
            <th>Action Performed</th>
        </tr>
        <%
            String filePath = "C:\\Users\\Ivan\\Desktop\\NRAKO\\log\\log.txt";
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(filePath));
                String line;
                Pattern pattern = Pattern.compile("\\[(.+?)\\] User '(.*?)' performed operation: '(.+)'");
                while ((line = br.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        String time = matcher.group(1);
                        String user = matcher.group(2);
                        String action = matcher.group(3);
        %>
        <tr>
            <td><%= time %></td>
            <td><%= user %></td>
            <td><%= action %></td>
        </tr>
        <%
                    }
                }
            } finally {
                if (br != null) {
                    br.close();
                }
            }
        %>
    </table>
</body>
</html>

