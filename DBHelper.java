package com.example.edutrack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "EduTrack.db";
    public DBHelper(Context context) { super(context, DBNAME, null, 1); }
    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(username TEXT PRIMARY KEY, password TEXT)");
        db.execSQL("CREATE TABLE attendance(id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT, status TEXT)");
        db.execSQL("CREATE TABLE events(id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, date TEXT, description TEXT)");
        // insert demo user and demo data
        db.execSQL("INSERT OR IGNORE INTO users(username,password) VALUES('admin','1234')");
        db.execSQL("INSERT INTO attendance(date,status) VALUES('2025-09-01','Present')");
        db.execSQL("INSERT INTO attendance(date,status) VALUES('2025-09-02','Absent')");
        db.execSQL("INSERT INTO events(title,date,description) VALUES('Freshers Party','2025-09-15','College freshers party')");
        db.execSQL("INSERT INTO events(title,date,description) VALUES('Hackathon','2025-09-20','Inter-college hackathon')");
    }
    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS attendance");
        db.execSQL("DROP TABLE IF EXISTS events");
        onCreate(db);
    }
    public boolean insertUser(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("username", username); cv.put("password", password);
        long r = db.insert("users", null, cv);
        return r != -1;
    }
    public boolean checkUser(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM users WHERE username=?", new String[]{username});
        boolean exists = c.getCount() > 0; c.close(); return exists;
    }
    public boolean checkUserPass(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM users WHERE username=? AND password=?", new String[]{username, password});
        boolean ok = c.getCount() > 0; c.close(); return ok;
    }
}
