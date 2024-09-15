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
    <link href="css/styleAccountDriver.css" rel="stylesheet">
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
                <button class="list-button" id="crearDriver">Crear cuenta conductor</button>
            </li>
            <li>
                <button class="list-button" id="crearAdmin">Crear cuenta admin</button>
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
        <p class="info-extra">Actualmente tienes <%=controller.numShipmentsPendings()%> envíos pendientes de
            entrega.</p>
        <p class="info-extra">La siguiente información ha sido proporcionada por la empresa FernanPaaq al momento de crear su cuenta.
            Este conjunto de datos refleja los detalles iniciales que hemos registrado para usted.
            Si considera que es necesario realizar alguna modificación o actualización en la información aquí presentada,
            le invitamos a que dirija su atención a la pestaña correspondiente en nuestro sistema.
            Si necesita asistencia adicional o tiene alguna consulta específica, no dude en contactar con nuestro equipo de soporte
            para recibir la ayuda que requiera.</p>
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
                <span>C/<%=admin.getId()%></span>
                <a class="edit-item" id="street-num" href="#">
                    <img alt="edit"
                         src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAnJJREFUSEulV1uSxCAIhJNt5mSZnGxzMzcgKC+TVG2+MkZtaJrWQRgPAkKDxr8RQN7ofY7P2etxO2f1Tnv+4/Hhaaj1qE+m/5LHLrDTVuM++8lQkQlvIfvI+13G2xMZJqTTzKV1P4CwQQMaP/q3Z+D9mvZNoD5xS9QXGh6SMYHS+hg0J+iKkPYTJa1wQkAUoGTEYBaUst3MPo7dqsZd2ACfiuognVMmG1CeoQFZ9k4E+OjmaOsuQOObk11BgQxN0FlGVC2ZvlS2mfSUfpNiIYBdXCpfasn0hrgkY9w5+/6RqB8sZlV7F5l6zBkT2N66eukhMCtK/i3LTgAW4FB/p9oXs6baz4lCMiJDJU11rC1lW650rgQcRFaCGq3s1/tXakyCOi5Wzphdp9orbAIHCV91WmQ6/NypWFpNMvXcGuDR4KuMt0tvJBYxB/wiNMpG7bAAxdMYSw9Alf+yxlsD+B2UI1i3ot32S5OD3pkp706B0lqnp1d9bPXH9RO3kqBv6OVQSwZzO9UTdbFVL+25Bp0laELvyjKHRzQ5wuzEKuoOOs2BPNu1THTCqFXfLWwgrFJqSH2if/94c4ADAcS3UysUQdc3kCq7EcPclt9Kcwh9fwPspX0D7LKhVhF6i96YvVOL6007zYM9XQiLmiajaIJsNKNUp4yHJKsjOTpdPSfrI5lVXHh7EbDu84QoEarx+HZKVNeX6BJjturq7u2WFVTnI69Hqb467GclouEB3n46d6QDPY+N6xrQ0Cp6GOQTO/F9G1BlKuXVJ1xELR0FQGJlXfkn52K66hweUGbRHaV6dFr5VFefl3/aPBOrP3ZV0WnlHxB1HDa/ZT6xAAAAAElFTkSuQmCC"/>
                </a>
            </div>
            <div class="info-container">
                <h3>Zonas de entrega asignadas</h3>
                <%
                    String zonas;/* = admin.getDeliveryZoneToString();*/
                %>
                <span></span>
                <a class="edit-item" id="city-state-postalCode" href="#"></a>
            </div>
        </div>
    </section>

    <section class="info-empresa" id="infoEmpresa">
        <%
            ArrayList<Message> messages = new ArrayList<>();/* = controller.messageForPackageDriver(driver.getId());*/
            if (messages == null || messages.isEmpty()) {
        %>
        <p class="not-info">No tienes chats abiertos actualmente</p>
        <%
        } else {
        %>
        <p>Tienes <%=messages.size()%> mensajes</p>
        <%
            }
        %>
    </section>

    <!--SECCIÓN PARA AÑADIR UNA NUEVA ZONA DE ENTREGA-->
    <section class="sin-asignar" id="sinAsignar">
        <h2>Añadir nueva zona de entregas</h2>
        <p class="info-extra">En esta sección, podrá introducir un nuevo código postal para sus áreas de entrega.
            Tenga en cuenta que, al añadir un nuevo código postal, los paquetes futuros que no tengan un conductor asignado se
            asignarán automáticamente al conductor disponible que cubra dicho código postal en nuestra base de datos.</p>
        <%
            if (session.getAttribute("addSuccess") == null) {
        %>
        <form action="addZonaEntregaDispatch.jsp" method="post" class="all-change-container">

            <label>Introduce un nuevo codigo postal
                <%
                    if (session.getAttribute("postalExiste") != null) {
                        session.removeAttribute("postalExiste");
                %>
                <p class="text-red">Este código postal ya existe, introduzca uno nuevo.</p>
                <%
                    }
                %>
                <%
                    if (session.getAttribute("postalNull") != null) {
                        session.removeAttribute("postalNull");
                %>
                <p class="text-red">No has introducido nada, por favor, añade un código postal</p>
                <%
                    }
                %>
                <input type="number" placeholder="Introduce un código postal" name="zonaEntregaNew">
            </label>
            <div class="button-form">
                <button type="submit">Añadir</button>
            </div>
        </form>
        <%
        } else {
        %>
        <div class="successAdd">
            <h2>Zona de entrega añadida correctamente</h2>
            <p class="info-extra">Se ha añadido una nueva zona de entrega a su perfil.
                A partir de ahora, la eliminación de zonas de entrega solo podrá ser realizada por un administrador.
                Si ha cometido un error al añadir esta zona, le solicitamos que se comunique con un superior para que
                pueda asistirle con la corrección.</p>
            <div class="button-form">
                <a href="borrarDriverDispatch.jsp"><button>Volver atrás</button></a>
            </div>
        </div>
        <%
            }
        %>
    </section>


    <!--SECCION QUE MUESTRA LOS PAQUETES ENVIADOS POR EL USUARIO-->

    <section class="resumen-users" id="resumenUsuarios">
        <h2>Envíos pendientes de entregar</h2>
        <p class="info-extra">En esta sección, tiene la posibilidad de consultar la información detallada sobre los envíos
            que aún quedan por entregar. Aquí podrá revisar los detalles específicos de cada paquete pendiente, incluyendo
            la dirección de entrega, el estado del envío y cualquier otra información relevante para la gestión de sus tareas diarias.</p>
        <div class="card-container">
            <%
                ArrayList<User> users = controller.getUsers();
                if (!users.isEmpty()) {
            %>
            <p class="not-info">No se ha encontrado información sobre envíos pendientes de entregar</p>
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
        <p class="not-info">No se han encontrado envíos para modificar</p>
        <%
            }
            Shipment shipmentFound = (Shipment) session.getAttribute("shipmentFound");
            if (shipmentFound == null && session.getAttribute("packageUpdateState") == null) {
        %>
        <div class="form-change">
            <form method="post" action="findPackageDriver.jsp">
                <label>Id del envío a modificar:</label>
                <%
                    String fails = (String) session.getAttribute("idNull");

                    if (fails != null) {
                        session.removeAttribute("idNull");
                %>
                <p class="text-red">Debes introducir un id</p>
                <%
                    }
                %>
                <%
                    String notFound = (String) session.getAttribute("shipmentNotFound");

                    if (notFound != null) {
                        session.removeAttribute("shipmentNotFound");
                %>
                <p class="text-red">No se han encontrado el envio para modificar</p>
                <%
                    }
                %>
                <input type="text" name="idPackage" placeholder="Introduce número identificativo del paquete">
                <button class="button-form">Modificar</button>
            </form>
        </div>
        <%
            for (Driver s : drivers) {
        %>
        <div class="target-package">
            <%=s.resumeForAdmin()%>
        </div>
        <%
            }
        } else if (shipmentFound != null && session.getAttribute("packageUpdateState") == null) {
        %>
        <h3>Selecciona el estado del envío haciendo clic en la opción deseada.</h3>
        <div class="option-status">
            <div class="options">
                <a href="changeStatus.jsp?status=1">En oficina de origen</a>
                <a href="changeStatus.jsp?status=2">En almacén</a>
                <a href="changeStatus.jsp?status=3">En reparto</a>
                <a href="changeStatus.jsp?status=4">Entregado</a>
            </div>
        </div>
        <%
            }
            if (session.getAttribute("packageUpdateState") != null) {
                session.removeAttribute("packageUpdateState");
        %>
        <div class="finished-container">
            <h2>Envío actualizado con exito</h2>
            <p class="info-extra">Te informamos que el estado del envío ha sido actualizado exitosamente
                Si tienes alguna pregunta o necesitas más detalles sobre este envío, no dudes en ponerte en contacto con
                nuestro equipo de soporte. Tu atención al detalle y dedicación en la gestión de los envíos son cruciales
                para ofrecer un servicio de calidad a nuestros clientes.</p>
            <!--CREAR EL BORRARDISPATCH PARA QUE FUNCIONE AQUI-->
            <a href="borrarDriverDispatch.jsp"><button>Volver atrás</button></a>
        </div>
        <%
            }
        %>

    </section>

    <!--SECCION QUE VEO SOLO LA INFORMACION DE LOS PAQUETES QUE YA HE RECIBIDO Y QUE RECIBIRÉ-->

    <!--tengo que hacer dos secciones dentro de esto, que estén separadas por botones, si pulso el botón de "Entregados" debo mostrar
    los envios que ya me han sido entregados, si pulso el botón de "En curso" me mostrara la información de los paquetes
    que todavia no me han entregado y siguen siendo despachados por la empresa-->
    <section class="envios-finished" id="configProperties">
        <h2>Envíos que me han realizado</h2>
        <p class="info-extra">Esta opción permite al usuario ver todos los paquetes que le han enviado a través del
            sistema.
            Aquí se muestra un listado detallado de cada envío, incluyendo información como la fecha de expedición, la
            entrega estimada,
            el estado actual del paquete, la dirección de destino, el remitente y el destinatario. Esta sección
            proporciona una
            forma rápida y sencilla de gestionar y hacer
            seguimiento de todos los paquetes, manteniendo al usuario informado en todo momento sobre el estado de los
            paquetes.</p>

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
</main>



<!--Comienzo del footer-->
<footer class="footer">
    <div class="container-footer">
        <p>&copy; 2024 FernanPaaq. Todos los derechos reservados.</p>
    </div>
</footer>

<script src="jscript/cuentaDriver.js"></script>
<%
    }
%>
<!--Fin del footer-->
</body>
</html>
