package com.example.a1918017_pertemuan7prak;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_kebun";
    private static final String tb_baju = "tb_baju";
    private static final String tb_baju_id = "id";
    private static final String tb_baju_nama = "nama";
    private static final String tb_baju_harga = "kelas";
    private static final String CREATE_TABLE_BAJU = "CREATE TABLE "
            + tb_baju +"("
            + tb_baju_id + " INTEGER PRIMARY KEY ,"
            + tb_baju_nama + " TEXT ,"
            + tb_baju_harga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_BAJU);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateBaju(Baju data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_baju_id, data.get_id());
        values.put(tb_baju_nama, data.get_nama());
        values.put(tb_baju_harga, data.get_harga());
        db.insert(tb_baju, null, values);
        db.close();
    }
    public List<Baju> ReadBaju() {
        List<Baju> listMhs = new ArrayList<Baju>();
        String selectQuery = "SELECT * FROM " + tb_baju;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Baju data = new Baju();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_harga(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateBaju (Baju data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_baju_nama, data.get_nama());
        values.put(tb_baju_harga, data.get_harga());
        return db.update(tb_baju, values, tb_baju_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteBaju(Baju data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_baju,tb_baju_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

