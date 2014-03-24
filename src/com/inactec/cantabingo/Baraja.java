package com.inactec.cantabingo;

import java.util.ArrayList;

import android.util.Log;

public class Baraja {
	private ArrayList<Carta> baraja;
	private int posicion;
	
	public Baraja() {
		this.baraja = new ArrayList<Carta>();
		this.posicion = -1;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	public void barajar(ArrayList<Carta> barajaEsp) {
		
		while(baraja.size() < barajaEsp.size()) {
			int numero = (int) (Math.random()*barajaEsp.size());
			Carta carta = barajaEsp.get(numero);
			if (!carta.isEnBaraja()) {
				baraja.add(carta);
				carta.setEnBaraja(true);
			}
		}
	}
	
	public void siguienteCarta() {
		this.setPosicion(this.getPosicion() + 1);
	}
	
	public Carta actualCarta() {
		return baraja.get(this.getPosicion());
	}

	@Override
	public String toString() {
		String lista = "";
		for (int i = 0; i < baraja.size(); i++) {
			lista+= baraja.get(i).toString() + "\n";
		}
		
		return lista;
	}
	
	public int size() {
		return baraja.size();
	}
	
}
