package com.bridgelabz.fundoo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name="user3")
@Data
public class User {
       
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column(unique=true)
	private String emailId;
	
	@Column
	private String password;

	@Column(unique=true)
	private Long mobileNumber;
	
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean status;
	
	@Column
	private LocalDateTime createdStamp;
	
	@Column
	private LocalDateTime updatedStamp;

	public User(String firstName, String lastName, String emailId, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
	}
	
}
