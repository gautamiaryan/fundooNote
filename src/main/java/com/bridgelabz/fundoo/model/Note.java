package com.bridgelabz.fundoo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="noteDetails")
@Getter
@Setter
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isTrashed;
	
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isPinned;
	
	@Column
	private String color;
	
	@Column
	private LocalDateTime remaindMe;
	
	@Column
	private LocalDateTime createdStamp;
	
	@Column
	private LocalDateTime updatedStamp;
	
}
