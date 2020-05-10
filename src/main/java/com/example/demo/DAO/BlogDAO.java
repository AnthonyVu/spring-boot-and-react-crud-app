package com.example.demo.DAO;

import com.example.demo.Models.Blog;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BlogDAO {
    int insertBlog(UUID id, Blog blog);
    default int insertBlog(Blog blog) {
        UUID id = UUID.randomUUID();
        return insertBlog(id, blog);
    }
    List<Blog> getAll();
    Optional<Blog> getBlog(UUID id);
    int deleteBlog(UUID id);
    int updateBlog(UUID id, Blog newBlog);
}
