package com.unla.UnlaLybrary.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.unla.UnlaLybrary.entities.Career;

@Repository("careerRepository")
public interface ICareerRepository extends JpaRepository<Career, Serializable> {
	
	public abstract Career findByIdCareer(long idCareer);
	
	public abstract Career findByName(String name);
	
	//Consulta que trae una lista de carreras con ese id de Universidad
	@Query("SELECT c FROM Career c JOIN FETCH c.university u WHERE u.id = (:id)")
	public abstract List<Career> findByIdUniversity(long id);
	
	
}