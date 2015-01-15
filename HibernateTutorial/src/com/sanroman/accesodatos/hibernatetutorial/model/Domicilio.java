package com.sanroman.accesodatos.hibernatetutorial.model;

import javax.persistence.Embeddable;

@Embeddable
public class Domicilio {
	public static final int CALLE = 1;
	public static final int PLAZA = 2;
	public static final int AVENIDA = 3;
	public static final int GLORIETA = 4;
	private int tipoVia;
	private String nombreVia;
	private int numero;
	private int codigoPostal;

	public int getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(int tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getNombreVia() {
		return nombreVia;
	}

	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	@Override
	public String toString() {
		StringBuffer buff = new StringBuffer();
		switch (tipoVia) {
		case CALLE:
			buff.append("Calle ");
			break;
		case PLAZA:
			buff.append("Pza. ");
			break;
		case GLORIETA:
			buff.append("Gta. ");
			break;
		case AVENIDA:
			buff.append("Avd. ");
			break;
		}
		buff.append(nombreVia + " " + numero + ", " + codigoPostal);
		return buff.toString();
	}

}
