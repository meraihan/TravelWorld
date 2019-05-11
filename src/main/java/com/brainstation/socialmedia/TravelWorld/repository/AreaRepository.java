package com.brainstation.socialmedia.TravelWorld.repository;

import com.brainstation.socialmedia.TravelWorld.model.Area;
import com.brainstation.socialmedia.TravelWorld.model.User;
import com.brainstation.socialmedia.TravelWorld.model.rowmapper.AreaRowMapper;
import com.brainstation.socialmedia.TravelWorld.model.rowmapper.UserRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class AreaRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Area> findAll() {
        List<Area> areas;
        String query = "Select * from area";
        try {
            areas = jdbcTemplate.query(query, new AreaRowMapper());
            return areas;
        } catch (DataAccessException dae) {
            log.error("An exception occurred when executing the following query:");
            log.error(query);
            log.error(dae.getLocalizedMessage());
        }
        return new ArrayList<>();
    }
}