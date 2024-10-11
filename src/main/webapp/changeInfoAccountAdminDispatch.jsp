<%@ page import="appcontroller.AppController" %>
<%@ page import="utils.Utils" %>
<%@ page import="models.Admin" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 10/10/2024
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
<%
    AppController controller = new AppController();
    Object admin = session.getAttribute("usuarioLogueado");

    String email = request.getParameter("emailNew"),
            name = request.getParameter("nameNew");

    int fails = 0;

    if (name == null || name.trim().isEmpty() || Utils.VerEtiquetas(name) || Utils.VerInyeccionSql(name)) {
        session.setAttribute("nameNull", "No hay nombre");
        fails++;
    }
    if (email == null || email.trim().isEmpty() || Utils.VerEtiquetas(email) || Utils.VerInyeccionSql(email)) {
        session.setAttribute("emailNull", "No hay email");
        fails++;
    }
    if (fails > 0) {
        response.sendRedirect("accountDriver.jsp");
        return;
    }

    if (admin instanceof Admin) {
        try {
            ((Admin) admin).setEmail(email);
            ((Admin) admin).setName(name);
            if (controller.updateUser(admin)){
                session.setAttribute("usuarioLogueado", admin);
                session.setAttribute("modifySuccess", "Modificado con exito");
                response.sendRedirect("accountAdmin.jsp");
                return;
            };
            session.setAttribute("modifyError", "No se ha podido modificar");
            response.sendRedirect("accountAdmin.jsp");
        }catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
    }
    response.sendRedirect("error.jsp");

%>
%>
</body>
</html>
