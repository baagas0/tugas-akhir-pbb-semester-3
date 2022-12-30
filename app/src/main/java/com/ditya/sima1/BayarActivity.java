package com.ditya.sima1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
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

public class BayarActivity extends AppCompatActivity {

    private final String TAG = "activity_bayar";

    private EditText jmlBayar;
    private TextView textNominalTotalTagihan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);
        jmlBayar = (EditText) findViewById(R.id.jmlBayar);
        textNominalTotalTagihan = (TextView) findViewById(R.id.textNominalTotalTagihan);

        /** Check Login **/
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        Log.d("cek token", sh.getString("token", ""));
        if(sh.getString("token", "").toString().equals("")) {
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
        }


        jmlBayar.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                // you can call or do what you want with your EditText here

                // yourEditText...
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, s.toString());
                textNominalTotalTagihan.setText("Rp. "+s);
            }
        });
    }

}