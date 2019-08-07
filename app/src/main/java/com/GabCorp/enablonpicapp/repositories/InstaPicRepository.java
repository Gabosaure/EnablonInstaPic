package com.GabCorp.enablonpicapp.repositories;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import com.GabCorp.enablonpicapp.models.InstaPic;

import java.util.ArrayList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class InstaPicRepository {

    private static InstaPicRepository instance;
    private ArrayList<InstaPic> dataSet = new ArrayList<>();

    public static InstaPicRepository getInstance(){
        if (instance == null)
            instance = new InstaPicRepository();
        Log.i(TAG, "getInstance: done");
        return instance;
    }

    // get pics from Insta APIs
    public MutableLiveData<List<InstaPic>> getInstaPics(){
        setPics();

        MutableLiveData<List<InstaPic>> data = new MutableLiveData<>();
        Log.i(TAG, "getInstaPics: dataSet size "+dataSet.size());
        data.setValue(dataSet);
        return data;
    }

    private void setPics(){
        // Mock
        dataSet.add(
                new InstaPic("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new InstaPic("https://i.redd.it/tpsnoz5bzo501.jpg",
                        "Trondheim")
        );
        dataSet.add(
                new InstaPic("https://i.redd.it/qn7f9oqu7o501.jpg",
                        "Portugal")
        );
        dataSet.add(
                new InstaPic("https://i.redd.it/j6myfqglup501.jpg",
                        "Rocky Mountain National Park")
        );
        dataSet.add(
                new InstaPic("https://i.redd.it/0h2gm1ix6p501.jpg",
                        "Havasu Falls")
        );
        dataSet.add(
                new InstaPic("https://i.redd.it/k98uzl68eh501.jpg",
                        "Mahahual")
        );
        dataSet.add(
                new InstaPic("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg",
                        "Frozen Lake")
        );
        dataSet.add(
                new InstaPic("https://i.redd.it/obx4zydshg601.jpg",
                        "Austrailia")
        );
    }
}
