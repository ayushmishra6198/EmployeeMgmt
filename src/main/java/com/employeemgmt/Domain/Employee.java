package com.employeemgmt.Domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown= true)
public class Employee {

	private long employeeCode;
	private String firstName;
	private String lastName;
	private String location;
	private String email;
	private String dob;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(long employeeCode) {
		this.employeeCode = employeeCode;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "Employee [employeeCode=" + employeeCode + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", location=" + location + ", email=" + email + ", dob=" + dob + "]";
	}
	
}

