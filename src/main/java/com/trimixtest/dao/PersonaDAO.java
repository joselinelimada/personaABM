package com.trimixtest.dao;

import java.util.List;

import com.trimixtest.model.Persona;

public interface PersonaDAO {
	long save(Persona persona);
	Persona get(long perId);
	List<Persona> listByDocType(String perTipoDocumento);
	List<Persona> listByName(String perName);
	List<Persona> list();
	void update(long perId, Persona persona);
	void delete(long perId);

}
