package com.example.PaintballTracker.model;

public class Blog {

    private int blogID;
    private String blogName;
    private String blogContent;

    public Blog() {}

    public Blog (int blogID, String blogName, String blogContent) {
        this.blogID = blogID;
        this.blogName = blogName;
        this.blogContent = blogContent;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}