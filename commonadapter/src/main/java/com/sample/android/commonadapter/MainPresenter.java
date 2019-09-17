package com.sample.android.commonadapter;


import com.sample.android.commonadapter.data.DaoSession;
import com.sample.android.commonadapter.data.Item;
import com.sample.android.commonadapter.data.ItemDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {

    public Observable<List<Item>> getSession() {
        return getSessionCache()
                .flatMap((Function<List<Item>, ObservableSource<List<Item>>>) list -> {
                    if (list == null || list.isEmpty()) {
                        /**
                         * 网络读取
                         */
                        return getSessionFromHttp();
                    }
                    return Observable.just(list);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    /**
     * 缓存读取
     */
    public Observable<List<Item>> getSessionCache() {
        return Observable.fromCallable(() -> {
            DaoSession daoSession = App.getDaoSession();
            ItemDao itemDao = daoSession.getItemDao();
            return itemDao.loadAll();
        });
    }

    /**
     * 网络读取
     *
     * @return
     */
    public Observable<List<Item>> getSessionFromHttp() {
        return Observable.fromCallable(() -> {
            List<Item> items = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                Item item = new Item();
                item.setUid(i + "");
                items.add(item);
            }
            return items;
        });
    }

    public void updateSession() {

    }

    public void removeSession(Item item) {
        DaoSession daoSession = App.getDaoSession();
        ItemDao itemDao = daoSession.getItemDao();
    }
}
