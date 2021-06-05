package com.unla.UnlaLybrary.service;

import java.util.List;
import com.unla.UnlaLybrary.entities.Career;
import com.unla.UnlaLybrary.models.CareerModel;

public interface ICareerService {
	
	public List<Career> getAll();

    public List<CareerModel> getAlls();

	public CareerModel findByIdCareer(long idCareer);
	
	public CareerModel findByName(String name);
	
	public CareerModel insert(CareerModel careerModel);
	
	public CareerModel update(CareerModel careerModel);
	
	public boolean remove(long id);
	
	public List<CareerModel> findByIdUniversity(long id);
	
}
