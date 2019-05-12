package com.brainstation.socialmedia.TravelWorld.model.rowmapper;

import com.brainstation.socialmedia.TravelWorld.model.Area;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaRowMapper implements RowMapper<Area> {
    @Override
    public Area mapRow(ResultSet resultSet, int i) throws SQLException {
        Area area = new Area();
        area.setId(resultSet.getInt("id"));
        area.setLocation(resultSet.getString("location"));
        area.setCreatedAt(resultSet.getDate("created_at"));
        area.setUpdatedAt(resultSet.getDate("updated_at"));
        area.setDeletedAt(resultSet.getDate("deleted_at"));
        return area;
    }
}