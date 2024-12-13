<%@ page import="appcontroller.AppController" %>
<%@ page import="models.Shipment" %>
<%@ page import="utils.Utils" %><%--
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
    String idPackage = request.getParameter("idPackage");
    boolean admin = Boolean.parseBoolean(request.getParameter("admin"));

    // Verifica si el idPackage es válido
    if (idPackage == null || idPackage.trim().isEmpty() || Utils.VerEtiquetas(idPackage) || Utils.VerInyeccionSql(idPackage)) {
        session.setAttribute("idNull", "Debe introducir un identificador");
        if (admin) {
            response.sendRedirect("accountAdmin.jsp");
        } else {
            response.sendRedirect("accountUser.jsp");
        }
        return;  // Asegúrate de salir aquí para evitar que el código posterior se ejecute
    }

    try {
        int id = Integer.parseInt(idPackage);
        Shipment shipment = controller.searchShipmentById(id);

        if (shipment == null) {
            session.setAttribute("shipmentNotFound", "No encontrado");
            if (admin) {
                response.sendRedirect("accountAdmin.jsp");
            } else {
                response.sendRedirect("accountUser.jsp");
            }
            return;  // Asegúrate de salir aquí también
        }

        // Si se encuentra el envío, lo guardamos en la sesión
        session.setAttribute("shipmentFound", shipment);

        // Redirección según el tipo de usuario
        if (admin) {
            response.sendRedirect("accountAdmin.jsp");
        } else {
            response.sendRedirect("accountUser.jsp");
        }

    } catch (NumberFormatException e) {
        // Si ocurre un error al convertir el idPackage a número
        session.setAttribute("numError", "Debe introducir un número");
        if (admin) {
            response.sendRedirect("accountAdmin.jsp");
        } else {
            response.sendRedirect("accountUser.jsp");
        }
    }
%>

</body>
</html>
