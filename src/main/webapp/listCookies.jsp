<%@ page import="javax.servlet.http.Cookie" %>

<html>
<body>

<h2>Active Cookies</h2>

<table border="1">
<tr>
    <th>Name</th>
    <th>Value</th>
</tr>

<%
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
        for (Cookie c : cookies) {
%>
<tr>
    <td><%= c.getName() %></td>
    <td><%= c.getValue() %></td>
</tr>
<%
        }
    } else {
%>
<tr>
    <td colspan="2">No Cookies Found</td>
</tr>
<%
    }
%>

</table>

<br>
<a href="index.jsp">Back</a>

</body>
</html>