package com.example.newsapp;

import java.io.Serializable;
import java.util.List;

public class NewsDataModel implements Serializable {

    private String title;
    private String description;
    private int imageResourceId;
    private List<NewsDataModel> relatedNews;

    public NewsDataModel(String title, String description, int imageUrl, List<NewsDataModel> relatedNews) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageUrl;
        this.relatedNews = relatedNews;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public int getImageResourceId()
    {
        return imageResourceId;
    }

    public List<NewsDataModel> getRelatedNews() {
        return  relatedNews;
    }

}
