package com.nit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nit.entity.Employee;
import com.nit.repository.IEmployeeRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee savEmployee = employeeRepository.save(employee);
		return savEmployee;
	}

	@Override
	public List<Employee> findAllEmployee() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return employeeRepository.findById(id).get();
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee deleteEmployee = employeeRepository.findById(id).get();
		
		if(deleteEmployee != null) {
			employeeRepository.delete(deleteEmployee);
			return true;
		}
		return false;
	}
	
	public void removeSessionMessage() {
		HttpSession session =  ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
		session.removeAttribute("msg");
	}

}
