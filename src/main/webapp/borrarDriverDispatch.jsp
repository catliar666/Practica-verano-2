<%
    if (session.getAttribute("packageUpdateState") != null) {
        session.removeAttribute("packageUpdateState");
        response.sendRedirect("accountDriver.jsp");
        return;
}

    if (session.getAttribute("addSuccess") != null) {
        session.removeAttribute("addSuccess");
        response.sendRedirect("accountDriver.jsp");
        return;
    }
    if (session.getAttribute("changePassYes") != null) {
        session.removeAttribute("changePassYes");
        response.sendRedirect("accountDriver.jsp");
        return;
    }

    session.setAttribute("errorBorrar", "No hay un elemento para borrar");
    response.sendRedirect("accountDriver.jsp");
%>