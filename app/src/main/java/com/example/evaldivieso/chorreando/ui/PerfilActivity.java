package com.example.evaldivieso.chorreando.ui;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.evaldivieso.chorreando.AppChorreando;
import com.example.evaldivieso.chorreando.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PerfilActivity extends AppCompatActivity {
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.app_bar)
    Toolbar toolbar;
    @Bind(R.id.navigation)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.title_activity_perfil);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.mipmap.ic_menu);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fm_perfil_content, PerfilFragment.newInstance());
        ft.commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft;
                switch (menuItem.getItemId()) {
                    case R.id.drawer_perfil:
                        ft = fm.beginTransaction();
                        ft.replace(R.id.fm_perfil_content, PerfilFragment.newInstance());
                        ft.commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.drawer_que_haciendo:
                        ft = fm.beginTransaction();
                        ft.replace(R.id.fm_perfil_content, QueHaciendoFragment.newInstance());
                        ft.commit();
                        drawerLayout.closeDrawers();
                        return true;
                    case R.id.drawer_amigos:
                        ft = fm.beginTransaction();
                        ft.replace(R.id.fm_perfil_content, AmigosFragment.newInstance());
                        ft.commit();
                        drawerLayout.closeDrawers();
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_perfil, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
