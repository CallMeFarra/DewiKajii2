package com.faradilla.dewikajii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.faradilla.dewikajii.CardViewItem;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;


public class HomepageAdmin extends AppCompatActivity {

    private ArrayList<CardViewItem> cardViewItemsList = new ArrayList<>();

    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri selectedImageUri;
    private ImageView imageView;
    private EditText judulEditText, keteranganEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage_admin);

        // Inisialisasi view dan variabel
        imageView = findViewById(R.id.uploadImage);
        judulEditText = findViewById(R.id.judulEditText);
        keteranganEditText = findViewById(R.id.keteranganEditText);

        // Menambahkan onClickListener ke imageView untuk memilih gambar
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
            }
        });

        // Menambahkan onClickListener ke tombol-tombol upload
        Button uploadAtraksiButton = findViewById(R.id.uploadAtraksi);
        Button uploadPaketWisataButton = findViewById(R.id.uploadPaketWisata);
        Button uploadIkanButton = findViewById(R.id.uploadIkan);
        Button uploadHomestayButton = findViewById(R.id.uploadHomestay);

        uploadAtraksiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData(R.id.uploadAtraksi);
            }
        });

        uploadPaketWisataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData(R.id.uploadPaketWisata);
            }
        });

        uploadIkanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData(R.id.uploadIkan);
            }
        });

        uploadHomestayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData(R.id.uploadHomestay);
            }
        });
    }

    // Metode untuk memilih gambar dari galeri
    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    // Metode untuk menangani hasil pemilihan gambar dari galeri
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedImageUri = data.getData();
            imageView.setImageURI(selectedImageUri);
        }
    }

    // Metode untuk menambahkan data dan mengirimkannya ke aktivitas yang sesuai
    private void sendData(int buttonId) {
        String judul = judulEditText.getText().toString();
        String keterangan = keteranganEditText.getText().toString();

        if (selectedImageUri != null) {
            Intent intent = null;

            if (buttonId == R.id.uploadAtraksi) {
                intent = new Intent(this, AtraksiActivity.class);
            } else if (buttonId == R.id.uploadPaketWisata) {
                intent = new Intent(this, PaketWisata.class);
            } else if (buttonId == R.id.uploadIkan) {
                intent = new Intent(this, KatalogIkanActivity.class);
            } else if (buttonId == R.id.uploadHomestay) {
                intent = new Intent(this, HomestayActivity.class);
            }

            if (intent != null) {
                // Menambahkan CardViewItem baru ke ArrayList
                cardViewItemsList.add(new CardViewItem(judul, keterangan, selectedImageUri.toString()));

                // Mengirim ArrayList ke aktivitas yang sesuai
                intent.putExtra("cardViewItemsList", cardViewItemsList);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "Pilih gambar dan isi teks terlebih dahulu", Toast.LENGTH_SHORT).show();
        }
    }

}

