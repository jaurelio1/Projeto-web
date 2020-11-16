<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/sala/excluirSala" var="linkServletExcluirSala"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Excluir Sala</title>
</head>
<body>
<a href="/alocarsalas/index.jsp">Home</a>
<br/>
	<form action="${linkServletExcluirSala}" method="get">
		Id: <input type="text" name="idSala" />
		<br/>
		<input type="submit"/>		 
	</form>
</body>
</html>