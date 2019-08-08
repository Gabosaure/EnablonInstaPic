package com.GabCorp.enablonpicapp.requests;

import com.GabCorp.enablonpicapp.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit service, generates the code for InstaPicApi interface
 */
public class RetrofitService {

    private static Retrofit getRetroInstance() {

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static InstaPicApi getInstaPicApi(){
        return getRetroInstance().create(InstaPicApi.class);
    }
}
