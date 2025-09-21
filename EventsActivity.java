package com.example.edutrack;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {
    ListView listView; DBHelper DB;
    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        listView = findViewById(R.id.eventsList);
        DB = new DBHelper(this);
        ArrayList<String> items = new ArrayList<>();
        Cursor c = DB.getReadableDatabase().rawQuery("SELECT title,date FROM events ORDER BY id DESC", null);
        while(c.moveToNext()){
            items.add(c.getString(0) + " (" + c.getString(1) + ")");
        }
        c.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
    }
}
