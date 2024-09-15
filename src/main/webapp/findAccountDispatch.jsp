<%@ page import="appcontroller.AppController" %>
<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 27/08/2024
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String email = request.getParameter("email");
    AppController controller = new AppController();
try {
    if (email == null || email.trim().isEmpty()) {
        session.setAttribute("emailNull", email);
        response.sendRedirect("accountUser.jsp");
        return;
    }
    User user = controller.searchUserByEmail(email);
    if (user == null) {
        session.setAttribute("userNotFound", email);
        response.sendRedirect("accountUser.jsp");
        return;
    }
    session.setAttribute("userFound", email);
    response.sendRedirect("accountUser.jsp");
}catch (Exception e){
    response.sendRedirect("error.jsp");
}
%>
</body>
</html>
