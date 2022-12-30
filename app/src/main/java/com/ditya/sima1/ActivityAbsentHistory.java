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

public class ActivityAbsentHistory extends AppCompatActivity {

    RecyclerView recyclerView_absent;
    private final String TAG = "absent_history";

    ImageView buttonBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absent_history);

        /** Check Login **/
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        Log.d("cek token", sh.getString("token", ""));
        if(sh.getString("token", "").toString().equals("")) {
            Intent i = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(i);
        }

        buttonBack = findViewById(R.id.buttonBack);
        recyclerView_absent = findViewById(R.id.recyclerView_absent);

        getData(null);

        recyclerView_absent.setLayoutManager(new LinearLayoutManager(this));

        CalendarView calendarView = findViewById(R.id.calendar);
        calendarView.setOnDateChangeListener((view, year, month, day) -> {
            String date = day + "-" + (month+1) + "-" + year;
            Log.d(TAG, date);
            getData(date);
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    private void getData(String date) {
        Log.d(TAG, "getData: "+date);

        Map<String, String> params = new HashMap<String, String>();
        if(date != null) {
            params.put("date", date);
        }

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        Call<List<ModelAbsentHistory>> call = RetrofitClient.getInstance().getMyApi().getAbsenceCheck("Bearer "+sh.getString("token", ""),params);

        call.enqueue(new Callback<List<ModelAbsentHistory>>() {
            @Override
            public void onResponse(Call<List<ModelAbsentHistory>> call, Response<List<ModelAbsentHistory>> response) {
                Toast.makeText(getApplicationContext(), "Success Fetch", Toast.LENGTH_LONG).show();

                ArrayList<ModelAbsentHistory> modelAbsentHistoryArrayList= (ArrayList<ModelAbsentHistory>) response.body();
                AdapterAbsentHistory adapterAbsent=new AdapterAbsentHistory(modelAbsentHistoryArrayList);
                recyclerView_absent.setAdapter(adapterAbsent);
            }

            @Override
            public void onFailure(Call<List<ModelAbsentHistory>> call, Throwable t) {
                Log.e(TAG, "gagal fetch" );
                Log.e(TAG, t.toString() );
                Log.e(TAG, t.getMessage() );
                Toast.makeText(getApplicationContext(), "Failed Fetch", Toast.LENGTH_LONG).show();
            }
        });
    }

}