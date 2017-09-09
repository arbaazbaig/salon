package com.salon.salon.employee.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="salon_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name = "firstname")
	@NotEmpty
	private String firstName;

	@Column(name = "lastname")
	@NotEmpty
	private String lastName;

	@Column(name = "phone",nullable = false, length=10)
	private int phone;

	@Column(name = "email")
	private String email;

	@Column(name = "address")
	private String address;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "level")
	@NotEmpty
	private String level;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	
}