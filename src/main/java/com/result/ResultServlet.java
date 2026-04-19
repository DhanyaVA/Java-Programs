/*10.b Build an Application to get Rollno, Studentname, Sub1, Sub2, Sub3, Sub4 and Sub5 through JSP
called index.jsp with client sided validation and submit to the servlet called ResultServlet and process all
the fields with server sided validation and display all the data along with result ( Pass if all subjects
greater than 40%) and Average marks through result.jsp with a link to move to the client side*/
package com.result;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");

        int s1 = Integer.parseInt(request.getParameter("sub1"));
        int s2 = Integer.parseInt(request.getParameter("sub2"));
        int s3 = Integer.parseInt(request.getParameter("sub3"));
        int s4 = Integer.parseInt(request.getParameter("sub4"));
        int s5 = Integer.parseInt(request.getParameter("sub5"));

        int[] marks = {s1, s2, s3, s4, s5};

        // Server-side validation
        String message = "";
        boolean valid = true;

        for (int m : marks) {
            if (m < 0 || m > 100) {
                valid = false;
                message = "Invalid marks entered!";
                break;
            }
        }

        double avg = 0;
        String result = "Fail";

        if (valid) {
            int total = s1 + s2 + s3 + s4 + s5;
            avg = total / 5.0;

            boolean pass = true;
            for (int m : marks) {
                if (m < 40) {
                    pass = false;
                    break;
                }
            }

            if (pass) result = "Pass";

            message = "Result calculated successfully";
        }

        // Send data to JSP
        request.setAttribute("rollno", rollno);
        request.setAttribute("name", name);
        request.setAttribute("s1", s1);
        request.setAttribute("s2", s2);
        request.setAttribute("s3", s3);
        request.setAttribute("s4", s4);
        request.setAttribute("s5", s5);
        request.setAttribute("average", avg);
        request.setAttribute("result", result);
        request.setAttribute("message", message);

        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }

    // Avoid 405 error
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }
}