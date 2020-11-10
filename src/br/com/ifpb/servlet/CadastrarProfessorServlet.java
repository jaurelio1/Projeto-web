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
		String matriculaProfessor = request.getParameter("matriculaProfessor");
		String cargaHoraria = request.getParameter("cargaHoraria");
		int ch = Integer.parseInt(cargaHoraria);		
		int mt = Integer.parseInt(matriculaProfessor);
		
		
		String nomeDisciplina = request.getParameter("nomeDisciplina");
		String quantAlunos = request.getParameter("qntAlunos");
		String horasAula = request.getParameter("hrsAula");
		int qntAlunos = Integer.parseInt(quantAlunos);
		int hrsAulas = Integer.parseInt(horasAula);
		
		String dataAula = request.getParameter("dataAula");
		String inicioAula = request.getParameter("inicioAula");
		String fimAula = request.getParameter("fimAula");
		
		String idSala = request.getParameter("idSala");
		
		/*Date diaAula = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			diaAula = sdf.parse(dataAula);
		}catch(ParseException e){
			throw new ServletException(e);
			
		}*/
		
		
		SalaDAO salaDAO = new SalaDAO();
		ProfessorDAO professorDAO = new ProfessorDAO();
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		
		Sala sala = salaDAO.save(idSala);
		
		Professor professor = new Professor(nomeProfessor, mt, ch);
		professorDAO.save(professor);
		
		Disciplina disciplina = new Disciplina(nomeDisciplina,qntAlunos,hrsAulas,dataAula,sala,professor);
		disciplina.setInicioAula(inicioAula);
		disciplina.setFimAula(fimAula);
		disciplinaDAO.save(disciplina);
		
		Banco banco = new Banco();
		banco.adiciona(professor);
		banco.adicionaDisciplina(disciplina);
		
		request.setAttribute("professor", professor);
		
		response.sendRedirect("listaProfessores");		
		
	}

}
