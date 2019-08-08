package com.GabCorp.enablonpicapp.requests;

import com.GabCorp.enablonpicapp.models.ApiData;
import com.GabCorp.enablonpicapp.models.InstaPic;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

/**
 * Interface that contains the GET requests, the code will be generated by Retrofit
 */
public interface InstaPicApi {

    @GET("v1/users/self/media/recent/")
    Call<ApiData> getInstaPicList(
            @Query("access_token") String accessToken
    );

}
