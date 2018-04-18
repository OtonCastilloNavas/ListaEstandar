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
        implements ListView.OnItemClickListener, SearchView.OnQueryTextListener {

    public List<Item> lista;
    public int pos=-1;

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
        MiAdapter arrayAdapter = new MiAdapter(MainActivity.this,
                R.layout.itemlist,lista);
        //ASIGNAR ADAPTADOR
        lvLista.setAdapter(arrayAdapter);

        //MANEJADOR DE EVENTO
        lvLista.setOnItemClickListener(this);

        SearchView svBuscar= (SearchView) findViewById(R.id.swBuscar);
        svBuscar.setOnQueryTextListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView,
                            View view, int i, long l) {

        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        EditText etApellido = (EditText) findViewById(R.id.etApllido);
        EditText etAnio = (EditText) findViewById(R.id.etAnio);

        etNombre.setText(lista.get(i).getNombre());
        etApellido.setText(lista.get(i).getApellido());
        etAnio.setText(lista.get(i).getAnio());

        pos=i;

        Toast.makeText(this, lista.get(i).getNombre(),
                Toast.LENGTH_SHORT).show();
    }

    public void onClick(View v)
    {
        EditText etNombre= (EditText)findViewById(R.id.etNombre);
        EditText etApellido =(EditText) findViewById(R.id.etApllido);
        EditText etAnio= (EditText) findViewById(R.id.etAnio);
        if(pos==-1) {
            //lista.add(etNombre.getText().toString());
            Item item = new Item(etNombre.getText().toString()
                    , etApellido.getText().toString(), etAnio.getText().toString());
            lista.add(item);
        } else
        {
            lista.get(pos).setAnio(etAnio.getText().toString());
            lista.get(pos).setApellido(etApellido.getText().toString());
            lista.get(pos).setNombre(etNombre.getText().toString());
            pos=-1;
        }
        etAnio.setText("");
        etApellido.setText("");
        etNombre.setText("");

        ListView lvLista=(ListView)findViewById(R.id.lvLista);
        MiAdapter arrayAdapter= (MiAdapter) lvLista.getAdapter();
        arrayAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        ListView lvLista=(ListView)findViewById(R.id.lvLista);
        MiAdapter arrayAdapter= (MiAdapter) lvLista.getAdapter();
        arrayAdapter.getFilter().filter(newText);
        return false;
    }
}




