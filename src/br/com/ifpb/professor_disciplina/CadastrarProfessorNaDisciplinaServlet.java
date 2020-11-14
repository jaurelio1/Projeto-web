package br.com.ifpb.professor_disciplina;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.dao.ProfessorDisciplinaDAO;
import br.com.ifpb.model.ProfessorDisciplina;

@WebServlet("/disciplina/cadastrarProfessorNaDisciplina")
public class CadastrarProfessorNaDisciplinaServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		int matriculaProfessor  = Integer.parseInt(request.getParameter("matriculaProfessor"));
		int codigoDisciplina = Integer.parseInt(request.getParameter("codigoDisciplina"));
		
		ProfessorDisciplinaDAO pdDAO = new ProfessorDisciplinaDAO();
		
		pdDAO.salvar(new ProfessorDisciplina(matriculaProfessor,codigoDisciplina));
		
		response.sendRedirect("listarDisciplina");
	}

}