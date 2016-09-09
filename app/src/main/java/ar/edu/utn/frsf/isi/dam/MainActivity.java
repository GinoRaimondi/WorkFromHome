package ar.edu.utn.frsf.isi.dam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listView);

        Trabajo[] trabajos = new Trabajo[]{
          new Trabajo(1,"Trabajo 1"),new Trabajo(2,"Trabajo 2"),new Trabajo(3,"Trabajo 3")
        };

        CustomAdapter adapter = new CustomAdapter(listview, Arrays.asList(trabajos),getResources()));


    }
}
