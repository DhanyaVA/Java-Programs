<%@ page language="java" %>
<html>
<head><title>Welcome</title></head>
<body>

<%
    String name = request.getParameter("uname");

    if (name != null && !name.isEmpty()) {
        session.setAttribute("user", name);

        // Set session expiry = 60 seconds
        session.setMaxInactiveInterval(60);
    }

    String user = (String) session.getAttribute("user");

    if (user != null) {
%>
        <h2 style="color:blue;">Hello <%= user %>!</h2>
        <h3>Session will expire in 1 minute.</h3>
        <p>Refresh after 1 minute to check expiry.</p>
<%
    } else {
%>
        <h2 style="color:red;">Session Expired!</h2>
        <a href="index.jsp">Login Again</a>
<%
    }
%>

</body>
</html>