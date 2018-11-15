package com.rx.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author:XWQ
 * Time   2018/11/14
 * Descrition: this is User
 */

@Entity
public class User
{
    @Id
    private Long id;
    private String name;
    private int age;
    private String sex;

    private String num;

    private String wangnian;

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getSex()
    {
        return this.sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getNum() {
        return this.num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getWangnian() {
        return this.wangnian;
    }

    public void setWangnian(String wangnian) {
        this.wangnian = wangnian;
    }

    @Generated(hash = 965482585)
    public User(Long id, String name, int age, String sex, String num,
            String wangnian) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.num = num;
        this.wangnian = wangnian;
    }

    @Generated(hash = 586692638)
    public User()
    {
    }

    //下面省去了 setter/getter
}
