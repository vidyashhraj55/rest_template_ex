package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {

	

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

	@NotNull
	@Size(min=2,message="studentname atleast 10charcter",max=10)
	private String name;
	

	@NotNull
	@Size(min=5,message="altleast 5 charcter")
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
