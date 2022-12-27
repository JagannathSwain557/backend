package com.techimaginia.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.techimaginia.ExcelReadWrite.UploadFileFromExcel;
import com.techimaginia.dao.EmpRepository;
import com.techimaginia.dto.EmpDto;
import com.techimaginia.entity.EmpEntity;
import com.techimaginia.service.EmpService;




@RestController

public class EmpController {
	@Autowired
	EmpService empService;
	@PostMapping(value="/Emp",
				consumes= {"application/xml","application/json"}
				)
	public ResponseEntity<EmpEntity> CreateEmp(@RequestBody EmpDto id) throws ParseException{
	 EmpEntity stu=empService.createProduct(id);
	 return new ResponseEntity<EmpEntity>(stu,HttpStatus.CREATED);
		
	}

	
	@GetMapping("/Employee")  
	public  ResponseEntity<List<EmpEntity>> getAllEmp()   
	{  
		 return new ResponseEntity<List<EmpEntity>>( empService.getAllEmployees(),HttpStatus.CREATED);
	} 
	@GetMapping("/Emp/{id}")  
	public ResponseEntity<EmpEntity> getEmpById(@PathVariable("id") int empId)   
	{ 
		return new ResponseEntity<EmpEntity>(empService.getEmployeeById(empId),HttpStatus.CREATED);
	}   
	@DeleteMapping("/Emp/{id}")  
	public void deleteEmpById(@PathVariable("id") int empId)   
	{  
		empService.deleteEmp(empId);
		  
	}   
	@PutMapping("/EmpUpdate")  
	public ResponseEntity<EmpEntity> saveEmpById(@RequestBody EmpDto empId) throws ParseException   
	{  
		EmpEntity empEntity=empService.updateEmployee(empId);  
		return new ResponseEntity<EmpEntity>(empEntity,HttpStatus.CREATED); 
	}   
	@GetMapping("/EmpSort")  
	public ResponseEntity<List<EmpEntity>> AscendingSortByallEmp()   
	{  
		return new ResponseEntity<List<EmpEntity>>( empService.allEmpSort(),HttpStatus.CREATED);
	
	} 
	 @GetMapping("/download")
	  public ResponseEntity<Resource> downloadEmp() {
		
	    String filename = "Emp.xlsx";
	    InputStreamResource file = new InputStreamResource(empService.load());

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
	        .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	        .body(file);
	  }
  
	 @PostMapping("/upload")
	 public ResponseEntity<ArrayList<EmpEntity>> UploadFile(@RequestParam("file")  MultipartFile file) throws IOException
	 {
		 ArrayList<EmpEntity> emp=empService.saveInDataBase(file);
		return new ResponseEntity<ArrayList<EmpEntity>>(emp,HttpStatus.CREATED); 
		//return new ResponseEntity<EmpEntity>(empService.saveInDataBase(file),HttpStatus.CREATED); 
	 }
}
