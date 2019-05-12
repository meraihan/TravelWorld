package com.brainstation.socialmedia.TravelWorld.model;

import lombok.Data;

import java.util.Date;

@Data
public class Area {
    private Integer id;
    private String location;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}