package br.com.alocarsalas.servlet.disciplina;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alocarsalas.dao.DisciplinaDAO;

@WebServlet("/disciplina/excluirDisciplina")
public class ExcluirDisciplinaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		
		String paramId = request.getParameter("codigoDisciplina");
		Integer id = Integer.valueOf(paramId);
		
		disciplinaDAO.remover(id);
		
		response.sendRedirect("listarDisciplina");
		
	}
}
