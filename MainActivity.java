package com.example.edutrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button att = findViewById(R.id.btnAttendance);
        Button ev = findViewById(R.id.btnEvents);
        Button ph = findViewById(R.id.btnPhotos);
        Button cert = findViewById(R.id.btnCertificates);
        att.setOnClickListener(v -> startActivity(new Intent(this, AttendanceActivity.class)));
        ev.setOnClickListener(v -> startActivity(new Intent(this, EventsActivity.class)));
        ph.setOnClickListener(v -> startActivity(new Intent(this, PhotosActivity.class)));
        cert.setOnClickListener(v -> startActivity(new Intent(this, CertificatesActivity.class)));
    }
}
