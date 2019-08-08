package com.GabCorp.enablonpicapp.requests;

import com.GabCorp.enablonpicapp.models.ApiData;
import com.GabCorp.enablonpicapp.utils.Constants;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

public class RetrofitServiceTest {

    final static String WRONG_TOKEN = "1234567912345678";

    @Test
    public void RetroService_SendRequest_ReturnsTrue(){
        InstaPicApi apiTest = RetrofitService.getInstaPicApi();
        Call<ApiData> call = apiTest.getInstaPicList(Constants.ACCESS_TOKEN);

        call.enqueue(new Callback<ApiData>() {
            @Override
            public void onResponse(Call<ApiData> call, Response<ApiData> response) {
                assertEquals(200, response.code());
            }

            @Override
            public void onFailure(Call<ApiData> call, Throwable t) {
            }
        });

    }

    @Test
    public void RetroService_SendRequest_ReturnsFalse(){
        InstaPicApi apiTest = RetrofitService.getInstaPicApi();
        Call<ApiData> call = apiTest.getInstaPicList(WRONG_TOKEN);

        call.enqueue(new Callback<ApiData>() {
            @Override
            public void onResponse(Call<ApiData> call, Response<ApiData> response) {
                assertEquals(400, response.code());
            }

            @Override
            public void onFailure(Call<ApiData> call, Throwable t) {
            }
        });

    }



}