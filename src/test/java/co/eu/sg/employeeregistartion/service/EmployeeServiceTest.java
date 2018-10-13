package co.eu.sg.employeeregistartion.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import co.eu.sg.employeeregistartion.model.Employee;
import co.eu.sg.employeeregistartion.repository.EmployeeRepository;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceTest {

	@Mock
	EmployeeRepository employeeRepository;

	EmployeeService employeeService;

	@Before
	public void setUp() {
		employeeService = new EmployeeServiceImpl(employeeRepository);
	}

	@Test
	public void shouldRegisterEmployeeDetailsSuccessfully() {

		Employee employee = new Employee(Long.valueOf("1001"), "Bipin", "Bhesaniya", "Male", LocalDate.now(),
				"Development");

		when(employeeRepository.save(employee)).thenReturn(employee);
		Employee persistedEmployee = employeeService.registerEmployee(employee);

		assertEquals("Bipin", persistedEmployee.getFirstName());

	}

	@Test(expected = Exception.class)
	public void shouldThrowExceptionWhileRegistringEmployee() {

		Employee employee = new Employee(Long.valueOf("1001"), "Bipin", "Bhesaniya", "Male", LocalDate.now(),
				"Development");

		when(employeeRepository.save(employee)).thenThrow(Exception.class);
		employeeService.registerEmployee(employee);

	}

	@Test
	public void shouldRetriveAllEmployeeSuccessfully() {

		when(employeeRepository.findAll()).thenReturn(createEmployeeList());
		List<Employee> employees = employeeService.retrieveAllEmployees();

		assertTrue(2 == employees.size());

	}

	@Test(expected = Exception.class)
	public void shouldThrowExceptionWhileRetrivingEmployees() {

		when(employeeRepository.findAll()).thenThrow(Exception.class);
		employeeService.retrieveAllEmployees();

	}

	private List<Employee> createEmployeeList() {
		Employee employeeFirst = new Employee(Long.valueOf("1001"), "Bipin", "Bhesaniya", "Male", LocalDate.now(),
				"Development");

		Employee employeeSecond = new Employee(Long.valueOf("1002"), "Rajesh", "Sharma", "Male", LocalDate.now(),
				"Development");

		return Arrays.asList(employeeFirst, employeeSecond);
	}

}
