package com.futuristic.EmployeeManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futuristic.EmployeeManager.Service.EmployeeService;
import com.futuristic.EmployeeManager.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

	private final EmployeeService empService;
	
	@Autowired
	public EmployeeResource(EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> emp = empService.findAllEmployees();
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		Employee emp = empService.findEmployeeById(id);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp){
		Employee newEmp = empService.addEmployee(emp);
		return new ResponseEntity<>(newEmp,HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable("id") Long id){
		 empService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		Employee newEmp = empService.addEmployee(emp);
		return new ResponseEntity<>(newEmp,HttpStatus.OK);
	}
}
