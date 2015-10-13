package com.beautydroid.footballz.core.dev;

import com.beautydroid.footballz.core.api.IApiRetrofitFootballData;
import com.beautydroid.footballz.core.api.msg.SeasonMsg;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import static com.beautydroid.caramel.common.common.ScreenOutputs.println;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by trung.do on 10/13/2015.
 */
public class FootballTest {

    final String token = "f9ea0e1bf4204d1793b2e324f7ab0f0c";

    Retrofit retrofit;
    IApiRetrofitFootballData api;

    @Before
    public void setUp() {
        retrofit = new Retrofit.Builder().baseUrl(IApiRetrofitFootballData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(IApiRetrofitFootballData.class);
    }

    @Test
    @Ignore
    public void testSeason() throws IOException {

        Call<List<SeasonMsg>> call = api.listSeason(token, 2014);
        List<SeasonMsg> seasonMsgList = call.execute().body();
        assertEquals(14, seasonMsgList.size());
        //check item 1
        SeasonMsg seasonMsg = seasonMsgList.get(0);
        assertEquals(18, seasonMsg.getNumberOfTeams());
        assertEquals(306, seasonMsg.getNumberOfGames());
        assertEquals("2014", seasonMsg.getYear());

        assertEquals("http://api.football-data.org/alpha/soccerseasons/351", seasonMsg.get_links().getSelf().getHref());

    }

    @Test
    public void testSuccess() throws IOException {
        println("test Success");
        Call<List<SeasonMsg>> call = api.listSeason(token, 2015);

        Response<List<SeasonMsg>> response = call.execute();
        List<SeasonMsg> seasonMsgList = response.body();
        println("is success %b", response.isSuccess());
        println("code %d", response.code());
        //println("header %s", response.headers());
        println("message %s", response.message());
        println("error body %s", response.errorBody().string());
    }

    @Test
    public void testError() throws IOException {
        println("test error");
        Call<List<SeasonMsg>> call = api.listSeason(token, 2000);

        Response<List<SeasonMsg>> response = call.execute();
        List<SeasonMsg> seasonMsgList = response.body();
        //assertNull("null response", seasonMsgList);
        println("is success %b", response.isSuccess());
        println("code %d", response.code());
        //println("header %s", response.headers());
        println("message %s", response.message());
        println("error body %s", response.errorBody().string());
        //println("raw %s", response.raw().body().string());

    }


    @Test
    @Ignore
    public void testGithut() throws IOException {
        Retrofit myRetrofit = new Retrofit.Builder().baseUrl(SimpleService.API_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        SimpleService.GitHub github = myRetrofit.create(SimpleService.GitHub.class);
        Call<List<SimpleService.Contributor>> call = github.contributors("square", "retrofit");

        // Fetch and print a list of the contributors to the library.
        List<SimpleService.Contributor> contributors;

        //contributors = github.synContributors("square", "retrofit");
        contributors = call.execute().body();

        System.out.println("size of contributors : " + contributors.size());
        for (SimpleService.Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ") \n");
            System.out.println(contributor.login + " (" + contributor.contributions + ") \n");
        }
    }
}
