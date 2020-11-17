package br.com.alocarsalas.servlet.sala;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alocarsalas.dao.SalaDAO;

@WebServlet("/sala/excluirSala")
public class ExcluirSalaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
		SalaDAO salaDAO = new SalaDAO();
		
		String paramId = request.getParameter("idSala");
		Integer id = Integer.valueOf(paramId);
		
		salaDAO.remover(id);
		
		response.sendRedirect("listarSala");
		
	}
}
