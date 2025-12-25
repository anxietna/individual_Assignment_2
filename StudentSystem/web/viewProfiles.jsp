<%@ page import="java.util.*, csc584.bean.ProfileBean" %>
<%
    // Retrieve the list that was sent by the Servlet
    List profiles = (List) request.getAttribute("profiles");

    // If someone tries to access this JSP directly without going through the Servlet
    if (profiles == null) {
        response.sendRedirect("ViewProfilesServlet");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>All Profiles</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: auto; }
        th, td { border: 1px solid #cc0066; padding: 10px; text-align: left; }
        th { background-color: #ff99cc; color: white; }
        tr:nth-child(even) { background-color: #ffe6f2; }
        h2 { text-align: center; color: #cc0066; }
        p { text-align: center; }
        .action-btn {
            display: inline-block; padding: 6px 12px; margin: 2px;
            border-radius: 8px; text-decoration: none; font-size: 14px;
            font-weight: bold; color: white;
        }
        .edit-btn { background: green; }
        .delete-btn { background: red; }
        .add-btn {
            display: block; width: 200px; margin: 20px auto; padding: 12px;
            text-align: center; background: #cc0066; color: white;
            font-weight: bold; border-radius: 12px; text-decoration: none;
        }
    </style>
</head>
<body>
<%
    String msg = request.getParameter("msg");
    if ("updated".equals(msg)) {
%>
    <script>alert("Profile updated successfully!");</script>
<%
    } else if ("deleted".equals(msg)) {
%>
    <script>alert("Profile deleted successfully!");</script>
<%
    }
%>

<h2>All Profiles</h2>

<% if (profiles.isEmpty()) { %>
    <p>No profiles found in the database.</p>
<% } else { %>
    <table>
        <tr>
            <th>Name</th>
            <th>Student ID</th>
            <th>Program</th>
            <th>Email</th>
            <th>Hobbies</th>
            <th>Intro</th>
            <th>Actions</th>
        </tr>
        <% for (Object obj : profiles) { 
            ProfileBean p = (ProfileBean) obj; %>
        <tr>
            <td><%= p.getName() %></td>
            <td><%= p.getStudentID() %></td>
            <td><%= p.getProgram() %></td>
            <td><%= p.getEmail() %></td>
            <td><%= p.getHobbies() %></td>
            <td><%= p.getIntro() %></td>
            <td>
                <a href="EditProfileServlet?id=<%= p.getId() %>" class="action-btn edit-btn">Edit</a>
                <a href="DeleteProfileServlet?id=<%= p.getId() %>" class="action-btn delete-btn" 
                   onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
<% } %>

<a href="index.html" class="add-btn">Add New Profile</a>
</body>
</html>