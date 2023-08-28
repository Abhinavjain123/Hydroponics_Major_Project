package com.example.hydroponics_major_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "Crops";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "AllCrops";

    //Columns
    private static final String ID_COL = "id";
    private static final String CROP_NAME = "cropName";
    private static final String CROP_TYPE = "cropType";
    private static final String MAX_TEMP = "MaxTemp";
    private static final String MIN_TEMP = "MinTemp";
    private static final String MAX_PH = "MaxPH";
    private static final String MIN_PH = "MinPH";
    private static final String MAX_RH = "MaxRH";
    private static final String MIN_RH = "MinRH";
    private static final String LIGHT_DURATION = "LightDuration(hr)";
    private static final String NUTRIENTS = "Nutrients";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CROP_NAME + " TEXT,"
                + CROP_TYPE + " TEXT,"
                + MAX_TEMP + " NUMBER,"
                + MIN_TEMP + "NUMBER,"
                + MAX_PH + "NUMBER,"
                + MIN_PH + "NUMBER,"
                + MAX_RH + "NUMBER,"
                + MIN_RH + "NUMBER,"
                + LIGHT_DURATION + "NUMBER,"
                + NUTRIENTS + "NUMBER )";

        db.execSQL(query);
    }

    public void addNewForm( String cropName, String cropType, int maxTemp, int minTemp, int maxPH, int minPH, int maxRH, int minRH,
                                int lightDuration, int nutrients ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CROP_NAME, cropName);
        values.put(CROP_TYPE, cropType);
        values.put(MAX_TEMP, maxTemp);
        values.put(MIN_TEMP, minTemp);
        values.put(MAX_PH, maxPH);
        values.put(MIN_PH, minPH);
        values.put(MAX_RH, maxRH);
        values.put(MIN_RH, minRH);
        values.put(LIGHT_DURATION, lightDuration);
        values.put(NUTRIENTS, nutrients);

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateForm( int originalId, String cropName, String cropType, int maxTemp, int minTemp, int maxPH, int minPH, int maxRH,
                                int minRH, int lightDuration, int nutrients ) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(CROP_NAME, cropName);
        values.put(CROP_TYPE, cropType);
        values.put(MAX_TEMP, maxTemp);
        values.put(MIN_TEMP, minTemp);
        values.put(MAX_PH, maxPH);
        values.put(MIN_PH, minPH);
        values.put(MAX_RH, maxRH);
        values.put(MIN_RH, minRH);
        values.put(LIGHT_DURATION, lightDuration);
        values.put(NUTRIENTS, nutrients);

        db.update(TABLE_NAME,values,"id="+originalId,new String[]{});
        db.close();
    }

    // below is the method for deleting our course.
    public void deleteForm(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME, "id="+id, new String[]{});
        db.close();
    }

    public ArrayList<com.example.hydroponics_major_project.cropModel> readForms() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorForm = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<com.example.hydroponics_major_project.cropModel> courseModalArrayList = new ArrayList<>();

        if (cursorForm.moveToFirst()) {
            do {
                courseModalArrayList.add(new com.example.hydroponics_major_project.cropModel(
                    cursorForm.getInt(0),
                    cursorForm.getString(1),
                    cursorForm.getString(2),
                    cursorForm.getInt(3),
                    cursorForm.getInt(4),
                    cursorForm.getInt(5),
                    cursorForm.getInt(6),
                    cursorForm.getInt(7),
                    cursorForm.getInt(8),
                    cursorForm.getInt(9),
                    cursorForm.getInt(10))
                );
            } while (cursorForm.moveToNext());
        }

        cursorForm.close();
        return courseModalArrayList;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}