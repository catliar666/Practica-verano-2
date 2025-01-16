<%--
  Created by IntelliJ IDEA.
  User: Maria
  Date: 08/08/2024
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.User" %>
<%@ page import="appcontroller.AppController" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Message" %>
<%@ page import="models.Shipment" %>
<%@ page import="dataclass.InfoShipmentDataClass" %>
<%@ page import="dataclass.InfoChats" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/styleAccount.css" rel="stylesheet">
    <link href="css/styleFails.css" rel="stylesheet">
    <link href="css/styleHeader.css" rel="stylesheet">
    <link href="css/styleMessages.css" rel="stylesheet">
    <link href="css/styleFooterWhite.css" rel="stylesheet">
    <link href="css/styleResponsiveAll.css" rel="stylesheet">

    <!--Links iconos-->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <title>Cuenta de Usuario</title>
</head>
<body>

<%
    Object user = session.getAttribute("usuarioLogueado");
    AppController controller = new AppController();
    if (user == null) {
        response.sendRedirect("index.jsp");
        return;
    }
    if (user instanceof User) {
        if (((User) user).isFirst_login() && !((User) user).isValidate()) {
            response.sendRedirect("questionValidate.jsp");
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
        <a class="nav_welcome">Bienvenido <%= ((User) user).getName()%>
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
                <button class="list-button" id="verMensajes">Ver mis mensajes</button>
            </li>
            <li>
                <button class="list-button" id="realizarEnvio">Realizar un envío</button>
            </li>
            <li>
                <button class="list-button" id="enviosRealizados">Envíos que he realizado</button>
            </li>
            <li>
                <button class="list-button" id="modificarEnvio">Modificar datos de un envío</button>
            </li>
            <li>
                <button class="list-button" id="misEnvios">Envíos que me han realizado</button>
            </li>
            <li><a href="closeSessionDispatch.jsp">
                <button class="list-button" id="cerrarSesion">Cerrar Sesión</button>
            </a></li>
        </ul>
    </section>

    <section class="info-perfil" id="infoPerfil">
        <h2>Datos del perfil</h2>
        <p class="info-extra">Actualmente tienes <%=((User) user).numDeliveriesPendingToDeliver()%> envíos pendientes de
            entrega.</p>
        <p class="info-extra">FernanPaaq utiliza la información que proporcionas como base para crear
            nuevos paquetes asociados a tu cuenta. El remitente al ingresar tu correo electrónico para crear un paquete,
            si ya existe una cuenta asociada en nuestro sistema, se utilizarán los datos correspondientes a tu
            perfil.</p>
        <div class="all-info-container">
            <div class="info-container">
                <h3>Información de contacto:</h3>
                <span><%=((User) user).getEmail()%>, <%=((User) user).getPhone()%></span>
                <a class="edit-item" id="email-phone" href="#">
                    <img alt="edit"
                         src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAnJJREFUSEulV1uSxCAIhJNt5mSZnGxzMzcgKC+TVG2+MkZtaJrWQRgPAkKDxr8RQN7ofY7P2etxO2f1Tnv+4/Hhaaj1qE+m/5LHLrDTVuM++8lQkQlvIfvI+13G2xMZJqTTzKV1P4CwQQMaP/q3Z+D9mvZNoD5xS9QXGh6SMYHS+hg0J+iKkPYTJa1wQkAUoGTEYBaUst3MPo7dqsZd2ACfiuognVMmG1CeoQFZ9k4E+OjmaOsuQOObk11BgQxN0FlGVC2ZvlS2mfSUfpNiIYBdXCpfasn0hrgkY9w5+/6RqB8sZlV7F5l6zBkT2N66eukhMCtK/i3LTgAW4FB/p9oXs6baz4lCMiJDJU11rC1lW650rgQcRFaCGq3s1/tXakyCOi5Wzphdp9orbAIHCV91WmQ6/NypWFpNMvXcGuDR4KuMt0tvJBYxB/wiNMpG7bAAxdMYSw9Alf+yxlsD+B2UI1i3ot32S5OD3pkp706B0lqnp1d9bPXH9RO3kqBv6OVQSwZzO9UTdbFVL+25Bp0laELvyjKHRzQ5wuzEKuoOOs2BPNu1THTCqFXfLWwgrFJqSH2if/94c4ADAcS3UysUQdc3kCq7EcPclt9Kcwh9fwPspX0D7LKhVhF6i96YvVOL6007zYM9XQiLmiajaIJsNKNUp4yHJKsjOTpdPSfrI5lVXHh7EbDu84QoEarx+HZKVNeX6BJjturq7u2WFVTnI69Hqb467GclouEB3n46d6QDPY+N6xrQ0Cp6GOQTO/F9G1BlKuXVJ1xELR0FQGJlXfkn52K66hweUGbRHaV6dFr5VFefl3/aPBOrP3ZV0WnlHxB1HDa/ZT6xAAAAAElFTkSuQmCC"/>
                </a>
            </div>
            <div class="info-container">
                <h3>Nombre y apellidos:</h3>
                <span><%=((User) user).getName()%> <%=((User) user).getSurname()%></span>
                <a class="edit-item" id="name-surname" href="#">
                    <img alt="edit"
                         src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAnJJREFUSEulV1uSxCAIhJNt5mSZnGxzMzcgKC+TVG2+MkZtaJrWQRgPAkKDxr8RQN7ofY7P2etxO2f1Tnv+4/Hhaaj1qE+m/5LHLrDTVuM++8lQkQlvIfvI+13G2xMZJqTTzKV1P4CwQQMaP/q3Z+D9mvZNoD5xS9QXGh6SMYHS+hg0J+iKkPYTJa1wQkAUoGTEYBaUst3MPo7dqsZd2ACfiuognVMmG1CeoQFZ9k4E+OjmaOsuQOObk11BgQxN0FlGVC2ZvlS2mfSUfpNiIYBdXCpfasn0hrgkY9w5+/6RqB8sZlV7F5l6zBkT2N66eukhMCtK/i3LTgAW4FB/p9oXs6baz4lCMiJDJU11rC1lW650rgQcRFaCGq3s1/tXakyCOi5Wzphdp9orbAIHCV91WmQ6/NypWFpNMvXcGuDR4KuMt0tvJBYxB/wiNMpG7bAAxdMYSw9Alf+yxlsD+B2UI1i3ot32S5OD3pkp706B0lqnp1d9bPXH9RO3kqBv6OVQSwZzO9UTdbFVL+25Bp0laELvyjKHRzQ5wuzEKuoOOs2BPNu1THTCqFXfLWwgrFJqSH2if/94c4ADAcS3UysUQdc3kCq7EcPclt9Kcwh9fwPspX0D7LKhVhF6i96YvVOL6007zYM9XQiLmiajaIJsNKNUp4yHJKsjOTpdPSfrI5lVXHh7EbDu84QoEarx+HZKVNeX6BJjturq7u2WFVTnI69Hqb467GclouEB3n46d6QDPY+N6xrQ0Cp6GOQTO/F9G1BlKuXVJ1xELR0FQGJlXfkn52K66hweUGbRHaV6dFr5VFefl3/aPBOrP3ZV0WnlHxB1HDa/ZT6xAAAAAElFTkSuQmCC"/>
                </a>
            </div>
            <div class="info-container">
                <h3>Dirección:</h3>
                <span>C/<%=((User) user).getStreet()%>, <%=((User) user).getNum()%></span>
                <a class="edit-item" id="street-num" href="#">
                    <img alt="edit"
                         src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAnJJREFUSEulV1uSxCAIhJNt5mSZnGxzMzcgKC+TVG2+MkZtaJrWQRgPAkKDxr8RQN7ofY7P2etxO2f1Tnv+4/Hhaaj1qE+m/5LHLrDTVuM++8lQkQlvIfvI+13G2xMZJqTTzKV1P4CwQQMaP/q3Z+D9mvZNoD5xS9QXGh6SMYHS+hg0J+iKkPYTJa1wQkAUoGTEYBaUst3MPo7dqsZd2ACfiuognVMmG1CeoQFZ9k4E+OjmaOsuQOObk11BgQxN0FlGVC2ZvlS2mfSUfpNiIYBdXCpfasn0hrgkY9w5+/6RqB8sZlV7F5l6zBkT2N66eukhMCtK/i3LTgAW4FB/p9oXs6baz4lCMiJDJU11rC1lW650rgQcRFaCGq3s1/tXakyCOi5Wzphdp9orbAIHCV91WmQ6/NypWFpNMvXcGuDR4KuMt0tvJBYxB/wiNMpG7bAAxdMYSw9Alf+yxlsD+B2UI1i3ot32S5OD3pkp706B0lqnp1d9bPXH9RO3kqBv6OVQSwZzO9UTdbFVL+25Bp0laELvyjKHRzQ5wuzEKuoOOs2BPNu1THTCqFXfLWwgrFJqSH2if/94c4ADAcS3UysUQdc3kCq7EcPclt9Kcwh9fwPspX0D7LKhVhF6i96YvVOL6007zYM9XQiLmiajaIJsNKNUp4yHJKsjOTpdPSfrI5lVXHh7EbDu84QoEarx+HZKVNeX6BJjturq7u2WFVTnI69Hqb467GclouEB3n46d6QDPY+N6xrQ0Cp6GOQTO/F9G1BlKuXVJ1xELR0FQGJlXfkn52K66hweUGbRHaV6dFr5VFefl3/aPBOrP3ZV0WnlHxB1HDa/ZT6xAAAAAElFTkSuQmCC"/>
                </a>
            </div>
            <div class="info-container">
                <h3>Ciudad:</h3>
                <span><%=((User) user).getCity()%>, <%=((User) user).getState()%>, (<%=((User) user).getPostalCode()%>)</span>
                <a class="edit-item" id="city-state-postalCode" href="#">
                    <img alt="edit"
                         src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAnJJREFUSEulV1uSxCAIhJNt5mSZnGxzMzcgKC+TVG2+MkZtaJrWQRgPAkKDxr8RQN7ofY7P2etxO2f1Tnv+4/Hhaaj1qE+m/5LHLrDTVuM++8lQkQlvIfvI+13G2xMZJqTTzKV1P4CwQQMaP/q3Z+D9mvZNoD5xS9QXGh6SMYHS+hg0J+iKkPYTJa1wQkAUoGTEYBaUst3MPo7dqsZd2ACfiuognVMmG1CeoQFZ9k4E+OjmaOsuQOObk11BgQxN0FlGVC2ZvlS2mfSUfpNiIYBdXCpfasn0hrgkY9w5+/6RqB8sZlV7F5l6zBkT2N66eukhMCtK/i3LTgAW4FB/p9oXs6baz4lCMiJDJU11rC1lW650rgQcRFaCGq3s1/tXakyCOi5Wzphdp9orbAIHCV91WmQ6/NypWFpNMvXcGuDR4KuMt0tvJBYxB/wiNMpG7bAAxdMYSw9Alf+yxlsD+B2UI1i3ot32S5OD3pkp706B0lqnp1d9bPXH9RO3kqBv6OVQSwZzO9UTdbFVL+25Bp0laELvyjKHRzQ5wuzEKuoOOs2BPNu1THTCqFXfLWwgrFJqSH2if/94c4ADAcS3UysUQdc3kCq7EcPclt9Kcwh9fwPspX0D7LKhVhF6i96YvVOL6007zYM9XQiLmiajaIJsNKNUp4yHJKsjOTpdPSfrI5lVXHh7EbDu84QoEarx+HZKVNeX6BJjturq7u2WFVTnI69Hqb467GclouEB3n46d6QDPY+N6xrQ0Cp6GOQTO/F9G1BlKuXVJ1xELR0FQGJlXfkn52K66hweUGbRHaV6dFr5VFefl3/aPBOrP3ZV0WnlHxB1HDa/ZT6xAAAAAElFTkSuQmCC"/></a>
            </div>
        </div>
    </section>

    <section class="show-message" id="showMessage">
        <h2>Chats abiertos</h2>
        <p class="info-extra">Aquí se muestran todos los chats abiertos entre el conductor del paquete y usted.
        No se aceptan mensajes de odio, ni spam, por favor, tenga cuidado con lo que envía.</p>
        <%
            ArrayList<Message> messages = controller.messageForUserAll(((User) user).getId());
            ArrayList<InfoChats> chats = controller.groupsChats(((User) user).getId(), messages);
            if (chats == null || chats.isEmpty()) {
        %>
        <p class="not-info">No tienes chats abiertos actualmente</p>
        <%
        } else {
                for (InfoChats chat : chats) {
        %>
        <div class="container-chats">
        <div class="card">
            <%=chat.showUserView()%>
        </div>
        </div>

        <%
                }
            }
        %>
    </section>

    <!--SECCIÓN PARA CREAR ENVÍOS-->

    <!--Si al introducir un email, este no encuentra una cuenta de usuario, lo llevará a la opción para crear un paquete desde cero
    pero si encuentra una cuenta se le preguntará si quiere crear el paquete según esa información, si no es así se le envía a la misma
    opción que antes, sino, se le mandará a un dispatch que creará el paquete desde la información de la cuenta encontrada.-->
    <section class="make-envio" id="makeEnvio">
        <h2>Creación de un envío</h2>
        <p class="info-extra">En esta opción podrás introducir el correo electrónico de la persona a la que deseas
            enviar el paquete.
            Si esa persona ya tiene una cuenta registrada en nuestro sistema, se te dará la opción de utilizar la
            información de su perfil para completar automáticamente los detalles de envío. Si prefieres,
            también podrás ingresar manualmente la dirección a la que deseas que se envíe el paquete.</p>

        <%
            // Obteniendo el atributo de sesión 'packageSuccess' y otros atributos necesarios
            Shipment shipmentNotUser = (Shipment) session.getAttribute("packageSuccess");

            // Verificando si no hay 'userNotFound' ni 'userFound' y tampoco se ha creado un paquete
            if (session.getAttribute("userNotFound") == null && session.getAttribute("userFound") == null &&
                shipmentNotUser == null && session.getAttribute("noInfo") == null) {
        %>
        <form method="post" action="findAccountDispatch.jsp">
            <div class="all-make-container findAccount">
                <%
                    if (session.getAttribute("emailNull") != null) {
                        session.removeAttribute("emailNull");
                %>
                <p class="fail">Debes introducir un email</p>
                <%
                    }
                %>
                <div class="make-container">
                    <label>Introduce un email:</label>
                    <input type="email" name="email" id="email" placeholder="Introduce un email" pattern="^[^<>]*$"
                           required>
                </div>
                <div class="button-form findAccount">
                    <button>Enviar</button>
                </div>
            </div>
        </form>
        <%
            }
        %>

        <%
            String userFound = (String) session.getAttribute("userFound");
            if (userFound != null) {
        %>
        <div class="find-container">
            <h2>Información encontrada</h2>
            <p class="info-extra">Hemos verificado que ya disponemos de información sobre esta persona en nuestra base
                de datos.
                ¿Desea que los datos del paquete se completen automáticamente utilizando la información que tenemos
                registrada?</p>
            <form action="infoFoundDispatch.jsp" method="post">
                <div class="options">
                    <input type="radio" id="yes" name="userResponse" value="yes" required>
                    <label class="yes" for="yes">Sí</label>
                    <input type="radio" id="no" name="userResponse" value="no" required>
                    <label class="no" for="no">No</label>
                </div>
                <button type="submit">Enviar</button>
            </form>
        </div>
        <%
                /*Llave de userFound != null*/
            }
        %>

        <%
            // Verificar si el usuario no fue encontrado
            String userNotFound = (String) session.getAttribute("userNotFound");
            String infoNoUse = (String) session.getAttribute("noInfo");

            String email = "";

            if (userNotFound != null) {
                email = userNotFound;
            }
            if (infoNoUse != null) {
                email = infoNoUse;
            }

            if (userNotFound != null || infoNoUse != null) {
                session.removeAttribute("userNotFound");
                session.removeAttribute("noInfo");
        %>
        <form method="post" action="makePackageDispatch.jsp">
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
                    <input type="email" name="email" placeholder="Introduce un email" value="<%= email %>"
                           pattern="^[^<>]*$" required>
                </div>

                <!-- Otras secciones para capturar la dirección, ciudad, etc. -->
                <!-- Ingresar la dirección -->
                <div class="make-container">
                    <label>Introduce una dirección:</label>
                    <%
                        if (session.getAttribute("streetNull") != null) {
                            session.removeAttribute("streetNull");
                    %>
                    <p class="fail">Debes introducir una dirección</p>
                    <%
                        }
                    %>
                    <input type="text" name="street" placeholder="Introduce una dirección" pattern="^[^<>]*$" required>
                </div>
                <div class="make-container">
                    <label>Introduce un número de portal:</label>
                    <%
                        if (session.getAttribute("numNull") != null) {
                            session.removeAttribute("numNull");
                    %>
                    <p class="fail">Debes introducir un número de portal</p>
                    <%
                        }
                    %>
                    <input type="text" name="num" placeholder="Introduce un número de portal" pattern="^[^<>]*$" required>
                </div>

                <!-- Ingresar la ciudad -->
                <div class="make-container">
                    <label>Introduce una ciudad:</label>
                    <%
                        if (session.getAttribute("cityNull") != null) {
                            session.removeAttribute("cityNull");
                    %>
                    <p class="fail">Debes introducir una ciudad</p>
                    <%
                        }
                    %>
                    <input type="text" name="city" placeholder="Introduce una ciudad" pattern="^[^<>]*$" required>
                </div>

                <!-- Ingresar el código postal -->
                <div class="make-container">
                    <label>Introduce un código postal:</label>
                    <%
                        if (session.getAttribute("postalNull") != null) {
                            session.removeAttribute("postalNull");
                    %>
                    <p class="fail">Debes introducir un código postal</p>
                    <%
                        }
                    %>
                    <input type="number" name="postalCode" placeholder="Introduce un código postal" pattern="^[^<>]*$"
                           required>
                </div>

                <!-- Ingresar el nombre del destinatario -->
                <div class="make-container">
                    <label>Introduce el nombre del destinatario:</label>
                    <%
                        if (session.getAttribute("nameNull") != null) {
                            session.removeAttribute("nameNull");
                    %>
                    <p class="fail">Debes introducir el nombre del destinatario</p>
                    <%
                        }
                    %>
                    <input type="text" name="nameReciever" placeholder="Introduce el nombre del destinatario"
                           pattern="^[^<>]*$" required>
                </div>

                <div class="button-form">
                    <button>Enviar</button>
                </div>
            </div>
        </form>

        <%
            }
            // Mostrar la sección si se ha creado un paquete (shipmentNotUser != null)
            if (shipmentNotUser != null) {
        %>
        <section class="packageNotUser">
            <h3>Información del envío creado</h3>
            <%= shipmentNotUser.resumeWeb() %>
            <div class="button-form">
                <a href="borrarAccount&FollowDispatch.jsp?page=makeShipment">
                    <button>Volver al inicio</button>
                </a>
            </div>
        </section>
        <%
            }
        %>
    </section>


    <!--SECCION QUE MUESTRA LOS PAQUETES ENVIADOS POR EL USUARIO-->

    <section class="envios-I-Make" id="enviosImake">
        <h2>Envíos que he realizado</h2>
        <p class="info-extra">Esta opción permite al usuario ver todos los paquetes que ha enviado a través del sistema.
            Aquí se muestra un listado detallado de cada envío, incluyendo información como la fecha de expedición, la
            entrega estimada,
            el estado actual del paquete, la dirección de destino, el remitente y el destinatario. Esta sección
            proporciona una
            forma rápida y sencilla de gestionar y hacer
            seguimiento de todos los paquetes enviados, manteniendo al usuario informado en todo momento sobre el estado
            de los paquetes.</p>
        <div class="card-container">
            <%
                ArrayList<InfoShipmentDataClass> shipmentsIMake = controller.getShipmentSendByUser(((User) user).getId());
                if (shipmentsIMake.isEmpty()) {
            %>
            <p class="not-info">No se ha encontrado información sobre envíos que haya realizado este usuario</p>
            <%
            } else {
                for (InfoShipmentDataClass s : shipmentsIMake) {
            %>
            <div class="target-package">
                <%=s.forSender()%>
            </div>
            <%
                    }
                }
            %>
        </div>
    </section>


    <!--SECCIÓN QUE MUESTRA MIS PAQUETES Y ME DA A ELEGIR EN CUÁL MODIFICAR LA INFORMACIÓN-->
    <section class="modify-envio" id="modifyEnvio">
        <h2>Modificar datos de un envío</h2>
        <p class="info-extra">En esta sección, se le brinda la oportunidad de modificar la información
            de un paquete que aún no ha sido entregado. Podrá actualizar tanto la dirección de destino del
            paquete como el nombre del destinatario.
            Estos datos pueden ser modificados tantas veces como lo considere necesario.
            <span class="text-bold">Introduzca el ID en el buscador o seleccione la tarjeta del envío deseado.</span>
        </p>

        <%
            ArrayList<InfoShipmentDataClass> shipmentsChange = controller.getShipmentPendingsToUser(((User) user).getId());

            if (shipmentsChange.isEmpty()) {
        %>
        <p class="not-info">No se han encontrado envíos para modificar</p>
        <%
            }
            Shipment shipmentFound = (Shipment) session.getAttribute("shipmentFound");
            if (shipmentFound == null) {
        %>
        <div class="form-change">
            <form method="post" action="findPackageDispatch.jsp">
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
            for (InfoShipmentDataClass s : shipmentsChange) {
        %>
        <div class="target-package">
            <%=s.forTracking()%>
        </div>
        <%
            }
        } else {
        %>
        <div class="all-change-container">
        <form method="post" action="changeInfoPackageDispatch.jsp?idPackage=<%=shipmentFound.getId()%>" >
            <div class="info-container">
                <h3>Dirección:</h3>
                <%
                    if (session.getAttribute("streetNull") != null) {
                        session.removeAttribute("streetNull");
                %>
                <p class="fail">Debes introducir una dirección</p>
                <%
                    }
                %>
                <input type="text" name="streetNew" value="<%=shipmentFound.getAlternativeAddress()%>">
            </div>
            <div class="info-container">
                <h3>Número de portal:</h3>
                <%
                    if (session.getAttribute("numNull") != null) {
                        session.removeAttribute("numNull");
                %>
                <p class="fail">Debes introducir un número de portal</p>
                <%
                    }
                %>
                <input type="text" name="numNew" value="<%=shipmentFound.getNumAlternative()%>">
            </div>
            <div class="info-container">
                <h3>Ciudad:</h3>
                <%
                    if (session.getAttribute("cityNull") != null) {
                        session.removeAttribute("cityNull");
                %>
                <p class="fail">Debes introducir una ciudad</p>
                <%
                    }
                %>
                <input type="text" name="cityNew" value="<%=shipmentFound.getAlternativeCity()%>">
            </div>
            <div class="info-container">
                <h3>Código postal:</h3>
                <%
                    if (session.getAttribute("postalCodeNull") != null) {
                        session.removeAttribute("postalCodeNull");
                %>
                <p class="fail">Debes introducir un codigo postal</p>
                <%
                    }
                %>
                <input type="number" name="postalNew" value="<%=shipmentFound.getAlternativePostalCode()%>">
            </div>
            <div class="button-form">
                <button type="submit">Modificar</button>
            </div>
        </form>
        </div>
        <%
            }
        %>
    </section>

    <!--SECCION QUE VEO SOLO LA INFORMACION DE LOS PAQUETES QUE YA HE RECIBIDO Y QUE RECIBIRÉ-->

    <!--tengo que hacer dos secciones dentro de esto, que estén separadas por botones, si pulso el botón de "Entregados" debo mostrar
    los envios que ya me han sido entregados, si pulso el botón de "En curso" me mostrara la información de los paquetes
    que todavia no me han entregado y siguen siendo despachados por la empresa-->
    <section class="envios-receive" id="enviosReceive">
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
        <div class="btn-box">
            <button class="btn btn-1" id="Encurso">Envíos en curso</button>
            <button class="btn btn-2" id="Entregados">Envíos entregados</button>
        </div>

        <!--MODIFICAR EL JAVASCRIPT PARA MOSTRAR LOS PEDIDOS ORDENADOS POR, ENTREGADOS O NO ENTREGADOS-->
        <div class="card-container card-container-finished" id="card-container-finished">
            <%
                ArrayList<InfoShipmentDataClass> shipmentsFinished = controller.getShipmentsFinishedUser(((User) user).getId());

                if (shipmentsFinished.isEmpty()) {
            %>
            <p class="not-info">Por ahora, no tienes ningún envío finalizado.</p>
            <%
            } else {
                for (InfoShipmentDataClass s : shipmentsFinished) {
            %>

            <div class="target-button">
            <a class="enlace" href='openNewChatDispatch.jsp?idPackage=<%=s.getId()%>&amp;user=<%=((User) user).getId()%>'>
                <button class='abrirChat'>Abrir chat <%=s.getId()%></button></a>;
            <div class="target-package">
                <%=s.forReciever()%>
            </div>
            </div>
            <%
                    }
                }
            %>
        </div>
        <div class="card-container card-container-pendings" id="card-container-pendings">
            <%
                ArrayList<InfoShipmentDataClass> shipmentPendings = controller.getShipmentPendingsToUser(((User) user).getId());

                if (shipmentPendings.isEmpty()) {
            %>
            <p class="not-info">Por ahora, no tienes ningún envío en curso</p>
            <%
            } else {
                for (InfoShipmentDataClass s : shipmentPendings) {
            %>

            <div class="target-button">
            <a class="enlace" href='openNewChatDispatch.jsp?idPackage=<%=s.getId()%>&amp;user=<%=((User) user).getId()%>'>
                <button class='abrirChat'>Abrir chat <%=s.getId()%></button></a>
            <div class="target-package">
                <%=s.forReciever()%>
            </div>
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
        <form method="post" action="changeInfoAccountUserDispatch.jsp" class="all-change-container">
            <div class="info-container">
                <%
                    if (session.getAttribute("emailNull") != null) {
                        session.removeAttribute("emailNull");
                %>
                <p class="text-red">Debes introducir un email</p>
                <%
                    }
                %>
                <h3>Email:</h3>
                <input type="text" name="emailNew" value="<%=((User) user).getEmail()%>">
            </div>
            <div class="info-container">
                <%
                    if (session.getAttribute("phoneNull") != null) {
                        session.removeAttribute("phoneNull");
                %>
                <p class="text-red">Debes introducir un número de teléfono</p>
                <%
                    }
                %>
                <h3>Número de telefono:</h3>
                <input type="number" name="phoneNew" value="<%=((User) user).getPhone()%>">
            </div>
            <div class="info-container">
                <%
                    if (session.getAttribute("nameNull") != null) {
                        session.removeAttribute("nameNull");
                %>
                <p class="text-red">Debes introducir el nombre del destinatario</p>
                <%
                    }
                %>
                <h3>Nombre:</h3>
                <input type="text" name="nameNew" value="<%=((User) user).getName()%>">
            </div>
            <div class="info-container">
                <%
                    if (session.getAttribute("surnameNull") != null) {
                        session.removeAttribute("surnameNull");
                %>
                <p class="text-red">Debes introducir el nombre del destinatario</p>
                <%
                    }
                %>
                <h3>Apellidos:</h3>
                <input type="text" name="surnameNew" value="<%=((User) user).getSurname()%>">
            </div>
            <div class="info-container">
                <%
                    if (session.getAttribute("streetNull") != null) {
                        session.removeAttribute("streetNull");
                %>
                <p class="text-red">Debes introducir el nombre del destinatario</p>
                <%
                    }
                %>
                <h3>Dirección:</h3>
                <input type="text" name="streetNew" value="<%=((User) user).getStreet()%>">
            </div>
            <div class="info-container">
                <%
                    if (session.getAttribute("numNull") != null) {
                        session.removeAttribute("numNull");
                %>
                <p class="text-red">Debes introducir el nombre del destinatario</p>
                <%
                    }
                %>
                <h3>Número de portal:</h3>
                <input type="number" name="numNew" value="<%=((User) user).getNum()%>">
            </div>
            <div class="info-container">
                <%
                    if (session.getAttribute("cityNull") != null) {
                        session.removeAttribute("cityNull");
                %>
                <p class="text-red">Debes introducir el nombre del destinatario</p>
                <%
                    }
                %>
                <h3>Ciudad:</h3>
                <input type="text" name="cityNew" value="<%=((User) user).getCity()%>">
            </div>
            <div class="info-container">
                <%
                    if (session.getAttribute("postalCodeNull") != null) {
                        session.removeAttribute("postalCodeNull");
                %>
                <p class="text-red">Debes introducir el nombre del destinatario</p>
                <%
                    }
                %>
                <h3>Código postal:</h3>
                <input type="number" name="postalNew" value="<%=((User) user).getPostalCode()%>">
            </div>
            <div class="info-container">
                <%
                    if (session.getAttribute("provinceNull") != null) {
                        session.removeAttribute("provinceNull");
                %>
                <p class="text-redl">Debes introducir el nombre del destinatario</p>
                <%
                    }
                %>
                <h3>Provincia:</h3>
                <input type="text" name="stateNew" value="<%=((User) user).getState()%>">
            </div>
            <div class="info-container">
                <h3>Notificaciones:</h3>
                <%
                    if (((User) user).isNotification()) {
                %>
                <label class="notification-text">Activadas<input type="checkbox" name="notificationNoName" id="notificationNo" value="no"></label>
                <%
                    } else {
                %>
                <label class="notification-text">Desactivadas<input type="checkbox" name="notificationYesName" id="notificationYes" value="yes"></label>
                <%
                    }
                %>
            </div>
            <div class="button-form">
                <button type="submit">Modificar</button>
                <a href="changePasswordDispatch.jsp">Cambiar contraseña</a>
            </div>
        </form>
        <%
            } else {
        %>
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
            if (session.getAttribute("passNotCorrect") != null) {
                session.removeAttribute("passNotCorrect");
        %>
        <p class="text-red">Debes introducir la contraseña antigua para cambiarla</p>
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
        <%
            if (session.getAttribute("passNull") != null) {
                session.removeAttribute("passNull");
        %>
        <p class="text-red">Debes introducir la nueva contraseña</p>
        <%
            }
        %>
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
        <form method="post" action="changePasswordDispatch.jsp" class="all-change-container">

            <div class="info-container">
                <h3>Contraseña antigua</h3>
                <input type="password" name="passOld" placeholder="Introduzca la antigua contraseña">
            </div>

            <div class="info-container">
                <h3>Nueva contraseña</h3>
                <input type="password" name="passChange" placeholder="Introduzca la nueva contraseña">
            </div>

            <div class="info-container">
                <h3>Repite la nueva contraseña</h3>
                <input type="password" name="pass2Change" placeholder="Repita la nueva contraseña">
            </div>
            <div class="button-form">
                <button type="submit">Modificar</button>
                <a href="borrarAccount&FollowDispatch.jsp">Volver atrás</a>
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

<script src="jscript/cuentaUsuario.js"></script>
<script src="jscript/opcionEnviosMostrar.js"></script>
<script src="jscript/modifyNoti.js"></script>
<!--Fin del footer-->
<%
        }
    } else {
        response.sendRedirect("error.jsp");
        }
%>
</body>
</html>
