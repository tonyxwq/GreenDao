package com.rx.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

import static com.rx.greendao.DaoMaster.SCHEMA_VERSION;
import static com.rx.greendao.DaoMaster.createAllTables;
import static com.rx.greendao.DaoMaster.dropAllTables;

/**
 * Author:XWQ
 * Time   2018/11/15
 * Descrition: this is MyOpenHelper
 */

public class MyOpenHelper extends DatabaseOpenHelper
{
    public MyOpenHelper(Context context, String name)
    {
        super(context, name, SCHEMA_VERSION);
    }

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory)
    {
        super(context, name, factory, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(Database db)
    {
        Log.i("greenDAO", "Creating tables for schema version " + SCHEMA_VERSION);
        createAllTables(db, false);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion)
    {
        Log.i("greenDAO", "Upgrading schema from version " + oldVersion + " to " + newVersion + " by dropping all tables");
        //dropAllTables(db, true);
        //onCreate(db);
        //操作数据库的更新 有几个表升级都可以传入到下面
        MigrationHelper.getInstance().migrate(db,UserDao.class);
    }

}

