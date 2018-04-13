package com.cam.listaestandar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MiAdapter extends ArrayAdapter {

    public List<Item> items;
    public int res;
    public Context context;

    public MiAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.items=objects;
        this.res=resource;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(this.res,
                parent,false);

        TextView tvNombre = (TextView)convertView.findViewById(R.id.tvNombre);
        TextView tvApellido= (TextView) convertView.findViewById(R.id.tvApellido);
        TextView tvAnio=(TextView) convertView.findViewById(R.id.tvAnio);
        tvNombre.setText(items.get(position).getNombre());
        tvApellido.setText(items.get(position).getApellido());
        tvAnio.setText(items.get(position).getAnio());
        //items.get(position).getNombre()
        Button btBorrar= (Button) convertView.findViewById(R.id.btBorrar);
        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
