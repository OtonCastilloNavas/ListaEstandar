package com.cam.listaestandar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ListView.OnItemClickListener {
public List<Item> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CONTROL LISTVIEW
        ListView lvLista =(ListView) findViewById(R.id.lvLista);
        //ORIGEN DE DATOS
        lista= new ArrayList<>();
        /*lista.add("Sergio");
        lista.add("Francisco");
        lista.add("Hector");
        lista.add("Alejandro");
        lista.add("Cristian");
        lista.add("Luis");
        lista.add("Anabell");
        lista.add("Mario");
        lista.add("orlando");
        lista.add("Roberto");
        lista.add("Marlon");
        lista.add("Gabriela");
        lista.add("Claudia");
        lista.add("Maxsuel");
        lista.add("Riemann");
        lista.add("Jiuber");*/
        //ADAPTADOR
        //ArrayAdapter arrayAdapter= new ArrayAdapter(MainActivity.this,
          //      android.R.layout.simple_list_item_1,lista);
        final MiAdapter arrayAdapter = new MiAdapter(MainActivity.this,
                R.layout.itemlist,lista);
        //ASIGNAR ADAPTADOR
        lvLista.setAdapter(arrayAdapter);

        //MANEJADOR DE EVENTO
        lvLista.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView,
                            View view, int i, long l) {


        //Toast.makeText(this, item.getNombre(), Toast.LENGTH_SHORT).show();
    }

    public void onClick(View v)
    {
        EditText etNombre= (EditText)findViewById(R.id.etNombre);
        EditText etApellido =(EditText) findViewById(R.id.etApllido);
        EditText etAnio= (EditText) findViewById(R.id.etAnio);
        //lista.add(etNombre.getText().toString());
        Item item= new Item(etNombre.getText().toString()
        ,etApellido.getText().toString(), etAnio.getText().toString());
        lista.add(item);
        ListView lvLista=(ListView)findViewById(R.id.lvLista);
        MiAdapter arrayAdapter= (MiAdapter) lvLista.getAdapter();
        arrayAdapter.notifyDataSetChanged();
    }
}




