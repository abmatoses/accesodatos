package com.sanroman.accesodatos.hibernatetutorial.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Empresa {
	@Id
	private String codEmpresa;
	private String CIF;
	private String url;
	private String telefono;
	public String getCIF() {
		return CIF;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}
	public String getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
