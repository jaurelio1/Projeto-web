package br.com.alocarsalas.servlet.sala;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alocarsalas.dao.SalaDAO;
import br.com.alocarsalas.model.Sala;

@WebServlet("/sala/listarSala")
public class ListarSalaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
		SalaDAO salaDAO = new SalaDAO();
		
		ArrayList<Sala> salas = salaDAO.listarTudo();
		
		request.setAttribute("salas", salas);
		RequestDispatcher rd = request.getRequestDispatcher("/sobreSalas.jsp");
		rd.forward(request, response);
	}
}
