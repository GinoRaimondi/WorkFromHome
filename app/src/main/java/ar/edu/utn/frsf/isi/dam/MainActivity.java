package ar.edu.utn.frsf.isi.dam;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    private static Context context;
    Trabajo[] trabajos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.context = getApplicationContext();

        listview = (ListView) findViewById(R.id.listView);


        trabajos = Trabajo.TRABAJOS_MOCK;
        CustomAdapter adapter = new CustomAdapter(this,  Arrays.asList(trabajos), getResources());
        listview.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

      /*  public boolean onOptionsItemSelected(MenuItem item){

            if (item.getItemId() == R.id.idMenu1)
            {
                Toast.makeText(this, "this is my Toast message!!! =)",
                        Toast.LENGTH_LONG).show();
            }*/

        switch (item.getItemId())
        {
            case R.id.idMenu1:

                Intent intent = new Intent(this,nuevaOferta.class);

                startActivityForResult(intent,0);

        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.

                Trabajo trabajo_r = (Trabajo) data.getSerializableExtra("resultado");
                /*Toast.makeText(this, trabajo.getDescripcion(),
                        Toast.LENGTH_LONG).show();*/

                List listaTrabajos = Arrays.asList(trabajos);
                listaTrabajos.add(trabajo_r);


                CustomAdapter adapter = new CustomAdapter(this, listaTrabajos, getResources());
                listview.setAdapter(adapter);


                // Do something with the contact here (bigger example below)
            }
        }

}
