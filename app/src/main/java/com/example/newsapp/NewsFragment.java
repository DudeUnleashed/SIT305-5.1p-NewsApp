package com.example.newsapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewsFragment extends Fragment {

    NewsDataModel newsItem;
    String newsName, newsBody;
    int newsImage;
    RecyclerView recyclerRelatedNews;
    RecyclerView.LayoutManager layoutManagerRelatedNews;

    TextView fragmentHeader, fragmentBody;
    ImageView fragmentImage;
    private MainActivity mActivity;

    public NewsFragment() {
    }

    public static NewsFragment newInstance(NewsDataModel newsItem) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putSerializable("newsItem", (Serializable) newsItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            newsItem = (NewsDataModel) getArguments().getSerializable("newsItem");
            newsName = newsItem.getTitle();
            newsBody = newsItem.getDescription();
            newsImage = newsItem.getImageResourceId();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        recyclerRelatedNews = view.findViewById(R.id.recyclerRelatedNews);
        layoutManagerRelatedNews = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RelatedNewsAdapter relatedNewsAdapter = new RelatedNewsAdapter(getActivity(), ((MainActivity) requireActivity()).getRelatedNews());
        recyclerRelatedNews.setLayoutManager(layoutManagerRelatedNews);
        recyclerRelatedNews.setAdapter(relatedNewsAdapter);

        mActivity.setAdapterClickable(false);

        fragmentHeader = view.findViewById(R.id.textFragmentNewsHeading);
        fragmentBody = view.findViewById(R.id.textFragmentNewsDescription);
        fragmentImage = view.findViewById(R.id.imageFragmentNews);

        // set the data of the news item
        fragmentHeader.setText(newsName);
        fragmentBody.setText(newsBody);
        fragmentImage.setImageResource(newsImage);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mActivity.setAdapterClickable(true);
    }
}