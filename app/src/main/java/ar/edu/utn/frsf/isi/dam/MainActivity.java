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

public class MainActivity extends AppCompatActivity {

    ListView listview;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.context = getApplicationContext();

        listview = (ListView) findViewById(R.id.listView);

        Trabajo[] trabajos = new Trabajo[]{
          new Trabajo(1,"Trabajo 1"),new Trabajo(2,"Trabajo 2"),new Trabajo(3,"Trabajo 3")
        };
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
}
