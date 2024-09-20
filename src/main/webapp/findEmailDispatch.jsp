<%@ page import="appcontroller.AppController" %>
<%@ page import="models.User" %>
<%@ page import="comunication.ValidarCorreo" %>
<%@ page import="utils.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 09/07/2024
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    // Verificamos si hay algún usuario logueado
    Object userLogin = session.getAttribute("usuarioLogueado");

    if (userLogin != null) {
        response.sendRedirect("index.jsp");
        return;
    }

    String emailRegister = request.getParameter("registerEmail");
    boolean emailUse = true;
    AppController controller = new AppController();

    if (emailRegister == null || emailRegister.trim().isEmpty() || Utils.VerEtiquetas(emailRegister)) {
        session.setAttribute("emailNull", "Email no introducido");
        response.sendRedirect("findEmail.jsp");
        return;
    }
    try {
        if (controller.searchUserByEmail(emailRegister) != null ||
            controller.searchDriverByEmail(emailRegister) != null ||
            controller.searchAdminByEmail(emailRegister) != null) {

            session.setAttribute("emailUse", emailUse);
            response.sendRedirect("findEmail.jsp");
            return;
        }

        if (!controller.searchShipmentByEmail(emailRegister).isEmpty()) {
            session.setAttribute("emailRegister", emailRegister);
            response.sendRedirect("registerByInfoShipment.jsp");
            return;
        } else {
            session.setAttribute("emailNoRegister", emailRegister);
            response.sendRedirect("registerComplete.jsp");
            return;
        }
    } catch (Exception e) {
        response.sendRedirect("error.jsp");
    }
%>

