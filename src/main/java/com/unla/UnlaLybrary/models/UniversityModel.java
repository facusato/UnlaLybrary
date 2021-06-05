package com.unla.UnlaLybrary.models;

import java.util.HashSet;
import java.util.Set;

import com.unla.UnlaLybrary.entities.Career;

public class UniversityModel {

	
	private long id;
	private String name;
	private Set<Career> careers = new HashSet<Career>();
	
	public UniversityModel() {}
	
	public UniversityModel(long id, String name) {
		this.setId(id);
		this.name = name;
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Career> getCareers() {
		return careers;
	}

	public void setCareers(Set<Career> careers) {
		this.careers = careers;
	}
	
	
}
