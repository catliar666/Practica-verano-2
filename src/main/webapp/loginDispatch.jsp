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

<%
    String email = request.getParameter("emailText");
    String pass = request.getParameter("passText");
    AppController controller = new AppController();
    Object user = controller.login(email, pass);

    if (user == null) {
        // Redirigir si las credenciales son incorrectas
        response.sendRedirect("index.jsp");
        return;
    }

    // Verificar el tipo de usuario
    if (user instanceof User) {
        // Iniciar sesión para el usuario
        controller.getLastLogin(user);
        session.setAttribute("usuarioLogueado", user);
        response.sendRedirect("accountUser.jsp");
        return;
    } else if (user instanceof Driver){
        controller.getLastLogin(user);
        session.setAttribute("usuarioLogueado", user);
        response.sendRedirect("accountDriver.jsp");
        return;
    } else if (user instanceof Admin){
        controller.getLastLogin(user);
        session.setAttribute("usuarioLogueado", user);
        response.sendRedirect("accountAdmin.jsp");
        return;
    } else {
        response.sendRedirect("error.jsp");
    }
%>
