package br.com.ifpb.servlet.disciplina;

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
import br.com.ifpb.dao.ProfessorDisciplinaDAO;
import br.com.ifpb.model.Disciplina;

@WebServlet("/disciplina/listarDisciplina")
public class ListarDisciplinaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		
		ArrayList<Disciplina> disciplinas = disciplinaDAO.listarTudo();
		
		ProfessorDisciplinaDAO pdDAO = new ProfessorDisciplinaDAO();
		
		List<Object> professores = new ArrayList<Object>();
		
		for (Disciplina item : disciplinas) {
			professores.add(pdDAO.listarProfessorPorDisciplina(item.getCodigo()));
		}
		
		request.setAttribute("professores", professores);
		request.setAttribute("disciplinas", disciplinas);
		RequestDispatcher rd = request.getRequestDispatcher("/sobreDisciplinas.jsp");
		rd.forward(request, response);
	}
}
