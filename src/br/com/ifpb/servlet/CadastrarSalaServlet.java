package br.com.ifpb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.dao.SalaDAO;
import br.com.ifpb.model.Sala;

@WebServlet("/cadastrarSala")
public class CadastrarSalaServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		
		int idSala = Integer.parseInt(request.getParameter("idSala"));
		String nomeSala = request.getParameter("nomeSala");
	
		//Cria sala caso ainda não tenha sido criada
		SalaDAO salaDAO = new SalaDAO();
		Sala sala = new Sala(idSala, nomeSala);
		
		if (salaDAO.find(idSala) == null){
			salaDAO.save(sala);
		}
		
		response.sendRedirect("index.html");		
		
	}
}