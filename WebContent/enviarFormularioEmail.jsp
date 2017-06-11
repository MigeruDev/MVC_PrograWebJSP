<%@page import="Model.DAO.Envio_Email"%>
<jsp:useBean id="email" class="Model.VO.EmailVO"></jsp:useBean>
<jsp:setProperty property="*" name="email"/>

<%
	Envio_Email.sendFromGMail(email);
	response.sendRedirect("viewPersona.jsp");
%>