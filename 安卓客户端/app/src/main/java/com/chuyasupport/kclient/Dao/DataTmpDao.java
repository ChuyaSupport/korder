package com.chuyasupport.kclient.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.chuyasupport.kclient.utils.DBUtil;

public class DataTmpDao {
    private DBUtil dbUtil = null;
    public DataTmpDao(Context context) {
        dbUtil = new DBUtil(context);
    }

    public void update(String postId) {
        Log.d("DDDDD", "update: ##################" + postId);
        SQLiteDatabase db = dbUtil.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", postId);
        db.update("t_data_tmp", contentValues, null, null);
        db.close();
    }
    public String select() {
        SQLiteDatabase db = dbUtil.getWritableDatabase();
        Cursor cursor = db.query("t_data_tmp", null, null, null, null, null, null);
        if (cursor.moveToNext()) {
            int data = cursor.getColumnIndex("data");
            return  cursor.getString(data);
        }
        cursor.close();
        db.close();
        return null;
    }
    public String hha() {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        return "###############################";
    }
}
