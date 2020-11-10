package br.com.ifpb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ifpb.dao.DisciplinaDAO;
import br.com.ifpb.dao.ProfessorDAO;
import br.com.ifpb.dao.SalaDAO;
import br.com.ifpb.model.Disciplina;
import br.com.ifpb.model.Professor;
import br.com.ifpb.model.Sala;
import br.com.ifpb.util.Banco;


@WebServlet("/cadastrarProfessor")
public class CadastrarProfessorServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
	
		String nomeProfessor = request.getParameter("nomeProfessor");
		int mt = Integer.parseInt(request.getParameter("matriculaProfessor"));
		int ch = Integer.parseInt(request.getParameter("cargaHoraria"));		
		
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
		Sala sala = new Sala(idSala);
		
		if (salaDAO.find(idSala) == null){
			salaDAO.save(sala);
		}
		
		
		//Cria professor caso ainda não tenha sido criado
		ProfessorDAO professorDAO = new ProfessorDAO();
		Professor professor = new Professor(nomeProfessor, mt, ch);
		professorDAO.save(professor);
		
		if (professorDAO.find(mt) == null){
			professorDAO.save(professor);
		}
		
		//Cria professor caso ainda não tenha sido criado
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		Disciplina disciplina = new Disciplina(nomeDisciplina,codigoDisciplina,qntAlunos,hrsAulas,dataAula,sala);
		disciplina.setInicioAula(inicioAula);
		disciplina.setFimAula(fimAula);
		disciplinaDAO.save(disciplina);
		
		if (disciplinaDAO.find(codigoDisciplina) == null){
			disciplinaDAO.save(disciplina);
		}
		
		Banco banco = new Banco();
		banco.adiciona(professor);
		banco.adicionaDisciplina(disciplina);
		
		request.setAttribute("professor", professor); 
		
		response.sendRedirect("listaProfessores");		
		
	}

}
