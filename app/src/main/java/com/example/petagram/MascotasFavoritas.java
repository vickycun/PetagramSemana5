package com.example.petagram;

import android.content.Intent;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.adapter.MascotaAdaptador;
import com.example.petagram.db.ConstantesBaseDatos;
import com.example.petagram.fragments.IMascotasFragmentView;
import com.example.petagram.menuopc.AcercaDe;
import com.example.petagram.menuopc.Contacto;
import com.example.petagram.pojo.Mascota;
import com.example.petagram.presentador.IMascotasFragmentPresenter;
import com.example.petagram.presentador.MascotasFragmentPresenter;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IMascotasFragmentView {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IMascotasFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritas_mascotas);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarFavoritos);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        //presenter = new MascotasFragmentPresenter (this,this, ConstantesBaseDatos.MASCOTAS_TOP5);
        presenter = new MascotasFragmentPresenter(this,this, ConstantesBaseDatos.MASCOTAS_TOP5);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.mContancto:
                intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                intent = new Intent(this, AcercaDe.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorMF(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
