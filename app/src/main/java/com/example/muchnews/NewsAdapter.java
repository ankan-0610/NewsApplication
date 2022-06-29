package com.example.muchnews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private List<News> newsList;
    private Context context;

    public NewsAdapter (List<News> newsList,Context context){
        this.newsList = newsList;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

//        int imageResource = newsList.get(position).getImageView();
//        String heading = newsList.get(position).getNewsHeader();
//        holder.setData(imageResource,heading);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, webView.class);
                intent.putExtra("url",newsList.get(holder.getBindingAdapterPosition()).getUrl());
                context.startActivity(intent);
            }
        });

        holder.mtime.setText("Published At "+newsList.get(position).getPublishedAt());
        holder.mauthor.setText(newsList.get(position).getAuthor());
        holder.mheading.setText(newsList.get(position).getTitle());
        holder.mdescription.setText(newsList.get(position).getDescription());
        Glide.with(context).load(newsList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        return newsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView mheading,mdescription,mauthor,mtime;
        CardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            mheading=itemView.findViewById(R.id.newsHeader);
            mdescription=itemView.findViewById(R.id.description);
            mauthor=itemView.findViewById(R.id.author);
            mtime=itemView.findViewById(R.id.time);
            cardView=itemView.findViewById(R.id.cardView);
        }

//        public void setData(int imageResource, String heading) {
//            imageView.setImageResource(imageResource);
//            mheading.setText(heading);
//        }
    }
}
