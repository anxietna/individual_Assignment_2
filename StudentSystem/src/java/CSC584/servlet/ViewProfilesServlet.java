package csc584.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import csc584.bean.ProfileBean;

@WebServlet("/ViewProfilesServlet")
public class ViewProfilesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<ProfileBean> profiles = new ArrayList<>();
        String dbURL = "jdbc:derby://localhost:1527/student_profiles";
        String dbUser = "app";  
        String dbPass = "app";  

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM profile");

            while (rs.next()) {
                ProfileBean p = new ProfileBean();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setStudentID(rs.getString("studentID"));
                p.setProgram(rs.getString("program"));
                p.setEmail(rs.getString("email"));
                p.setHobbies(rs.getString("hobbies"));
                p.setIntro(rs.getString("intro"));
                profiles.add(p);
            }
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Attach the list to the request object to pass it to the JSP
        request.setAttribute("profiles", profiles);
        
        // Forward the request to viewProfiles.jsp
        request.getRequestDispatcher("viewProfiles.jsp").forward(request, response);
    }
}