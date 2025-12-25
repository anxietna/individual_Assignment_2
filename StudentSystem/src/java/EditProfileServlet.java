
import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import csc584.bean.ProfileBean;

public class EditProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        if (idStr == null) {
            response.sendRedirect("viewProfiles.jsp");
            return;
        }

        int id = Integer.parseInt(idStr);
        String dbURL = "jdbc:derby://localhost:1527/student_profiles";
        String dbUser = "app"; 
        String dbPass = "app";  

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String sql = "SELECT * FROM profile WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            ProfileBean profile = null;

            if (rs.next()) {
                profile = new ProfileBean();
                profile.setId(rs.getInt("id"));
                profile.setName(rs.getString("name"));
                profile.setStudentID(rs.getString("studentID"));
                profile.setProgram(rs.getString("program"));
                profile.setEmail(rs.getString("email"));
                profile.setHobbies(rs.getString("hobbies"));
                profile.setIntro(rs.getString("intro"));
            }

            conn.close();

            if (profile != null) {
                request.setAttribute("profile", profile);
                RequestDispatcher rd = request.getRequestDispatcher("editProfile.jsp");
                rd.forward(request, response);
            } else {
                response.sendRedirect("viewProfiles.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("viewProfiles.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String studentID = request.getParameter("studentID");
        String program = request.getParameter("program");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String intro = request.getParameter("intro");

        String dbURL = "jdbc:derby://localhost:1527/student_profiles";
        String dbUser = "app";  
        String dbPass = "app";  

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String sql = "UPDATE profile SET name=?, studentID=?, program=?, email=?, hobbies=?, intro=? WHERE id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, studentID);
            pst.setString(3, program);
            pst.setString(4, email);
            pst.setString(5, hobbies);
            pst.setString(6, intro);
            pst.setInt(7, id);

            pst.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redirect to viewProfiles.jsp with success message
        response.sendRedirect("viewProfiles.jsp?msg=updated");
    }
}
