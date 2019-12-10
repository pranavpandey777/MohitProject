package com.example.newsapp;


public class Model {

    String title;
    String urlToImage;
    String content;
    String url;

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getContent() {
        return content;
    }

    public Model(String title, String urlToImage, String content, String url) {

        this.title = title;
        this.urlToImage = urlToImage;
        this.content = content;
        this.url = url;
    }
}
