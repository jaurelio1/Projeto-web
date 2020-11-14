<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/sala/listarSala" var="linkServletListarSala"/>
<c:url value="/professor/listarProfessor" var="linkServletListarProfessor"/>
<c:url value="/disciplina/listarDisciplina" var="linkServletListarDisciplina"/>
<c:url value="/horario/listarHorario" var="linkServletListarHorario"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<a href="${linkServletListarSala}">Sala</a>
	<br/>
	<a href="${linkServletListarProfessor}">Professor</a>
	<br/>
	<a href="${linkServletListarDisciplina}">Disciplina</a>
	<br/>
	<a href="${linkServletListarHorario}">Horários Completos</a>
</body>
</html>