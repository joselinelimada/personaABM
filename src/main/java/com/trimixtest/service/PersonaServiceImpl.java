package com.trimixtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trimixtest.dao.PersonaDAO;
import com.trimixtest.model.Persona;

@Service
//@Transactional(readOnly = true)
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDAO;

	@Override
	@Transactional
	public long save(Persona persona) {		
		return personaDAO.save(persona);
	}

	@Override
	public Persona get(long perId) {		
		return personaDAO.get(perId);
	}

	@Override
	@Transactional
	public List<Persona> listByDocType(String perTipoDocumento) {
		return personaDAO.listByDocType(perTipoDocumento);
	}

	@Override
	@Transactional
	public List<Persona> list() {		
		return personaDAO.list();
	}

	@Override
	@Transactional
	public void update(long perId, Persona persona) {
		personaDAO.update(perId, persona);		
	}

	@Override
	@Transactional
	public void delete(long perId) {
		personaDAO.delete(perId);		
	}

	@Override
	@Transactional
	public List<Persona> listByName(String perName) {
		return personaDAO.listByName(perName);
	}
	

}
