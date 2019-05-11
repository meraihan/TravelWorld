package com.brainstation.socialmedia.TravelWorld.model.rowmapper;

import com.brainstation.socialmedia.TravelWorld.model.Area;
import com.brainstation.socialmedia.TravelWorld.utils.Helper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaRowMapper implements RowMapper<Area> {
    @Override
    public Area mapRow(ResultSet resultSet, int i) throws SQLException {
        Area area = new Area();
        area.setId(resultSet.getInt("id"));
        area.setLocation(resultSet.getString("location"));
        area.setCreatedAt(Helper.timeStampToLocalDateTime(resultSet.getTimestamp("created_at")));
        area.setUpdatedAt(Helper.timeStampToLocalDateTime(resultSet.getTimestamp("updated_at")));
        area.setDeletedAt(Helper.timeStampToLocalDateTime(resultSet.getTimestamp("deleted_at")));
        return area;
    }
}