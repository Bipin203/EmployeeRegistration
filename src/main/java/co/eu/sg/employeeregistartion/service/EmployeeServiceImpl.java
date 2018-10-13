package co.eu.sg.employeeregistartion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.eu.sg.employeeregistartion.model.Employee;
import co.eu.sg.employeeregistartion.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private final EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee registerEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> retrieveAllEmployees() {
		return employeeRepository.findAll();
	}

}
