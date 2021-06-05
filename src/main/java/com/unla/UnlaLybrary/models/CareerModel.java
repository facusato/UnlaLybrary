package com.unla.UnlaLybrary.models;

import java.util.HashSet;
import java.util.Set;


import com.unla.UnlaLybrary.entities.Subject;


public class CareerModel {
	
	private long idCareer;

	private String name;
	
	private UniversityModel university;
		
	private Set<Subject> subjects = new HashSet<Subject>();
	
	public CareerModel() {}

	public CareerModel(long idCareer, String name, UniversityModel university) {
		this.setIdCareer(idCareer);
		this.name = name;
		this.university = university;
	}

	public long getIdCareer() {
		return idCareer;
	}

	public void setIdCareer(long idCareer) {
		this.idCareer = idCareer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UniversityModel getUniversity() {
		return university;
	}

	public void setUniversity(UniversityModel university) {
		this.university = university;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
}
