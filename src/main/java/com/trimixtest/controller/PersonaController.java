package com.trimixtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trimixtest.model.Persona;
import com.trimixtest.service.PersonaService;



@RestController
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	//Add person
	@PostMapping("/api/persona")
	public ResponseEntity<?> save(@RequestBody Persona persona){		
		long perId = personaService.save(persona);
		return ResponseEntity.ok().body("Una nueva persona ha sido registrada con el id:" +perId);
	}
	
	//Get person by docType
	@GetMapping("/api/findByDocType/{perTipoDocumento}")
		public ResponseEntity<List<Persona>> listByDocType(@PathVariable("perTipoDocumento") String perTipoDocumento){
		List<Persona> list = personaService.listByDocType(perTipoDocumento);
		return ResponseEntity.ok(list);		
	}
	
	//Get person by Name
	@GetMapping("/api/findByName/{perNombre}")
		public ResponseEntity<List<Persona>> listByName(@PathVariable("perNombre") String perNombre){
		List<Persona> list = personaService.listByName(perNombre);
		return ResponseEntity.ok(list);		
	}
	
	//Get all persons
	@GetMapping("/api/personas")
	public ResponseEntity<List<Persona>> list(){
		List<Persona> list = personaService.list();
		return ResponseEntity.ok(list);		
	}
	
	//Update person
	@PutMapping("/api/persona/{perId}")
	public ResponseEntity<?> update(@PathVariable("perId") Long perId, @RequestBody Persona persona){
		personaService.update(perId, persona);
		return ResponseEntity.ok().body("El registro ha sido actualizado");		
	}
	
	//Delete person
	@DeleteMapping("/api/persona/{perId}")
	public ResponseEntity<?> delete(@PathVariable("perId") Long perId){
		personaService.delete(perId);
		return ResponseEntity.ok().body("El registro ha sido eliminado");		
	}
	
	 

}
