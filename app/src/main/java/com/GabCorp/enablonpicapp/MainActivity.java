package com.GabCorp.enablonpicapp;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.GabCorp.enablonpicapp.adapters.RecyclerViewAdapter;
import com.GabCorp.enablonpicapp.models.InstaPic;
import com.GabCorp.enablonpicapp.utils.Constants;
import com.GabCorp.enablonpicapp.viewmodels.InstaPicViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private InstaPicViewModel mInstaPicViewModel;
    private List<InstaPic> mInstaPicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        // Initializing ViewModel
        mInstaPicViewModel = ViewModelProviders.of(this).get(InstaPicViewModel.class);
        mInstaPicViewModel.init();

        mInstaPicList = new ArrayList<>();
        initRecyclerView();
        subscribeObservers();
    }

    /**
     * Initilizing the recyclerview
     * Watches mInstaPicList for updates
     */
    private void initRecyclerView(){
        List<InstaPic> list = mInstaPicViewModel.getInstaPics().getValue();
        if (list != null) mInstaPicList.addAll(list);
        mAdapter = new RecyclerViewAdapter(mInstaPicList, this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * Subscribing to oberver
     */
    private void subscribeObservers(){
        mInstaPicViewModel.getInstaPics().observe(this, new Observer<List<InstaPic>>()  {
            @Override
            public void onChanged(@Nullable List<InstaPic> instaPics) {
                if (instaPics != null) mInstaPicList.addAll(instaPics);
                mAdapter.notifyDataSetChanged();
            }
        });
    }
}
