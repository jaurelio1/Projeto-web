package br.com.ifpb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.alocarsalas.servlet.Banco;
import br.com.ifpb.model.Professor;

@WebServlet("/listaProfessores")
public class ListaProfessores extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		Banco banco = new Banco();
		List<Professor> professores = banco.getProfessores();
		
		request.setAttribute("professores", professores);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaProfessores.jsp");
		rd.forward(request, response);
	}

}
