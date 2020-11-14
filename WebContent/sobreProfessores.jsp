<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.ifpb.model.Professor"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Professores</title>
</head>
<body>
	Professores:
	
	<c:forEach var="professores" items="${professores}">
		${professores.nome} - ${professores.matricula} - ${professores.cargaHoraria}
	</c:forEach>
	
	<a href="/alocarsalas/cadastrarProfessor.jsp">Cadastrar Professor</a>
	<a href="/alocarsalas/index.jsp">Home</a>
</body>
</html>
