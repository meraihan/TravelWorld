package com.brainstation.socialmedia.TravelWorld.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Posts {
    private Integer id;
    private String post;
    private Status status;
    private User user;
    private Area area;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


    public enum Status{
        PUBLIC, PRIVATE
    }
}