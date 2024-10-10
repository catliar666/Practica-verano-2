<%@ page import="appcontroller.AppController" %>
<%@ page import="dataclass.InfoChats" %>
<%@ page import="models.User" %>
<%@ page import="models.Driver" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Message" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 01/10/2024
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--ESTILOS DE LA PÁGINA-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/styleChatComplete.css" rel="stylesheet">
    <link href="css/styleHeader.css" rel="stylesheet">
    <link href="css/styleFooterWhite.css" rel="stylesheet">
    <link href="css/styleResponsiveAll.css" rel="stylesheet">
    <!--SCRIPT FUNCIONALIDADES DE LA PÁGINA-->
    <script src="jscript/scroll.js"></script>
    <title>Chat FernanPaaq</title>
</head>
<body>
<%
    AppController controller = new AppController();
    Object user = session.getAttribute("usuarioLogueado");

    if (user == null) response.sendRedirect("index.jsp");
    else {
%>
<header class="header">
    <div class="nav">
        <a href="index.jsp" class="nav_logo"><img src="img/Logo fernanpaaq.png" alt="logo" style="width: 75%;"></a>
        <ul class="nav_items">
            <li class="nav_item">
                <a href="index.jsp" class="nav_link">Inicio</a>
                <a href="sobreNosotros.html" class="nav_link">Sobre nosotros</a>
                <a href="sobreNosotros.html" class="nav_link">Contacto</a>
            </li>

        </ul>
        <div class="nav-icons">
            <a href="chatComplete.jsp" class="nav_link"><button class="button"><i class="fa-solid fa-message"></i></button></a>
            <%
                if (user instanceof User) {
            %>
            <a href="accountUser.jsp" class="nav_link"><button class="button"><i class="fa-solid fa-user"></i></button></a>
                    <%
            } else {
            %>
            <a href="accountDriver.jsp" class="nav_link"><button class="button"><i class="fa-solid fa-user"></i></button></a>
                    <%
                        }
                    %>
                </a>

        </div>
    </div>
</header>
<script src="https://kit.fontawesome.com/a85738640e.js" crossorigin="anonymous"></script>

<main>
<%
    if (user instanceof User) {
        ArrayList<Message> messages = controller.messageForUserAll(((User) user).getId());
        ArrayList<InfoChats> chats = controller.groupsChats(((User) user).getId(), messages);
        InfoChats chatUser = (InfoChats) session.getAttribute("mostrarChatUser");
        if (chatUser == null) response.sendRedirect("error.jsp");
        else {
%>
<section class="list-vertical">
    <h2>Todos los chats</h2>
        <%
            for (InfoChats chat : chats) {
        %>
    <div class="container-chats">
        <div class="card">
            <%=chat.showUserView()%>
        </div>
    </div>
        <%
            }
        %>
</section>



    <div class="chat-container">
        <%
            controller.markReadMessage(chatUser.getMensajesReciever());
        %>
        <%=chatUser.showMessageView(((User) user).getId())%>
        <div class="message-input">
            <form method="post" action="sendMessageDispatch.jsp?idSender=<%=((User) user).getId()%>&idReciever=<%=chatUser.getIdReciever()%>&idChat=<%=chatUser.getIdChat()%>">
                <input type="text" name="mensajeUsuario" placeholder="Escribe tu mensaje aquí" class="message-send">
                <button type="submit" class="button-send">Send</button>
            </form>
        </div>
    </div>
<%
    }
} else if (user instanceof Driver) {
        ArrayList<Message> messages = controller.messageForUserAll(((Driver) user).getId());
        ArrayList<InfoChats> chats = controller.groupsChats(((Driver) user).getId(), messages);
    InfoChats chatDriver = (InfoChats) session.getAttribute("mostrarChatDriver");
    if (chatDriver == null) response.sendRedirect("error.jsp");
    else {
%>
    <section class="list-vertical">
        <h2>Todos los chats</h2>
        <%
            for (InfoChats chat : chats) {
        %>
        <div class="container-chats">
            <div class="card">
                <%=chat.showUserView()%>
            </div>
        </div>
        <%
            }
        %>
    </section>
    <div class="chat-container">
        <%
            controller.markReadMessage(chatDriver.getMensajesReciever());
        %>
    <%=chatDriver.showMessageView(((Driver) user).getId())%>
    <div class="message-input">
    <form method="post" action="sendMessageDispatch.jsp?idSender=<%=((Driver) user).getId()%>&idReciever=<%=chatDriver.getIdReciever()%>&idChat=<%=chatDriver.getIdChat()%>">
        <input type="text" name="mensajeUsuario" placeholder="Escribe tu mensaje aquí" class="message-send">
        <button type="submit" class="button-send">Send</button>
    </form>
</div>
</div>
<%
            }
        } else {
            response.sendRedirect("error.jsp");
        }
    %>
</main>
<footer class="footer">
    <div class="container-footer">
        <p>&copy; 2024 FernanPaaq. Todos los derechos reservados.</p>
    </div>
</footer>
<%
    }
%>

</body>
</html>
