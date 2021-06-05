package com.unla.UnlaLybrary.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.UnlaLybrary.entities.Career;
import com.unla.UnlaLybrary.models.CareerModel;

@Component("careerConverter")
public class CareerConverter {
	
	@Autowired()
	@Qualifier("universityConverter")
	private UniversityConverter universityConverter;
	
	public CareerModel entityToModel(Career career) {
		return new CareerModel(career.getIdCareer(),career.getName(),universityConverter.entityToModel(career.getUniversity()));
	}

	public Career modelToEntity(CareerModel careerModel) {
		return new Career(careerModel.getIdCareer(),careerModel.getName(),universityConverter.modelToEntity(careerModel.getUniversity()));
	}

}
