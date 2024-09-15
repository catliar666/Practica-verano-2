<%@ page import="appcontroller.AppController" %>
<%@ page import="models.Shipment" %><%--
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
    try {
        if (idPackage != null) {
            int id = Integer.parseInt(idPackage);
            Shipment shipment = controller.searchShipmentById(id);
            if (shipment == null) {
                session.setAttribute("shipmentNotFound", "No encontrado");
                response.sendRedirect("accountUser.jsp");
            }
            session.setAttribute("shipmentFound", shipment);
            response.sendRedirect("accountUser.jsp");
            return;
        }
        session.setAttribute("idNull", "Debe introducir un identificador");
        response.sendRedirect("accountUser.jsp");
    }catch (NumberFormatException e){
        session.setAttribute("numError", "Debe introducir un número");
        response.sendRedirect("accountUser.jsp");
    }
%>
</body>
</html>
