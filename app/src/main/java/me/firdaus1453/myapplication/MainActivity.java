package me.firdaus1453.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Membuat variable
    private Button btnCount,btnCount2;
    private TextView txtAngka,txtAngka2;
    private int angka,angka2;

    private static final String STATE_RESULT = "state_result";
    private static final String STATE_RESULT2 = "state_result2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menginisiasikan view ke dalam object java
        btnCount = findViewById(R.id.btn_count);
        btnCount2 = findViewById(R.id.btn_count2);
        txtAngka = findViewById(R.id.txt_angka);
        txtAngka2 = findViewById(R.id.txt_angka2);

        // Membuat method untuk klik pada button
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Menambah +1 nilai di dalam variable angka
                angka++;
                // Menampilkan isi variable angka ke TextView
                // Karena textview harus bertipe data String maka variable angka kita convert menjadi String
                txtAngka.setText(String.valueOf(angka));
            }
        });

        btnCount2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angka2++;
                txtAngka2.setText(String.valueOf(angka2));
            }
        });


        if(savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            String result2 = savedInstanceState.getString(STATE_RESULT2);
            angka = Integer.valueOf(result);
            angka2 = Integer.valueOf(result2);
            txtAngka.setText(result);
            txtAngka2.setText(result2);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_RESULT,txtAngka.getText().toString());
        outState.putString(STATE_RESULT2,txtAngka2.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
