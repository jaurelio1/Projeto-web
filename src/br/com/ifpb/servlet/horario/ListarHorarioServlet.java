package br.com.ifpb.servlet.horario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.dao.DisciplinaDAO;
import br.com.ifpb.dao.SalaDAO;
import br.com.ifpb.model.Sala;

@WebServlet("/horario/listarHorario")
public class ListarHorarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
		SalaDAO salaDAO = new SalaDAO();
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		
		ArrayList<Sala> lista = salaDAO.listarTudo();
		
		List<Object> matriz = new ArrayList<Object>();
		
		for (Sala item : lista) {
			matriz.add(disciplinaDAO.buscarPorSala(item.getId()));
		}
	
		request.setAttribute("matriz", matriz);
		
		RequestDispatcher rd = request.getRequestDispatcher("/horariosCompletos.jsp");
		rd.forward(request, response);
	}
}
