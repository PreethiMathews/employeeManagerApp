package com.futuristic.EmployeeManager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.futuristic.EmployeeManager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	void deleteEmployeeById(Long id);

	Optional<Employee> findEmployeeById(Long id);

}
