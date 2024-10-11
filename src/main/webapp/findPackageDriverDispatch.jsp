<%@ page import="appcontroller.AppController" %>
<%@ page import="models.Driver" %>
<%@ page import="models.Shipment" %>
<%@ page import="utils.Utils" %>
<%
    AppController controller = new AppController();
    Object driver = session.getAttribute("usuarioLogueado");

    if (driver == null) {
        response.sendRedirect("index.jsp");
    }

    if (driver instanceof Driver) {
        String idPackage = request.getParameter("idPackage");

        if (idPackage == null || idPackage.trim().isEmpty() || Utils.VerEtiquetas(idPackage) || Utils.VerInyeccionSql(idPackage)) {
            session.setAttribute("idNull", "Identificacion del paquete no introducida");
            response.sendRedirect("accountDriver.jsp");
            return;
        }

        int id = Integer.parseInt(idPackage);

        if (id <= 0) {
            session.setAttribute("idNull", "Identificacion del paquete no introducida");
            response.sendRedirect("accountDriver.jsp");
            return;
        }

        Shipment shipmentFound = controller.searchShipmentById(id);

        if (shipmentFound == null) {
            session.setAttribute("shipmentNotFound", "No se ha podido encontrar el paquete");
            response.sendRedirect("accountDriver.jsp");
            return;
        } else {
            session.removeAttribute("idPackage");
            session.setAttribute("shipmentFound", shipmentFound);
            response.sendRedirect("accountDriver.jsp");
            return;
        }
    }
    response.sendRedirect("error.jsp");
%>