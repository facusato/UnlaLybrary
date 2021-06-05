package com.unla.UnlaLybrary.models;

public class FileModel {
	
	private long idFile;
	
	private String name;
	
	private SubjectModel subject;
	
	public FileModel() {}
	
	

	public FileModel(long idFile, String name, SubjectModel subject) {
		this.setIdFile(idFile);
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

	public SubjectModel getSubject() {
		return subject;
	}

	public void setSubject(SubjectModel subject) {
		this.subject = subject;
	}
	
	
	
	

}
