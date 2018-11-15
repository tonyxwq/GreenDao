package com.rx.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author:XWQ
 * Time   2018/11/14
 * Descrition: this is UserInfo
 */

@Entity
public class UserInfo
{
    @Id
    private Long id;
    private String Address;
    public String getAddress() {
        return this.Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 531124321)
    public UserInfo(Long id, String Address) {
        this.id = id;
        this.Address = Address;
    }
    @Generated(hash = 1279772520)
    public UserInfo() {
    }
}
