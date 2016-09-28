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
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    RadioGroup idioma_group;
    RadioButton radioButtonAR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nueva_oferta);

        descripcion = (EditText) findViewById(R.id.descripcionOferta);
        btn_guardar = (Button) findViewById(R.id.guardar);
        idioma_group = (RadioGroup) findViewById(R.id.idioma_group);
        radioButtonAR = (RadioButton) findViewById(R.id.rbAR);

        //radioButtonAR.setButtonDrawable(R.drawable.ar);

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

                // Obtenemos el idioma seleccionado

                /*int radioButtonID = idioma_group.getCheckedRadioButtonId();
                View radioButton = idioma_group.findViewById(radioButtonID);
                int idx = idioma_group.indexOfChild(radioButton);

                RadioButton r = (RadioButton)  radioButton.getChildAt(idx);
                String selectedtext = r.getText().toString();*/

                Trabajo trabajo = new Trabajo();

                int positionSpinner = spinner_categoria.getSelectedItemPosition();

                System.out.println("POSITION SPINNER : " + positionSpinner);

                switch (positionSpinner) {
                    case 0:

                        trabajo.getCategoria().setId(1);
                        trabajo.getCategoria().setDescripcion("Arquitecto");

                        break;

                    case 1:

                        trabajo.getCategoria().setId(2);
                        trabajo.getCategoria().setDescripcion("Desarrollador");

                        break;

                    case 2:

                        trabajo.getCategoria().setId(3);
                        trabajo.getCategoria().setDescripcion("Tester");

                        break;

                    case 3:

                        trabajo.getCategoria().setId(4);
                        trabajo.getCategoria().setDescripcion("Analista");

                        break;

                    case 4:

                        trabajo.getCategoria().setId(5);
                        trabajo.getCategoria().setDescripcion("Mobile Developer");

                        break;

                }


                int checkedRadioButtonId = idioma_group.getCheckedRadioButtonId();
                if (checkedRadioButtonId == -1) {
                    // No item selected
                }
                else{
                    switch (checkedRadioButtonId) {
                        case R.id.rbAR:

                            trabajo.setMonedaPago(3);

                           break;

                        case R.id.rbBR:

                            trabajo.setMonedaPago(5);

                            break;

                        case R.id.rbEU:

                            trabajo.setMonedaPago(2);

                            break;

                        case R.id.rbUK:

                            trabajo.setMonedaPago(4);

                            break;

                        case R.id.rbUS:

                            trabajo.setMonedaPago(1);

                            break;

                    }

                }

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
