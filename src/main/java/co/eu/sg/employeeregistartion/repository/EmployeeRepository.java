package co.eu.sg.employeeregistartion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.eu.sg.employeeregistartion.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
