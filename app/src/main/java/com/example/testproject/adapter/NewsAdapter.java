package com.example.testproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.testproject.R;
import com.example.testproject.model.TypiCodeModel;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context mCtx;
    private List<TypiCodeModel> newsList;

    public NewsAdapter(Context mCtx, List<TypiCodeModel> newsModelList) {
        this.mCtx = mCtx;
        this.newsList = newsModelList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_layout, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        TypiCodeModel newsModel = newsList.get(position);
        holder.txtTitle.setText(newsModel.getTitle());
        Glide.with(mCtx).load(newsModel.getThumbnailUrl()).into(holder.img_icon);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {
        ImageView img_icon;
        TextView txtTitle;

        NewsViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_title);
            img_icon = itemView.findViewById(R.id.img_icon);
        }
    }
}
