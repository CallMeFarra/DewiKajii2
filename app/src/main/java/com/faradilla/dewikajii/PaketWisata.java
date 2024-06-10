package com.faradilla.dewikajii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

public class PaketWisata extends AppCompatActivity {
    private TextView judul1;
    private TextView deskripsi2;
    private ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paket_wisata);
        judul1 = findViewById(R.id.judul);
        deskripsi2 = findViewById(R.id.deskripsi);
        imageView3 = findViewById(R.id.gambar);

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
            String judul = getIntent().getStringExtra("judul");
            String keterangan = getIntent().getStringExtra("keterangan");
            String imageUri = getIntent().getStringExtra("selectedImage");
            Uri urimage = Uri.parse(imageUri);

            judul1.setText(judul);
            deskripsi2.setText(keterangan);
            imageView3.setImageURI(urimage);

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