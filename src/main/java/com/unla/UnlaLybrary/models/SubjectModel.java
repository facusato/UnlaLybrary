package com.unla.UnlaLybrary.models;

import java.util.HashSet;
import java.util.Set;
import com.unla.UnlaLybrary.entities.File;

public class SubjectModel {
	
	private long idSubject;
	

	private String name;
	
	private CareerModel career;

	private Set<File> files = new HashSet<File>();

	public SubjectModel() {}

	public SubjectModel(long idSubject, String name, CareerModel career) {
		this.setIdSubject(idSubject);
		this.name = name;
		this.career = career;
	}

	public long getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(long idSubject) {
		this.idSubject = idSubject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CareerModel getCareer() {
		return career;
	}

	public void setCareer(CareerModel career) {
		this.career = career;
	}

	public Set<File> getFiles() {
		return files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}
	
	
	
	

}
