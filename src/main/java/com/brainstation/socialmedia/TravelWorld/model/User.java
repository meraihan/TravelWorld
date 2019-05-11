package com.brainstation.socialmedia.TravelWorld.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
	private Integer id;
	private String fullName;
	private String userName;
	private String password;
	private String email;
	private String role;
	private int age;
	private Gender gender;
	private String address;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;

	public enum Gender{
		MALE, FEMALE, OTHER
	}

}
