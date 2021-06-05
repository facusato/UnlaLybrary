package com.unla.UnlaLybrary.entities;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="university")
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="university")
	private Set<Career> careers = new HashSet<Career>();

	public University() {}
	
	public University(long id, String name) {
		this.id = id;
		this.name = name;
		
	}
	
	public University( String name) {
		this.name = name;
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Career> getCareers() {
		return careers;
	}

	public void setCareers(Set<Career> careers) {
		this.careers = careers;
	}
	
}
