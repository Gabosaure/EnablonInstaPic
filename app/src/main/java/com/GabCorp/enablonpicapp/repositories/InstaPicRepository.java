package com.GabCorp.enablonpicapp.repositories;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import com.GabCorp.enablonpicapp.models.ApiData;
import com.GabCorp.enablonpicapp.models.InstaPic;
import com.GabCorp.enablonpicapp.models.Profil;
import com.GabCorp.enablonpicapp.requests.InstaPicApi;
import com.GabCorp.enablonpicapp.requests.RetrofitService;
import com.GabCorp.enablonpicapp.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;


public class InstaPicRepository {

    private static InstaPicRepository instance;
    private ArrayList<InstaPic> dataSet = new ArrayList<>();
    private InstaPicApi instaPicApi;

    /**
     * Singleton
     * @return unique instance of the repository
     */
    public static InstaPicRepository getInstance(){
        if (instance == null)
            instance = new InstaPicRepository();
        return instance;
    }

    /**
     * Constructor
     */
    public InstaPicRepository(){
        // We ask Retrofit to create a Api based on the InstaPicApi class we created
        instaPicApi = new RetrofitService().getInstaPicApi();
    }

    /**
     * Get data from the instagram API
     * @return a list of instaPics or null in case of failure
     */
    public MutableLiveData<List<InstaPic>> getInstaPicList() {

        final MutableLiveData<List<InstaPic>> instaPicList = new MutableLiveData<>();

        // starting the HTTP request in an asynchronous manner
        Call<ApiData> call = instaPicApi.getInstaPicList(Constants.ACCESS_TOKEN);
        call.enqueue(new Callback<ApiData>() {
             @Override
             public void onResponse(Call<ApiData> call, Response<ApiData> response) {
                 // Creating the picture object with wanted datas
                 for (Profil p : response.body().getData()){
                     dataSet.add( new InstaPic(
                             p.getTitle(),
                             p.getImageData().getStandardResolution().getImageUrl(),
                             p.getLikes().getCount(),
                             p.getDate()));

                 }
                 instaPicList.setValue(dataSet);
             }

             @Override
             public void onFailure(Call<ApiData> call, Throwable t) {
                 instaPicList.setValue(null);
             }
         });

        return instaPicList;
    }
}
