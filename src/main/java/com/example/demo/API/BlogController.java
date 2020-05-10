package com.example.demo.API;

import com.example.demo.Models.Blog;
import com.example.demo.Services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RequestMapping("api/v1/blogs")
@RestController
public class BlogController {
    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> getAll() {
        return blogService.getAll();
    }

    @PostMapping
    public int addBlog(@RequestBody Blog blog) {
        return blogService.addBlog(blog);
    }

    @GetMapping(path = "{id}")
    public Blog getBlog(@PathVariable("id") UUID id) {
        return blogService.getBlog(id);
    }

    @DeleteMapping(path ="{id}")
    public int deleteBlog(@PathVariable("id") UUID id) {
        return blogService.deleteBlog(id);
    }

    @PutMapping(path = "{id}")
    public int updateBlog(@PathVariable("id") UUID id, @RequestBody Blog newBlog) {
        return blogService.updateBlog(id, newBlog);
    }

}
