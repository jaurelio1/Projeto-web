package br.com.alocarsalas.servlet.disciplina;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alocarsalas.dao.DisciplinaDAO;
import br.com.alocarsalas.dao.SalaDAO;
import br.com.alocarsalas.model.Disciplina;
import br.com.alocarsalas.model.Sala;

@WebServlet("/disciplina/editarDisciplina")
public class EditarDisciplinaServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
	
		String nomeDisciplina = request.getParameter("nomeDisciplina");
		int codigoDisciplina = Integer.parseInt(request.getParameter("codigoDisciplina"));
		int qntAlunos = Integer.parseInt(request.getParameter("qntAlunos"));
		int hrsAulas = Integer.parseInt(request.getParameter("hrsAula"));
		String dataAula = request.getParameter("dataAula");
		String inicioAula = request.getParameter("inicioAula");
		String fimAula = request.getParameter("fimAula");
		
		int idSala = Integer.parseInt(request.getParameter("idSala"));
	
		SalaDAO salaDAO = new SalaDAO();
		Sala sala = new Sala(idSala,"sala");
		
		if (salaDAO.buscar(idSala) == null){
			salaDAO.salvar(sala);
		}
		
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		Disciplina disciplina = new Disciplina(nomeDisciplina,codigoDisciplina,qntAlunos,hrsAulas,dataAula,inicioAula,fimAula,sala);
		disciplinaDAO.editar(disciplina);
		
		response.sendRedirect("listarDisciplina");
	}

}