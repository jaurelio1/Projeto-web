package br.com.ifpb.alocarsalas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/professorOrganizados")
public class ListaProfessorOrdenados extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		
		OrganizarAtividades as = new OrganizarAtividades();
		as.ordenaHorarios();
		as.selectActivity();
		List<Professor> professoresOrganizados = as.getSelectedActivity();
		
		for(int i = 0; i < professoresOrganizados.size(); i++) {
			System.out.println(professoresOrganizados.get(i).getNome());
		}
		
		request.setAttribute("professoresOrganizados", professoresOrganizados);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaProfessoresOrganizados.jsp");
		rd.forward(request, response);
	}

}
