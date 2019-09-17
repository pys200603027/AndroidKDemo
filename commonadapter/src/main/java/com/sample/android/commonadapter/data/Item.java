package com.sample.android.commonadapter.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class Item {
    @Id
    public Long id;
    private String uid;

    @Generated(hash = 571396114)
    public Item(Long id, String uid) {
        this.id = id;
        this.uid = uid;
    }

    @Generated(hash = 1470900980)
    public Item() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return this.uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
