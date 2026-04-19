/*9.a Build a Session Management using Servlet program set with one minute session to show Session
Tracking Information, Session ID,Session Creation Time,Last Access Time,Visit Count*/
package com.sessiontracking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SessionTracker")
public class SessionTrackingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get session
        HttpSession session = request.getSession(true);

        // Set session expiry to 60 seconds
        session.setMaxInactiveInterval(60);

        String name = request.getParameter("uname");

        // If name entered → store in session
        if (name != null && !name.isEmpty()) {
            session.setAttribute("user", name);
        }

        String user = (String) session.getAttribute("user");

        // Visit count
        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }
        session.setAttribute("visitCount", visitCount);

        // Times
        Date createTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        out.println("<html><body>");

        if (user != null) {

            out.println("<h2 style='color:blue;'>Hello " + user + "!</h2>");
            out.println("<p>Visit Count: " + visitCount + "</p>");
            out.println("<p>Session ID: " + session.getId() + "</p>");
            out.println("<p>Session Created: " + createTime + "</p>");
            out.println("<p>Last Access Time: " + lastAccessTime + "</p>");
            out.println("<p style='color:red;'>Session expires in 1 minute</p>");

        } else {
            // Show form
            out.println("<h2>Enter Your Name</h2>");
            out.println("<form action='SessionTracker' method='get'>");
            out.println("Name: <input type='text' name='uname' required>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }
}