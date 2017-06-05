<%@page import="Model.DAO.PersonaDAO" %>

<jsp:useBean id="persona" class="Model.VO.PersonaVO" ></jsp:useBean>
<jsp:setProperty property="*" name="persona" />

<%
	int estado = PersonaDAO.updatePersona(persona);
	response.sendRedirect("viewPersona.jsp");
%> 

