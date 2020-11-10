<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/cadastrarProfessor" var="linkServletCadastroProfessor"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${linkServletCadastroProfessor}" method="post">
		Nome do professor: <input type="text" name="nomeProfessor"/>
		<br/>
		Matricula: <input type="text" name="matriculaProfessor" />
		<br/>
		Carga Horária: <input type="text" name="cargaHoraria" />
		<br/>
		<br/>
		Nome Disciplina: <input type="text" name="nomeDisciplina"/>
		<br/>
		Código Disciplina: <input type="text" name="codigoDisciplina"/>
		<br/>
		Quantidade de Alunos: <input type="text" name="qntAlunos"/>
		<br/>
		Horas/Aula: <input type="text" name="hrsAula"/>
		<br/>	
		Dia da aula: <input type="text" name="dataAula"/> - metódo de inserção(12/12/12)
		<br/>
		Início da Aula: <input type="text" name="inicioAula"/> - metódo de inserção(HH:MM)
		<br/>
		Fim da Aula: <input type="text" name="fimAula"/> - metódo de inserção(HH:MM)
		<br/>
		Sala <input type="text" name="idSala"/> - codigo da sala
		<br/>
		<input type="submit"/>
		 
	</form>

</body>
</html>