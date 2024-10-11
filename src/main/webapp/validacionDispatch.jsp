<%@ page import="appcontroller.AppController" %>
<%@ page import="models.User" %>
<%@ page import="utils.Utils" %><%--
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
    String token = request.getParameter("token");
    if (token == null || token.trim().isEmpty() || Utils.VerEtiquetas(token) || Utils.VerInyeccionSql(token)) {
        session.setAttribute("tokenNull", "Se debe crear un token");
        response.sendRedirect("error.jsp");
        return;
    }
        int tokenNum = Integer.parseInt(token);
    if (tokenNum <=0) {
        session.setAttribute("tokenNull", "Se debe crear un token");
        response.sendRedirect("error.jsp");
        return;
    }
        User user = controller.validateAccountToken(tokenNum);
        if (user != null) {
            session.removeAttribute("usuarioLogueado");
            session.setAttribute("usuarioLogueado", user);
            response.sendRedirect("sucess.jsp");
            return;
        } else {
            response.sendRedirect("error.jsp");
    }
%>
</body>
</html>
