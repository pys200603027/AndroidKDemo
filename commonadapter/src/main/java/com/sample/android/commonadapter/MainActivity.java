package com.sample.android.commonadapter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.sample.android.commonadapter.data.Item;

import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private MainPresenter presenter = new MainPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final MainAdapter adapter = new MainAdapter();
        recyclerView.setAdapter(adapter);

        Disposable subscribe = presenter.getSession().subscribe(adapter::setNewData, Throwable::printStackTrace);
    }

    @Subscribe(
            tags = {@Tag(Event.ON_ITEM_CLICK)}
    )
    public void onItemClick(Item item) {

    }
}
