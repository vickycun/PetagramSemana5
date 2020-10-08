package com.example.petagram.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.pojo.Mascota;
import com.example.petagram.R;
import com.example.petagram.adapter.MascotaAdaptador;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        listaMascotas.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Rambo",1,R.drawable.bulldog1));
        mascotas.add(new Mascota("Rambo",2,R.drawable.bulldog2));
        mascotas.add(new Mascota("Rambo",4,R.drawable.bulldog3));
        mascotas.add(new Mascota("Rambo",6,R.drawable.bulldog4));
        mascotas.add(new Mascota("Rambo",3,R.drawable.bulldog5));
        mascotas.add(new Mascota("Rambo",4,R.drawable.bulldog6));
        mascotas.add(new Mascota("Rambo",2,R.drawable.bulldog7));
        mascotas.add(new Mascota("Rambo",1,R.drawable.bulldog8));
    }

}
