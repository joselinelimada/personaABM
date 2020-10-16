package com.trimixtest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Persona")

public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long perId;
	private String perApellido;
	private String perNombre;
	private Long perNumeroDocumento;
	private String perTipoDocumento;
	private Date perFechaNacimiento;
	public Long getPerId() {
		return perId;
	}
	public void setPerId(Long perId) {
		this.perId = perId;
	}
	public String getPerApellido() {
		return perApellido;
	}
	public void setPerApellido(String perApellido) {
		this.perApellido = perApellido;
	}
	public String getPerNombre() {
		return perNombre;
	}
	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}
	public Long getPerNumeroDocumento() {
		return perNumeroDocumento;
	}
	public void setPerNumeroDocumento(Long perNumeroDocumento) {
		this.perNumeroDocumento = perNumeroDocumento;
	}
	public String getPerTipoDocumento() {
		return perTipoDocumento;
	}
	public void setPerTipoDocumento(String perTipoDocumento) {
		this.perTipoDocumento = perTipoDocumento;
	}
	public Date getPerFechaNacimiento() {
		return perFechaNacimiento;
	}
	public void setPerFechaNacimiento(Date perFechaNacimiento) {
		this.perFechaNacimiento = perFechaNacimiento;
	}
	@Override
	public String toString() {
		return "Persona [perId=" + perId + ", perApellido=" + perApellido + ", perNombre=" + perNombre
				+ ", perNumeroDocumento=" + perNumeroDocumento + ", perTipoDocumento=" + perTipoDocumento
				+ ", perFechaNacimiento=" + perFechaNacimiento + "]";
	}	
	

}
