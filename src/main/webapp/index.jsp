<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.User" %>
<%@ page import="models.Driver" %>
<%@ page import="models.Admin" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Message" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/styleHeader.css" rel="stylesheet">
    <link href="css/styleFooter.css" rel="stylesheet">
    <link href="css/styleResponsiveAll.css" rel="stylesheet">

    <!--Links iconos-->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <title>FernanPaaq Inicio</title>
</head>
<body>

<%
    Object userLog = session.getAttribute("usuarioLogueado");
    if (userLog != null){
        if (userLog instanceof User) {
            response.sendRedirect("indexUsuario.jsp");
        } else if (userLog instanceof Driver) {
            response.sendRedirect("indexConductor.jsp");
        } else if (userLog instanceof Admin) {
            response.sendRedirect("indexAdmin.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }


%>

<!-- Comienzo de la barra de navegación -->
<header class="header">
    <nav class="nav">
        <a href="index.jsp" class="nav_logo"><img src="img/Logo fernanpaaq.png" alt="logo" style="width: 75%;"></a> <!--<img src="img/FernanPaaq.png" value="Logotipo FernanPaaq">-->
        <ul class="nav_items">
            <li class="nav_item">
                <a href="index.jsp" class="nav_link">Inicio</a>
                <a href="sobreNosotros.html" class="nav_link">Sobre nosotros</a>
                <a href="sobreNosotros.html" class="nav_link">Contacto</a>
            </li>

        </ul>

        <a href="login.jsp" class="nav_link"><button class="button" id="form-open">Login</button></a>

    </nav>
</header>

<!--Fin de la barra de navegación-->

<!--Comienzo del cuerpo principal-->
<main>
<!--Siga su envio, seccion parte 1-->
<header class="section_container header_container">
    <div class="header_content">
        <span class="bg_blur"></span>
        <span class="bg_blur header_blur"></span>
        <h4>Tu paquete, rastreo sin descanso.</h4>
        <h1><span>Siga </span>su envío <span>en tiempo real</span></h1>
        <p>Ahora puedes seguir tu pedido en tiempo real de manera sencilla y
            sin complicaciones con nuestro sistema de rastreo. No necesitas registros adicionales ni hay costos extras.
            ¿A qué esperas para probarlo?
        </p>
        <a href="seguimientoEnvio.jsp"><button class="btn">Seguir envío</button></a>
    </div>
    <div class="header_image">
        <img src="img/personaConPaquete.png" alt="seguimientoEnvio">
    </div>
</header>

<!--Fin del siga su envio, seccion parte 1-->


<!--Sobre Nosotros, seccion parte 2-->

<section class="section_container sobreNosotros">
    <h2 class="section-title">Conócenos más</h2>
    <div class="sobreNosotros_header">
    <a href="sobreNosotros.html" class="sobreNosotros_link">
            <div class="sobreNosotros_card">
                <img src="img/logistica_verde.png" alt="Imagen_verde">
                <h4>Logística verde</h4>
                <p>En FernanPaaq, creemos firmemente que el progreso y la sostenibilidad pueden
                    y deben ir de la mano. Nuestro compromiso con la logística verde es una muestra tangible
                    de nuestros esfuerzos por proteger el medio ambiente mientras continuamos ofreciendo
                    servicios de alta calidad a nuestros clientes. Estamos dedicados a implementar prácticas
                    ecológicas innovadoras y efectivas, siempre buscando reducir nuestra huella de carbono.
                    Cada paso que damos está orientado hacia un futuro más sostenible,
                    sin comprometer la eficiencia y la excelencia en nuestros servicios.</p>
            </div>
    </a>
    <a href="sobreNosotros.html" class="sobreNosotros_link">
        <div class="sobreNosotros_card">
            <img src="img/tio.png" alt="Imagen_seguridad">
            <h4>Seguridad</h4>
            <p>La seguridad de cada paquete que recibimos es nuestra principal prioridad absoluta.
                Reconocemos plenamente que cada envío representa un valor significativo para nuestros
                clientes, motivo por el cual nos comprometemos de manera firme a manejar cada paquete
                con el máximo cuidado y atención que merece. Desde el momento exacto en que recepcionamos su envío hasta su entrega final, implementamos y aplicamos rigurosos controles y procedimientos de seguridad diseñados meticulosamente.</p>
        </div>
    </a>
    <a href="sobreNosotros.html" class="sobreNosotros_link">
        <div class="sobreNosotros_card">
            <img src="img/calidad.png" alt="Imagen_calidad">
            <h4>Calidad</h4>
            <p>Nuestro compromiso con la calidad comienza desde el momento en que usted
                confía su envío a nosotros. Utilizamos sistemas avanzados de seguimiento y
                gestión para asegurar que cada paquete sea monitoreado en tiempo real,
                reduciendo al mínimo los errores y garantizando una entrega puntual.
                Cada miembro de nuestro equipo está altamente capacitado y se compromete
                a mantener los más altos estándares en todas nuestras operaciones logísticas.</p>
        </div>
    </a>
    </div>

</section>

<!--Fin del sobre Nosotros, seccion parte 2-->

<!--Fin del cuerpo principal-->
</main>

<!--Comienzo del footer-->

<footer class="footer">
    <div class="container-footer">
        <p>&copy; 2024 FernanPaaq. Todos los derechos reservados.</p>
    </div>
</footer>

<!--Fin del footer-->

<!-- End Example Code -->
</body>
</html>