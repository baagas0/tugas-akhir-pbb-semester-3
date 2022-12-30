package com.ditya.sima1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    RecyclerView recyclerView_absent;
    private final String TAG = "login_activity";
    EditText email, password;
    Button btnLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /** Check Login **/
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        Log.d("cek token", sh.getString("token", ""));
        if(!sh.getString("token", "").toString().equals("")) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        }

        email = findViewById(R.id.editTextTextEmail);
        password = findViewById(R.id.editTextTextPassword);

        btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                doLogin(email.getText().toString(), password.getText().toString());
            }
        });

    }

    private void doLogin(String email, String password) {

        Credentials loginCredentials = new Credentials();
        loginCredentials.email = email;
        loginCredentials.password = password;

        Call<List<ModelLogin>> call = RetrofitClient.getInstance().getMyApi().postLogin(loginCredentials);

        call.enqueue(new Callback<List<ModelLogin>>() {
            @Override
            public void onResponse(Call<List<ModelLogin>> call, Response<List<ModelLogin>> response) {
                Toast.makeText(getApplicationContext(), "Success Fetch", Toast.LENGTH_LONG).show();

                List<ModelLogin> object = response.body();

                Log.d("token", object.get(0).getToken());

                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();

                // write all the data entered by the user in SharedPreference and apply
                myEdit.putString("token", object.get(0).getToken());
                myEdit.apply();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<List<ModelLogin>> call, Throwable t) {
                Log.e(TAG, "gagal fetch" );
                Log.e(TAG, t.toString() );
                Log.e(TAG, t.getMessage() );
                Toast.makeText(getApplicationContext(), "Failed Fetch", Toast.LENGTH_LONG).show();
            }

        });
    }


}