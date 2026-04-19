<%@ page import="javax.servlet.http.Cookie" %>

<%
    String cname = request.getParameter("cname");
    String domain = request.getParameter("domain");
    int age = Integer.parseInt(request.getParameter("age"));

    Cookie ck = new Cookie(cname, "SampleValue");

    if (domain != null && !domain.isEmpty()) {
        ck.setDomain(domain);
    }

    ck.setMaxAge(age);

    response.addCookie(ck);
%>

<html>
<body>

<h2>Cookie Added Successfully!</h2>

<p><b>Name:</b> <%= cname %></p>
<p><b>Domain:</b> <%= domain %></p>
<p><b>Max Age:</b> <%= age %> seconds</p>

<br>
<a href="listCookies.jsp">Go to Active Cookie List</a>

</body>
</html>