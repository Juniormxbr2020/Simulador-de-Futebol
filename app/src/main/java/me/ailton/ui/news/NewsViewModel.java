package me.ailton.ui.news;



import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

import me.ailton.data.remote.FutebolNewsApi;
import me.ailton.domain.News;
import retrofit2.Retrofit;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private  final FutebolNewsApi api;

    public NewsViewModel() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://juniormxbr2020.github.io/Simulador-de-Futebol-API/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         api = retrofit.create(FutebolNewsApi.class);
         FutebolNewsApi service = retrofit.create(FutebolNewsApi.class);

        this.findNews();

    }

    private void findNews() {
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {

                if (response.isSuccessful()) {
                    news.setValue(response.body());

                } else {

                    // TODO Pensar em estrategias de tratamentos de erros.
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                // TODO Pensar em estrategias de tratamentos de erros.
            }
        });
    }

    public LiveData<List<News>> getNews() {
        return news;
    }


    }
