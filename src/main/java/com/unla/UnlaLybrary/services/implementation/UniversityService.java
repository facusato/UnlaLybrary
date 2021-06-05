package com.unla.UnlaLybrary.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.unla.UnlaLybrary.models.UniversityModel;
import com.unla.UnlaLybrary.converters.UniversityConverter;
import com.unla.UnlaLybrary.entities.University;
import com.unla.UnlaLybrary.repositories.IUniversityRepository;
import com.unla.UnlaLybrary.service.IUniversityService;

import java.util.*;


@Service("universityService")
public class UniversityService implements IUniversityService {

		@Autowired
		@Qualifier("universityRepository")
		private IUniversityRepository universityRepository;
		
		@Autowired
		@Qualifier("universityConverter")
		private UniversityConverter universityConverter;
		
		@Override
		public List<University> getAll() {
			return universityRepository.findAll();
		}

		@Override
		public UniversityModel insert(UniversityModel universityModel) {
			University university= universityRepository.save(universityConverter.modelToEntity(universityModel));
			return universityConverter.entityToModel(university);
		}
		
		@Override
		public UniversityModel update(UniversityModel universityModel) {
			University university= universityRepository.save(universityConverter.modelToEntity(universityModel));
			return universityConverter.entityToModel(university);
		}
		
		@Override
		public List<UniversityModel> getAlls() {
			List<UniversityModel> models = new ArrayList<UniversityModel>();
			for (University university: universityRepository.findAll()) {
				models.add(universityConverter.entityToModel(university));
			}
			return models;
		}

		@Override
		public boolean remove(long id) {
			try {
				universityRepository.deleteById(id);
				return true;
			}catch (Exception e) {
				return false;
			}
		}

		@Override
		public UniversityModel findById(long id) {
			return universityConverter.entityToModel(universityRepository.findById(id));
		}

		@Override
		public UniversityModel findByName(String name) {
			return universityConverter.entityToModel(universityRepository.findByName(name));
		}
		
	

}