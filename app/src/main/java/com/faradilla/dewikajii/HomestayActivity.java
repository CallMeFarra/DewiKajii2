package com.faradilla.dewikajii;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HomestayActivity extends AppCompatActivity {
    private TextView judul1;
    private TextView deskripsi2;
    private ImageView imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homestay);
        judul1 = findViewById(R.id.judul);
        deskripsi2 = findViewById(R.id.deskripsi);
        imageView3 = findViewById(R.id.gambar);
        String judul = getIntent().getStringExtra("judul");
        String keterangan = getIntent().getStringExtra("keterangan");
        String imageUri = getIntent().getStringExtra("selectedImage");
        Uri urimage = Uri.parse(imageUri);

        judul1.setText(judul);
        deskripsi2.setText(keterangan);
        imageView3.setImageURI(urimage);
    }
}