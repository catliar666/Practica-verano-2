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
    if (idPackage == null || idPackage.trim().isEmpty() || Utils.VerEtiquetas(idPackage)) {
        session.setAttribute("idNull", "Debe introducir un identificador");
        if (admin) response.sendRedirect("accountAdmin.jsp");
        else response.sendRedirect("accountUser.jsp");
        return;
    }
    try {
            int id = Integer.parseInt(idPackage);
            Shipment shipment = controller.searchShipmentById(id);
            if (shipment == null) {
                session.setAttribute("shipmentNotFound", "No encontrado");
                if (admin) response.sendRedirect("accountAdmin.jsp");
                else response.sendRedirect("accountUser.jsp");
            }
            session.setAttribute("shipmentFound", shipment);
            if (admin) response.sendRedirect("accountAdmin.jsp");
            else response.sendRedirect("accountUser.jsp");
            return;

    }catch (NumberFormatException e){
        session.setAttribute("numError", "Debe introducir un número");
        if (admin) response.sendRedirect("accountAdmin.jsp");
        else response.sendRedirect("accountUser.jsp");
    }
%>
</body>
</html>
