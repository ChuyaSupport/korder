package com.chuyasupport.kclient.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;

public class DBUtil extends SQLiteOpenHelper {
    private static final String TAG = "DBUtil";

    public DBUtil(@Nullable Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        创建数据库
        Log.d(TAG, "onCreate: 数据库已创建.....");
        String sql = "create table t_user(user_id varchar(50), user_name varchar(50), avartar_url varchar(50), phone_number varchar(50), balance decimal(10, 2), gender varchar(2), password varchar(50))";
        sqLiteDatabase.execSQL(sql);
        String sql1 = "create table t_data_tmp(data varchar(100))";
        String sql2 = "insert into t_data_tmp values('1')";
        sqLiteDatabase.execSQL(sql1);
        sqLiteDatabase.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
