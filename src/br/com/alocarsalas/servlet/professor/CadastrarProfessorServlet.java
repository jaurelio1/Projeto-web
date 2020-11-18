package br.com.alocarsalas.servlet.professor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alocarsalas.dao.ProfessorDAO;
import br.com.alocarsalas.model.Professor;

@WebServlet("/professor/cadastrarProfessor")
public class CadastrarProfessorServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
	
		String nomeProfessor = request.getParameter("nomeProfessor");
		int mt = Integer.parseInt(request.getParameter("matriculaProfessor"));
		int ch = Integer.parseInt(request.getParameter("cargaHoraria"));		
		

		//Cria professor caso ainda não tenha sido criado
		ProfessorDAO professorDAO = new ProfessorDAO();
		Professor professor = new Professor(nomeProfessor, mt, ch);
		
		
		if (professorDAO.buscar(mt) == null){
			professorDAO.salvar(professor);
		}
		
		response.sendRedirect("listarProfessor");		
		
	}

}
