<%@ page import="models.User" %>
<%@ page import="appcontroller.AppController" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 03/08/2024
  Time: 0:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/styleHeader.css" rel="stylesheet">
    <link href="css/styleFooter.css" rel="stylesheet">
    <link href="css/styleResponsiveAll.css" rel="stylesheet">

    <!--Links iconos-->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <title>Title</title>
</head>
<body>

<%
    Object user = session.getAttribute("usuarioLogueado");

    if (user != null) {
        if (((User) user).isFirst_login() && !((User) user).isValidate()) {
            response.sendRedirect("questionValidate.jsp");
            return;
        }
    }
%>


<!-- Comienzo de la barra de navegación -->
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
        <a href="message.jsp" class="nav_link"><button class="button"><i class="fa-solid fa-message"></i></button></a>
        <a href="accountUser.jsp" class="nav_link"><button class="button"><i class="fa-solid fa-user"></i></button></a>
        </div>
    </div>
</header>
<script src="https://kit.fontawesome.com/a85738640e.js" crossorigin="anonymous"></script>
<!--Fin de la barra de navegación-->
</body>
</html>
