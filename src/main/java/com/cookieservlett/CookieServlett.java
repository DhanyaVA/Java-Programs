/*8b. Build a servlet program to create a cookie to get your name through text box and press submit button(
through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
n times ( n = number of your visit ) along with the list of cookies and its setvalues and demonstrate the
expiry of cookie also.*/
package com.cookieservlett;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlett extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // If user enters name → create cookies
        if (userName != null && !userName.isEmpty()) {

            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(30); // expires in 30 seconds
            response.addCookie(userCookie);

            Cookie countCookie = new Cookie("count", "1");
            countCookie.setMaxAge(30);
            response.addCookie(countCookie);
        }

        // Read cookies
        Cookie[] cookies = request.getCookies();
        String name = null;
        int count = 0;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    name = c.getValue();
                }
                if (c.getName().equals("count")) {
                    count = Integer.parseInt(c.getValue());
                }
            }
        }

        out.println("<html><body>");

        if (name != null) {

            // increase visit count
            count++;
            Cookie countCookie = new Cookie("count", String.valueOf(count));
            countCookie.setMaxAge(30);
            response.addCookie(countCookie);

            out.println("<h2 style='color:blue;'>Welcome back, " + name + "!</h2>");
            out.println("<h3>You have visited this page " + count + " times</h3>");

            // Show all cookies
            out.println("<h3>Cookie List:</h3>");
            out.println("<table border='1'>");
            out.println("<tr><th>Name</th><th>Value</th><th>Max Age</th></tr>");

            for (Cookie c : cookies) {
                out.println("<tr>");
                out.println("<td>" + c.getName() + "</td>");
                out.println("<td>" + c.getValue() + "</td>");
                out.println("<td>" + c.getMaxAge() + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            // Expiry note
            out.println("<p style='color:red;'>Note: Cookies will expire in 30 seconds.</p>");

        } else {
            out.println("<h2>Welcome Guest! Please enter your name.</h2>");
            out.println("<a href='index.html'>Go Back</a>");
        }

        out.println("</body></html>");
    }
}