package com.example.studentdbhandling.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.studentdbhandling.model.Student;
import com.example.studentdbhandling.params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper{
    public MyDbHandler(Context context)
    {
        super(context, Params.DATABASE_NAME,null,Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE  IF NOT EXISTS " + Params.S_TABLE_NAME + "("
                + Params.S_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Params.S_COLUMN_ROLLNO + " TEXT,"
                + Params.S_COLUMN_NAME + " TEXT,"
                + Params.S_COLUMN_SABAQ + " TEXT,"
                + Params.S_COLUMN_MANZIL + " TEXT,"
                + Params.S_COLUMN_SABQI + " TEXT"
                + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public  void insertStudent(Student std)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.S_COLUMN_ROLLNO,std.getRollNo());
        values.put(Params.S_COLUMN_NAME,std.getName());
        values.put(Params.S_COLUMN_SABAQ,std.getSabaq());
        values.put(Params.S_COLUMN_MANZIL,std.getManzil());
        values.put(Params.S_COLUMN_SABQI,std.getSabqi());

        db.insert(Params.S_TABLE_NAME,null,values);
        db.close();
    }
    public Student getStudent(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String query= "SELECT * FROM "+ Params.S_TABLE_NAME + " WHERE " + Params.S_COLUMN_ID + " = " + id;
        Cursor cursor = db.rawQuery(query,null);
        Student std = new Student();
        if(cursor.moveToFirst())
        {
            do {
                std.setId(Integer.parseInt(cursor.getString(0)));
                std.setRollNo(cursor.getString(1));
                std.setName(cursor.getString(2));
                std.setSabaq(cursor.getString(3));
                std.setManzil(cursor.getString(4));
                std.setSabqi(cursor.getString(5));
            }while (cursor.moveToNext());
        }
        return std;
    }
    public void deleteStudent(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Params.S_TABLE_NAME, Params.S_COLUMN_ID + " = ?", new String[] {id});
        db.close();
    }

    public int updateStudent(Student std)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.S_COLUMN_ROLLNO,std.getRollNo());
        values.put(Params.S_COLUMN_NAME,std.getName());
        values.put(Params.S_COLUMN_SABAQ,std.getSabaq());
        values.put(Params.S_COLUMN_MANZIL,std.getManzil());
        values.put(Params.S_COLUMN_SABQI,std.getSabqi());
        return db.update(Params.S_TABLE_NAME,values,Params.S_COLUMN_ID + " = ?", new String[]{String.valueOf(std.getId())});
    }

    public int updateLesson(Student std)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Params.S_COLUMN_ROLLNO,std.getRollNo());
        values.put(Params.S_COLUMN_NAME,std.getName());
        values.put(Params.S_COLUMN_SABAQ,std.getSabaq());
        values.put(Params.S_COLUMN_MANZIL,std.getManzil());
        values.put(Params.S_COLUMN_SABQI,std.getSabqi());

        return db.update(Params.S_TABLE_NAME,values,Params.S_COLUMN_ID + " = ?", new String[]{String.valueOf(std.getId())});

    }



    public List<Student> getAllStudents()
    {
        List<Student> students = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String query= "SELECT * FROM "+ Params.S_TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst())
        {
            do {
                 Student std = new Student();
                 std.setId(Integer.parseInt(cursor.getString(0)));
                 std.setRollNo(cursor.getString(1));
                 std.setName(cursor.getString(2));
                 std.setSabaq(cursor.getString(3));
                 std.setManzil(cursor.getString(4));
                 std.setSabqi(cursor.getString(5));
                 students.add(std);
            }while (cursor.moveToNext());
        }
        return students;
    }
}
