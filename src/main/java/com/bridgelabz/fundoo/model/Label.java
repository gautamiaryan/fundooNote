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
@Table(name="label_detals")
@Getter
@Setter
public class Label {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column()
	private Integer id;
	
	@Column
	private String name;
	
	@Column
    private Integer user_id;
	
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="note_details",joinColumns = {@JoinColumn(name="id")},inverseJoinColumns = {@JoinColumn(name="id")})
    private List<Note> noteList;
    
}
