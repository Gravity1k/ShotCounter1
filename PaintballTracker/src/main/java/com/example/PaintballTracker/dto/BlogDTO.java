package com.example.PaintballTracker.dto;

import com.example.PaintballTracker.model.Blog;

import java.util.List;

public interface BlogDTO {

    List<Blog> getBlogs();

    Blog getBlogById(int id);

}