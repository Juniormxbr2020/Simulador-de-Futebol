package me.ailton.ui.news;

import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import me.ailton.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {

        this.news= new MutableLiveData<>();

        List<News> news = new ArrayList<>();
        news.add(new News(TextView:"ferroviaria",textView2"ferroviaria"));
        news.add(new News(title:"ferroviaria", description"ferroviaria"));
        news.add(new News(title:"ferroviaria", description"ferroviaria"));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}