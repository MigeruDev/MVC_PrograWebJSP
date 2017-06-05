<%@page import="Model.DAO.PersonaDAO"%>  
<jsp:useBean id="persona" class="Model.VO.PersonaVO"></jsp:useBean>  
<jsp:setProperty property="*" name="persona"/>  
<%  
	PersonaDAO.deletePersona(persona);  
	response.sendRedirect("viewPersona.jsp");  
%>  