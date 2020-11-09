<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.ifpb.alocarsalas.servlet.Professor"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/professorOrganizados" var="linkServletProfessoresOrdenados"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Professores</title>
</head>
<body>
Lista de Professores: <br/>
	<ul>
		<c:forEach items="${professores}" var="professor">			
			<li>
				${professor.nome}
				<p>${professor.inicioAula} - ${professor.fimAula} </p>
			</li>
		</c:forEach>
	</ul>
	<a href="${linkServletProfessoresOrdenados}">Organizar Hor�rio</a>

</body>
</html>