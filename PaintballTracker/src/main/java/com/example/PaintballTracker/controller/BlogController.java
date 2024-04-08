package com.example.PaintballTracker.controller;

import com.example.PaintballTracker.dto.BlogDTO;
import com.example.PaintballTracker.model.Blog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final BlogDTO blogDTO;

    public BlogController(BlogDTO blogDTO) {
        this.blogDTO = blogDTO;
    }

    @GetMapping
    public List<Blog> getBlogs() {
        return blogDTO.getBlogs();
    }
}