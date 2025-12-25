

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        if (idStr != null) {
            int id = Integer.parseInt(idStr);

            String dbURL = "jdbc:derby://localhost:1527/student_profiles";
            String dbUser = "app"; 
            String dbPass = "app"; 

            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

                String sql = "DELETE FROM profile WHERE id=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                pst.executeUpdate();

                conn.close();
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Redirect with success message
        response.sendRedirect("viewProfiles.jsp?msg=deleted");
    }
}
