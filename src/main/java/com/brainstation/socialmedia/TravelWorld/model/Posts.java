package com.brainstation.socialmedia.TravelWorld.model;

import lombok.Data;

import java.util.Date;

@Data
public class Posts {
    private Integer id;
    private String post;
    private Status status;
    private User user;
    private Area area;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;


    public enum Status{
        PUBLIC, PRIVATE
    }
}