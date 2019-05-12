package com.brainstation.socialmedia.TravelWorld.model.rowmapper;

import com.brainstation.socialmedia.TravelWorld.model.Area;
import com.brainstation.socialmedia.TravelWorld.model.Posts;
import com.brainstation.socialmedia.TravelWorld.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostsRowMapper implements RowMapper<Posts> {

    @Override
    public Posts mapRow(ResultSet resultSet, int i) throws SQLException {
        Posts posts = new Posts();
        posts.setId(resultSet.getInt("id"));
        posts.setPost(resultSet.getString("post"));
        posts.setStatus(Posts.Status.valueOf(resultSet.getString("status")));
        Area area = new Area();
        area.setId(resultSet.getInt("location_id"));
        posts.setArea(area);
        User user = new User();
        user.setId(resultSet.getInt("user_id"));
        posts.setUser(user);
        posts.setCreatedAt(resultSet.getDate("created_at"));
        posts.setUpdatedAt(resultSet.getDate("updated_at"));
        posts.setDeletedAt(resultSet.getDate("deleted_at"));
        return posts;
    }
}