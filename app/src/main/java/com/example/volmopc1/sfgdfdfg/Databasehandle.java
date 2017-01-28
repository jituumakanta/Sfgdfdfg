package com.example.volmopc1.sfgdfdfg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volmopc1 on 18-01-2017.
 */

public class Databasehandle extends SQLiteOpenHelper {

    //**
    private static String DatabaseName = "mydatabse";
    private static int DatabaseVersion = 1;

    private static String TableName = "person";

    private static String ColoumName1 = "ID";
    private static String ColoumName2 = "NAME";
    private static String ColoumName3 = "NUMBER";
    private static String ColoumName4 = "AREA";

    private static String CreateEntity = "CREATE TABLE " + TableName + "(" + ColoumName1 + " INTEGER PRIMARY KEY ," + ColoumName2 + " TEXT," + ColoumName3 + " TEXT," + ColoumName4 + " TEXT" + ")";
    private String CreateNewTable = "DROP TABLE IF EXISTS " + TableName;

    Context context;
    //**

    public Databasehandle(Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CreateEntity);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(CreateNewTable);

        // Create tables again
        onCreate(db);
    }

    void createRow(DataBean DataBean) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ColoumName1, DataBean.getID());
        values.put(ColoumName2, DataBean.getName()); // Contact Name
        values.put(ColoumName3, DataBean.getNumber());
        values.put(ColoumName4, DataBean.getNumber()); // Contact Phone

        db.insert(TableName, null, values);
        db.close();
    }

    public void updateData() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ColoumName2, "ravi");

        // Which row to update, based on the title
        String selection = ColoumName2 + " = ?";

        String[] selectionArgs = { "rahim" };
        //or
       // String[] selectionArgs = {String.valueOf(DataBean.getID())};

        int count = db.update(TableName, values, selection, selectionArgs);

    }


    void getData() {
        SQLiteDatabase db = this.getReadableDatabase();

        String[] projection = {ColoumName1, ColoumName2, ColoumName3, ColoumName4};
        String selection = ColoumName2 + " = ?";
        String[] selectionArgs = {"jitu"};
        String sortOrder = ColoumName1 + " DESC";
        //String[] d={String.valueOf(ColoumName1)};
        Cursor cursor = db.query(TableName, projection, selection, selectionArgs, null, null, sortOrder);

        ArrayList numbers = new ArrayList<>();
        while (cursor.moveToNext()) {
            String number = cursor.getString(cursor.getColumnIndexOrThrow(ColoumName3));
            numbers.add(number);
        }
//int d=(Integer.parseInt(cursor.getString(0)));
        // Contact contact = new Contact(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

        Toast.makeText(context, "This is my Toast message!" + numbers, Toast.LENGTH_LONG).show();
        //  Toast.makeText(context, "This is my Toast message!"+d, Toast.LENGTH_LONG).show();

        cursor.close();

    }


    public List<DataBean> getAllContacts() {
        List<DataBean> contactList = new ArrayList<DataBean>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TableName;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DataBean contact = new DataBean();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setNumber(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
                Toast.makeText(context, "This is my Toast message!" + Integer.parseInt(cursor.getString(0))+" "+cursor.getString(1)+" "+cursor.getString(2), Toast.LENGTH_LONG).show();
            } while (cursor.moveToNext());
        }
      //  Toast.makeText(context, "This is my Toast message!" + contactList, Toast.LENGTH_LONG).show();
        // return contact list
        return contactList;
    }


    public void deleteContact() {
        SQLiteDatabase db = this.getWritableDatabase();

        String selection = ColoumName2 + " = ?";
        String[] selectionArgs = { "pradeep" };
        //or
       // String[] selectionArgs = new String[]{String.valueOf(DataBean.getID())};

        db.delete(TableName, selection,selectionArgs);
        db.close();
    }

}
