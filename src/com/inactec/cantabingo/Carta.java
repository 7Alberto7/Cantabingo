package com.inactec.cantabingo;

public class Carta {
	private String numero;
	private Palo palo;
	private String imagen;
	private boolean enBaraja;
	
	public Carta(String numero, Palo palo, String imagen, Boolean enBaraja) {
		this.numero = numero;
		this.palo = palo;
		this.imagen = imagen;
		this.enBaraja = enBaraja;
	}
	
	public boolean isEnBaraja() {
		return enBaraja;
	}

	public void setEnBaraja(boolean enBaraja) {
		this.enBaraja = enBaraja;
	}

	public String getNumero() {
		return numero;
	}
	
	public Palo getPalo() {
		return palo;
	}
	
	public String getImagen() {
		return imagen;
	}

	@Override
	public String toString() {
		return this.getNumero() + " de " + this.getPalo() + ". enBaraja=" + enBaraja + "]";
	}
	
}
