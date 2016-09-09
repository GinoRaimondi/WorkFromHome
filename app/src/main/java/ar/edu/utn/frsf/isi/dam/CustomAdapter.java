package ar.edu.utn.frsf.isi.dam;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RAIMONDI on 08/09/2016.
 */
public class CustomAdapter extends BaseAdapter {

    private Activity activity;
    private List data;
    private static LayoutInflater inflater=null;
    public Resources res;


public CustomAdapter(Activity a, List d, Resources resLocal){

    activity = a;
    data = d;
    res = resLocal;
    inflater = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

}

    @Override
    public int getCount() {return data.size();
    }

    @Override
    public Trabajo getItem(int position) {
        return (Trabajo)data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        if(row==null) row=inflater.inflate(R.layout.row, parent, false);
        TextView textViewCategoria = (TextView)row.findViewById(R.id.textViewCategoria);
        TextView textViewDescripcion = (TextView)row.findViewById(R.id.textViewDescripcion);
        TextView textViewHorasPresupuestadas = (TextView)row.findViewById(R.id.textViewHorasPresupuestadas);
        TextView textViewPrecioMax = (TextView)row.findViewById(R.id.textViewPrecioMax);
        TextView textViewFechaEntrega = (TextView)row.findViewById(R.id.textViewFechaEntrega);
        ImageView imageViewTipoMoneda = (ImageView)row.findViewById(R.id.imageViewTipoMoneda);
        CheckBox checkBoxRequiereIngles = (CheckBox) row.findViewById(R.id.checkBoxRequiereIngles);
        if(this.getItem(position)==null) return row;
        textViewCategoria.setText(this.getItem(position).getCategoria().getDescripcion());
        textViewDescripcion.setText(this.getItem(position).getDescripcion());
        textViewHorasPresupuestadas.setText("Horas:"+this.getItem(position).getHorasPresupuestadas());
        DecimalFormat df= new DecimalFormat("#.##");
        textViewPrecioMax.setText(" Max $/Hora:"+ df.format(this.getItem(position).getPrecioMaximoHora()));
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        textViewFechaEntrega.setText("Fecha Fin:"+ formato.format(this.getItem(position).getFechaEntrega()));

        switch (this.getItem(position).getMonedaPago()){
            case 1:imageViewTipoMoneda.setImageResource(R.drawable.us);break;
            case 2:imageViewTipoMoneda.setImageResource(R.drawable.eu);break;
            case 3:imageViewTipoMoneda.setImageResource(R.drawable.ar);break;
            case 4:imageViewTipoMoneda.setImageResource(R.drawable.uk);break;
            case 5:imageViewTipoMoneda.setImageResource(R.drawable.br);break;
        }

        if(this.getItem(position).getRequiereIngles())checkBoxRequiereIngles.setChecked(true);

        return row;
    }
}
