package com.faradilla.dewikajii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;
    private EditText editTextUsn;
    private EditText editTextPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        dbHelper = new DatabaseHelper(this);

        // Ambil data username dan peran dari Intent
        Intent intent = getIntent();
        if (intent != null) {
            String username = intent.getStringExtra("USERNAME");
            String sebagai = intent.getStringExtra("SEBAGAI");

            // Update TextView dengan data yang diterima
            TextView textViewUsn = findViewById(R.id.textViewUsn);
            TextView textViewAs = findViewById(R.id.textViewAs);

            textViewUsn.setText("Username : " + username);
            textViewAs.setText("Sebagai : " + sebagai);
        }


        Button buttonLogout = findViewById(R.id.buttonLogout);
        Button buttonLog = findViewById(R.id.buttonLogin);

        buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void login() {
        // Ambil data dari EditText
        String username = editTextUsn.getText().toString().trim();
        String password = editTextPw.getText().toString().trim();

        // Periksa apakah input tidak kosong
        if (username.isEmpty() || password.isEmpty()) {
            // Tampilkan pesan kesalahan jika ada input yang kosong
            Toast.makeText(this, "Isi semua data", Toast.LENGTH_SHORT).show();
            return;
        }

        // Redirect ke halaman HomepageAdmin dengan mengirimkan data username
        Intent intentAdmin = new Intent(ProfilActivity.this, HomepageAdmin.class);
        intentAdmin.putExtra("USERNAME", username);
        startActivity(intentAdmin);
        finish();
    }


    private void logout() {
        // Hapus semua data pengguna dari database
        dbHelper.deleteAllUsers();

        // Redirect ke halaman login (YourAccount)
        Intent intent = new Intent(ProfilActivity.this, YourAccount.class);
        startActivity(intent);
        finish();
    }
}
