package com.example.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.example.petagram.R;
import com.example.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ConstructoMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructoMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerMascotas(String filtro){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        switch (filtro)
        {
            case ConstantesBaseDatos.MASCOTAS_TOP5: mascotas = db.obtenerTop5Mascotas();
                break;
            case ConstantesBaseDatos.MASCOTAS_ALL: mascotas = db.obtenerTodasLasMascotas();
                break;
        }
        return mascotas;
    }

    public void insertarMascotas(BaseDatos db){

        if(!(db.existeTablaMascotas())){
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rambo");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN, R.drawable.mascota1);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Firulais");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.mascota2);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Dobby");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.mascota3);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rufus");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.mascota4);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Fatiga");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.mascota5);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Ronny");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.mascota6);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Rocco");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.mascota7);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Luchi");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.mascota8);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Dory");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.mascota9);
            db.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Patán");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_IMAGEN,  R.drawable.mascota10);
            db.insertarMascota(contentValues);

        }
    }

    public void darRaiting(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_RATING_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_RATING_MASCOTA_RATING, LIKE);
        db.insertarRatingMascota(contentValues);
    }

    public int obtenerRatingMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRatingMascota(mascota);
    }

}
