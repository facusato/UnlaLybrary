package com.unla.UnlaLybrary.repositories;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
	
import org.springframework.stereotype.Repository;

import com.unla.UnlaLybrary.entities.University;

	@Repository("universityRepository")
	public interface IUniversityRepository extends JpaRepository<University, Serializable> {
		
		public abstract University findById(long id);
		
		public abstract University findByName(String name);
		
		
	}