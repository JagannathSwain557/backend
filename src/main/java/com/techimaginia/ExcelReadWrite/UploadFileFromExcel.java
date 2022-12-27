package com.techimaginia.ExcelReadWrite;

import java.io.*;
import java.sql.Date;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.techimaginia.entity.EmpEntity;

public class UploadFileFromExcel {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String[] HEADERs = { "Id", "Name", "Address", "salary" , "deg", "phone", "Branch", "date" };
	  static String SHEET = "Employee";

	  public static boolean excelFormat(MultipartFile file) {
		  if(!TYPE.equals(file.getContentType())) {
			  return false;
		  }
		  return true;
	  }
	  public static List<EmpEntity> excelToEmpEntity(InputStream is) throws IOException{
		
			Workbook workbook=new XSSFWorkbook(is);
			
			Sheet sheet=workbook.getSheet(SHEET);
			Iterator<Row> rows=sheet.iterator();
			List<EmpEntity> employees=new ArrayList<EmpEntity>();
			
			int rowNumber=0;
			while(rows.hasNext())
			{
				Row currentRow=rows.next();
				if(rowNumber==0)
				{
					rowNumber++;
					continue;
				}
				Iterator<Cell> cellsInRow=currentRow.iterator();
				EmpEntity empEntity=new EmpEntity();
				int cellIdx=0;
				while(cellsInRow.hasNext())
				{
					Cell currentCell=cellsInRow.next();
		
					switch(cellIdx)
					{
					case 0:
						empEntity.setId((int) currentCell.getNumericCellValue());
						break;
					
					case 1:
						empEntity.setName(currentCell.getStringCellValue());
						break;
					case 2:
						empEntity.setAddress(currentCell.getStringCellValue());
						break;
					case 3:
						empEntity.setSalary((int) currentCell.getNumericCellValue());
						break;
					case 4:
						empEntity.setDeg(currentCell.getStringCellValue());
						break;
					case 5:
						empEntity.setPhone((int) currentCell.getNumericCellValue());
						break;
					case 6:
						empEntity.setBranch(currentCell.getStringCellValue());
						break;
					case 7:
						java.util.Date d= (java.util.Date) currentCell.getDateCellValue();
						java.sql.Date sqlDate = new java.sql.Date(d.getTime());
						 
					empEntity.setDate(sqlDate);
						break;
					default:
						break;
					}
					cellIdx++;
				}
				employees.add(empEntity);
			}
			workbook.close();
		
	  return employees;
}
}
