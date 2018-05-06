package com.example.yann.classroom_community.BDD1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class GestionBDD extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "favouritesmanager";

    //Colonne Table
    public static final String COMPTE_KEY = "id";
    public static final String COMPTE_LOGIN = "login";
    public static final String COMPTE_MDP = "mdp";
    public static final String COMPTE_TABLE_NAME = "compte";
    public static final String COMPTE_TABLE_CREATE =
            "CREATE TABLE " + COMPTE_TABLE_NAME + " (" +
                    COMPTE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COMPTE_LOGIN + " TEXT, " +
                    COMPTE_MDP + " TEXT);";

    public static final String METIER_TABLE_DROP = "DROP TABLE IF EXISTS " + COMPTE_TABLE_NAME + ";";

    public GestionBDD(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        //super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMPTE_TABLE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(METIER_TABLE_DROP);
        onCreate(db);
    }

}
