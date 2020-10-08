package com.example.petagram.presentador;

import android.content.Context;

import com.example.petagram.db.ConstructoMascotas;
import com.example.petagram.fragments.IMascotasFragmentView;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFragmentPresenter implements IMascotasFragmentPresenter {

    private IMascotasFragmentView iMascotasFragmentView;
    private Context context;
    private ConstructoMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    private String filtro;

    public MascotasFragmentPresenter(IMascotasFragmentView iMascotasFragmentView, Context context, String filtro){
        this.iMascotasFragmentView = iMascotasFragmentView;
        this.context = context;
        this.filtro = filtro;
        obtenerMascotasBaseDatos(filtro);
    }

    @Override
    public void obtenerMascotasBaseDatos(String filtro) {
        constructorMascotas = new ConstructoMascotas(context);
        mascotas = constructorMascotas.obtenerMascotas(filtro);
        mostrarMascotasMF();
    }

    @Override
    public void mostrarMascotasMF() {
        iMascotasFragmentView.inicializarAdaptadorMF(iMascotasFragmentView.crearAdaptador(mascotas));
        iMascotasFragmentView.generarLinearLayoutVertical();
    }
}
