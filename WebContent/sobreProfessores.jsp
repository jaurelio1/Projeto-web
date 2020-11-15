<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.ifpb.model.Professor"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Professores</title>
</head>
<body>

	<a href="/alocarsalas/index.jsp">Home</a>
	<a href="/alocarsalas/cadastrarProfessor.jsp">Cadastrar Professor</a>
	<br/>
	<br/>
	
	Professores:
	
	<c:forEach var="professor" items="${professores}" varStatus="status">
		<table border="1">
			<tr>
		        <th>Nome:</th>
		        <td>${professor.nome}</td>
		    </tr>
		    <tr>
		    	<th>Matrícula:</th>
		        <td>${professor.matricula}</td>
		    </tr>
		   	<tr>
		    	<th>Carga Horária:</th>
		        <td>${professor.cargaHoraria}</td>
		    </tr>
		    
		    <c:forEach var="disciplina" items="${disciplinas[status.index]}" varStatus="status2">
		    	<tr>
			    	<th>Disciplina</th>
			        <td>${disciplina.nome}</td>
		    	</tr>
		    </c:forEach>
		    
		</table>
		<br/>
	</c:forEach>
	
	
</body>
</html>
