<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.alocarsalas.model.Disciplina"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Disciplinas</title>
</head>
<body>
	
	<a href="../index.jsp">Home</a>
	<a href="/cadastrarDisciplina.jsp">Adicionar Disciplina</a>
	<a href="/excluirDisciplina.jsp">Excluir Disciplina</a>
	<a href="/editarDisciplina.jsp">Editar Disciplina</a>
	<a href="/cadastrarProfessorNaDisciplina.jsp">Adicionar Professor na Disciplina</a>
	<a href="/excluirProfessorDaDisciplina.jsp">Excluir Professor da Disciplina</a>
	
	<br/>
	<br/>

	Disciplinas:
	
	<c:forEach var="disciplina" items="${disciplinas}" varStatus="status">
		<table border="1">
			<tr>
			    <th>Nome:</th>
			    <td>${disciplina.nome}</td>
	   		</tr>
		    <tr>
		    	<th>Código:</th>
		    	<td>${disciplina.codigo}</td>
		    </tr>
		    <tr>
		    	<th>Carga Horária:</th>
		    	<td>${disciplina.cargaHoraria} </td>
		    </tr>
		    
		     <tr>
		    	<th>Dia da aula</th>
		    	<td>${disciplina.diaAula} </td>
		    </tr>
		    
		     <tr>
		    	<th>Início da Aula:</th>
		    	<td>${disciplina.inicioAula} </td>
		    </tr>
		    
		    <tr>
		    	<th>Fim da Aula:</th>
		    	<td>${disciplina.fimAula} </td>
		    </tr>
		    
		     <c:forEach var="professor" items="${professores[status.index]}" varStatus="status2">
		    	<tr>
			    	<th>Professor</th>
			        <td>${professor.matricula}</td>
		    	</tr>
		    </c:forEach>
		    
		</table>
		<br/>
	</c:forEach>
	
</body>
</html>