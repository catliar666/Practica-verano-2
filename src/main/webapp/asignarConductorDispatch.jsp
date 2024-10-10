<%@ page import="appcontroller.AppController" %>
<%@ page import="utils.Utils" %>
<%@ page import="models.Shipment" %>
<%@ page import="models.Driver" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 09/10/2024
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Asignar paquete</title>
</head>
<body>
<%
    Object user = session.getAttribute("usuarioLogueado");
    AppController controller = new AppController();
    String idPackage = request.getParameter("idPackage");
    String idConductor = request.getParameter("idConductor");

    if (user == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    int fails = 0;

    // Validación de campos
    if (idConductor == null || idConductor.trim().isEmpty() || Utils.VerEtiquetas(idConductor)) {
        session.setAttribute("idConductorNull", "No hay identificador del conductor");
        fails++;
    }
    if (idPackage == null || idPackage.trim().isEmpty() || Utils.VerEtiquetas(idPackage)) {
        session.setAttribute("idPackageNull", "No hay identificador del paquete");
        fails++;
    }

    if (fails >= 1){
        response.sendRedirect("accountAdmin.jsp");
        return;
    }

    int idPackageNum = Integer.parseInt(idPackage), idConductorNum = Integer.parseInt(idConductor);

    if (idPackageNum <= 0 || idConductorNum <= 0) {
        session.setAttribute("noValido", "Números introducidos no válidos");
        response.sendRedirect("accountAdmin.jsp");
        return;
    }

    Shipment shipment = controller.searchShipmentById(idPackageNum);

    if (shipment == null) {
        session.setAttribute("shipmentNotFound", "No se ha encontrado el paquete");
        return;
    }

    Driver conductor = controller.searchDriverById(idConductorNum);

    if (conductor == null) {
        session.setAttribute("driverNotFound", "No se ha encontrado el driver");
        response.sendRedirect("accountAdmin.jsp");
        return;
    }

    if (controller.addShipmentDriver(idPackageNum, idConductorNum)) {
        session.setAttribute("driverAdded", "Yes");
        response.sendRedirect("accountAdmin.jsp");
        return;
    }

    response.sendRedirect("error.jsp");

%>
</body>
</html>
