package com.unla.UnlaLybrary.service;

import java.util.List;

import com.unla.UnlaLybrary.entities.Subject;
import com.unla.UnlaLybrary.models.SubjectModel;

public interface ISubjectService {
	
	public List<Subject> getAll();

    public List<SubjectModel> getAlls();

	public SubjectModel findByIdSubject(long idSubject);
	
	public SubjectModel findByName(String name);
	
	public SubjectModel insert(SubjectModel subjectModel);
	
	public SubjectModel update(SubjectModel subjectModel);
	
	public boolean remove(long idSubject);
	
	public List<SubjectModel> findByIdCareer(long idCareer);
	
}