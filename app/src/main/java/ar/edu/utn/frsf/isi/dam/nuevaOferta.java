package ar.edu.utn.frsf.isi.dam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.Arrays;

/**
 * Created by RAIMONDI on 22/09/2016.
 */
public class nuevaOferta extends Activity {

    EditText descripcion;
    Button btn_guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nueva_oferta);

        descripcion = (EditText) findViewById(R.id.descripcionOferta);
        btn_guardar = (Button) findViewById(R.id.guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Trabajo trabajo = new Trabajo(100,descripcion.getText().toString());

                Intent i = getIntent();

                i.putExtra("resultado", trabajo);

                setResult(RESULT_OK, i);

                finish();

            }
        });
    }

}
