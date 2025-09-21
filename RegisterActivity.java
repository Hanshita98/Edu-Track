package com.example.edutrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password;
    Button registerBtn;
    DBHelper DB;
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        registerBtn = findViewById(R.id.registerBtn);
        DB = new DBHelper(this);
        registerBtn.setOnClickListener(v -> {
            String u = username.getText().toString().trim();
            String p = password.getText().toString().trim();
            if(u.isEmpty() || p.isEmpty()){ Toast.makeText(this, "Enter details", Toast.LENGTH_SHORT).show(); return; }
            if(DB.checkUser(u)){ Toast.makeText(this, "User exists", Toast.LENGTH_SHORT).show(); return; }
            boolean ok = DB.insertUser(u,p);
            Toast.makeText(this, ok ? "Registered" : "Registration failed", Toast.LENGTH_SHORT).show();
            if(ok) finish();
        });
    }
}
