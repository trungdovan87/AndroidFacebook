package com.beautydroid.footballz.core.dev;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public final class SimpleService {
    public static final String API_URL = "https://api.github.com/";

    public interface GitHub {
        @GET("repos/{owner}/{repo}/contributors")
        Call<List<Contributor>> contributors(
                @Path("owner") String owner,
                @Path("repo") String repo);

        @GET("repos/{owner}/{repo}/contributors")
        List<Contributor> synContributors(
                @Path("owner") String owner,
                @Path("repo") String repo);
    }

    public static class Contributor {
        public final String login;
        public final int contributions;

        public Contributor(String login, int contributions) {
            this.login = login;
            this.contributions = contributions;
        }
    }
}