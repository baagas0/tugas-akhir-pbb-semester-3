package com.ditya.sima1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ditya.sima1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    LinearLayout layout_absensi;
    LinearLayout layout_bayar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /** Check Login **/
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        Log.d("cek token", sh.getString("token", ""));
        if(sh.getString("token", "").toString().equals("")) {
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
        }

        layout_absensi = findViewById(R.id.layout_absensi);
        layout_bayar = findViewById(R.id.layout_bayar);

        // Start With absent history activity
//        Intent i = new Intent(getApplicationContext(), absentHistory.class);
//        startActivity(i);

        // Start with login activity
//        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
//        startActivity(i);

        layout_absensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ActivityAbsentHistory.class);
                startActivity(i);
            }
        });

        layout_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), BayarActivity.class);
                startActivity(i);
            }
        });
    }

}