package com.brainstation.socialmedia.TravelWorld.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
	private Integer id;
	private String fullName;
	private String userName;
	private String password;
	private String email;
	private Role role;
	private int age;
	private Boolean isActive;
	private Gender gender;
	private String address;
	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;

	public enum Gender{
		MALE, FEMALE, OTHER
	}

	public enum Role{
		ADMIN, USER
	}

}
