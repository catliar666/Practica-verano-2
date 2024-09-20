<%@ page import="appcontroller.AppController" %>
<%@ page import="utils.Utils" %>

<%
    AppController controller = new AppController();
    String idPackage = request.getParameter("idPackage"),
    street = request.getParameter("streetNew"),
    city = request.getParameter("cityNew"),
    postalCode = request.getParameter("postalNew");

    int fails = 0;

    if (street == null || street.trim().isEmpty() || Utils.VerEtiquetas(street)) {
        session.setAttribute("streetNull", "No hay direccion");
        fails++;
    }
    if (city == null || city.trim().isEmpty() || Utils.VerEtiquetas(city)) {
        session.setAttribute("cityNull", "No hay ciudad");
        fails++;
    }
    if (postalCode == null || postalCode.trim().isEmpty() || Utils.VerEtiquetas(postalCode)) {
        session.setAttribute("postalCodeNull", "No hay código postal");
        fails++;
    }
    if (fails > 0) {
        response.sendRedirect("accountUser.jsp");
        return;
    }
    try {

        if (idPackage != null) {
            int postalNum = Integer.parseInt(postalCode), idNum = Integer.parseInt(idPackage);

            if (controller.changeDeliveryData(idNum, street, postalNum, city)) {
                session.setAttribute("modifySuccess", "Paquete actualizado correctamente");
                response.sendRedirect("accountUser.jsp");
                return;
            }
            session.setAttribute("modifyFail", "No se ha podido actualizar el paquete");
            response.sendRedirect("accountUser.jsp");
            return;
        }
        session.setAttribute("NotFound", "Paquete no encontrado");
        response.sendRedirect("accountUser.jsp");
    }catch (NumberFormatException e){
        session.setAttribute("error", "Ha ocurrido un error");
        response.sendRedirect("error.jsp");
    }
%>