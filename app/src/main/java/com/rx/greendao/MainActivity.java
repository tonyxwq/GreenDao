package com.rx.greendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*User user = new User();
        user.setAge(1000);
        //user.setId(999L);
        user.setSex("女");
        user.setName("王铁锤");

        User user1 = new User();
        user1.setAge(1000);
        //user1.setId(999L);
        user1.setSex("女");
        user1.setName("王铁锤");*/

        //DBManager.getInstance(MainActivity.this).insertUser(user);
        //DBManager.getInstance(MainActivity.this).insertUser(user1);
        //DBManager.getInstance(MainActivity.this).updateUser(user);

        List<User> list = new ArrayList<>();
        for (int i= 1; i <= 100; i++)
        {
            User users = new User();
            users.setAge(i);
            users.setSex("女" + i);
            users.setName("王铁锤" + i);
            users.setNum("num"+i);
            users.setWangnian("wangnian"+i);
            list.add(users);

            DBManager.getInstance(MainActivity.this).update(i+1,users);
        }

        //DaoMaster.newDevSession(MainActivity.this,DBManager.dbName);


       /* List<User> list = DBManager.getInstance(MainActivity.this).queryUserList(90);
        Log.d("data","============"+list.size());
        for (User entiy : list)
        {
            Log.d("data", "==================" + entiy.getName() + entiy.getSex() + entiy.getAge() + entiy.getId() + "\n");
        }*/

        DBManager.getInstance(MainActivity.this).delete(1);
    }
}
