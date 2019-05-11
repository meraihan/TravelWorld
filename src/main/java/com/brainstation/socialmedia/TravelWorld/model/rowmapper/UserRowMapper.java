package com.brainstation.socialmedia.TravelWorld.model.rowmapper;

import com.brainstation.socialmedia.TravelWorld.model.User;
import com.brainstation.socialmedia.TravelWorld.utils.Helper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setFullName(resultSet.getString("full_name"));
        user.setUserName(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setRole(User.Role.valueOf(resultSet.getString("role")));
        user.setGender(User.Gender.valueOf(resultSet.getString("gender")));
        user.setAddress(resultSet.getString("address"));
        user.setCreatedAt(Helper.timeStampToLocalDateTime(resultSet.getTimestamp("created_at")));
        user.setUpdatedAt(Helper.timeStampToLocalDateTime(resultSet.getTimestamp("updated_at")));
        user.setDeletedAt(Helper.timeStampToLocalDateTime(resultSet.getTimestamp("deleted_at")));
        return user;
    }

}