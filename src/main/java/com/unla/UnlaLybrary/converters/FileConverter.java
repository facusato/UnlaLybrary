package com.unla.UnlaLybrary.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.unla.UnlaLybrary.entities.File;
import com.unla.UnlaLybrary.models.FileModel;

@Component("fileConverter")
public class FileConverter {
	
	@Autowired()
	@Qualifier("subjectConverter")
	private SubjectConverter subjectConverter;
	
	public FileModel entityToModel(File file) {
		return new FileModel(file.getIdFile(),file.getName(),subjectConverter.entityToModel(file.getSubject()));
	}

	public File modelToEntity(FileModel fileModel) {
		return new File(fileModel.getIdFile(),fileModel.getName(),subjectConverter.modelToEntity(fileModel.getSubject()));
	}

}
