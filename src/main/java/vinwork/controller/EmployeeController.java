package vinwork.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vinwork.modal.Employee;
import vinwork.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	public EmployeeController() {}
	
	@RequestMapping(value = "getall", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		
		List<Employee> employeesList = null;
		try {
			employeesList = CompletableFuture.supplyAsync(() -> this.employeeService.getAllEmployees())
							.get();
		} catch (Exception e) {
			e.printStackTrace();
		} 
			
		return new ResponseEntity<>(employeesList, HttpStatus.OK);
	}
	
}
