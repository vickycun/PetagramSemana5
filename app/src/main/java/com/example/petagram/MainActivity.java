package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.petagram.adapter.PageAdapter;
import com.example.petagram.fragments.MascotasFragment;
import com.example.petagram.fragments.PerfilFragment;
import com.example.petagram.menuopc.AcercaDe;
import com.example.petagram.menuopc.Contacto;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private static final int MNU_FAVORITOS=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        toolbar   = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new MascotasFragment());
        fragments.add(new PerfilFragment());

        return  fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.ic_home);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.ic_perrito);
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        menu.add(Menu.NONE, MNU_FAVORITOS, Menu.NONE, R.string.menu_favoritos)
                .setIcon(R.drawable.estrella).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case MNU_FAVORITOS:
                intent = new Intent(this, MascotasFavoritas.class);
                startActivity(intent);
                break;

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
}