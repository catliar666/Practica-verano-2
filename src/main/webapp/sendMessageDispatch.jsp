<%@ page import="models.User" %>
<%@ page import="appcontroller.AppController" %>
<%@ page import="utils.Utils" %>
<%@ page import="models.Driver" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 07/10/2024
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>creación de mensaje</title>
</head>
<body>
<%
    try {
        AppController controller = new AppController();
        Object user = session.getAttribute("usuarioLogueado");
        String idSender = request.getParameter("idSender");
        String idReceiver = request.getParameter("idReciever");
        String idChat = request.getParameter("idChat");
        String mensaje = request.getParameter("mensajeUsuario");

        if (user == null) {
            response.sendRedirect("error.jsp");
            return;
        }

        if (idSender == null || idReceiver == null || idChat == null) {
            response.sendRedirect("error.jsp");
            return;
        }

        if (mensaje == null || mensaje.trim().isEmpty() || Utils.VerEtiquetas(mensaje) || Utils.VerInyeccionSql(mensaje)) {
            session.setAttribute("ErrorMensaje", "El mensaje no puede estar vacío o contener etiquetas.");
            response.sendRedirect("chatComplete.jsp");
            return;
        }

        int idSenderNum = Integer.parseInt(idSender);
        int idReceiverNum = Integer.parseInt(idReceiver);
        int idChatNum = Integer.parseInt(idChat);

        if (user instanceof User || user instanceof Driver) {
            if (controller.newMessage(mensaje, idSenderNum, idReceiverNum, idChatNum)) {
                response.sendRedirect("foundChatDispatch.jsp?idChat=" + idChatNum);
                return;
            }
        }

        response.sendRedirect("error.jsp");

    } catch (NumberFormatException e) {
        response.sendRedirect("error.jsp");
    }

%>
</body>
</html>
