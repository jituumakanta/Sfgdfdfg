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
    Context context;
    //**

    public Databasehandle(Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CreateTable = "CREATE TABLE " + TableName + "(" + ColoumName1 + " INTEGER PRIMARY KEY ," + ColoumName2 + " TEXT," + ColoumName3 + " TEXT," + ColoumName4 + " TEXT" + ")";
        db.execSQL(CreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TableName);

        // Create tables again
        onCreate(db);
    }

    void addRow(DataBean DataBean) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ColoumName2, DataBean.getName()); // Contact Name
        values.put(ColoumName3, DataBean.getID()); // Contact Phone
        values.put(ColoumName4, DataBean.getNumber()); // Contact Phone

        // Inserting Row
        db.insert(TableName, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    void getData() {
        SQLiteDatabase db = this.getReadableDatabase();
// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                ColoumName1,
                ColoumName2,
                ColoumName3,
                ColoumName4
        };

// Filter results WHERE "title" = 'My Title'
        String selection = ColoumName2 + " = ?";
        String[] selectionArgs = {"fff"};

// How you want the results sorted in the resulting Cursor
        String sortOrder =
                ColoumName1 + " DESC";

        Cursor cursor = db.query(
                TableName,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        ArrayList itemIds = new ArrayList<>();
        while (cursor.moveToNext()) {
            String itemId = cursor.getString(
                    cursor.getColumnIndexOrThrow(ColoumName1));
            itemIds.add(itemId);
        }
        // Toast.makeText(context, "This is my Toast message!"+itemIds, Toast.LENGTH_LONG).show();
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
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

}
