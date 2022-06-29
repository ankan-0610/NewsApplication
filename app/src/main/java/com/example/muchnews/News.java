package com.example.muchnews;

public class News {
    private String urlToImage;
    private String title;
    private String description;
    private String author;
    private String publishedAt;
    private String url;

    public News(String urlToImage, String title, String description, String author, String publishedAt, String url) {
        this.urlToImage = urlToImage;
        this.title = title;
        this.description = description;
        this.author = author;
        this.publishedAt = publishedAt;
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
