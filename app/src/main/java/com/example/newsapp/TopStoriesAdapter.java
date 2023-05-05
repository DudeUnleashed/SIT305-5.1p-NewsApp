package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopStoriesViewHolder> {

    private List<NewsDataModel> newsList;
    private Context context;
    private boolean mClickable = true;

    public TopStoriesAdapter(Context context, List<NewsDataModel> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    public void setClickable(boolean clickable){
        mClickable = clickable;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TopStoriesAdapter.TopStoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclertopstories_layout, parent, false);
        return new TopStoriesAdapter.TopStoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopStoriesAdapter.TopStoriesViewHolder holder, int position) {
        NewsDataModel newsItem = newsList.get(position);
        holder.titleTextView.setText(newsItem.getTitle());
        holder.descriptionTextView.setText(newsItem.getDescription());
        holder.imageView.setImageResource(newsItem.getImageResourceId());

        // Set OnClickListener for the item
        if (mClickable){
            // Set OnClickListener for the item
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NewsFragment newsFragment = NewsFragment.newInstance(newsItem);
                    FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, newsFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.setReorderingAllowed(true);
                    fragmentTransaction.commit();
                    ((MainActivity) context).setAdapterClickable(false);
                }
            });
        } else holder.itemView.setOnClickListener(null);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class TopStoriesViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView descriptionTextView;
        public ImageView imageView;

        public TopStoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textNewsHeader);
            descriptionTextView = itemView.findViewById(R.id.textNewsDescription);
            imageView = itemView.findViewById(R.id.imageNews);
        }
    }
}

