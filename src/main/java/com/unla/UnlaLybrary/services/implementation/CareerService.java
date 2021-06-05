package com.unla.UnlaLybrary.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.UnlaLybrary.converters.CareerConverter;
import com.unla.UnlaLybrary.entities.Career;
import com.unla.UnlaLybrary.models.CareerModel;
import com.unla.UnlaLybrary.repositories.ICareerRepository;
import com.unla.UnlaLybrary.service.ICareerService;
import com.unla.UnlaLybrary.service.IUniversityService;

@Service("careerService")
public class CareerService implements ICareerService {
	
	@Autowired
	@Qualifier("universityService")
	private IUniversityService universityService;
	
	@Autowired
	@Qualifier("careerRepository")
	private ICareerRepository careerRepository;
	
	@Autowired
	@Qualifier("careerConverter")
	private CareerConverter careerConverter;
	
	@Override
	public List<Career> getAll() {
		return careerRepository.findAll();
	}

	
	@Override
	public CareerModel insert(CareerModel careerModel) {
		careerModel.setUniversity(universityService.findById(careerModel.getUniversity().getId()));
		Career career= careerRepository.save(careerConverter.modelToEntity(careerModel));
		return careerConverter.entityToModel(career);
	}
	
	@Override
	public CareerModel update(CareerModel careerModel) {
		careerModel.setUniversity(universityService.findById(careerModel.getUniversity().getId()));
		Career career= careerRepository.save(careerConverter.modelToEntity(careerModel));
		return careerConverter.entityToModel(career);
	}
	
	@Override
	public List<CareerModel> getAlls() {
		List<CareerModel> models = new ArrayList<CareerModel>();
		for (Career career: careerRepository.findAll()) {
			models.add(careerConverter.entityToModel(career));
		}
		return models;
	}

	@Override
	public List<CareerModel> findByIdUniversity(long id) {
		List<CareerModel> models = new ArrayList<CareerModel>();
		for (Career career : careerRepository.findByIdUniversity(id)) {
			models.add(careerConverter.entityToModel(career));
		}
		return models;
	}
	
	
	
	
	@Override
	public boolean remove(long idCareer) {
		try {
			careerRepository.deleteById(idCareer);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public CareerModel findByIdCareer(long idCareer) {
		return careerConverter.entityToModel(careerRepository.findByIdCareer(idCareer));
	}

	@Override
	public CareerModel findByName(String name) {
		return careerConverter.entityToModel(careerRepository.findByName(name));
	}
	

}
