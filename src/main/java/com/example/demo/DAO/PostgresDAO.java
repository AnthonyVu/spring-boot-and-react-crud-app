package com.example.demo.DAO;

import com.example.demo.Models.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PostgresDAO implements BlogDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertBlog(UUID id, Blog blog) {
        String sql = "insert into blog values(?,?,?,?,?)";
        return jdbcTemplate.update(sql, id, blog.getTitle(), blog.getAuthor(), blog.getUrl(), blog.getLikes());
    }

    @Override
    public List<Blog> getAll() {
        String sql = "select * from blog";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String url = resultSet.getString("url");
            int likes = resultSet.getInt("likes");
            return new Blog(id, title, author, url, likes);
        });
    }

    @Override
    public Optional<Blog> getBlog(UUID id) {
        String sql = "select * from blog where id = ?";
        Blog blog = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID blog_id = UUID.fromString(resultSet.getString("id"));
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String url = resultSet.getString("url");
            int likes = resultSet.getInt("likes");
            return new Blog(blog_id, title, author, url, likes);
        });
        return Optional.ofNullable(blog);
    }

    @Override
    public int deleteBlog(UUID id) {
        String sql = "delete from blog where id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateBlog(UUID id, Blog newBlog) {
        String sql = "update blog set title = ?, author = ?, url = ?, likes = ? where id = ?";
        return jdbcTemplate.update(sql, newBlog.getTitle(), newBlog.getAuthor(), newBlog.getUrl(), newBlog.getLikes(), id);
    }
}
