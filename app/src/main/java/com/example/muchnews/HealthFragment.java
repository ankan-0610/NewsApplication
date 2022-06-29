package com.example.muchnews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {

    private RecyclerView recyclerViewOfHealth;
    String country="in";
    String apiKey="5032bf8bf0394968956c9d2891dc3612";
    ArrayList<News> newsList;
    NewsAdapter newsAdapter;
    private String category="health";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.health_fragment, null);
        recyclerViewOfHealth = view.findViewById(R.id.recyclerViewOfHealth);
        newsList = new ArrayList<>();
        recyclerViewOfHealth.setLayoutManager(new LinearLayoutManager(getContext()));
        newsAdapter = new NewsAdapter(newsList, getContext());
        recyclerViewOfHealth.setAdapter(newsAdapter);

        findNews();

        return view;
    }

    private void findNews() {
        ApiUtils.getApiInterface().getCategoryNews(country, category, 100, apiKey).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    newsList.addAll(response.body().getArticles());
                    newsAdapter.notifyDataSetChanged();
                } else {
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}