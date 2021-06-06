package com.unla.UnlaLybrary.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.UnlaLybrary.converters.FileConverter;
import com.unla.UnlaLybrary.entities.File;
import com.unla.UnlaLybrary.models.FileModel;
import com.unla.UnlaLybrary.repositories.IFileRepository;
import com.unla.UnlaLybrary.service.IFileService;
import com.unla.UnlaLybrary.service.ISubjectService;

@Service("fileService")
public class FileService implements IFileService {

	@Autowired
	@Qualifier("subjectService")
	private ISubjectService subjectService;
	
	@Autowired
	@Qualifier("fileRepository")
	private IFileRepository fileRepository;
	
	@Autowired
	@Qualifier("fileConverter")
	private FileConverter fileConverter;
	
	@Override
	public List<File> getAll() {
		return fileRepository.findAll();
	}

	
	@Override
	public FileModel insert(FileModel fileModel) {
		fileModel.setSubject(subjectService.findByIdSubject(fileModel.getSubject().getIdSubject()));
		File file= fileRepository.save(fileConverter.modelToEntity(fileModel));
		return fileConverter.entityToModel(file);
	}
	
	@Override
	public FileModel update(FileModel fileModel) {
		fileModel.setSubject(subjectService.findByIdSubject(fileModel.getSubject().getIdSubject()));
		File file= fileRepository.save(fileConverter.modelToEntity(fileModel));
		return fileConverter.entityToModel(file);
	}
	
	@Override
	public List<FileModel> getAlls() {
		List<FileModel> models = new ArrayList<FileModel>();
		for (File file: fileRepository.findAll()) {
			models.add(fileConverter.entityToModel(file));
		}
		return models;
	}

	@Override
	public List<FileModel> findByIdSubject(long idSubject) {
		List<FileModel> models = new ArrayList<FileModel>();
		for (File file : fileRepository.findByIdSubject(idSubject)) {
			models.add(fileConverter.entityToModel(file));
		}
		return models;
	}
	
	
	
	
	@Override
	public boolean remove(long idFile) {
		try {
			fileRepository.deleteById(idFile);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public FileModel findByIdFile(long idFile) {
		return fileConverter.entityToModel(fileRepository.findByIdFile(idFile));
	}

	@Override
	public FileModel findByName(String name) {
		return fileConverter.entityToModel(fileRepository.findByName(name));
	}
	

}

