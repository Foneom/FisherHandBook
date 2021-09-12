package com.example.fisherhandbook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;

public class TextContentActivity extends AppCompatActivity {
    private TextView text_content;
    private int category = 0;
    private int position = 0;
    private int[] array_fish = {R.string.fish_1, R.string.fish_2, R.string.fish_3, R.string.fish_4,
            R.string.fish_5, R.string.fish_6};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        text_content = findViewById(R.id.text_main_content);
        reciveIntent();
    }

    private void reciveIntent() {
        Intent i = getIntent();
        if (i != null) {
            category = i.getIntExtra("category", 0);
            position = i.getIntExtra("position", 0);
        }
        switch (category) {
            case 0:
                text_content.setText(array_fish[position]);
                break;
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
        }
    }
}

