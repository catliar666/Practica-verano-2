<%@ page import="appcontroller.AppController" %>
<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 03/09/2024
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Espera validación</title>
</head>
<body>
<%
    AppController controller = new AppController();
    if (request.getParameter("token") != null) {
        int token = Integer.parseInt(request.getParameter("token"));
        User user = controller.validateAccountToken(token);
        if (user != null) {
            session.removeAttribute("usuarioLogueado");
            session.setAttribute("usuarioLogueado", user);
            response.sendRedirect("sucess.jsp");
            return;
        } else {
            response.sendRedirect("error.jsp");
        }
    }
%>
</body>
</html>
