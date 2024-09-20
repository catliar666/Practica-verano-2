<%@ page import="appcontroller.AppController" %>
<%@ page import="dataclass.InfoShipmentDataClass" %>
<%@ page import="models.Shipment" %>
<%@ page import="utils.Utils" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 28/08/2024
  Time: 20:36
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
    String numSeguimientoParam = request.getParameter("numSeguimiento");

// Verificar si el parámetro es nulo o vacío
    if (numSeguimientoParam == null || numSeguimientoParam.isEmpty() || Utils.VerEtiquetas(numSeguimientoParam)) {
        session.setAttribute("numSeguimientoNull", "No introducido");
        response.sendRedirect("seguimientoEnvio.jsp");
        return;
    }

// Convertir el parámetro a entero, ya que sabemos que no es nulo ni vacío
    try {
        int idPackage = Integer.parseInt(numSeguimientoParam);

            Shipment packageNoLogin = controller.searchShipmentById(idPackage);
            if (packageNoLogin != null) {
                session.setAttribute("packageNoLogin", packageNoLogin);
                response.sendRedirect("seguimientoEnvio.jsp");
                return;
            } else {
                session.setAttribute("packageNotFound", "No encontrado");
                response.sendRedirect("seguimientoEnvio.jsp");
                return;
            }
    }catch (NumberFormatException e) {
        session.setAttribute("error", "Debe introducir un número");
        response.sendRedirect("seguimientoEnvio.jsp");
    }
%>
</body>
</html>
