<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alocarsalas.model.Sala"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salas</title>
</head>
<body>
	
	<a href="../index.jsp">Home</a>
	<a href="/cadastrarSala.jsp">Adicionar</a>
	<a href="/editarSala.jsp">Editar</a>
	<a href="/excluirSala.jsp">Excluir</a>
	<br/>
	<br/>
		Salas:
		
		<c:forEach var="sala" items="${salas}">
			<table border="1">
				<tr>
			       <th>Nome:</th>
			       <td>${sala.nome}</td>
		   		</tr>
			    <tr>
			        <th>Código:</th>
			        <td>${sala.codigo}</td>
			    </tr>
			</table>
			<br/>
		</c:forEach>
		
</body>
</html>
