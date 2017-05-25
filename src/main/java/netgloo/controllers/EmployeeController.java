package netgloo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.Headers;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.models.Employee;
import netgloo.services.EmployeeService;

@Controller
@RequestMapping(value = "/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "get")
	@ResponseBody
	public ResponseEntity<List<Employee>> get() {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}

	@RequestMapping(value = "post")
	@ResponseBody
	public ResponseEntity<List<Employee>> post(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		List<Employee> listEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}

	@RequestMapping(value = "update")
	@ResponseBody
	public ResponseEntity<List<Employee>> update(@RequestBody Employee employee, @RequestHeader(value = "Authorization") String header) {
		employeeService.updateEmployee(employee);
		System.out.println(header);
		List<Employee> listEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<List<Employee>> delete(@RequestParam(value = "employeeId", required = true) int employeeId) {
		employeeService.deleteEmployee(employeeId);
		List<Employee> listEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}
}
