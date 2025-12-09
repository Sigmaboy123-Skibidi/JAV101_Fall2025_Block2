package com.abcnews.entity;

import java.util.Date;

public class News {
    private int id;
    private String title;
    private String image;
    private String content;
    private Date postedDate;
    private int categoryId;
    private int viewCount; // Thêm để dùng cho top view

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Date getPostedDate() { return postedDate; }
    public void setPostedDate(Date postedDate) { this.postedDate = postedDate; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public int getViewCount() { return viewCount; }
    public void setViewCount(int viewCount) { this.viewCount = viewCount; }
}
