<%@ page import="appcontroller.AppController" %>
<%@ page import="utils.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 26/09/2024
  Time: 9:56
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
    // Aquí empieza el registro del administrador
    String name = request.getParameter("name"),
            email = request.getParameter("email"),
            pass = request.getParameter("pass");

    int fails = 0;

    // Validación de campos
    if (name == null || name.trim().isEmpty() || Utils.VerEtiquetas(name)) {
        session.setAttribute("nameNull", "No hay nombre");
        fails++;
    }
    if (email == null || email.trim().isEmpty() || Utils.VerEtiquetas(email)) {
        session.setAttribute("emailNull", "No hay email");
        fails++;
    }
    if (pass == null || pass.trim().isEmpty()|| Utils.VerEtiquetas(pass)) {
        session.setAttribute("passNull", "No hay contraseña");
        fails++;
    }
    if (fails >= 1) {
        response.sendRedirect("accountAdmin.jsp");
        return;
    }



    try {
        boolean register = controller.addDriver(name, email, pass);
        if (register){
            session.setAttribute("register", "Se ha registrado con éxito");
            response.sendRedirect("accountAdmin.jsp");
            return;
        }
        session.setAttribute("fail", "No se ha podido registrar");
        response.sendRedirect("accountAdmin.jsp");

    } catch (Exception e) {
        session.setAttribute("error", "Error en la base de datos");
        response.sendRedirect("error.jsp");
    }
%>
</body>
</html>
