package com.unla.UnlaLybrary.service;

import com.unla.UnlaLybrary.entities.University;
import com.unla.UnlaLybrary.models.UniversityModel;

import java.util.*;

public interface IUniversityService {
	
    public List<University> getAll();

    public List<UniversityModel> getAlls();

	public UniversityModel findById(long id);
	
	public UniversityModel findByName(String name);
	
	public UniversityModel insert(UniversityModel universityModel);
	
	public UniversityModel update(UniversityModel universityModel);
	
	public boolean remove(long id);
	
	
}