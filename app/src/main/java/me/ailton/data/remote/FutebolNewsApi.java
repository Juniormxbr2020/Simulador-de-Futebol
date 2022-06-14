package me.ailton.data.remote;

import java.util.List;

import me.ailton.domain.News;
import retrofit2.Call;
import retrofit2.http.GET;


public interface FutebolNewsApi {

    @GET("news.json")
    Call<List<News>> getNews();

}
