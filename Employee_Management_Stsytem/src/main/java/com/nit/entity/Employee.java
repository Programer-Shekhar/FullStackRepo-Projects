package com.nit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EMPLOYEE_MANAGEMENT_SYSTEM")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(length=30)
	private String firstName;
	@Column(length=30)
	private String lastName;
	@Column(length=60)
	private String email;
	@Column(length=10)
	private Long mobileNo;
	@Column(length=30)
	private String address;
	@Column(length=30)
	private String job;
	private Double salary;
	@Column(length=4)
	private Integer departmentNo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", address=" + address + ", job=" + job + ", salary=" + salary
				+ ", departmentNo=" + departmentNo + "]";
	}
	
	
}
