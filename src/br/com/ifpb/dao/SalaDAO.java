package br.com.ifpb.dao;

import br.com.ifpb.model.Sala;

public class SalaDAO {

	public boolean find(String id) {
		return true;
	}
	
	public Sala findOne(String id) {
		return new Sala();
	}
	
	public Sala save(String id) {
		if (!this.find(id)){
			return new Sala(id);
		}else {
			return this.findOne(id);
		}
	}
}
