package com.juve.payroll.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.juve.payroll.model.Client;
import com.juve.payroll.model.Employee;
import com.juve.payroll.service.IEmployeeService;
import com.juve.payroll.service.IGenericPayrollService;

@Controller
public class DTRController {
	
	@Autowired
	private IGenericPayrollService<Employee> employeeService; 
	@Autowired
	private IGenericPayrollService<Client> clientService;
	
	private Long clientId = 1L;
	
	@RequestMapping("/dtr")
	public ModelAndView welcomePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeList", ((IEmployeeService)employeeService).getEmployeesByClientId(clientId));
		modelAndView.addObject("client", clientService.findOne(clientId));
		
		modelAndView.setViewName("dtrpage");
		
		return modelAndView;
	}
}
