package com.techimaginia.entity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.techimaginia.dto.EmpDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@XmlRootElement
@Table(name="emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpEntity {
	@Id
	@Column(name="empid")
	private Integer id;
	
	@Column(name="empname")
private String name;
	@Column(name="empaddress")
	private String address;
	@Column(name="empsalary")
private Integer salary;
	@Column(name="empdesignation")
private String deg;
	@Column(name="empphone")
	private Integer phone;
	@Column(name="empbranch")
	private String branch;
	@Column(name="emphiredate")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date date;


	public EmpEntity() {
		
	}
	public EmpEntity(EmpDto empdto) throws ParseException
	{
		this.id=empdto.getId();
		this.name = empdto.getName();
		this.address = empdto.getAddress();
		this.salary = empdto.getSalary();
		this.deg = empdto.getDeg();
		this.phone = empdto.getPhone();
		this.branch = empdto.getBranch();
	
		 String startDate=empdto.getDate(); // Input String
	        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy"); // New Pattern
	        java.util.Date date = sdf1.parse(startDate); // Returns a Date format object with the pattern
	        java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
	       this.date=sqlStartDate;
	}
	public EmpEntity(EmpEntity emp) {
		super();
		this.id = emp.getId();
		this.name = emp.getName();
		this.address = emp.getAddress();
		this.salary = emp.getSalary();
		this.deg = emp.getDeg();
		this.phone = emp.getPhone();
		this.branch = emp.getBranch();
		//this.date = emp.getDate();
		//java.util.Date utilDate = new java.util.Date();
      //  java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
       this.date=emp.getDate();
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getDeg() {
		return deg;
	}
	public void setDeg(String deg) {
		this.deg = deg;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date =date;
	}
	@Override
	public String toString() {
		return "Emppojo [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", deg=" + deg
				+ ", phone=" + phone + ", branch=" + branch + ", date=" + date + "]";
	}
	



}
