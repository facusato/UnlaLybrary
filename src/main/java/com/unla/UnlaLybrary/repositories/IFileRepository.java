package com.unla.UnlaLybrary.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.unla.UnlaLybrary.entities.File;

@Repository("fileRepository")
public interface IFileRepository extends JpaRepository<File, Serializable> {
	
	public abstract File findByIdFile(long idFile);
	
	public abstract File findByName(String name);
	
	//Consulta que trae una lista de apuntes con ese id de materia
	@Query("SELECT f FROM File f JOIN FETCH f.subject s WHERE s.idSubject = (:idSubject)")
	public abstract List<File> findByIdSubject(long idSubject);
	
	
}