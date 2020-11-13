<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.ifpb.model.Disciplina"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Disciplinas</title>
</head>
<body>
	Disciplinas:
	
	<c:forEach var="disciplinas" items="${disciplinas}">
		${disciplinas.nome} - ${disciplinas.codigo} - ${disciplinas.cargaHoraria}
	</c:forEach>
	
	<a href="/alocarsalas/cadastrarDisciplina.jsp">Cadastrar Disciplina</a>
	<a href="/alocarsalas/cadastrarProfessorNaDisciplina.jsp">Cadastrar Professor na Disciplina</a>
	<a href="/alocarsalas/index.jsp">Home</a>
	
</body>
</html>