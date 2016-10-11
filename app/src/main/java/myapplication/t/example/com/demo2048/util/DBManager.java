package myapplication.t.example.com.demo2048.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by T on 2016/9/12.
 */
public class DBManager extends SQLiteOpenHelper {
    public static final String DB_NAME = "news.db";
    public static final String NEWSTYPE_NAME = "news_type";
    public static final String NEWS_NAME = "news";
    public static final String NEWSFAVORITE_NAME = "news_favorite";
    public static final int VER = 1;


    public DBManager(Context context) {
        super(context, DB_NAME, null,VER);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_1 = "create table " + NEWSTYPE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "grade INTEGER);";


        db.execSQL(sql_1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
