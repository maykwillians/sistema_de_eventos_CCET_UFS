<%@page import="Model.Usuario"%>

<%
    Usuario usuario = (Usuario) session.getAttribute("user");

    if (usuario == null) {

        response.sendRedirect("login.jsp");
        return;
    } else {
        
        session.invalidate();
        response.sendRedirect("index.jsp");
        return;
    }
%>