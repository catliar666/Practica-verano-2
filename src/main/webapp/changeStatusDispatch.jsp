<%@ page import="appcontroller.AppController" %>
<%@ page import="models.Driver" %>
<%@ page import="models.Shipment" %>
<%@ page import="models.User" %>
<%@ page import="comunication.Mensajes" %>
<%@ page import="comunication.AvisoCorreo" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 13/09/2024
  Time: 12:34
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
    Driver driver = (Driver) session.getAttribute("usuarioLogueado");
    Shipment shipmentFound = (Shipment) session.getAttribute("shipmentFound");
    String status = request.getParameter("status");
    try {
        if (driver == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        if (shipmentFound == null && status == null) {
            session.setAttribute("error", "No hay paquete encontrado o no hay status");
            response.sendRedirect("error.jsp");
            return;
        }

        driver.updateShipmentStatus(status, shipmentFound.getId());
        controller.changeDeliveryStatus(status, shipmentFound.getId());
        User userFind = controller.searchUserByEmail(shipmentFound.getEmailUserNoRegister());
        if (userFind != null) {
            if (userFind.isNotification()) {
                Mensajes.enviarMensaje(userFind.getEmail(), "Actualización de envío", AvisoCorreo.generaPlantillaAviso(userFind.getName(),
                        shipmentFound.getId(), shipmentFound.getExpectDate(), shipmentFound.getStatus(), shipmentFound.getAlternativeAddress(),
                        shipmentFound.getAlternativeCity()), null);
            }
        }
        session.removeAttribute("shipmentFound");
        session.setAttribute("packageUpdateState", "Paquete actualizado");
        response.sendRedirect("accountDriver.jsp");
    }catch (Exception e) {
        session.setAttribute("error", "Error al enviar el email al destinatario");
        response.sendRedirect("error.jsp");
    }
%>
</body>
</html>
