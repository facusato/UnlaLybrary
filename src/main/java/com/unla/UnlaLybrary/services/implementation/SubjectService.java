package com.unla.UnlaLybrary.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.UnlaLybrary.converters.SubjectConverter;
import com.unla.UnlaLybrary.entities.Subject;
import com.unla.UnlaLybrary.models.SubjectModel;
import com.unla.UnlaLybrary.repositories.ISubjectRepository;
import com.unla.UnlaLybrary.service.ICareerService;
import com.unla.UnlaLybrary.service.ISubjectService;

@Service("subjectService")
public class SubjectService implements ISubjectService {
	
	@Autowired
	@Qualifier("careerService")
	private ICareerService careerService;
	
	@Autowired
	@Qualifier("subjectConverter")
	private SubjectConverter subjectConverter;
	
	@Autowired
	@Qualifier("subjectRepository")
	private ISubjectRepository subjectRepository;
	
	@Override
	public List<Subject> getAll() {
		return subjectRepository.findAll();
	}

	
	@Override
	public SubjectModel insert(SubjectModel subjectModel) {
		subjectModel.setCareer(careerService.findByIdCareer(subjectModel.getCareer().getIdCareer()));
		Subject subject= subjectRepository.save(subjectConverter.modelToEntity(subjectModel));
		return subjectConverter.entityToModel(subject);
	}
	
	@Override
	public SubjectModel update(SubjectModel subjectModel) {
		subjectModel.setCareer(careerService.findByIdCareer(subjectModel.getCareer().getIdCareer()));
		Subject subject= subjectRepository.save(subjectConverter.modelToEntity(subjectModel));
		return subjectConverter.entityToModel(subject);
	}
	
	@Override
	public List<SubjectModel> getAlls() {
		List<SubjectModel> models = new ArrayList<SubjectModel>();
		for (Subject subject: subjectRepository.findAll()) {
			models.add(subjectConverter.entityToModel(subject));
		}
		return models;
	}

	@Override
	public List<SubjectModel> findByIdCareer(long idCareer) {
		List<SubjectModel> models = new ArrayList<SubjectModel>();
		for (Subject subject : subjectRepository.findByIdCareer(idCareer)) {
			models.add(subjectConverter.entityToModel(subject));
		}
		return models;
	}
	

	@Override
	public boolean remove(long idSubject) {
		try {
			subjectRepository.deleteById(idSubject);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public SubjectModel findByIdSubject(long idSubject) {
		return subjectConverter.entityToModel(subjectRepository.findByIdSubject(idSubject));
	}

	@Override
	public SubjectModel findByName(String name) {
		return subjectConverter.entityToModel(subjectRepository.findByName(name));
	}
	

}


