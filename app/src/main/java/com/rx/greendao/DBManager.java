package com.rx.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Author:XWQ
 * Time   2018/11/14
 * Descrition: this is DBManager
 */

public class DBManager
{
    public final static String dbName = "test_db";
    private static DBManager mInstance;
    private MyOpenHelper openHelper;
    private Context context;

    public DBManager(Context context)
    {
        this.context = context;
        openHelper = new MyOpenHelper(context, dbName, null);
    }

    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context)
    {
        if (mInstance == null)
        {
            synchronized (DBManager.class)
            {
                if (mInstance == null)
                {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase()
    {
        if (openHelper == null)
        {
            openHelper = new MyOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase()
    {
        if (openHelper == null)
        {
            openHelper = new MyOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }

    /**
     * 插入一条记录
     *
     * @param user
     */
    public void insertUser(User user)
    {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.insert(user);
    }

    /**
     * 更新一条记录
     *
     * @param user
     */
    public void updateUser(User user)
    {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.update(user);
    }

    /**
     * 根据id更改
     *
     * @param id
     */
    public void update(int id, User users)
    {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        User user = qb.where(UserDao.Properties.Id.eq(id)).build().unique();
        if (user != null)
        {
            user.setNum(users.getNum());
            user.setWangnian(users.getWangnian());
        }
        userDao.update(user);
    }


    /**
     * 删除数据
     *
     * @param id
     */
    public void delete(int id)
    {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        User user = qb.where(UserDao.Properties.Id.eq(id)).build().unique();
        if (user != null)
        {
            //userDao.delete(user);
            userDao.deleteByKey(user.getId());
        }
    }


    /**
     * 插入用户集合
     *
     * @param users
     */
    public void insertUserList(List<User> users)
    {
        if (users == null || users.isEmpty())
        {
            return;
        }
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        userDao.insertInTx(users);
    }


    /**
     * 查询用户列表
     */
    public List<User> queryUserList()
    {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        List<User> list = qb.list();
        return list;
    }


    /**
     * 查询用户列表
     */
    public List<User> queryUserList(int age)
    {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        UserDao userDao = daoSession.getUserDao();
        QueryBuilder<User> qb = userDao.queryBuilder();
        //qb.where(UserDao.Properties.Age.gt(age)).orderDesc(UserDao.Properties.Age);
        qb.where(UserDao.Properties.Age.notEq(age));
        List<User> list = qb.list();
        return list;
    }

}
