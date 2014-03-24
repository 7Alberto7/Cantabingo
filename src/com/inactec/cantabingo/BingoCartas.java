package com.inactec.cantabingo;

import java.util.ArrayList;

import com.example.cantabingo.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class BingoCartas extends Activity {
	private ArrayList<Carta> barajaEsp = new ArrayList<Carta>();
	private Baraja baraja = null;
	private Context contextActual = null;

	private ImageView imgActual;
	private Button btnSiguiente;
	private Button btnReanudar;
	private GridView tablero;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bingo_cartas);
		ArrayList<Object> restore = (ArrayList<Object>) getLastNonConfigurationInstance();
        
		imgActual = (ImageView) findViewById(R.id.img_carta);
		btnSiguiente = (Button) findViewById(R.id.btn_carta);
		btnReanudar = (Button) findViewById(R.id.btn_reanudar);
		tablero = (GridView) findViewById(R.id.grd_tablero);
		tablero.setAdapter(new ImageAdapter(this));
		
        if (restore != null)
        {
            barajaEsp = (ArrayList<Carta>) restore.get(0);
            baraja = (Baraja) restore.get(1);
			contextActual = imgActual.getContext();
			int idImg = contextActual.getResources().getIdentifier(baraja.actualCarta().getImagen(), "drawable", contextActual.getPackageName());			
			imgActual.setImageResource(idImg);
        }
        else
        {
    		inicializarBarajaEsp(barajaEsp, 40, 10);
    		baraja = new Baraja();
    		
    		baraja.barajar(barajaEsp);
        }

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				baraja.siguienteCarta();
				if(baraja.getPosicion() < baraja.size()) {
					contextActual = imgActual.getContext();
					int idImg = contextActual.getResources().getIdentifier(baraja.actualCarta().getImagen(), "drawable", contextActual.getPackageName());			
					imgActual.setImageResource(idImg);
					int posEnTablero = barajaEsp.indexOf(baraja.actualCarta());
					ImageView img = (ImageView) tablero.getAdapter().getView(posEnTablero, tablero.getChildAt(posEnTablero), tablero);
					img.setImageResource(idImg);
				}
			}
		});

        btnReanudar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			}
		});
	}
 
    @Override
    public Object onRetainNonConfigurationInstance()
    {
    	ArrayList<Object> barajaRecovered = new ArrayList<Object>();
    	barajaRecovered.add(barajaEsp);
    	barajaRecovered.add(baraja);
    	
        return barajaRecovered;
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bingo__cartas, menu);
		return true;
	}
	
	public void inicializarBarajaEsp(ArrayList<Carta> baraja, int totalCartas, int cartasPorPalo) {
		int numCarta = 1;
		int numCartaPalo = 1;
		Palo palo = Palo.OROS;
		
		while(numCarta <= totalCartas) {
			numCartaPalo = 1;
			
			if (numCarta == 11) {
				palo = Palo.BASTOS;
			} else if (numCarta == 21) {
				palo = Palo.ESPADAS;
			} else if (numCarta == 31) {
				palo = Palo.COPAS;
			}
			
			while(numCartaPalo <= cartasPorPalo) {
				
				if (numCartaPalo > 7) {
					baraja.add(new Carta(Integer.toString(numCartaPalo+2), palo, "c"+String.format("%02d", numCarta), false));
				} else {
					baraja.add(new Carta(Integer.toString(numCartaPalo), palo, "c"+String.format("%02d", numCarta), false));
				}
				
				numCartaPalo++;
				numCarta++;
			}
		}
	}

}
