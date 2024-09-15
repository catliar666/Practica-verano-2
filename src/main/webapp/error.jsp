<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 03/08/2024
  Time: 0:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/styleError&Sucess.css" rel="stylesheet">
    <link href="css/styleHeader.css" rel="stylesheet">
    <link href="css/styleFooterWhite.css" rel="stylesheet">
    <link href="css/styleResponsiveAll.css" rel="stylesheet">

    <!--Links iconos-->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <title></title>
</head>
<body>

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
    </div>
</header>

<!--Fin de la barra de navegación-->

<main>
    <section class="container-info">
        <div class="info-box">
            <h3>Ha ocurrido un error al realizar su petición</h3>
            <div class="option-container">
                <a href="index.jsp">
                    Pulse aquí para continuar
                </a>

            </div>
        </div>
    </section>
</main>

<footer class="footer">
    <div class="container-footer">
        <p>&copy; 2024 FernanPaaq. Todos los derechos reservados.</p>
    </div>
</footer>

<script src="https://kit.fontawesome.com/a85738640e.js" crossorigin="anonymous"></script>
</body>
</html>
