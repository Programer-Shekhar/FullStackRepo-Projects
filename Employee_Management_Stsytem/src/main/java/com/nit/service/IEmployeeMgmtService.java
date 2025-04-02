package com.nit.service;

import java.util.List;

import com.nit.entity.Employee;

public interface IEmployeeMgmtService {
	
	public Employee saveEmployee(Employee employee);
	
	public List<Employee> findAllEmployee();
	
	public Employee getEmployeeById(int id);
	
	public boolean deleteEmployee(int id);
}
