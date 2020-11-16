package br.com.ifpb.servlet.professor_disciplina;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.dao.ProfessorDisciplinaDAO;

@WebServlet("/disciplina/excluirProfessorDaDisciplina")
public class ExcluirProfessorDaDisciplinaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
		ProfessorDisciplinaDAO pfDAO = new ProfessorDisciplinaDAO();
		
		String idD = request.getParameter("codigoDisciplina");
		Integer idDisciplina = Integer.valueOf(idD);
		
		String idP = request.getParameter("matriculaProfessor");
		Integer idProfessor = Integer.valueOf(idP);
		
		pfDAO.remover(idProfessor, idDisciplina);
		
		response.sendRedirect("listarDisciplina");
		
	}
}
