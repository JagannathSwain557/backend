package com.techimaginia.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.techimaginia.ExcelReadWrite.ExcelReadAndWrite;
import com.techimaginia.ExcelReadWrite.UploadFileFromExcel;
import com.techimaginia.dao.EmpRepository;
import com.techimaginia.dto.EmpDto;
import com.techimaginia.entity.EmpEntity;
import java.util.*;


@Service
public class EmpService {
	   @Autowired
	   private EmpRepository empRepository;
	   public EmpEntity createProduct(EmpDto product) throws ParseException {
		  EmpEntity empEntity=empRepository.save(new EmpEntity(product));
			return empEntity;
	   }
	   
	   public List<EmpEntity> getAllEmployees()   
	   {  
	   List<EmpEntity> empList = new ArrayList<EmpEntity>();  
	   empRepository.findAll().forEach(empAll -> empList.add(empAll));  
	   return empList;  
	   }  
	   public EmpEntity getEmployeeById(int empId)   
	   {  
	   return empRepository.findById(empId).get();  
	   }  
	  public void deleteEmp(int empId)
	  {
		  empRepository.deleteById(empId);
	  }
	  public EmpEntity updateEmployee(EmpDto empDto) throws ParseException   
	   {  
	   EmpEntity EmpEntity=empRepository.save(new EmpEntity(empDto));
	   return EmpEntity;
	   } 
	 public List<EmpEntity> allEmpSort() {
		 List<EmpEntity> listEmp=new ArrayList<EmpEntity>();
		 empRepository.findAll(Sort.by("id").ascending()).forEach(listEmp1->listEmp.add(listEmp1));
		 return listEmp;
	 }

	  public ByteArrayInputStream load() {
		    List<EmpEntity> empList= empRepository.findAll();

		    ByteArrayInputStream  bityArrayInputStream= ExcelReadAndWrite.tutorialsToExcel(empList);
		    return bityArrayInputStream;
		  }
	  public ArrayList<EmpEntity> saveInDataBase(MultipartFile file) throws IOException {
			  ArrayList<EmpEntity> employees=(ArrayList<EmpEntity>) UploadFileFromExcel.excelToEmpEntity(file.getInputStream());
		 empRepository.saveAll(employees);
		return employees;
	  }
}
