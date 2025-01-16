<%@ page import="models.User" %>
<%@ page import="appcontroller.AppController" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 13/01/2025
  Time: 16:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    AppController controller = new AppController();
    Object user = session.getAttribute("usuarioLogueado");

    if (user != null) {
        if (user instanceof User) {
            String email = ((User) user).getEmail();
            Object userReload = controller.searchUserByEmail(email);
            if (userReload != null) {
                session.removeAttribute("usuarioLogueado");
                session.setAttribute("usuarioLogueado", userReload);
                response.sendRedirect("index.jsp");
                return;
            }
        }
    }
%>
</body>
</html>
