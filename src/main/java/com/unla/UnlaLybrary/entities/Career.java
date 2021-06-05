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
@Table(name="career")
public class Career {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCareer;
	
	@Column(name="name")
	private String name;
	
	//lado propietario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="university_id", nullable=false)
	private University university;
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy="career")
	private Set<Subject> subjects = new HashSet<Subject>();
		
	public Career() {}

	public Career(long idCareer, String name, University university) {
			this.idCareer = idCareer;
			this.name = name;
			this.university = university;
	}

	public Career(String name, University university) {
			super();
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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
		
		

}
