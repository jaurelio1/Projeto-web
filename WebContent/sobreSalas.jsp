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
	
	<a href="/alocarsalas/index.jsp">Home</a>
	<a href="/alocarsalas/cadastrarSala.jsp">Adicionar</a>
	<a href="/alocarsalas/excluirSala.jsp">Excluir</a>
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
			        <td>${sala.id}</td>
			    </tr>
			</table>
			<br/>
		</c:forEach>
		
</body>
</html>
