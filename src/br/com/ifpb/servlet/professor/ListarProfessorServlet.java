package br.com.ifpb.servlet.professor;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.dao.ProfessorDAO;
import br.com.ifpb.model.Professor;

@WebServlet("/professor/listarProfessor")
public class ListarProfessorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
		ProfessorDAO professorDAO = new ProfessorDAO();
		
		ArrayList<Professor> professores = professorDAO.listarTudo();
		
		request.setAttribute("professores", professores);
		RequestDispatcher rd = request.getRequestDispatcher("/sobreProfessores.jsp");
		rd.forward(request, response);
	}
}
