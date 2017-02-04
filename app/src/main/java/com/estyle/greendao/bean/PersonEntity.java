package com.estyle.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public classdPersonEntity {

    @Id(autoincrement = true)
    private long id;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "age")
    private int age;

    @Property(nameInDb = "cur_time")
    private long curTime;

    @Generated(hash = 1191680960)
    public PersonEntity(long id, String name, int age, long curTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.curTime = curTime;
    }

    @Generated(hash = 69356185)
    public PersonEntity() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getCurTime() {
        return this.curTime;
    }

    public void setCurTime(long curTime) {
        this.curTime = curTime;
    }

}
