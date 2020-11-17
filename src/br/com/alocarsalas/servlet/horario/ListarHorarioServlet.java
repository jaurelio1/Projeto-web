package br.com.alocarsalas.servlet.horario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alocarsalas.dao.DisciplinaDAO;
import br.com.alocarsalas.dao.SalaDAO;
import br.com.alocarsalas.model.Sala;

@WebServlet("/horario/listarHorario")
public class ListarHorarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
		SalaDAO salaDAO = new SalaDAO();
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		
		ArrayList<Sala> salas = salaDAO.listarTudo();
		
		List<Object> disciplinas = new ArrayList<Object>();
		
		for (Sala item : salas) {
			disciplinas.add(disciplinaDAO.buscarPorSala(item.getCodigo()));
		}
	
		request.setAttribute("salas", salas);
		request.setAttribute("disciplinas", disciplinas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/horariosCompletos.jsp");
		rd.forward(request, response);
	}
}
