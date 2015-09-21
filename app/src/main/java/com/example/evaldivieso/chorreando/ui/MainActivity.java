package com.example.evaldivieso.chorreando.ui;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.evaldivieso.chorreando.AppChorreando;
import com.example.evaldivieso.chorreando.R;
import com.example.evaldivieso.chorreando.ui.mvp.presenter.LoginPresenter;
import com.example.evaldivieso.chorreando.ui.mvp.view.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView {
    @Bind(R.id.butLogin)
    Button butLogin;
    @Bind(R.id.butLoginFacebook)
    Button butLoginFacebook;
    @Bind(R.id.butRegistrar)
    Button butRegistrar;
    @Bind(R.id.eteUsername)
    EditText eteUsername;
    @Bind(R.id.etePassword)
    EditText etePassword;
    @Bind(R.id.app_bar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);




        butLogin.setOnClickListener(this);
        butLoginFacebook.setOnClickListener(this);
        butRegistrar.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.butLogin) {
            String username = eteUsername.getText().toString();
            String password = etePassword.getText().toString();

            new LoginPresenter(this).login(username, password);

            //onLoginCorrecto();

        }else if (view.getId() == R.id.butLoginFacebook){
            Log.i("MainActivity", "Se hizo click en el boton LoginFacebook");
            Toast.makeText(
                    this,
                    "Opcion de LoginFacebook... proximamente",
                    Toast.LENGTH_LONG
            ).show();
        }else{
            Log.i("MainActivity", "Se hizo click en el boton Registrarse");
            Toast.makeText(
                    this,
                    "Opcion de Registrarse... proximamente",
                    Toast.LENGTH_LONG
            ).show();
        }
    }

    @Override
    public void onLoginCorrecto() {
        // Ir a un nuevo activity Perfil
        Intent intent = new Intent();
        intent.setClass(MainActivity.this,
                PerfilActivity.class);
        //intent.putExtra("username", eteUsername.getText().toString());
        ((AppChorreando) getApplication()).username = eteUsername.getText().toString();
        startActivity(intent);
    }

    @Override
    public void onLoginIncorrecto() {
        // Mostrar un toast de error
        Toast.makeText(
                this,
                "Error en login",
                Toast.LENGTH_SHORT
        ).show();
        // Limpiar los edittext
        eteUsername.setText("");
        etePassword.setText("");
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(
                this,
                "EXC: " + msg,
                Toast.LENGTH_LONG
        ).show();
    }
}