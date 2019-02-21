package com.example.demo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student{

	public Student() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long rollNo;
	
	public Long getRollNo() {
		return rollNo;
	}


	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	private String name;
	

	private String standard;
    
	private Date CreateOn =new Date();

	public Date getCreateOn() {
		return CreateOn;
	}


	public void setCreateOn(Date createOn) {
		CreateOn = createOn;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStandard() {
		return standard;
	}


	public void setStandard(String standard) {
		this.standard = standard;
	}


	



	
	
}
