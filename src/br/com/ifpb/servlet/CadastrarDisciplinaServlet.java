package br.com.ifpb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.dao.DisciplinaDAO;
import br.com.ifpb.dao.SalaDAO;
import br.com.ifpb.model.Disciplina;
import br.com.ifpb.model.Sala;

@WebServlet("/cadastrarDisciplina")
public class CadastrarDisciplinaServlet extends HttpServlet{
	
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
		
		
		//Cria sala caso ainda não tenha sido criada
		SalaDAO salaDAO = new SalaDAO();
		Sala sala = new Sala(idSala,"sala");
		
		if (salaDAO.find(idSala) == null){
			salaDAO.save(sala);
		}
		

		//Cria disciplina caso ainda não tenha sido criada
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		Disciplina disciplina = new Disciplina(nomeDisciplina,codigoDisciplina,qntAlunos,hrsAulas,dataAula,sala);
		disciplina.setInicioAula(inicioAula);
		disciplina.setFimAula(fimAula);
		disciplinaDAO.save(disciplina);
		
		if (disciplinaDAO.find(codigoDisciplina) == null){
			disciplinaDAO.save(disciplina);
		}
		
		response.sendRedirect("index.html");		
		
	}

}