<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/cadastrarProfessor" var="linkServletCadastroProfessor"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Professor</title>
</head>
<body>
	<form action="${linkServletCadastroProfessor}" method="post">
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