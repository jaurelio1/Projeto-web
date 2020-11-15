<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Horários</title>
</head>
<body>
	Horários:
	
	<c:forEach var="sala" items="${salas}" varStatus="status">
	<table border="1">
			
		<p> Sala: ${sala.nome}   Código: ${sala.id} <p/>
		    
	     <c:forEach var="disciplina" items="${disciplinas[status.index]}" varStatus="status2">
	     	
	     	<tr>
		    	<th>Disciplina</th>
		        <th>Início da Aula</th>
		        <th>Fim da Aula</th>
		         
	    	</tr>
	    	<tr>
		        <td>${disciplina.nome}</td>
		        <td>${disciplina.inicioAula}</td>
		        <td>${disciplina.fimAula}</td>
	    	</tr>
	    </c:forEach>
		    
	</table>
	<br/>
	</c:forEach>




</body>
</html>