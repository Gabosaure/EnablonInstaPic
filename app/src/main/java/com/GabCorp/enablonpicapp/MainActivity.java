package com.GabCorp.enablonpicapp;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.GabCorp.enablonpicapp.adapters.RecyclerViewAdapter;
import com.GabCorp.enablonpicapp.models.InstaPic;
import com.GabCorp.enablonpicapp.viewmodels.InstaPicViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private InstaPicViewModel mInstaPicViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        mInstaPicViewModel = ViewModelProviders.of(this).get(InstaPicViewModel.class);
        mInstaPicViewModel.init();
        mInstaPicViewModel.getInstaPics().observe(this, new Observer<List<InstaPic>>() {
            @Override
            public void onChanged(@Nullable List<InstaPic> nicePlaces) {
                mAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();
    }

    private void initRecyclerView(){
        mAdapter = new RecyclerViewAdapter(mInstaPicViewModel.getInstaPics().getValue(), this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
