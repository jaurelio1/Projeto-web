<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/disciplina/cadastrarDisciplina" var="linkServletCadastroDisciplina"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro Disciplina</title>
</head>
<a href="/alocarsalas/index.jsp">Home</a>
<br/>

<body>
	<form action="${linkServletCadastroDisciplina}" method="post">
		Nome: <input type="text" name="nomeDisciplina"/>
		<br/>
		C�digo: <input type="text" name="codigoDisciplina"/>
		<br/>
		Quantidade de Alunos: <input type="text" name="qntAlunos"/>
		<br/>
		Horas/Aula: <input type="text" name="hrsAula"/>
		<br/>	
		Dia da aula: <input type="text" name="dataAula"/> - met�do de inser��o(12/12/12)
		<br/>
		In�cio da Aula: <input type="text" name="inicioAula"/> - met�do de inser��o(HH:MM)
		<br/>
		Fim da Aula: <input type="text" name="fimAula"/> - met�do de inser��o(HH:MM)
		<br/>
		C�digo da Sala <input type="text" name="idSala"/> 
		<br/>
		<input type="submit"/>		 
	</form>
</body>
</html>