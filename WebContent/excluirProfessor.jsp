<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/professor/excluirProfessor" var="linkServletExcluirProfessor"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir Professor</title>
</head>
<body>
<a href="../index.jsp">Home</a>
<a href="/professor/listarProfessor">Voltar</a>
<br/>
	<form action="${linkServletExcluirProfessor}" method="get">
		Matr�cula: <input type="text" name="matriculaProfessor" />
		<br/>
		<input type="submit"/>		 
	</form>
</body>
</html>