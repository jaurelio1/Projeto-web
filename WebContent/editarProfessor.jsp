<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/professor/editarProfessor" var="linkServletEditarProfessor"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Professor</title>
</head>
<body>
<a href="../index.jsp">Home</a>
<a href="/professor/listarProfessor">Voltar</a>
<br/>

	<form action="${linkServletEditarProfessor}" method="post">
		Nome: <input type="text" name="nomeProfessor"/>
		<br/>
		Matrícula: <input type="text" name="matriculaProfessor" />
		<br/>
		Carga Horária: <input type="text" name="cargaHoraria" />
		<br/>
		<input type="submit"/>		 
	</form>
</body>
</html>