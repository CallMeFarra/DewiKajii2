package com.faradilla.dewikajii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

public class PaketWisata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paket_wisata);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = new TextView(this);
        textView.setText("Paket Wisata Dewi Kajii");

        textView.setTextColor(getResources().getColor(android.R.color.white));
        textView.setTextSize(20);

        androidx.appcompat.widget.Toolbar.LayoutParams layoutParams = new androidx.appcompat.widget.Toolbar.LayoutParams(
                androidx.appcompat.widget.Toolbar.LayoutParams.WRAP_CONTENT,
                androidx.appcompat.widget.Toolbar.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity = Gravity.LEFT;
        textView.setLayoutParams(layoutParams);
        toolbar.addView(textView);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        CardViewItem cardViewItem = getIntent().getParcelableExtra("cardViewItem");

        if(cardViewItem!=null){
            String judul =cardViewItem.getJudul();
            String keterangan = cardViewItem.getKeterangan();
            String imageUri = cardViewItem.getImageUri();

            // Menampilkan data di antarmuka pengguna
            TextView judulTextView = findViewById(R.id.judulEditText);
            TextView keteranganTextView = findViewById(R.id.keteranganEditText);
            ImageView imageView = findViewById(R.id.uploadImage);

            judulTextView.setText(judul);
            keteranganTextView.setText(keterangan);
            // Set gambar menggunakan imageUri
            Glide.with(this).load(imageUri).into(imageView);

        } else {
            Toast.makeText(this, "Terjadi kesalahan, silakan ulangi.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()== android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}