package com.brainstation.socialmedia.TravelWorld.repository;

import com.brainstation.socialmedia.TravelWorld.model.Posts;
import com.brainstation.socialmedia.TravelWorld.model.rowmapper.PostsRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class PostRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Posts add(Posts posts) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("posts")
                .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("post", posts.getPost());
        parameters.put("status", posts.getStatus().name());
        parameters.put("user_id", posts.getUser().getId());
        parameters.put("location_id", posts.getArea().getId());

        Number id = simpleJdbcInsert.executeAndReturnKey(parameters);
        if (id == null) {
            log.error("Failed to insert {}", posts);
            return null;
        }
        posts.setId(id.intValue());
        return posts;
    }


    public Posts findPostByUserId(int userId) {
        String query = "SELECT * FROM posts \n" +
                "WHERE user_id = ?";
        try{
            return jdbcTemplate.queryForObject(query,new Object[]{userId},new PostsRowMapper());
        }catch (DataAccessException dae){
            log.error("Post Not Found, Error: {}",dae.getLocalizedMessage());
            return new Posts();
        }
    }

    public List<Posts> findAll() {
        String query = "Select * from posts";
        try {
            return jdbcTemplate.query(query, new PostsRowMapper());
        } catch (DataAccessException dae) {
            log.error("An exception occurred when executing the following query:");
            log.error(query);
            log.error(dae.getLocalizedMessage());
        }
        return new ArrayList<>();
    }

    public boolean delete(Integer postId) {
        log.info("Deleting Posts Of PostId: {} ", postId);
        try {
            return jdbcTemplate.update("DELETE FROM posts WHERE id = ?", postId) == 1;
        } catch (DataAccessException dae) {
            log.error("Error : {} Deleting Posts id: {} " , dae.getLocalizedMessage(), postId);
        }
        return false;
    }

    public boolean update(Posts posts) {
        String query = "UPDATE posts SET  post = ?, status = ?, location_id=?,  updated_at = ? WHERE id = ?";
        try {
            return jdbcTemplate.update(query, posts.getPost(),posts.getStatus(), posts.getArea().getId(),
                    posts.getUpdatedAt() , posts.getId()) == 1;
        } catch (DataAccessException e) {
            log.error("Update failed for post: {}. Error: {}", posts, e.getLocalizedMessage());
            return false;
        }
    }

}