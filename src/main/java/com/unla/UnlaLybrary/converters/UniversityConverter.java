package com.unla.UnlaLybrary.converters;

import org.springframework.stereotype.Component;

import com.unla.UnlaLybrary.entities.University;
import com.unla.UnlaLybrary.models.UniversityModel;

@Component("universityConverter")
public class UniversityConverter {

	public UniversityModel entityToModel(University university) {
		return new UniversityModel(university.getId(), university.getName());
	}

	public University modelToEntity(UniversityModel universityModel) {
		return new University(universityModel.getId(), universityModel.getName());
	}
}