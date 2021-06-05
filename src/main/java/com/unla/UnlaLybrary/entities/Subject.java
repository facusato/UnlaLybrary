package com.unla.UnlaLybrary.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSubject;
	
	@Column(name="name")
	private String name;
	
	//lado propietario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="career_id", nullable=false)
	private Career career;
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy="subject")
	private Set<File> files = new HashSet<File>();

	public Subject() {}

	

	public Subject(long idSubject, String name, Career career) {
		this.idSubject = idSubject;
		this.name = name;
		this.career = career;
	}



	public Subject(String name, Career career) {
		super();
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



	public Career getCareer() {
		return career;
	}



	public void setCareer(Career career) {
		this.career = career;
	}



	public Set<File> getFiles() {
		return files;
	}



	public void setFiles(Set<File> files) {
		this.files = files;
	}
	
}
