<%@ page import="appcontroller.AppController" %>
<%@ page import="models.User" %>
<%@ page import="models.Shipment" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 10/09/2024
  Time: 17:59
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
    User userLogin = (User) session.getAttribute("usuarioLogueado");
    String infoConfirm = request.getParameter("userResponse");
    String email = (String) session.getAttribute("userFound");
try {
    if (infoConfirm.equals("yes")) {
        User userFound = controller.searchUserByEmail(email);
        if (userFound != null) {
            Shipment shipmentCreate = controller.addShipment(userLogin.getId(), userFound.getId(), true);
            session.removeAttribute("userFound");
            session.setAttribute("packageSuccess", shipmentCreate);
            response.sendRedirect("accountUser.jsp");
            return;
        }
        session.removeAttribute("userFound");
        session.setAttribute("errorUser", "No encontrado");
        response.sendRedirect("accountUser.jsp");

    }
    session.removeAttribute("userFound");
    session.setAttribute("noInfo", email);
    response.sendRedirect("accountUser.jsp");
}catch (Exception e) {
    response.sendRedirect("error.jsp");
}
%>
</body>
</html>
