<%@ page import="appcontroller.AppController" %>
<%@ page import="models.Driver" %>
<%@ page import="models.User" %>
<%@ page import="models.Admin" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 10/09/2024
  Time: 20:14
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

    if (user == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    if (session.getAttribute("changePassYes") == null) {
        if (user instanceof Driver) {
            session.setAttribute("changePassYes", "Autoriza cambiar la contraseña");
            response.sendRedirect("accountDriver.jsp");
        } else if (user instanceof User) {
            session.setAttribute("changePassYes", "Autoriza cambiar la contraseña");
            response.sendRedirect("accountUser.jsp");
        } else if (user instanceof Admin) {
            session.setAttribute("changePassYes", "Autoriza cambiar la contraseña");
            response.sendRedirect("accountAdmin.jsp");
        }
        return;
    }

    // Manejo de cambio de contraseña
    String pass = request.getParameter("passChange");
    String pass2 = request.getParameter("pass2Change");
    String passOld = request.getParameter("passOld");

    int fails = 0;
    if (passOld == null || passOld.trim().isEmpty()) {
        session.setAttribute("passOldNull", "Debes introducir la contraseña antigua");
        fails++;
    }
    if (pass == null || pass.trim().isEmpty()) {
        session.setAttribute("passNull", "Debes introducir una contraseña");
        fails++;
    }
    if (pass2 == null || pass2.trim().isEmpty()) {
        session.setAttribute("pass2Null", "Debes introducir una confirmación de contraseña");
        fails++;
    }

    if (fails > 0) {
        response.sendRedirect(user instanceof Driver ? "accountDriver.jsp" :
                user instanceof User ? "accountUser.jsp" :
                        "accountAdmin.jsp");
        return;
    }

    if (!pass.equals(pass2)) {
        session.setAttribute("passNotEqual", "Las dos contraseñas deben ser iguales");
        response.sendRedirect(user instanceof Driver ? "accountDriver.jsp" :
                user instanceof User ? "accountUser.jsp" :
                        "accountAdmin.jsp");
        return;
    }

    // Comparar la nueva contraseña con la antigua almacenada
    if (user instanceof User && !((User) user).checkPass(passOld)) {
        session.setAttribute("passEquals", "La contraseña antigua no es correcta");
        response.sendRedirect("accountUser.jsp");
        return;
    }

    if (user instanceof Driver && !((Driver) user).checkPass(passOld)) {
        session.setAttribute("passEquals", "La contraseña antigua no es correcta");
        response.sendRedirect("accountDriver.jsp");
        return;
    }

    if (user instanceof Admin && !((Admin) user).checkPass(passOld)) {
        session.setAttribute("passEquals", "La contraseña antigua no es correcta");
        response.sendRedirect("accountAdmin.jsp");
        return;
    }

    // Actualizar contraseña
    if (user instanceof User) ((User) user).setPass(pass);
    if (user instanceof Driver) ((Driver) user).setPass(pass);
    if (user instanceof Admin) ((Admin) user).setPass(pass);

    if (controller.updatePass(user)) {
        session.setAttribute("passUpdate", "Contraseña actualizada correctamente");
        response.sendRedirect(user instanceof Driver ? "accountDriver.jsp" :
                user instanceof User ? "accountUser.jsp" :
                        "accountAdmin.jsp");
    } else {
        session.setAttribute("error", "Error al actualizar la contraseña");
        response.sendRedirect("error.jsp");
    }
%>
</body>
</html>