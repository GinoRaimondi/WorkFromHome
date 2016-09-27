package ar.edu.utn.frsf.isi.dam;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    private static Context context;
    Trabajo[] trabajos;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivity.context = getApplicationContext();

        listview = (ListView) findViewById(R.id.listView);

        trabajos = Trabajo.TRABAJOS_MOCK;
        CustomAdapter adapter = new CustomAdapter(this, Arrays.asList(trabajos), getResources());
        listview.setAdapter(adapter);

        registerForContextMenu(listview);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

      /*  public boolean onOptionsItemSelected(MenuItem item){

            if (item.getItemId() == R.id.idMenu1)
            {
                Toast.makeText(this, "this is my Toast message!!! =)",
                        Toast.LENGTH_LONG).show();
            }*/

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.idMenu1:

                Intent intent = new Intent(this, NuevaOfertaActivity.class);

                startActivityForResult(intent, 0);

                return true;
            case R.id.menu3:

                android.os.Process.killProcess(android.os.Process.myPid());

                System.exit(1);
                return true;

        }

        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {


            case R.id.compartir:

                /*Toast.makeText(this, "Compartiendo",
                        Toast.LENGTH_LONG).show();*/

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Novedades sobre el trabajo '" + listview.getAdapter().getItem(info.position).toString() + "'. Enviado desde WorkFromHome");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                return true;

            case R.id.postularse:

                Toast.makeText(this, "Usted se ha postulado a la oferta de trabajo " + listview.getAdapter().getItem(info.position).toString(),
                        Toast.LENGTH_LONG).show();


        }

        return true;
    }



    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        if(v.getId() == R.id.listView)
        {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle(listview.getAdapter().getItem(info.position).toString());
        }

        inflater.inflate(R.menu.postularse,menu);

        // Get the list
        ListView list = (ListView) v;

        // Get the list item position
        /*AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        int position = info.position;*/

        // Now you can do whatever.. (Example, load different menus for different items)
        //list.getItem(position);
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

            List<Trabajo> listaTrabajos = Arrays.asList(trabajos);
            listaTrabajos = new ArrayList<>(listaTrabajos);

            System.out.println("arr: " + trabajo_r.toString());

            listaTrabajos.add(trabajo_r);

            CustomAdapter adapter = new CustomAdapter(this, listaTrabajos, getResources());
            listview.setAdapter(adapter);

            // Do something with the contact here (bigger example below)
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://ar.edu.utn.frsf.isi.dam/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://ar.edu.utn.frsf.isi.dam/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
