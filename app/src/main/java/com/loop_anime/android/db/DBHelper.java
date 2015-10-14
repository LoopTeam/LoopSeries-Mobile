package com.loop_anime.android.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * User: Yilun Chen
 * Date: 30/09/2015
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String LOG_TAG = DBHelper.class.getSimpleName();

    private static final String DB_NAME = "loop.sqlite";

    private static final int DB_VERSION = 1;

    private static DBHelper instance;

    private Context context;

    public static DBHelper instance(Context context) {
        synchronized (DBHelper.class) {
            if (instance == null) {
                Context appContext = context.getApplicationContext();
                instance = new DBHelper(appContext);
                instance.context = appContext;
            }
            return instance;
        }
    }

    private DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(Table.Anime.CREATE_SQL);
        } catch (SQLException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
