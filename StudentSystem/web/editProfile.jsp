<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="csc584.bean.ProfileBean" %>
<%
    ProfileBean profile = (ProfileBean) request.getAttribute("profile");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
    <style>
        body { font-family: Arial, sans-serif; background: #ffe6f2; padding: 50px 0; }
        .container { width: 450px; margin: auto; background: white; padding: 40px 30px; border-radius: 20px; border: 2px solid #ff99cc; box-shadow: 0 10px 25px rgba(255,102,179,0.4); }
        h2 { text-align: center; color: #cc0066; margin-bottom: 30px; }
        input, textarea { width: 90%; display: block; margin: 0 auto 20px auto; padding: 12px; border-radius: 12px; border: 1px solid #ff99cc; }
        button, .btn { width: 95%; padding: 14px; background: linear-gradient(to right, #ff66b3, #e60073); color: white; border: none; border-radius: 12px; cursor: pointer; font-size: 16px; font-weight: bold; display: block; margin: 10px auto; text-align: center; text-decoration: none; }
        button:hover, .btn:hover { transform: translateY(-3px); box-shadow: 0 5px 15px rgba(255,102,179,0.4); }
    </style>
</head>
<body>

<div class="container">
    <h2>Edit Profile</h2>
    <form action="EditProfileServlet" method="post">
        <input type="hidden" name="id" value="<%= profile.getId() %>">

        <input type="text" name="name" placeholder="Name" value="<%= profile.getName() %>" required>
        <input type="text" name="studentID" placeholder="Student ID" value="<%= profile.getStudentID() %>" required>
        <input type="text" name="program" placeholder="Program" value="<%= profile.getProgram() %>" required>
        <input type="email" name="email" placeholder="Email" value="<%= profile.getEmail() %>" required>
        <input type="text" name="hobbies" placeholder="Hobbies" value="<%= profile.getHobbies() %>" required>
        <textarea name="intro" rows="4" placeholder="Introduction" required><%= profile.getIntro() %></textarea>

        <button type="submit">Update Profile</button>
        <a href="viewProfiles.jsp" class="btn">Back to Profiles</a>
    </form>
</div>

</body>
</html>
