/*6c. Build a servlet program to check the given number is prime number or not using HTML with step by
step procedure.*/
package com.prime;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String input = request.getParameter("num");

        out.println("<html><body>");

        if (input == null || input.trim().isEmpty()) {
            out.println("<h2 style='color:red;'>Please enter a number</h2>");
        } else {
            try {
                int num = Integer.parseInt(input.trim());
                boolean isPrime = true;

                if (num <= 1) {
                    isPrime = false;
                } else {
                    for (int i = 2; i <= Math.sqrt(num); i++) {
                        if (num % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }

                if (isPrime) {
                    out.println("<h2 style='color:green;'>" + num + " is a Prime Number</h2>");
                } else {
                    out.println("<h2 style='color:red;'>" + num + " is NOT a Prime Number</h2>");
                }

            } catch (NumberFormatException e) {
                out.println("<h2 style='color:red;'>Invalid Input! Enter only numbers</h2>");
            }
        }

        out.println("<br><a href='index.jsp'>Try Again</a>");
        out.println("</body></html>");
    }

    // Fix direct URL access
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("index.jsp");
    }
}