package com.techimaginia.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techimaginia.dto.EmpDto;
import com.techimaginia.entity.EmpEntity;

public interface EmpRepository extends JpaRepository <EmpEntity,Integer>{

	EmpEntity getById(EmpDto empDto);
	
		 
		
}
