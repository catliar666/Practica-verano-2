<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 08/08/2024
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="appcontroller.AppController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dataclass.InfoShipmentDataClass" %>
<%@ page import="models.*" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/styleAccountAdmin.css" rel="stylesheet">
    <link href="css/styleHeader.css" rel="stylesheet">
    <link href="css/styleFails.css" rel="stylesheet">
    <link href="css/styleFooterWhite.css" rel="stylesheet">
    <link href="css/styleResponsiveAll.css" rel="stylesheet">

    <!--Links iconos-->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <title>Cuenta de conductor</title>
</head>
<body>

<%
    Admin admin = (Admin) session.getAttribute("usuarioLogueado");
    AppController controller = new AppController();
    if (admin == null) {
        response.sendRedirect("index.jsp");
        return;
    } else {
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
        <a class="nav_welcome">Bienvenido <%= admin.getName()%>
        </a>
    </div>
</header>

<!--Fin de la barra de navegación-->

<main>

    <section class="list-vertical">
        <h2>Ajustes de cuenta</h2>
        <ul>
            <li>
                <button class="list-button" id="verPerfil">Datos del perfil</button>
            </li>
            <li>
                <button class="list-button" id="modificarPerfil">Modificar mis datos</button>
            </li>
            <li>
                <button class="list-button" id="infoApp">Información de la empresa</button>
            </li>
            <li>
                <button class="list-button" id="enviosSinAsignar">Envíos sin asignar</button>
            </li>
            <li>
                <button class="list-button" id="resumenUsers">Resumen de usuarios</button>
            </li>
            <li>
                <button class="list-button" id="resumenDriver">Resumen de conductores</button>
            </li>
            <li>
                <button class="list-button" id="crearCuentas">Crear cuentas</button>
            </li>
            <li>
                <button class="list-button" id="configWeb">Configuración web</button>
            </li>
            <li>
                <button class="list-button" id="copiaSeguridad">Copia de seguridad</button>
            </li>
            <li><a href="closeSessionDispatch.jsp">
                <button class="list-button" id="cerrarSesion">Cerrar Sesión</button>
            </a></li>
        </ul>
    </section>

    <section class="info-perfil" id="infoPerfil">
        <h2>Datos del perfil</h2>
        <p class="info-extra">Actualmente usted ha iniciado sesión en una cuenta administradora, por lo tanto, cualquier cambio
        podrá realizarlo aquí.</p>
        <div class="all-info-container">
            <div class="info-container">
                <h3>Información de contacto:</h3>
                <span><%=admin.getEmail()%></span>
                <a class="edit-item" id="email-phone" href="#">
                    <img alt="edit"
                         src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAnJJREFUSEulV1uSxCAIhJNt5mSZnGxzMzcgKC+TVG2+MkZtaJrWQRgPAkKDxr8RQN7ofY7P2etxO2f1Tnv+4/Hhaaj1qE+m/5LHLrDTVuM++8lQkQlvIfvI+13G2xMZJqTTzKV1P4CwQQMaP/q3Z+D9mvZNoD5xS9QXGh6SMYHS+hg0J+iKkPYTJa1wQkAUoGTEYBaUst3MPo7dqsZd2ACfiuognVMmG1CeoQFZ9k4E+OjmaOsuQOObk11BgQxN0FlGVC2ZvlS2mfSUfpNiIYBdXCpfasn0hrgkY9w5+/6RqB8sZlV7F5l6zBkT2N66eukhMCtK/i3LTgAW4FB/p9oXs6baz4lCMiJDJU11rC1lW650rgQcRFaCGq3s1/tXakyCOi5Wzphdp9orbAIHCV91WmQ6/NypWFpNMvXcGuDR4KuMt0tvJBYxB/wiNMpG7bAAxdMYSw9Alf+yxlsD+B2UI1i3ot32S5OD3pkp706B0lqnp1d9bPXH9RO3kqBv6OVQSwZzO9UTdbFVL+25Bp0laELvyjKHRzQ5wuzEKuoOOs2BPNu1THTCqFXfLWwgrFJqSH2if/94c4ADAcS3UysUQdc3kCq7EcPclt9Kcwh9fwPspX0D7LKhVhF6i96YvVOL6007zYM9XQiLmiajaIJsNKNUp4yHJKsjOTpdPSfrI5lVXHh7EbDu84QoEarx+HZKVNeX6BJjturq7u2WFVTnI69Hqb467GclouEB3n46d6QDPY+N6xrQ0Cp6GOQTO/F9G1BlKuXVJ1xELR0FQGJlXfkn52K66hweUGbRHaV6dFr5VFefl3/aPBOrP3ZV0WnlHxB1HDa/ZT6xAAAAAElFTkSuQmCC"/>
                </a>
            </div>
            <div class="info-container">
                <h3>Nombre:</h3>
                <span><%=admin.getName()%></span>
                <a class="edit-item" id="name-surname" href="#">
                    <img alt="edit"
                         src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAnJJREFUSEulV1uSxCAIhJNt5mSZnGxzMzcgKC+TVG2+MkZtaJrWQRgPAkKDxr8RQN7ofY7P2etxO2f1Tnv+4/Hhaaj1qE+m/5LHLrDTVuM++8lQkQlvIfvI+13G2xMZJqTTzKV1P4CwQQMaP/q3Z+D9mvZNoD5xS9QXGh6SMYHS+hg0J+iKkPYTJa1wQkAUoGTEYBaUst3MPo7dqsZd2ACfiuognVMmG1CeoQFZ9k4E+OjmaOsuQOObk11BgQxN0FlGVC2ZvlS2mfSUfpNiIYBdXCpfasn0hrgkY9w5+/6RqB8sZlV7F5l6zBkT2N66eukhMCtK/i3LTgAW4FB/p9oXs6baz4lCMiJDJU11rC1lW650rgQcRFaCGq3s1/tXakyCOi5Wzphdp9orbAIHCV91WmQ6/NypWFpNMvXcGuDR4KuMt0tvJBYxB/wiNMpG7bAAxdMYSw9Alf+yxlsD+B2UI1i3ot32S5OD3pkp706B0lqnp1d9bPXH9RO3kqBv6OVQSwZzO9UTdbFVL+25Bp0laELvyjKHRzQ5wuzEKuoOOs2BPNu1THTCqFXfLWwgrFJqSH2if/94c4ADAcS3UysUQdc3kCq7EcPclt9Kcwh9fwPspX0D7LKhVhF6i96YvVOL6007zYM9XQiLmiajaIJsNKNUp4yHJKsjOTpdPSfrI5lVXHh7EbDu84QoEarx+HZKVNeX6BJjturq7u2WFVTnI69Hqb467GclouEB3n46d6QDPY+N6xrQ0Cp6GOQTO/F9G1BlKuXVJ1xELR0FQGJlXfkn52K66hweUGbRHaV6dFr5VFefl3/aPBOrP3ZV0WnlHxB1HDa/ZT6xAAAAAElFTkSuQmCC"/>
                </a>
            </div>
            <div class="info-container">
                <h3>Número de identificación:</h3>
                <span><%=admin.getId()%></span>
                <a class="edit-item" id="street-num" href="#">
                    <img alt="edit"
                         src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAnJJREFUSEulV1uSxCAIhJNt5mSZnGxzMzcgKC+TVG2+MkZtaJrWQRgPAkKDxr8RQN7ofY7P2etxO2f1Tnv+4/Hhaaj1qE+m/5LHLrDTVuM++8lQkQlvIfvI+13G2xMZJqTTzKV1P4CwQQMaP/q3Z+D9mvZNoD5xS9QXGh6SMYHS+hg0J+iKkPYTJa1wQkAUoGTEYBaUst3MPo7dqsZd2ACfiuognVMmG1CeoQFZ9k4E+OjmaOsuQOObk11BgQxN0FlGVC2ZvlS2mfSUfpNiIYBdXCpfasn0hrgkY9w5+/6RqB8sZlV7F5l6zBkT2N66eukhMCtK/i3LTgAW4FB/p9oXs6baz4lCMiJDJU11rC1lW650rgQcRFaCGq3s1/tXakyCOi5Wzphdp9orbAIHCV91WmQ6/NypWFpNMvXcGuDR4KuMt0tvJBYxB/wiNMpG7bAAxdMYSw9Alf+yxlsD+B2UI1i3ot32S5OD3pkp706B0lqnp1d9bPXH9RO3kqBv6OVQSwZzO9UTdbFVL+25Bp0laELvyjKHRzQ5wuzEKuoOOs2BPNu1THTCqFXfLWwgrFJqSH2if/94c4ADAcS3UysUQdc3kCq7EcPclt9Kcwh9fwPspX0D7LKhVhF6i96YvVOL6007zYM9XQiLmiajaIJsNKNUp4yHJKsjOTpdPSfrI5lVXHh7EbDu84QoEarx+HZKVNeX6BJjturq7u2WFVTnI69Hqb467GclouEB3n46d6QDPY+N6xrQ0Cp6GOQTO/F9G1BlKuXVJ1xELR0FQGJlXfkn52K66hweUGbRHaV6dFr5VFefl3/aPBOrP3ZV0WnlHxB1HDa/ZT6xAAAAAElFTkSuQmCC"/>
                </a>
            </div>
        </div>
    </section>

    <section class="info-empresa" id="infoEmpresa">
        <h2>Información de la página web</h2>
        <p class="info-extra">Este sistema ofrece la capacidad de consultar y gestionar información relevante sobre usuarios, conductores,
            y envíos.
            Permite obtener el número total de usuarios registrados, la cantidad de conductores disponibles, y la cantidad de envíos
            que están pendientes. Además, proporciona detalles sobre envíos que aún no tienen un conductor asignado y aquellos que no
            tienen un usuario asignado. También calcula el promedio de días necesarios para entregar un paquete, desde su registro hasta
            la entrega final.
            Es fundamental tener en cuenta que todos estos datos se actualizan automáticamente en tiempo real.</p>
        <div class="all-info-container">
            <div class="info-container">
                <h3>Número de usuarios:</h3>
                <span><%=controller.numUsers()%></span>
            </div>
            <div class="info-container">
                <h3>Número de conductores:</h3>
                <span><%=controller.numDrivers()%></span>
            </div>
            <div class="info-container">
                <h3>Número de envíos pendientes de entrega:</h3>
                <span><%=controller.numShipmentsPendings()%></span>
            </div>
            <div class="info-container">
                <h3>Número de envios sin conductor:</h3>
                <span><%=controller.numShipmentsToAssing()%></span>
            </div>
            <div class="info-container">
                <h3>Número de envios con usuarios no registrados:</h3>
                <span><%=controller.numShipmentsToNoUserRegister()%></span>
            </div>
            <div class="info-container">
                <h3>Promedio de días que tardamos en entregar un paquete:</h3>
                <span><%=controller.numDaysToDeliver()%></span>
            </div>
        </div>
    </section>

    <!--SECCIÓN PARA AÑADIR UNA NUEVA ZONA DE ENTREGA-->
    <section class="sin-asignar" id="sinAsignar">
        <h2>Asignar paquetes a un conductor</h2>
        <p class="info-extra">En esta sección, podrá introducir un nuevo código postal para sus áreas de entrega.
            Tenga en cuenta que, al añadir un nuevo código postal, los paquetes futuros que no tengan un conductor asignado se
            asignarán automáticamente al conductor disponible que cubra dicho código postal en nuestra base de datos.</p>

    </section>


    <!--SECCION QUE MUESTRA LOS PAQUETES ENVIADOS POR EL USUARIO-->

    <section class="resumen-users" id="resumenUsuarios">
        <h2>Resumen de usuarios</h2>
        <p class="info-extra">Esta sección, se encarga de mostrar la información de todos los usuarios
            que se han registrado en la web. Presenta detalles como nombre, correo electrónico, dirección, etc.
            Esta funcionalidad permite a los administradores tener un control claro sobre la base de usuarios.</p>
        <div class="card-container">
            <%
                ArrayList<User> users = controller.getUsers();
                if (users.isEmpty()) {
            %>
            <p class="not-info">No se ha encontrado información sobre usuarios registrados</p>
            <%
            } else {
                for (User u : users) {
            %>
            <div class="target-package">
                <%=u.resumeForAdmin()%>
            </div>
            <%
                    }
                }
            %>
        </div>
    </section>


    <!--SECCIÓN QUE MUESTRA MIS PAQUETES Y ME DA A ELEGIR EN CUÁL MODIFICAR LA INFORMACIÓN-->
    <section class="resumen-driver" id="resumenConductores">
        <h2>Modificar estado de un envío</h2>
        <p class="info-extra">En esta sección, se le brinda la oportunidad de modificar la información
            de un paquete que aún no ha sido entregado. Podrá actualizar tanto la dirección de destino del
            paquete como el nombre del destinatario.
            Estos datos pueden ser modificados tantas veces como lo considere necesario.
            <span class="text-bold">Introduzca el ID en el buscador.</span>
        </p>

        <%
            ArrayList<Driver> drivers = controller.getDrivers();

            if (drivers.isEmpty()) {
        %>
        <p class="not-info">No se han encontrado conductores registrados</p>
        <%
            } else {
                for (Driver d : drivers) {
        %>
        <div class="target-package">
            <%=d.resumeForAdmin()%>
        </div>
        <%
                }
            }
        %>

    </section>

    <!--SECCION QUE SIRVE PARA CREAR CUENTAS TANTO DE ADMINISTRADOR COMO DE CONDUCTOR-->
    <section class="crear-cuentas" id="createDriver">
        <h2>Crear cuentas de conductor o administrador</h2>
        <p class="info-extra">Aquí podrás crear las cuentas de conductor y de administrador según las preferencias del administrador.</p>

        <div class="btn-box">
            <button class="btn btn-1" id="crearConductor">Crear Conductor</button>
            <button class="btn btn-2" id="crearAdministrador">Crear Administrador</button>
        </div>

        <div class="driver-container" id="drivercontainer">
            <%
                String email = (String) session.getAttribute("emailNoRegisterDriver");
                if (email == null) {
            %>
            <form method="post" action="findEmailDispatch.jsp?accountAdmin=driver">
                <div class="input-box">
                    <%
                        if (session.getAttribute("emailUse") != null) {
                            session.removeAttribute("emailUse");
                    %>
                    <p class="text-red">El email introducido ya está en uso</p>
                    <%
                        }
                    %>
                    <input type="email" name="registerEmail" class="input-field" placeholder="Introduce tu email" required>
                    <i class="bx bx-envelope icon"></i>
                </div>
                <div class="button-form">
                    <button type="submit">Enviar</button>
                </div>
            </form>
            <%
            } else {
            %>
            <form method="post" action="createDriverDispatch.jsp">
                <div class="all-make-container makePackage">
                    <div class="make-container">
                        <label>Introduce un email:</label>
                        <%
                            if (session.getAttribute("emailNull") != null) {
                                session.removeAttribute("emailNull");
                        %>
                        <p class="fail">Debes introducir un email</p>
                        <%
                            }
                        %>
                        <input type="email" name="email" placeholder="Introduce un email" value="<%= email %>" pattern="^[^<>]*$" required>
                    </div>

                    <!-- Otras secciones para capturar la dirección, ciudad, etc. -->
                    <!-- Ingresar el nombre -->
                    <div class="make-container">
                        <label>Introduce un nombre:</label>
                        <%
                            if (session.getAttribute("nameNull") != null) {
                                session.removeAttribute("nameNull");
                        %>
                        <p class="fail">Debes introducir un nombre</p>
                        <%
                            }
                        %>
                        <input type="text" name="name" placeholder="Introduce un nombre" pattern="^[^<>]*$" required>
                    </div>

                    <!-- Ingresar la contraseña -->
                    <div class="make-container">
                        <label>Introduce una contraseña:</label>
                        <%
                            if (session.getAttribute("passNull") != null) {
                                session.removeAttribute("passNull");
                        %>
                        <p class="fail">Debes introducir una contraseña</p>
                        <%
                            }
                        %>
                        <input type="password" name="pass" placeholder="Introduce una contraseña" pattern="^[^<>]*$" required>
                    </div>
                    <div class="button-form">
                        <button type="submit">Enviar</button>
                    </div>
                </div>
            </form>
            <%
                }
            %>
        </div>

        <div class="admin-container" id="admincontainer">
            <%
                String emailAdmin = (String) session.getAttribute("emailNoRegisterAdmin");
                if (emailAdmin == null) {
            %>
            <form method="post" action="findEmailDispatch.jsp?accountAdmin=admin">
                <div class="input-box">
                    <%
                        if (session.getAttribute("emailUse") != null) {
                            session.removeAttribute("emailUse");
                    %>
                    <p class="text-red">El email introducido ya está en uso</p>
                    <%
                        }
                    %>
                    <input type="email" name="registerEmail" class="input-field" placeholder="Introduce tu email" required>
                    <i class="bx bx-envelope icon"></i>
                </div>
                <div class="button-form">
                    <button type="submit">Enviar</button>
                </div>
            </form>
            <%
            } else {
            %>
            <form method="post" action="createAdminDispatch.jsp">
                <div class="all-make-container makePackage">
                    <div class="make-container">
                        <label>Introduce un email:</label>
                        <%
                            if (session.getAttribute("emailNull") != null) {
                                session.removeAttribute("emailNull");
                        %>
                        <p class="fail">Debes introducir un email</p>
                        <%
                            }
                        %>
                        <input type="email" name="email" placeholder="Introduce un email" value="<%= emailAdmin %>" pattern="^[^<>]*$" required>
                    </div>

                    <!-- Ingresar el nombre -->
                    <div class="make-container">
                        <label>Introduce un nombre:</label>
                        <%
                            if (session.getAttribute("nameNull") != null) {
                                session.removeAttribute("nameNull");
                        %>
                        <p class="fail">Debes introducir un nombre</p>
                        <%
                            }
                        %>
                        <input type="text" name="name" placeholder="Introduce un nombre" pattern="^[^<>]*$" required>
                    </div>

                    <!-- Ingresar la contraseña -->
                    <div class="make-container">
                        <label>Introduce una contraseña:</label>
                        <%
                            if (session.getAttribute("passNull") != null) {
                                session.removeAttribute("passNull");
                        %>
                        <p class="fail">Debes introducir una contraseña</p>
                        <%
                            }
                        %>
                        <input type="password" name="pass" placeholder="Introduce una contraseña" pattern="^[^<>]*$" required>
                    </div>
                    <div class="button-form">
                        <button type="submit">Enviar</button>
                    </div>
                </div>
            </form>
            <%
                if (session.getAttribute("register") != null) {
                    session.removeAttribute("register");
            %>
            <p class="successAdd">Administrador registrado con éxito</p>
            <%
                }
                if (session.getAttribute("fail") != null) {
                    session.removeAttribute("fail");
            %>
            <p class="fail">No se ha podido registrar al administrador</p>
            <%
                    }
                }
            %>
        </div>
    </section>

    <!--SECCION QUE VEO SOLO LA INFORMACION DE LOS PAQUETES QUE YA HE RECIBIDO Y QUE RECIBIRÉ-->

    <!--tengo que hacer dos secciones dentro de esto, que estén separadas por botones, si pulso el botón de "Entregados" debo mostrar
    los envios que ya me han sido entregados, si pulso el botón de "En curso" me mostrara la información de los paquetes
    que todavia no me han entregado y siguen siendo despachados por la empresa-->
    <section class="config-properties" id="configProperties">
        <h2>Envíos que me han realizado</h2>
        <p class="info-extra">Configuración properties muajaja</p>

        <!--MODIFICAR EL JAVASCRIPT PARA MOSTRAR LOS PEDIDOS ORDENADOS POR, ENTREGADOS O NO ENTREGADOS-->
        <div class="card-container-finished" id="card-container-finished">
            <%
                ArrayList<String> info = controller.getInfoProperties();

                if (info.isEmpty()) {
            %>
            <p class="not-info">Por ahora, no tienes ningún envío finalizado.</p>
            <%
            } else {
                for (String s : info) {
            %>
            <div class="target-package">
                <%=s%>
            </div>
            <%
                    }
                }
            %>
        </div>
    </section>

    <section class="modify-perfil" id="modifyPerfil">
        <h2>Modificar datos de mi perfil</h2>
        <p class="info-extra">En esta sección, podrá actualizar los datos de su cuenta de manera rápida, segura y
            eficiente.
            Cada campo estará pre-relleno con la información actual.
            Para realizar modificaciones, simplemente haga clic en cada opción y proporcione la nueva información
            deseada.</p>
        <%
            if (session.getAttribute("changePassYes") == null) {
        %>
        <%
            if (session.getAttribute("modifySuccess") != null) {
                session.removeAttribute("modifySuccess");
        %>
        <p class="text-red">Perfil modificado con éxito</p>
        <%
            }
            if (session.getAttribute("modifyError") != null) {
                session.removeAttribute("modifyError");
        %>
        <p class="text-red">No se ha podido modificar el perfil</p>
        <%
            }
        %>
        <%
            if (session.getAttribute("fails") != null) {
                session.removeAttribute("fails");
        %>
        <p class="text-red">Algo ha ido mal</p>
        <%
            }
        %>
        <form method="post" action="changeInfoAccountDriver.jsp" class="all-change-container">
            <div class="info-container">
                <h3>Email:</h3>
                <input type="text" name="emailNew" value="<%=admin.getEmail()%>">
            </div>
            <div class="info-container">
                <h3>Nombre:</h3>
                <input type="text" name="nameNew" value="<%=admin.getName()%>">
            </div>
            <div class="button-form">
                <button type="submit">Modificar</button>
                <a href="changePassword.jsp">Cambiar contraseña</a>
            </div>
        </form>
        <%
        } else {
        %>
        <form method="post" action="changePassword.jsp" class="all-change-container">
            <%
                if (session.getAttribute("passOldNull") != null) {
                    session.removeAttribute("passOldNull");
            %>
            <p class="text-red">Debes introducir la contraseña antigua</p>
            <%
                }
            %>
            <%
                if (session.getAttribute("passEquals") != null) {
                    session.removeAttribute("passEquals");
            %>
            <p class="text-red">La nueva contraseña no debe ser igual a la anterior</p>
            <%
                }
            %>
            <%
                if (session.getAttribute("passUpdate") != null) {
                    session.removeAttribute("passUpdate");
            %>
            <p class="text-red">Contraseña actualizada con éxito</p>
            <%
                }
            %>
            <div class="info-container">
                <h3>Contraseña antigua</h3>
                <input type="password" name="passOld" placeholder="Introduzca la antigua contraseña">
            </div>
            <%
                if (session.getAttribute("passNull") != null) {
                    session.removeAttribute("passNull");
            %>
            <p class="text-red">Debes introducir la nueva contraseña</p>
            <%
                }
            %>
            <div class="info-container">
                <h3>Nueva contraseña</h3>
                <input type="password" name="passChange" placeholder="Introduzca la nueva contraseña">
            </div>
            <%
                if (session.getAttribute("passNull") != null) {
                    session.removeAttribute("passNull");
            %>
            <p class="text-red">Debes introducir la nueva contraseña</p>
            <%
                }
            %>
            <%
                if (session.getAttribute("passNotEqual") != null) {
                    session.removeAttribute("passNotEqual");
            %>
            <p class="text-red">La nueva contraseña debe ser igual en el campo anterior</p>
            <%
                }
            %>
            <div class="info-container">
                <h3>Repite la nueva contraseña</h3>
                <input type="password" name="pass2Change" placeholder="Repita la nueva contraseña">
            </div>
            <div class="button-form">
                <button type="submit">Modificar</button>
                <a href="borrarDriverDispatch.jsp">Volver atrás</a>
            </div>
        </form>
        <%
            }
        %>
    </section>

    <section class="copy-security" id="copySecurity">

    </section>
</main>



<!--Comienzo del footer-->
<footer class="footer">
    <div class="container-footer">
        <p>&copy; 2024 FernanPaaq. Todos los derechos reservados.</p>
    </div>
</footer>

<script src="jscript/cuentaAdmin.js"></script>
<script src="jscript/opcionCrearMostrar.js"></script>
<%
    }
%>
<!--Fin del footer-->
</body>
</html>
