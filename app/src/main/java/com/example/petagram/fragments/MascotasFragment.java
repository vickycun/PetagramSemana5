package com.example.petagram.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.petagram.db.ConstantesBaseDatos;
import com.example.petagram.pojo.Mascota;
import com.example.petagram.R;
import com.example.petagram.adapter.MascotaAdaptador;
import com.example.petagram.presentador.IMascotasFragmentPresenter;
import com.example.petagram.presentador.MascotasFragmentPresenter;

import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;

public class MascotasFragment extends Fragment implements IMascotasFragmentView{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IMascotasFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter= new MascotasFragmentPresenter(this,getContext(), ConstantesBaseDatos.MASCOTAS_ALL);

        return v;

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorMF(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

}
