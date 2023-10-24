package com.example.reporthing;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.reporthing.Auth.AuthActivity;
import com.example.reporthing.Students.Models.ModelShowProfile;

import java.util.ArrayList;
import java.util.Arrays;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "db_master.db";
    public static final String TABLE_STUDENT = "student";
    public static final Integer VERSIONS = 1;
    public static final String COLUMN_ID = "id";
//    public static final String COLUMN_DATA = "id";
    public DatabaseHelper(@Nullable Context context) {
        super(context,DB_NAME,null,VERSIONS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table student(id TEXT primary key,password TEXT," +
                "username TEXT,nama TEXT)");
        db.execSQL("Create table teacher(id TEXT primary key,password TEXT," +
                "username TEXT,nama TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists student");
        db.execSQL("drop table if exists teacher");
    }
    public Boolean insertData(String ids,String pass,String username, String name) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",ids);
        contentValues.put("password",pass);
        contentValues.put("username",username);
        contentValues.put("nama",name);
        long result = sqLiteDatabase.insert("student",null,contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public String checkUsername(String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursorStudent = sqLiteDatabase.rawQuery("select * from student where username = ? and password = ? ",new String[]{username,password});
        Cursor cursorTeacher = sqLiteDatabase.rawQuery("select * from teacher where username = ? and password = ? ",new String[]{username,password});
        if (cursorStudent.getCount() > 0) {
            return "student";
        } else if(cursorTeacher.getCount() > 0) {
            return "teacher";
        } else {
            return "salah";
        }
    }
//    public String showProfileStudent(String username, String password) {
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * from student where username = ? And password = ?", new String[]{username,password});
//        String output = null;
//        if (cursor.moveToFirst()) {
//            String id = cursor.getString(0);
//            String dataPassword = cursor.getString(1);
//            String dataUsername = cursor.getString(2);
//            String nama = cursor.getString(3);
//            output = id ;
//        }
//        cursor.close();
//        return "ID nya " + output;
//    }
}
