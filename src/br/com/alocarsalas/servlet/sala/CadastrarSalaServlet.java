package br.com.alocarsalas.servlet.sala;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alocarsalas.dao.SalaDAO;
import br.com.alocarsalas.model.Sala;

@WebServlet("/sala/cadastrarSala")
public class CadastrarSalaServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		
		int idSala = Integer.parseInt(request.getParameter("idSala"));
		String nomeSala = request.getParameter("nomeSala");
	
		SalaDAO salaDAO = new SalaDAO();
		Sala sala = new Sala(idSala, nomeSala);
		
		if (salaDAO.buscar(idSala) == null){
			salaDAO.salvar(sala);
		}
		
		response.sendRedirect("listarSala");	
		
	}
}