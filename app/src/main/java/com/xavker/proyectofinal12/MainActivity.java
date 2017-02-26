package com.xavker.proyectofinal12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

public class MainActivity extends AppCompatActivity {
    TextView txtUser;
    ProfilePictureView imagenUsuario;
    Button btnCerrarSecion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser=(TextView)findViewById(R.id.tvusuario);
        imagenUsuario=(ProfilePictureView)findViewById(R.id.imgProfile);
        btnCerrarSecion=(Button)findViewById(R.id.btncerrarsecio);

        btnCerrarSecion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                IraPatallaLogin();
            }
        });

        if(AccessToken.getCurrentAccessToken()==null){
            IraPatallaLogin();
        }else{
            Profile profile=Profile.getCurrentProfile();
            txtUser.setText(""+profile.getName());
            imagenUsuario.setProfileId(profile.getId());
        }

    }

    private void IraPatallaLogin() {
        Intent intent=new Intent(MainActivity.this,LoginManager.class);
        finish();
        startActivity(intent);
    }
}
