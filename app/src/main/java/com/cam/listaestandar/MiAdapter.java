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
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MiAdapter extends ArrayAdapter implements Filterable {

    public List<Item> items;
    public List<Item> copiaitems;
    public int res;
    public Context context;
    private ValueFilter valueFilter;

    public MiAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.items=objects;
        this.copiaitems=objects;
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

    @Override
    public int getCount() {
        return items.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        if(valueFilter==null)
        {
            valueFilter= new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            if (charSequence != null && charSequence.length() > 0) {
                //si no es vacio lo escrito en searchView
                List<Item> list = new ArrayList<>();
                for (int x = 0; x < copiaitems.size(); x++) {
                    if (copiaitems.get(x).getNombre().toUpperCase().contains(
                            charSequence.toString().toUpperCase())) {
                        list.add(copiaitems.get(x));
                    }
                }

                results.values = list;
                results.count = list.size();
            }
            else
            {
                //si esta vacio lo escrito en searchView
                results.values=copiaitems;
                results.count=copiaitems.size();
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            items=(List<Item>) filterResults.values;
            notifyDataSetChanged();
        }
    }


}




