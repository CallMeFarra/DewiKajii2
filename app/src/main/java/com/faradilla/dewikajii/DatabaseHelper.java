package com.faradilla.dewikajii;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "password123";

    public DatabaseHelper(Context context) {
        super(context, "user_db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Buat tabel pengguna jika belum ada
        String createUserTableQuery = "CREATE TABLE IF NOT EXISTS users (" +
                "username TEXT PRIMARY KEY, " + // Kolom username sebagai primary key
                "password TEXT)";
        db.execSQL(createUserTableQuery);

        // Tambahkan akun admin jika belum ada
        addUser(ADMIN_USERNAME, ADMIN_PASSWORD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public boolean isAdmin(String username, String password) {
        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    public boolean checkLogin(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        Cursor cursor = db.rawQuery(query, new String[]{username, password});
        int count = cursor.getCount();
        cursor.close();
        return count > 0;
    }

    public void addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        db.insert("users", null, values);
        db.close();
    }


    public boolean deleteUser(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        int deleteRows = db.delete("users", "username = ?", new String[]{username});
        db.close();
        return deleteRows > 0;
    }

    public void deleteAllUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM users");
        db.close();
    }

}

