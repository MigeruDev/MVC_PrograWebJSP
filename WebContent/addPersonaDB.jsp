<%@page import="Model.Service.PersonaService"%>
<jsp:useBean id="persona" class="Model.VO.PersonaVO"></jsp:useBean>
<jsp:setProperty property="*" name="persona"/>

<%
	Map<String, String> fields = new HashMap<String,String>();
	fields.put("idPersona", persona.getId());
	fields.put("nombrePersona", persona.getNombre());
	fields.put("apellidoPersona", persona.getApellido());
	fields.put("edad", String.valueOf(persona.getEdad()));
	
	PersonaService ps = PersonaService.getInstance();
	ps.addElement("Persona", fields);
	
	response.sendRedirect("viewPersona.jsp");

%>