package com.example.edutrack;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class PhotosActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        GridView grid = findViewById(R.id.photosGrid);
        // using built-in sample drawables added below
        int[] imgs = {R.drawable.sample1, R.drawable.sample2, R.drawable.sample3};
        grid.setAdapter(new ImageAdapter(this, imgs));
    }
}
