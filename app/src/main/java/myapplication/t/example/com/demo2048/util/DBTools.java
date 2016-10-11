package myapplication.t.example.com.demo2048.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by T on 2016/9/12.
 */
public class DBTools {
    private Context context;
    private SQLiteDatabase sd;
    private SQLiteOpenHelper helper;
    private DBManager dbManager;

    public DBTools(Context context) {
        this.context = context;
        dbManager = new DBManager(context);
    }


    public boolean savaLocalType(int grade) {
        sd = dbManager.getReadableDatabase();
//        String sql = "select grade from " + DBManager.NEWSTYPE_NAME + " where grade = ?";
//        Cursor c = sd.rawQuery(sql, new String[]{usersGrade.getGrade() + ""});
//        if (c.moveToNext() && c.getCount() > 0) {
//            return false;
//        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("grade", grade);
        sd.insert(DBManager.NEWSTYPE_NAME, null, contentValues);
        return true;
    }

    public List getGrade() {
        List Lists = new ArrayList();
        sd = dbManager.getReadableDatabase();
        String sql = "select * from " + DBManager.NEWSTYPE_NAME;
        Cursor c = sd.rawQuery(sql, null);
        if (c.moveToFirst()) {
            do {
                int subid = c.getInt(c.getColumnIndex("grade"));

             Lists.add(subid);
            } while (c.moveToNext());
            c.close();
            sd.close();
        }
        return Lists;
    }


}

