package com.example.edutrack;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class CertificatesActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certificates);
        GridView grid = findViewById(R.id.certGrid);
        int[] imgs = {R.drawable.cert1, R.drawable.cert2};
        grid.setAdapter(new ImageAdapter(this, imgs));
    }
}
