package com.example.edutrack;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class AttendanceActivity extends AppCompatActivity {
    ListView listView;
    DBHelper DB;
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        listView = findViewById(R.id.attList);
        DB = new DBHelper(this);
        ArrayList<String> items = new ArrayList<>();
        Cursor c = DB.getReadableDatabase().rawQuery("SELECT date,status FROM attendance ORDER BY id DESC", null);
        while(c.moveToNext()){
            items.add(c.getString(0) + " - " + c.getString(1));
        }
        c.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }
}
