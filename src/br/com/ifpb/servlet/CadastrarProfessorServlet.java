package br.com.ifpb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.dao.ProfessorDAO;
import br.com.ifpb.model.Professor;

@WebServlet("/cadastrarProfessor")
public class CadastrarProfessorServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
	
		String nomeProfessor = request.getParameter("nomeProfessor");
		//int mt = Integer.parseInt(request.getParameter("matriculaProfessor"));
		int mt = 13;
		int ch = Integer.parseInt(request.getParameter("cargaHoraria"));		
		

		//Cria professor caso ainda não tenha sido criado
		ProfessorDAO professorDAO = new ProfessorDAO();
		Professor professor = new Professor(nomeProfessor, mt, ch);
		professorDAO.save(professor);
		
		if (professorDAO.find(mt) == null){
			professorDAO.save(professor);
		}
		
		request.setAttribute("professor", professor); 
		
		response.sendRedirect("index.html");		
		
	}

}
