<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/disciplina/excluirDisciplina" var="linkServletExcluirDisciplina"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir Disciplina</title>
</head>
<body>
<a href="/alocarsalas/index.jsp">Home</a>
<br/>
	<form action="${linkServletExcluirDisciplina}" method="get">
		Código: <input type="text" name="codigoDisciplina"/>
		<br/>
		<input type="submit"/>		 
	</form>
</body>
</html>