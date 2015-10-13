package com.beautydroid.footballz.core.api.impl;

import com.beautydroid.footballz.core.api.IApiRetrofitFootballData;
import com.beautydroid.footballz.core.api.IFootballData;
import com.beautydroid.footballz.core.api.msg.ErrorMsg;
import com.beautydroid.footballz.core.api.msg.SeasonMsg;
import com.google.gson.Gson;
import com.google.inject.Inject;

import java.util.List;

import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import roboguice.util.Ln;

/**
 * Created by trung.do on 10/13/2015.
 */
public class FootballData implements IFootballData {
    public static class StubCallback<S, E> implements ICallback<S,E>{

        @Override
        public void onSuccess(S successMsg) {
            Ln.d("on success %s", successMsg);
        }

        @Override
        public void onError(E errorMsg) {
            Ln.d("on error %s", errorMsg);
        }

        @Override
        public void onException(Exception ex) {
            Ln.d(ex, "on exception");
        }
    }

    private String mToken;
    private Retrofit mRetrofit;
    private IApiRetrofitFootballData mApi;

    public FootballData(){
        mRetrofit = new Retrofit.Builder().baseUrl(IApiRetrofitFootballData.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        mApi = mRetrofit.create(IApiRetrofitFootballData.class);
    }

    private void handleResponse(){

    }

    @Override
    public void listSeason(int season, ICallback<List<SeasonMsg>, ErrorMsg> callback) {
        try {
            Response<List<SeasonMsg>>  response =  mApi.listSeason(mToken, season).execute();
            if (response.isSuccess())
                callback.onSuccess(response.body());
            else
                 callback.onError(new Gson().fromJson(response.errorBody().string(), ErrorMsg.class));
        } catch (Exception e) {
            callback.onException(e);
        }
    }

    @Override
    @Inject
    public void setToken(String token) {
        this.mToken = token;
    }

    @Override
    public String getToken() {
        return mToken;
    }
}
