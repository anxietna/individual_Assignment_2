import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import csc584.bean.ProfileBean;


public class ProfileServlet extends HttpServlet {

    private String dbURL = "jdbc:derby://localhost:1527/student_profiles;create=true";
    private String dbUser = "app"; 
    private String dbPass = "app"; 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get values from form
        String name = request.getParameter("name");
        String studentID = request.getParameter("studentID");
        String program = request.getParameter("program");
        String email = request.getParameter("email");
        String hobbies = request.getParameter("hobbies");
        String intro = request.getParameter("intro");

        ProfileBean profile = new ProfileBean();
        profile.setName(name);
        profile.setStudentID(studentID);
        profile.setProgram(program);
        profile.setEmail(email);
        profile.setHobbies(hobbies);
        profile.setIntro(intro);

        // Save to database
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            String sql = "INSERT INTO profile (name, studentID, program, email, hobbies, intro) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, profile.getName());
            pst.setString(2, profile.getStudentID());
            pst.setString(3, profile.getProgram());
            pst.setString(4, profile.getEmail());
            pst.setString(5, profile.getHobbies());
            pst.setString(6, profile.getIntro());

            pst.executeUpdate();
            conn.close();
            
            // Success message
            request.setAttribute("message", "Profile saved successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Send profile to profile.jsp
        request.setAttribute("profile", profile);
        RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
        rd.forward(request, response);
    }
}
