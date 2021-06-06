package com.unla.UnlaLybrary.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="file")
public class File {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFile;
	
	@Column(name="name")
	private String name;

	
	//lado propietario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="subject_id", nullable=false)
	private Subject subject;

	public File() {
	}
	
	public File(long idFile,String name, Subject subject) {
		this.idFile=idFile;
		this.name = name;
		this.subject = subject;
	}

	public File(String name, Subject subject) {
		this.name = name;
		this.subject = subject;
	}

	public long getIdFile() {
		return idFile;
	}

	public void setIdFile(long idFile) {
		this.idFile = idFile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
