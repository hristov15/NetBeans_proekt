/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String r = """
                   <!DOCTYPE>
                   <html>
                      <head>
                          <title>Login</title>
                      </head>
                      <body>
                          <p>Login successful.</p>
                      </body>
                   </html>
                   """;
        String db = "jdbc:mariadb://localhost/countries";
        String reqName = request.getParameter("name");
        String reqPass = request.getParameter("pass");
        
               
        try {
           
           Class.forName("org.mariadb.jdbc.Driver");
           Connection conn = DriverManager.getConnection(db);
           Statement stmt = conn.createStatement();
           String query = """
                     INSERT INTO potrebiteli(name, pass)
                     VALUES (\"%s\", \"%s\");
                          """.formatted(reqName, reqPass);
           ResultSet rs = stmt.executeQuery(query);
           
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection conn = DriverManager.getConnection(db);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       
        response.getWriter().println(r);
       
    }

}
