<%@ page import="models.User" %>
<%@ page import="appcontroller.AppController" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 27/08/2024
  Time: 1:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Close session</title>
</head>
<body>
<%
    AppController controller = new AppController();
    Object user = session.getAttribute("usuarioLogueado");
    if (user != null) {
        if (user instanceof User && !((User) user).isFirst_login()) {
            ((User) user).setFirst_login(true);
            controller.updateUser(user);
        }
        controller.getLastLogin(user);
        session.removeAttribute("usuarioLogueado");
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
    }
    response.sendRedirect("error.jsp");
%>
</body>
</html>
