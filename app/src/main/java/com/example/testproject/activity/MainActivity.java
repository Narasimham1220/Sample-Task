package com.example.testproject.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testproject.R;
import com.example.testproject.adapter.NewsAdapter;
import com.example.testproject.model.TypiCodeModel;
import com.example.testproject.viewmodel.NewsViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recy_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        observable();
    }


    private void init() {
        recy_data = findViewById(R.id.recy_data);
        recy_data.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    private void observable() {
        NewsViewModel model = ViewModelProviders.of(this).get(NewsViewModel.class);
        model.getNews().observe(this, new Observer<List<TypiCodeModel>>() {
            @Override
            public void onChanged(List<TypiCodeModel> typiCodeModels) {
                NewsAdapter adapter = new NewsAdapter(MainActivity.this, typiCodeModels);
                recy_data.setAdapter(adapter);
            }
        });
    }


}
