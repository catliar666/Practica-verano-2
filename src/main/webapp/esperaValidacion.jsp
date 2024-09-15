<%@ page import="models.User" %>
<%@ page import="appcontroller.AppController" %><%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 04/09/2024
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styleQuestionValidate.css" rel="stylesheet">
    <link href="css/styleHeader.css" rel="stylesheet">
    <link href="css/styleFooter.css" rel="stylesheet">
    <link href="css/styleResponsiveAll.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<%
    AppController controller = new AppController();
    User user = (User) session.getAttribute("usuarioLogueado");

    if (user != null) {
        // Obtiene los datos más recientes del usuario desde la base de datos
        user = controller.searchUserById(user.getId());

        if (user.isValidate()) {
            response.sendRedirect("sucess.jsp");
            return;// Detenemos la ejecución después de redirigir
        } else {
            // Mostrar mensaje si la cuenta no está validada
%>
<!-- Comienzo de la barra de navegación -->
<header class="header">
    <nav class="nav">
        <a href="index.jsp" class="nav_logo"><img src="img/Logo fernanpaaq.png" alt="logo" style="width: 75%;"></a> <!--<img src="img/FernanPaaq.png" value="Logotipo FernanPaaq">-->
        <ul class="nav_items">
            <li class="nav_item">
                <a href="index.jsp" class="nav_link">Inicio</a>
                <a href="#" class="nav_link">Sobre nosotros</a>
                <a href="#" class="nav_link">Contacto</a>
            </li>

        </ul>

    </nav>
</header>
<!--Fin de la barra de navegación-->

<main>
    <section class="container-question">
        <div class="question-box">
            <h3>Le hemos enviado un email para validar su cuenta. Siga los pasos del email y actualice esta página</h3>
            <div class="option-container">
                <a href="esperaValidacion.jsp">
                    Actualizar
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
<%
        }
    } else {
        // Redirigir al usuario a index.jsp si no hay sesión activa
        response.sendRedirect("index.jsp");
        return; // Detenemos la ejecución después de redirigir
    }
%>
</body>

</body>
</html>
