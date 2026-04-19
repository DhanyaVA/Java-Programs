<%
    String user = (String) session.getAttribute("user");
%>

<html>
<body>

<%
    if (user != null) {
%>
        <h2 style="color:green;">Hello <%= user %>! Session is still active.</h2>
<%
    } else {
%>
        <h2 style="color:red;">Session Expired!</h2>
        <a href="index.jsp">Start Again</a>
<%
    }
%>

</body>
</html>