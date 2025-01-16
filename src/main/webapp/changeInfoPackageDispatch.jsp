<%@ page import="appcontroller.AppController" %>
<%@ page import="utils.Utils" %>

<%
    AppController controller = new AppController();
    String idPackage = request.getParameter("idPackage"),
    street = request.getParameter("streetNew"),
            num = request.getParameter("numNew"),
    city = request.getParameter("cityNew"),
    postalCode = request.getParameter("postalNew");

    int fails = 0;

    if (street == null || street.trim().isEmpty() || Utils.VerEtiquetas(street) || Utils.VerInyeccionSql(street)) {
        session.setAttribute("streetNull", "No hay direccion");
        fails++;
    }
    if (num == null || num.trim().isEmpty() || Utils.VerEtiquetas(num) || Utils.VerInyeccionSql(num)) {
        session.setAttribute("numNull", "No hay número");
        fails++;
    }
    if (city == null || city.trim().isEmpty() || Utils.VerEtiquetas(city) || Utils.VerInyeccionSql(city)) {
        session.setAttribute("cityNull", "No hay ciudad");
        fails++;
    }
    if (postalCode == null || postalCode.trim().isEmpty() || Utils.VerEtiquetas(postalCode) || Utils.VerInyeccionSql(postalCode)) {
        session.setAttribute("postalCodeNull", "No hay código postal");
        fails++;
    }
    if (fails > 0) {
        response.sendRedirect("accountUser.jsp");
        return;
    }
    try {

        if (idPackage != null) {
            int postalNum = Integer.parseInt(postalCode), idNum = Integer.parseInt(idPackage), numAlternative = Integer.parseInt(num);

            if (controller.changeDeliveryData(idNum, street, postalNum, city, numAlternative)) {
                session.setAttribute("modifySuccess", "Paquete actualizado correctamente");
                response.sendRedirect("accountUser.jsp");
                return;
            }
            session.setAttribute("modifyFail", "No se ha podido actualizar el paquete");
            response.sendRedirect("accountUser.jsp");
            return;
        }
        session.setAttribute("shipmentNotFound", "Paquete no encontrado");
        response.sendRedirect("accountUser.jsp");
    }catch (NumberFormatException e){
        session.setAttribute("error", "Ha ocurrido un error");
        response.sendRedirect("error.jsp");
    }
%>