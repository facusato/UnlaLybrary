package com.unla.UnlaLybrary.models;


public class UniversityModel {

	
	private long id;
	private String name;
	
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
}
