<%@ page import="models.User" %>
<%@ page import="models.Driver" %>
<%@ page import="appcontroller.AppController" %>
<%@ page import="utils.Utils" %>
<%@ page import="dataclass.InfoChats" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Message" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 13/10/2024
  Time: 18:34
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
    Object user = session.getAttribute("usuarioLogueado");
    String idPackage = request.getParameter("idPackage");
    String idUser = request.getParameter("user");
    int error = 0;

    if (user == null) {
        session.setAttribute("userNull", "usuario no logueado");
        response.sendRedirect("error.jsp");
        return;
    }

    if (idPackage == null || idPackage.trim().isEmpty() || Utils.VerEtiquetas(idPackage) || Utils.VerInyeccionSql(idPackage)) {
        error++;
    }

    if (idUser == null || idUser.trim().isEmpty() || Utils.VerEtiquetas(idUser) || Utils.VerInyeccionSql(idUser)) {
        error++;
    }

    if (error > 0) {
        session.setAttribute("errorAbrirchat", error);
        response.sendRedirect("error.jsp");
        return;
    }

    int idPackageNum = Integer.parseInt(idPackage), idUserNum = Integer.parseInt(idUser);
    InfoChats chatNew = null;
    if (user instanceof User) {
        Driver driver = controller.searchDriverByIdShipment(idPackageNum);
        ArrayList<Message> mensajesCompletos = controller.messageForUserAll(((User) user).getId());
        if (driver != null) {
            ArrayList<Message> mensajesSender = mensajesCompletos.isEmpty() ? null : controller.mensajesEnviados(idPackageNum, ((User) user).getId(), mensajesCompletos);
            ArrayList<Message> mensajesReciever = mensajesCompletos.isEmpty() ? null : controller.mensajesRecibidos(idPackageNum, ((User) user).getId(), mensajesCompletos);
            chatNew = new InfoChats(idPackageNum, idPackageNum, idUserNum, driver.getId(), mensajesSender, mensajesReciever, LocalDateTime.now());
            session.setAttribute("mostrarChatUser", chatNew);
            response.sendRedirect("chatComplete.jsp");
            return;
        }
    }


    if (user instanceof Driver) {
        User userFind = controller.searchUserByIdShipment(idPackageNum);
        ArrayList<Message> mensajesCompletos = controller.messageForUserAll(((Driver) user).getId());
        if (userFind != null) {
            ArrayList<Message> mensajesSender = mensajesCompletos.isEmpty() ? null : controller.mensajesEnviados(idPackageNum, ((Driver) user).getId(), mensajesCompletos);
            ArrayList<Message> mensajesReciever = mensajesCompletos.isEmpty() ? null : controller.mensajesRecibidos(idPackageNum, ((Driver) user).getId(), mensajesCompletos);
            chatNew = new InfoChats(idPackageNum, idPackageNum, idUserNum, userFind.getId(), mensajesSender, mensajesReciever, LocalDateTime.now());
            session.setAttribute("mostrarChatDriver", chatNew);
            response.sendRedirect("chatComplete.jsp");
            return;
        }
    }

    response.sendRedirect("error.jsp");
%>
</body>
</html>
