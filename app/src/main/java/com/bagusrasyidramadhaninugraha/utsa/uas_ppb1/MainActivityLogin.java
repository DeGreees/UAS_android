package com.bagusrasyidramadhaninugraha.utsa.uas_ppb1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

public class MainActivityLogin extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String name = "nameKey";
    public static final String pass = "passwordKey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login); final EditText txtUserName = (EditText) findViewById(R.id.editText1);
        final EditText txtPassword = (EditText) findViewById(R.id.editText2);
        Button btnLogin = (Button) findViewById(R.id.button1);
        Button btnRegister = (Button) findViewById(R.id.button2);
        Button btnKeluar = (Button) findViewById(R.id.button3);
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(MainActivityLogin.this, MainActivity.class);
                startActivity(i);

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                String username = txtUserName.getText().toString();
                String password = txtPassword.getText().toString();
                try {
                    adapteruser dbaUser = new adapteruser(MainActivityLogin.this);
                    dbaUser.open();
                    if (dbaUser.Register(username, password)) {
                        Toast.makeText(MainActivityLogin.this
                                , "Create Data", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivityLogin.this
                                , "Tambah Username/Password"
                                , Toast.LENGTH_LONG).show();
                    }
                    dbaUser.close();
                } catch (Exception e) {
// TODO: handle exception
                    Toast.makeText(MainActivityLogin.this, e.getMessage()
                            , Toast.LENGTH_LONG).show();
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUserName.getText().toString();
                String password = txtPassword.getText().toString();
                try {
                    if (username.length() > 0 && password.length() > 0) {
                        adapteruser dbUser = new adapteruser(MainActivityLogin.this);
                        dbUser.open();
                        if (dbUser.Login(username, password)) {
                            Toast.makeText(MainActivityLogin.this
                                    , "Successfully Logged In"
                                    , Toast.LENGTH_LONG).show();
                            Intent kela = new Intent(MainActivityLogin.this
                                    , Home.class);
                            startActivity(kela);
                        } else {
                            Toast.makeText(MainActivityLogin.this
                                    , "Invalid Username/Password"
                                    , Toast.LENGTH_LONG).show();
                        }
                        dbUser.close();
                    }
                } catch (Exception e) {
                    Toast.makeText(MainActivityLogin.this, e.getMessage()
                            , Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    protected void onResume() {
        sharedpreferences=getSharedPreferences(MyPREFERENCES,
                Context.MODE_PRIVATE);
        if (sharedpreferences.contains(name))
        {
            if(sharedpreferences.contains(pass)){
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
        }
        super.onResume();
    }

}
