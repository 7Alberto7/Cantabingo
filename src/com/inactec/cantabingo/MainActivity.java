package com.inactec.cantabingo;

import java.util.ArrayList;

import com.example.cantabingo.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btn_bingo;
	private Button btn_bingo_cartas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_bingo_cartas = (Button) findViewById(R.id.btn_bingo_cartas);
		
		btn_bingo_cartas.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				cargarBingoCartas();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void cargarBingoCartas() {

		Intent i= new Intent(this, BingoCartas.class);
		
		startActivity(i);
	}

}
