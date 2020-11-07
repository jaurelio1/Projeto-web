package br.com.ifpb.alocarsalas.servlet;

import java.util.Date;
import java.time.LocalDateTime;

public interface Aula {
	
	public Date getDiaAula();
	public void setDiaAula(Date diaAula);
	
	public int getInicioAula();
	public void setInicioAula(String inicioAula);
	
	public int getFimAula();
	public void setFimAula(String fimAula);
	

}
