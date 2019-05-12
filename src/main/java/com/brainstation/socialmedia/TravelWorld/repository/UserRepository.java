package com.brainstation.socialmedia.TravelWorld.repository;

import com.brainstation.socialmedia.TravelWorld.model.User;
import com.brainstation.socialmedia.TravelWorld.model.rowmapper.UserRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByUsername(String username) {
        User user;
        String query = "Select * from user where user_name like ? order by id desc limit 1";

        try {
            user = jdbcTemplate.queryForObject(query, new Object[] {username}, new UserRowMapper());
            return user;
        } catch (DataAccessException dae) {
            log.error("An exception occurred when executing the following query:");
            log.error(query.replace("?", username));
            log.error(dae.getLocalizedMessage());
        }
        return new User();
    }


    public List<User> findAll() {
        String query = "Select * from user";
        try {
            return jdbcTemplate.query(query, new UserRowMapper());
        } catch (DataAccessException dae) {
            log.error("An exception occurred when executing the following query:");
            log.error(query);
            log.error(dae.getLocalizedMessage());
        }
        return new ArrayList<>();
    }

    public User add(User user) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("user")
                .usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("full_name", user.getFullName());
        parameters.put("user_name", user.getUserName());
        parameters.put("password", user.getPassword());
        parameters.put("email", user.getEmail());
        parameters.put("is_active", user.getIsActive());
        parameters.put("role", user.getRole());
        parameters.put("age", user.getAge());
        parameters.put("gender", user.getGender().name());
        parameters.put("address", user.getAddress());
        parameters.put("created_at", new Date());
        parameters.put("updated_at", new Date());
        parameters.put("deleted_at", new Date());
        Number id = simpleJdbcInsert.executeAndReturnKey(parameters);
        if (id == null) {
            log.error("Failed to insert {}", user);
            return null;
        }
        user.setId(id.intValue());
        return user;
    }
}