package com.sample.android.commonadapter;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.sample.android.commonadapter.data.DaoMaster;
import com.sample.android.commonadapter.data.DaoSession;

public class App extends Application {

    static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "db-adapter");
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return daoSession;
    }
}
