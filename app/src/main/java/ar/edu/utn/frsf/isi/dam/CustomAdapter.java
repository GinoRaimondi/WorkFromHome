package ar.edu.utn.frsf.isi.dam;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by RAIMONDI on 08/09/2016.
 */
public class CustomAdapter extends BaseAdapter {

    private ListView activity;
    private ArrayList data;
    public Resources res;


public CustomAdapter(ListView a, ArrayList d, Resources resLocal){

    activity = a;
    data = d;
    res = resLocal;


}

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
