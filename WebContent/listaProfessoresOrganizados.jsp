<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/cadastrarProfessor" var="linkServletCadastrarProfessor"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Professores Ordenados</title>
</head>
<body>
Ordenados:
<div>
	<ul>
		<c:forEach items="${professoresOrganizados}" var="professor">			
			<li>
				<p>${professor.nome}</p>
				<p>${professor.inicioAula} - ${professor.fimAula}</p>
			</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>