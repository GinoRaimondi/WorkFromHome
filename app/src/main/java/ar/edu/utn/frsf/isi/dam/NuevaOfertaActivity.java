package ar.edu.utn.frsf.isi.dam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by RAIMONDI on 22/09/2016.
 */
public class NuevaOfertaActivity extends AppCompatActivity {

    EditText descripcion;
    Button btn_guardar;
    Spinner spinner_categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nueva_oferta);

        descripcion = (EditText) findViewById(R.id.descripcionOferta);
        btn_guardar = (Button) findViewById(R.id.guardar);

        Trabajo trabajo = new Trabajo();

        spinner_categoria = (Spinner) findViewById(R.id.spinner_categoria);

        ArrayList<String> array = new ArrayList();
        array.add("Arquitecto");
        array.add("Desarrollador");
        array.add("Tester");
        array.add("Analista");
        array.add("Mobile Developer");

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,array); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_categoria.setAdapter(spinnerArrayAdapter);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Trabajo trabajo = new Trabajo();

                trabajo.setId(100);

                trabajo.setDescripcion(descripcion.getText().toString());

                Intent i = getIntent();

                i.putExtra("resultado", trabajo);

                setResult(RESULT_OK, i);

                finish();

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu_oferta, menu);
        return true;
    }

}
