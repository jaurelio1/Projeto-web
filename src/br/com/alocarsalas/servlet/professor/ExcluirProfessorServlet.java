package br.com.alocarsalas.servlet.professor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alocarsalas.dao.ProfessorDAO;

@WebServlet("/professor/excluirProfessor")
public class ExcluirProfessorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
		ProfessorDAO professorDAO = new ProfessorDAO();
		
		String paramId = request.getParameter("matriculaProfessor");
		Integer id = Integer.valueOf(paramId);
		
		professorDAO.remover(id);
		
		response.sendRedirect("listarProfessor");
		
	}
}
