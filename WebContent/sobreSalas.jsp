<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.ifpb.model.Sala"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salas</title>
</head>
<body>
	Salas:
	
	<c:forEach var="salas" items="${salas}">
		${salas.nome} - ${salas.id}
	</c:forEach>
	
	<a href="/alocarsalas/cadastrarSala.jsp">Cadastrar Sala</a>
	<a href="/alocarsalas/index.jsp">Home</a>
</body>
</html>
