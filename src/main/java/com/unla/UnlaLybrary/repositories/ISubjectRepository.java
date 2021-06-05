package com.unla.UnlaLybrary.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.UnlaLybrary.entities.Subject;

@Repository("subjectRepository")
public interface ISubjectRepository extends JpaRepository<Subject, Serializable> {
	
	public abstract Subject findByIdSubject(long idSubject);
	
	public abstract Subject findByName(String name);
	
	//Consulta que trae una lista de materias con ese id de Carrera
	@Query("SELECT s FROM Subject s JOIN FETCH s.career c WHERE c.idCareer = (:idCareer)")
	public abstract List<Subject> findByIdCareer(long idCareer);
	
	
}