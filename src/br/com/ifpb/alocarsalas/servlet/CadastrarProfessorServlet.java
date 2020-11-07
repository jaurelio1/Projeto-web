package br.com.ifpb.alocarsalas.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cadastrarProfessor")
public class CadastrarProfessorServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		String nomeProfessor = request.getParameter("nomeProfessor");
		String cargaHoraria = request.getParameter("cargaHoraria");
		int ch = Integer.parseInt(cargaHoraria);		
		
		
		String nomeDisciplina = request.getParameter("nomeDisciplina");
		String quantAlunos = request.getParameter("qntAlunos");
		String horasAula = request.getParameter("hrsAula");
		int qntAlunos = Integer.parseInt(quantAlunos);
		int hrsAulas = Integer.parseInt(horasAula);
		
		String dataAula = request.getParameter("dataAula");
		String inicioAula = request.getParameter("inicioAula");
		String fimAula = request.getParameter("fimAula");
		
		Date diaAula = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			diaAula = sdf.parse(dataAula);
		}catch(ParseException e){
			throw new ServletException(e);
			
		}		
		
		Professor professor = new Professor();
		
		professor.setNome(nomeProfessor);
		professor.setCargaHoraria(ch);
		
		professor.setNomeDisciplina(nomeDisciplina);
		professor.setQntAlunos(qntAlunos);
		professor.setHrsAulas(hrsAulas);
		
		professor.setDiaAula(diaAula);
		professor.setInicioAula(inicioAula);
		professor.setFimAula(fimAula);
		
		Banco banco = new Banco();
		banco.adiciona(professor);
		
		request.setAttribute("professor", professor);
		
		response.sendRedirect("listaProfessores");		
		
	}

}
