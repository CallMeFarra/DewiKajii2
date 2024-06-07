package com.faradilla.dewikajii;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        //nyembunyiin nama project
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //nambahin text di toolbar nya
        TextView textView = new TextView(this);
        textView.setText("Desa Wisata Kajii");

        //nambahin warna di text nya
        textView.setTextColor(getResources().getColor(android.R.color.black));
        textView.setTextSize(20);

        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(
                Toolbar.LayoutParams.WRAP_CONTENT,
                Toolbar.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity = Gravity.LEFT;
        textView.setLayoutParams(layoutParams);
        toolbar.addView(textView);



        Log.d("LOG_TAG","OnCreate");
        TabLayout tabLayout=findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Categories"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        ViewPager viewPager=findViewById(R.id.pager);
        com.faradilla.dewikajii.PagerAdapter adapter = new com.faradilla.dewikajii.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.menu1) {
            Intent intent = new Intent(MainActivity.this,YourAccount.class);
            startActivity(intent);

        }else if(id==R.id.menu2) {

        }
        return true;
    }
}