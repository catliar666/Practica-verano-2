<%-- 
    Document   : login
    Created on : 3 jul 2024, 1:46:10
    Author     : Maria
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="appcontroller.AppController" %>
<%@ page import="models.User" %>
<%@ page import="models.Driver" %>
<%@ page import="models.Admin" %>
<%@ page import="utils.Utils" %>

<%
    try {
        String email = request.getParameter("emailText");
        String pass = request.getParameter("passText");
        AppController controller = new AppController();


        int fails = 0;
        if (email == null || email.trim().isEmpty() || Utils.VerEtiquetas(email) || Utils.VerInyeccionSql(email)) {
            session.setAttribute("emailNull", "Debes introducir un email");
            fails++;
        }
        if (pass == null || pass.trim().isEmpty() || Utils.VerEtiquetas(pass) || Utils.VerInyeccionSql(pass)) {
            session.setAttribute("passNull", "Debes introducir un pass");
            fails++;
        }
        if (fails > 0) {
            response.sendRedirect("login.jsp");
            return;
        }

        Object user = controller.login(email, pass);

        if (user == null) {
            // Redirigir si las credenciales son incorrectas
            session.setAttribute("datosIncorrectos", "No se ha encontrado el usuario");
            response.sendRedirect("login.jsp");
            return;
        }

        // Verificar el tipo de usuario
        if (user instanceof User) {
            // Iniciar sesión para el usuario
            controller.getLastLogin(user);
            session.setAttribute("usuarioLogueado", user);
            response.sendRedirect("accountUser.jsp");
            return;
        } else if (user instanceof Driver) {
            controller.getLastLogin(user);
            session.setAttribute("usuarioLogueado", user);
            response.sendRedirect("accountDriver.jsp");
            return;
        } else if (user instanceof Admin) {
            controller.getLastLogin(user);
            session.setAttribute("usuarioLogueado", user);
            response.sendRedirect("accountAdmin.jsp");
            return;
        } else {
            response.sendRedirect("error.jsp");
        }
    }catch (Exception e) {
        session.setAttribute("Error", "Error en la comunicación con la base de datos");
        response.sendRedirect("error.jsp");
    }
%>
