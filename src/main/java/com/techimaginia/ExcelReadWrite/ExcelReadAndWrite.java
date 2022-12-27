package com.techimaginia.ExcelReadWrite;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.techimaginia.entity.EmpEntity;

public class ExcelReadAndWrite {
	 public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id", "Name", "Address", "salary" , "deg", "phone", "Branch", "date" };
	  static String SHEET = "Employee";

	  public static ByteArrayInputStream tutorialsToExcel(List<EmpEntity> Emps) {

	    try  {
	    	Workbook workbook = new XSSFWorkbook();
    		ByteArrayOutputStream out = new ByteArrayOutputStream();
	      Sheet sheet = workbook.createSheet(SHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < HEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(HEADERs[col]);
	      }

	      
	      int rowIdx = 1;
	      for (EmpEntity Emp : Emps) {
	        Row row = sheet.createRow(rowIdx++);

	        row.createCell(0).setCellValue(Emp.getId());
	        row.createCell(1).setCellValue(Emp.getName());
	        row.createCell(2).setCellValue(Emp.getAddress());
	        row.createCell(3).setCellValue(Emp.getSalary());
	        row.createCell(4).setCellValue(Emp.getDeg());
	        row.createCell(5).setCellValue(Emp.getPhone());
	        row.createCell(6).setCellValue(Emp.getBranch());
	        row.createCell(7).setCellValue(Emp.getDate());
	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }
}
