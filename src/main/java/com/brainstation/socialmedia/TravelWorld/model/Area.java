package com.brainstation.socialmedia.TravelWorld.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Area {
    private Integer id;
    private String location;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}