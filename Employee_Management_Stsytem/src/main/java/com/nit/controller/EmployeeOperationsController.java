package com.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.entity.Employee;
import com.nit.service.IEmployeeMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeMgmtService employeeService;

	@GetMapping("/")
	public String showEmployeeReport(Model model) {
		List<Employee> list = employeeService.findAllEmployee();
		model.addAttribute("employeeList", list);
		return "show_employee_report";
	}
	
	@GetMapping("/addEmployee")
	public String addEmployee() {
		return "save_employee";
	}
	
	@GetMapping("/editEmployeeReport/{id}")
	public String editEmployeeReport(@PathVariable int id,Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "edit_employee_report";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee,HttpSession session) {
		Employee newEmployee = employeeService.saveEmployee(employee);
		if(newEmployee != null) {
			session.setAttribute("msg", "Employee Added Successfully...");
		}else {
			session.setAttribute("msg", "Somthing wrong on server...");
		}
		return "redirect:/addEmployee";
	}
	
	@PostMapping("/updateEmployeeDetails")
	public String updateEmployeeDetails(@ModelAttribute Employee employee, HttpSession session) {
		Employee updatEmployee = employeeService.saveEmployee(employee);
		
		if(updatEmployee != null) {
			session.setAttribute("msg", "Employee Update Successfully...");
		}else {
			session.setAttribute("msg", "Somthing wrong on server...");
		}
		return "redirect:/";
	}
	
	@GetMapping("/removeEmployee/{id}")
	public String removeEmployee(@PathVariable int id, HttpSession session) {
		boolean deleteEmployee = employeeService.deleteEmployee(id);
		if(deleteEmployee) {
			session.setAttribute("msg", "Employee Delete Successfully...");
		}else {
			session.setAttribute("msg", "Somthing wrong on server");
		}
		return "redirect:/";
	}
}









