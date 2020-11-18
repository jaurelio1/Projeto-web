<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/sala/cadastrarSala" var="linkServletCadastroSala"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Sala</title>
</head>
<body>
<a href="../index.jsp">Home</a>
<br/>

	<form action="${linkServletCadastroSala}" method="post">
		Nome: <input type="text" name="nomeSala"/>
		<br/>
		Código: <input type="text" name="idSala" />
		<br/>
		<input type="submit"/>		 
	</form>
</body>
</html>