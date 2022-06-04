package com.chuyasupport.kclient.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.chuyasupport.kclient.entity.pojo.User;
import com.chuyasupport.kclient.utils.DBUtil;


public class UserDao {
    private DBUtil dbUtil = null;
    public UserDao(Context context) {
        dbUtil = new DBUtil(context);
    }
    public void insert(User user) {
        SQLiteDatabase db = dbUtil.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_id", user.getUser_id());
        contentValues.put("user_name", user.getUser_name());
        contentValues.put("avartar_url", user.getAvartar_url());
        contentValues.put("phone_number", user.getPhone_number());
        contentValues.put("balance", String.valueOf(user.getBalance()));
        contentValues.put("gender", user.getGender());
        contentValues.put("password", user.getPassword());
        db.insert("t_user", null, contentValues);
        db.close();
    }
    public void delete() {

    }
    public void update(User user) {
        SQLiteDatabase db = dbUtil.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_id", user.getUser_id());
        contentValues.put("user_name", user.getUser_name());
        contentValues.put("avartar_url", user.getAvartar_url());
        contentValues.put("phone_number", user.getPhone_number());
        contentValues.put("balance", String.valueOf(user.getBalance()));
        contentValues.put("gender", user.getGender());
        contentValues.put("password", user.getPassword());
        db.update("t_user", contentValues, null, null);
        db.close();
    }
    public User select() {
        SQLiteDatabase db = dbUtil.getWritableDatabase();
        Cursor cursor = db.query("t_user", null, null, null, null, null, null);
        if (cursor.moveToNext()) {
            int user_id = cursor.getColumnIndex("user_id");
            int user_name = cursor.getColumnIndex("user_name");
            int avartar_url = cursor.getColumnIndex("avartar_url");
            int phone_number = cursor.getColumnIndex("phone_number");
            int balance = cursor.getColumnIndex("balance");
            int gender = cursor.getColumnIndex("gender");
            int password =cursor.getColumnIndex("password");
            return new User(cursor.getString(user_id), cursor.getString(user_name), cursor.getString(avartar_url),
                    cursor.getString(phone_number), cursor.getString(balance), cursor.getString(gender), cursor.getString(password));
        }
        cursor.close();
        db.close();
        return null;
    }
}
