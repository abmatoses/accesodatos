package com.sanroman.accesodatos.hibernatetutorial.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "user_table")
public class Usuario {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "user_name")
	private String name;
	@Column(name = "user_email")
	private String email;
	@Column(name = "user_telephone")
	private String telefono;
	@ElementCollection
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@JoinTable(name = "user_domicilio", joinColumns = { @JoinColumn(name = "user_id") })
	@CollectionId(columns = { @Column(name = "domicilio_id") }, generator = "hilo-gen", type = @Type(type = "long"))
	private List<Domicilio> domicilios = new ArrayList<Domicilio>();

	
	 @ManyToMany
	  @JoinTable(name="servicio_usuario",
	  joinColumns={@JoinColumn(name="usuario_id")},
	  inverseJoinColumns={@JoinColumn(name="servicio_id")}) private
	  List<Servicio> servicios=new ArrayList<Servicio>();
	 
	 
	  public List<Servicio> getServicios() { return servicios; } public void
	 setServicios(List<Servicio> servicios) { this.servicios = servicios; }
	 
	public List<Domicilio> getDomicilios() {
		return domicilios;
	}

	public void setDomicilios(List<Domicilio> domicilios) {
		this.domicilios = domicilios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void print() {
		System.out.println("User[id:" + id + ", nombre:" + name + "]");

	}

}
