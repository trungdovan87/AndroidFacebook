package com.beautydroid.footballz.core.api;

import com.beautydroid.footballz.core.api.msg.SeasonMsg;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Path;
import retrofit.http.Query;

public interface IApiRetrofitFootballData {
    String BASE_URL = "http://api.football-data.org/alpha/";

    @GET("soccerseasons/")
    Call<List<SeasonMsg>> listSeason(@Header("X-Auth-Token")String token, @Query("season") int season);

    @GET("soccerseasons/{seasonId}")
    Call<SeasonMsg> getSeason(@Header("X-Auth-Token")String token, @Path("seasonId") int seasonId);

}
