<%
    String name = request.getParameter("uname");
    int time = Integer.parseInt(request.getParameter("time"));

    // Create session
    session.setAttribute("user", name);

    // Convert minutes → seconds
    session.setMaxInactiveInterval(time * 60);
%>

<html>
<body>

<h2 style="color:blue;">Hello <%= name %>!</h2>

<p>Session set for <b><%= time %> minutes</b></p>

<a href="checkSession.jsp">Click here to check session</a>

</body>
</html>