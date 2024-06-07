package com.faradilla.dewikajii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class YourAccount extends AppCompatActivity {
    private EditText editTextUsername, editTextPassword;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_account);

        Toolbar toolbar = findViewById(R.id.toolbarAcc);
        setSupportActionBar(toolbar);

        //nyembunyiin nama project
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //nambahin text di toolbar nya
        TextView textView = new TextView(this);
        textView.setText("Your Account");

        //nambahin warna di text nya
        textView.setTextColor(getResources().getColor(android.R.color.white));
        textView.setTextSize(20);

        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(
                Toolbar.LayoutParams.WRAP_CONTENT,
                Toolbar.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity = Gravity.LEFT;
        textView.setLayoutParams(layoutParams);
        toolbar.addView(textView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /////////////////////////////////////////////////////////////////////////////////

        databaseHelper = new DatabaseHelper(this);

        editTextUsername = findViewById(R.id.textUsn);
        editTextPassword = findViewById(R.id.textPw);

        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        // Ambil nilai username dan password dari EditText
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();

        // Verifikasi login
        if(databaseHelper.checkLogin(username,password)){
            // Login berhasil

            String sebagai; // Variabel untuk menyimpan nilai "sebagai"

            // Periksa apakah pengguna adalah admin
            if(databaseHelper.isAdmin(username,password)){
                sebagai = "admin";
            } else {
                sebagai = "user";
            }

            databaseHelper.addUser(username, password);

            Intent intent = new Intent(YourAccount.this, ProfilActivity.class);
            intent.putExtra("USERNAME", username);
            intent.putExtra("SEBAGAI", sebagai);
            startActivity(intent);
        }
    }



    //backhome
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()== android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}