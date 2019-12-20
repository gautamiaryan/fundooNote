package com.bridgelabz.fundoo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="note_Details")
@Getter
@Setter
public class Note {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="note_id")
	private Integer id;
	
	@Column(name="note_title")
	private String title;
	
	@Column(name="note_description")
	private String description;
	
	@Column(name="note_trash",nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isTrashed;
	
	@Column(name="note_pin",nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isPinned;
	
	@Column(name="note_archieve")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isArchieve;
	
	@Column(name="note_color")
	private String color;
	
	@Column(name="note_remainder")
	private LocalDateTime remainder;
	
	@Column(name="note_createdtime")
	private LocalDateTime createdStamp;
	
	@Column(name="note_updatedtime")
	private LocalDateTime updatedStamp;
	
	
	@Column(name="user_id")
	private Long userId;
	
	@JoinColumn(name="user_id")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="note_label",joinColumns = {@JoinColumn(name="note_id")},inverseJoinColumns = {@JoinColumn(name="label_id")})
	private List<Label> labelList;
}
