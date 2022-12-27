package com.techimaginia.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.techimaginia.entity.EmpEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@XmlRootElement
@Table(name="emp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpDto {
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
	private String date;
	public EmpDto() {
		
	}
	public EmpDto(Integer id, String name, String address, Integer salary, String deg, Integer phone, String branch,
			String date) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.deg = deg;
		this.phone = phone;
		this.branch = branch;
		this.date = date;
	}
	public EmpDto(EmpDto id) {
	
		this.id=id.getId();
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date =date ;
	}
	@Override
	public String toString() {
		return "Emppojo [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + ", deg=" + deg
				+ ", phone=" + phone + ", branch=" + branch + ", date=" + date + "]";
	}



}
