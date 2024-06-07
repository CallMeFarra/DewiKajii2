package com.faradilla.dewikajii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AtraksiActivity extends AppCompatActivity {

    private ArrayList<CardViewItem> receivedCardViewItemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atraksi);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //nyembunyiin nama project
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //nambahin text di toolbar nya
        TextView textView = new TextView(this);
        textView.setText("Atraksi Dewi Kajii");

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

        if (getIntent().hasExtra("cardViewItemsList")) {
            receivedCardViewItemsList = getIntent().getParcelableArrayListExtra("cardViewItemsList");
        }
    }

    //back ke home
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()== android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
