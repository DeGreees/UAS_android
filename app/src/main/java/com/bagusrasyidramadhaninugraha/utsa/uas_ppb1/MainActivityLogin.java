package com.bagusrasyidramadhaninugraha.utsa.uas_ppb1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
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
    EditText username,password;
    Button login, exit;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("UserInfo",
                Context.MODE_PRIVATE);
        username = findViewById(R.id.edusername);
        password = findViewById(R.id.edpassword);
        exit = findViewById(R.id.button2);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        login = findViewById(R.id.button1);
        login.setOnClickListener(v -> {
            String tex_username = Objects
                    .requireNonNull(username.getText()).toString();
            String tex_password = Objects
                    .requireNonNull(password.getText()).toString();
            if (TextUtils.isEmpty(tex_username) || TextUtils.isEmpty(tex_password)){
                Toast.makeText(MainActivityLogin.this,
                        "All Fields Required", Toast.LENGTH_SHORT).show();
            }
            else{
                login(tex_username,tex_password);
            }
        });
    }
    private void login(final String username, final String password){
        final ProgressDialog progressDialog = new ProgressDialog(
                MainActivityLogin.this);
        progressDialog.setTitle("Login your account");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setIndeterminate(false);
        progressDialog.show();
        String uRl = "http://192.168.201.161/sql/login.php";
        StringRequest request = new StringRequest(Request.Method.POST,
                uRl,
                (String response) -> {
                    if (response.equals("Login Success")){
                        Toast.makeText(MainActivityLogin.this,
                                response, Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.apply();
                        startActivity(new Intent(MainActivityLogin
                                .this,Home.class));
                        progressDialog.dismiss();
                        finish();
                    }
                    else {
                        Toast.makeText(MainActivityLogin.this,
                                response, Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }, error -> {
            Toast.makeText(MainActivityLogin.this,
                    error.toString(), Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        }){
            @Override
            protected Map<String, String> getParams() {
                HashMap<String,String> param = new HashMap<>();
                param.put("username",username);
                param.put("password",password);
                return param;
            }
        };
        request.setRetryPolicy(
                new DefaultRetryPolicy(30000,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        MySingleton.getmInstance(MainActivityLogin.this).
                addToRequestQueue(request);
    }
}