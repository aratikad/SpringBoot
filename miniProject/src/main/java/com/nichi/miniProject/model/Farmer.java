package com.nichi.miniProject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Farmer {

	@Column(name = "FARMER_ID")
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	int farmerId;

	@NotNull(message = "Farmer name cannot be empty")
	@NotBlank(message = "Farmer name cannot be empty")
	@Size(min = 2, max = 12, message = "Farmer name should be atleast 8 chars and atmost 12 chars")
	String fname;

	@Min(1)
	@Max(value = 99, message = "not gretter than 99")
	public int age;

	public Farmer() {

	}


	public Farmer(String fname, int age) {
		this.fname = fname;
		this.age = age;
		
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getFarmerId() {
			return farmerId;
	}

}
