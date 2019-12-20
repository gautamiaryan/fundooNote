package com.bridgelabz.fundoo.model;

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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="label_details")
@Getter
@Setter
public class Label {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="label_id")
	private Integer labelId;
	
	@Column(name="label_name")
	private String name;
	
	@Column(name="user_id")
    private Integer user_id;
	
	@JoinColumn(name="user_id")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="note_label",joinColumns = {@JoinColumn(name="label_id")},inverseJoinColumns = {@JoinColumn(name="note_id")})
    private List<Note> noteList;
    
}
