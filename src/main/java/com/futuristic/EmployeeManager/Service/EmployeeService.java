package com.futuristic.EmployeeManager.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.futuristic.EmployeeManager.exception.UserNotFoundException;
import com.futuristic.EmployeeManager.model.Employee;
import com.futuristic.EmployeeManager.repo.EmployeeRepository;

@Service
@Transactional
public class EmployeeService {
	
	private final EmployeeRepository empRepo;

	@Autowired
	public EmployeeService(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}
	
	public Employee addEmployee(Employee emp) {
		emp.setEmpCode(UUID.randomUUID().toString());
		return empRepo.save(emp);
	}
	
	public List<Employee> findAllEmployees(){
		return empRepo.findAll();
	}
	
	public void deleteEmployee(Long id) {
		empRepo.deleteEmployeeById(id);
	}
	
	public Employee findEmployeeById(Long id) {
		return empRepo.findEmployeeById(id).orElseThrow(()-> new UserNotFoundException("Not Found"));
	}
}
