package com.trimixtest.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trimixtest.model.Persona;

@Repository
public class PersonaDAOImpl implements PersonaDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Persona persona) {
		sessionFactory.getCurrentSession().save(persona);
		return persona.getPerId();
	}

	@Override
	public Persona get(long perId) {
		return sessionFactory.getCurrentSession().get(Persona.class, perId);
	}

	@Override
	public List<Persona> listByDocType(String perTipoDocumento) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
		EntityType<Persona> type = session.getMetamodel().entity(Persona.class);
		Root<Persona> root = query.from(Persona.class);
		query.where(builder.like(root.get(type.getDeclaredSingularAttribute("perTipoDocumento", String.class)), "%" + perTipoDocumento.toLowerCase() + "%"));
		return session.createQuery(query).getResultList();		
	}

	@Override
	public List<Persona> list() {
		List<Persona> personList = sessionFactory.getCurrentSession().createQuery("from Persona").list();
		return personList;
	}

	@Override
	public void update(long perId, Persona persona) {
		Session session = sessionFactory.getCurrentSession();
		Persona currentPerson = session.byId(Persona.class).load(perId);
		currentPerson.setPerApellido(persona.getPerApellido());
		currentPerson.setPerNombre(persona.getPerNombre());
		currentPerson.setPerNumeroDocumento(persona.getPerNumeroDocumento());
		currentPerson.setPerTipoDocumento(persona.getPerTipoDocumento());
		currentPerson.setPerFechaNacimiento(persona.getPerFechaNacimiento());
		session.flush();	
	}

	@Override
	public void delete(long perId) {
		Session session = sessionFactory.getCurrentSession();
		Persona persona = session.byId(Persona.class).load(perId);
		session.delete(persona);
		
	}

	@Override
	public List<Persona> listByName(String perName) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Persona> query = builder.createQuery(Persona.class);
		EntityType<Persona> type = session.getMetamodel().entity(Persona.class);
		Root<Persona> root = query.from(Persona.class);
		query.where(builder.like(root.get(type.getDeclaredSingularAttribute("perNombre", String.class)), "%" + perName.toLowerCase() + "%"));
		return session.createQuery(query).getResultList();	
	}	

}
