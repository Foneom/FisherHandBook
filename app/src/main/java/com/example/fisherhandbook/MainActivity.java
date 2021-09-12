package com.example.fisherhandbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    private ListView list;
    private String[] arr;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;
    private int category_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onList(int num) {
        list = findViewById(R.id.listView);
        arr = getResources().getStringArray(num);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(arr)));
        list.setAdapter(adapter);
        adapter.clear();
        adapter.addAll(arr);
        adapter.notifyDataSetChanged();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Intent intent = new Intent(MainActivity.this, TextContentActivity.class);
            intent.putExtra("category", category_index);
            intent.putExtra("position", position);
            startActivity(intent);
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_fish) {
           toolbar.setTitle(R.string.fish);
           onList(R.array.fish_array);
           category_index = 0;
        } else if (id == R.id.nav_nazhivka) {
            toolbar.setTitle(R.string.nazhivka);
            onList(R.array.naghivka);
            category_index = 1;
        } else if (id == R.id.nav_snasti) {
            toolbar.setTitle(R.string.snasti);
            onList(R.array.snasti);
            category_index = 2;
        } else if (id == R.id.nav_prikormka) {
            toolbar.setTitle(R.string.prikormka);
            onList(R.array.prikormka);
            category_index = 3;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}