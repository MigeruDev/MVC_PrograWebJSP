<%@page import="Model.DAO.PersonaDAO"%>
<jsp:useBean id="persona" class="Model.VO.PersonaVO"></jsp:useBean>
<jsp:setProperty property="*" name="persona"/>

<%
	int estado = PersonaDAO.addPersona(persona);
	if(estado>0){
		response.sendRedirect("viewPersona.jsp");
	}else{
		response.sendRedirect("fail.jsp");
	}
%>