package co.eu.sg.employeeregistartion.service;

import java.util.List;

import co.eu.sg.employeeregistartion.model.Employee;

public interface EmployeeService {

	public Employee registerEmployee(Employee employee);

	public List<Employee> retrieveAllEmployees();

}
