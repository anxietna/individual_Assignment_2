<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="csc584.bean.ProfileBean" %>
<%
    ProfileBean profile = (ProfileBean) request.getAttribute("profile");
    String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Your Profile</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            background: #ffe6f2; 
            padding: 50px 0; 
        }
        .card { 
            width: 500px; 
            margin: auto; 
            background: white; 
            border-radius: 20px; 
            padding: 40px 30px; 
            border: 2px solid #ff99cc; 
        }
        h2 { 
            text-align: center; 
            color: #cc0066; 
        }
        .profile-item { 
            margin-bottom: 18px; 
        }
        .profile-item span.label { 
            font-weight: bold; 
            color: #cc0066; 
            width: 120px; 
            display: inline-block; 
        }
        .intro { 
            background: #ffe6f2; 
            padding: 10px 15px; 
            border-radius: 10px; 
            display: block; 
            margin-top: 5px; 
        }
        .message { 
            text-align: center; 
            font-weight: bold; 
            color: green; 
            margin-bottom: 20px; 
        }
        a { 
            text-align: center; 
            display: block; 
            margin-top: 20px; 
            color: #cc0066; 
            text-decoration: none; 
        }
        a:hover { 
            text-decoration: underline; 
        }
    </style>
</head>
<body>

<div class="card">
    <h2>Your Profile Details</h2>

    <% if (message != null) { %>
        <p class="message"><%= message %></p>
    <% } %>

    <div class="profile-item">
        <span class="label">Name:</span> 
        <span class="value"><%= profile.getName() %></span>
    </div>
    
    <div class="profile-item">
        <span class="label">Student ID:</span> 
        <span class="value"><%= profile.getStudentID() %></span>
    </div>
    
    <div class="profile-item">
        <span class="label">Program:</span> 
        <span class="value"><%= profile.getProgram() %></span>
    </div>
    
    <div class="profile-item">
        <span class="label">Email:</span> 
        <span class="value"><%= profile.getEmail() %></span>
    </div>
    
    <div class="profile-item">
        <span class="label">Hobbies:</span> 
        <span class="value"><%= profile.getHobbies() %></span>
    </div>
    
    <div class="profile-item">
        <span class="label">Introduction:</span>
        <span class="intro"><%= profile.getIntro() %></span>
    </div>

    <a href="viewProfiles.jsp">View All Profiles</a>
</div>

</body>
</html>
