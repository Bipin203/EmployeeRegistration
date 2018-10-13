package co.eu.sg.employeeregistartion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.eu.sg.employeeregistartion.model.Employee;
import co.eu.sg.employeeregistartion.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registerEmployee(@RequestBody Employee employee) {

		Employee persistedEmployee = employeeService.registerEmployee(employee);

		return new ResponseEntity<Object>(persistedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/employees")
	public List<Employee> retrieveAllEmployees() {
		return employeeService.retrieveAllEmployees();
	}

}
