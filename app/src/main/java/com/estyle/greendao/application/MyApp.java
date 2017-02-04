package com.estyle.greendao.application;

import android.app.Application;

import com.estyle.greendao.bean.DaoMaster;
import com.estyle.greendao.bean.DaoSession;

import org.greenrobot.greendao.database.Database;

public class MyApp extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        initDAO();
    }

    private void initDAO() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "my_db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
