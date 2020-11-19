<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/disciplina/excluirProfessorDaDisciplina" var="linkServletExcluirProfessorDaDisciplina"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir Professor da Disciplina</title>
</head>
<body>
<a href="../index.jsp">Home</a>
<a href="/disciplina/listarDisciplina">Voltar</a>
<br/>
	<form action="${linkServletExcluirProfessorDaDisciplina}" method="get">		
		Código Disciplina: <input type="text" name="codigoDisciplina"/>
		<br/>
		Matrícula Professor: <input type="text" name="matriculaProfessor"/>
		<br/>
		<input type="submit"/>		 
	</form>
</body>
</html>