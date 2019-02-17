package com.example.androiddemo.com.example.news;

public class News {
    private String mTitle;
    private String mContent;

    public News(String title, String content) {
        this.mTitle = title;
        this.mContent = content;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }

}
