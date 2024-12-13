<%@ page import="appcontroller.AppController" %>
<%@ page import="models.Admin" %>
<%@ page import="models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Message" %>
<%@ page import="dataclass.InfoChats" %>
<%@ page import="models.Driver" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 30/09/2024
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    try {
        AppController controller = new AppController();
        Object user = session.getAttribute("usuarioLogueado");
        int idChat = Integer.parseInt(request.getParameter("idChat"));

        // Verifica si el usuario no está logueado
        if (user == null) {
            response.sendRedirect("index.jsp");
            return; // Detenemos la ejecución después de la redirección
        }

        // Verifica si el usuario es Admin y redirige al panel de admin
        if (user instanceof Admin) {
            response.sendRedirect("indexAdmin.jsp");
            return; // Detenemos la ejecución después de la redirección
        }

        // Si es un usuario normal
        if (user instanceof User) {
            ArrayList<Message> todos = controller.messageForUserAll(((User) user).getId());
            ArrayList<InfoChats> chatsAll = controller.groupsChats(((User) user).getId(), todos);
            InfoChats chatShow = controller.searchChat(idChat, chatsAll);

            // Almacena el chat a mostrar en la sesión y redirige a la página de chat completo
            session.setAttribute("mostrarChatUser", chatShow);
            response.sendRedirect("chatComplete.jsp");
            return;
        }

        // Si es un conductor (Driver)
        if (user instanceof Driver) {
            ArrayList<Message> todos = controller.messageForUserAll(((Driver) user).getId());
            ArrayList<InfoChats> chatsAll = controller.groupsChats(((Driver) user).getId(), todos);
            InfoChats chatShow = controller.searchChat(idChat, chatsAll);

            // Almacena el chat a mostrar en la sesión y redirige a la página de chat completo
            session.setAttribute("mostrarChatDriver", chatShow);
            response.sendRedirect("chatComplete.jsp");
            return;
        }

        // Si no es ninguno de los casos anteriores, muestra un error
        session.setAttribute("error", "Se ha producido un error, no se ha encontrado el chat o no hay conexión");
        response.sendRedirect("error.jsp");

    } catch (Exception e) {
        // Manejo de excepciones
        session.setAttribute("error", e.getMessage());
        response.sendRedirect("error.jsp");
    }
%>

</body>
</html>
