package com.GabCorp.enablonpicapp.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.GabCorp.enablonpicapp.models.InstaPic;
import com.GabCorp.enablonpicapp.repositories.InstaPicRepository;

import java.util.List;

public class InstaPicViewModel extends ViewModel {

    private MutableLiveData<List<InstaPic>> mInstaPics;
    private InstaPicRepository mRepo;

    public void init() {
        if(mInstaPics != null) return;
        mRepo = InstaPicRepository.getInstance();
        mInstaPics = mRepo.getInstaPicList();
    }

    public LiveData<List<InstaPic>> getInstaPics() {
        return mInstaPics;
    }
}
