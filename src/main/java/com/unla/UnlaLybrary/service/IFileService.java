package com.unla.UnlaLybrary.service;

import java.util.List;

import com.unla.UnlaLybrary.entities.File;
import com.unla.UnlaLybrary.models.FileModel;

public interface IFileService {
	
	public List<File> getAll();

    public List<FileModel> getAlls();

	public FileModel findByIdFile(long idFile);
	
	public FileModel findByName(String name);
	
	public FileModel insert(FileModel fileModel);
	
	public FileModel update(FileModel fileModel);
	
	public boolean remove(long id);
	
	public List<FileModel> findByIdSubject(long idSubject);
	

}
