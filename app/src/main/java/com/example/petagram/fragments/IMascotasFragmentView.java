package com.example.petagram.fragments;

import com.example.petagram.adapter.MascotaAdaptador;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IMascotasFragmentView {

    public  void  generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorMF(MascotaAdaptador adaptador);

}
