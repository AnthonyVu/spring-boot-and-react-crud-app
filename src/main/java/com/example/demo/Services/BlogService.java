package com.example.demo.Services;

import com.example.demo.DAO.BlogDAO;
import com.example.demo.Models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlogService {
    private BlogDAO blogDAO;

    @Autowired
    public BlogService(@Qualifier("postgres") BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }

    public int addBlog(Blog blog) {
        return blogDAO.insertBlog(blog);
    }

    public List<Blog> getAll() {
        return blogDAO.getAll();
    }

    public Blog getBlog(UUID id) {
        return blogDAO.getBlog(id).orElse(null);
    }

    public int deleteBlog(UUID id) {
        return blogDAO.deleteBlog(id);
    }

    public int updateBlog(UUID id, Blog newBlog) {
        return blogDAO.updateBlog(id, newBlog);
    }
}
