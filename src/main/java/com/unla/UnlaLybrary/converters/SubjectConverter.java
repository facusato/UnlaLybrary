package com.unla.UnlaLybrary.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.unla.UnlaLybrary.entities.Subject;
import com.unla.UnlaLybrary.models.SubjectModel;

@Component("subjectConverter")
public class SubjectConverter {
	
	@Autowired()
	@Qualifier("careerConverter")
	private CareerConverter careerConverter;
	
	public SubjectModel entityToModel(Subject subject) {
		return new SubjectModel(subject.getIdSubject(),subject.getName(),careerConverter.entityToModel(subject.getCareer()));
	}

	public Subject modelToEntity(SubjectModel subjectModel) {
		return new Subject(subjectModel.getIdSubject(),subjectModel.getName(),careerConverter.modelToEntity(subjectModel.getCareer()));
	}

}
