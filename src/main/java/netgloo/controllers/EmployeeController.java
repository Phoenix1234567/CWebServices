package netgloo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import netgloo.exception.EmployeeNotFoundException;
import netgloo.models.Employee;
import netgloo.services.interfaces.EmployeeService;

@Controller
@RequestMapping(value = "/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	private final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@RequestMapping(value = "get", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Employee>> get() throws EmployeeNotFoundException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}

	@RequestMapping(value = "getById", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Employee>> getById() throws EmployeeNotFoundException {
		List<Employee> listEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}

	@RequestMapping(value = "post", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<Employee>> post(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		List<Employee> listEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<List<Employee>> update(@RequestBody Employee employee,
			@RequestHeader(value = "Authorization") String header) {
		employeeService.updateEmployee(employee);
		logger.info(header);
		List<Employee> listEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}

	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<List<Employee>> delete(@RequestParam(value = "employeeId", required = true) int employeeId)
			throws EmployeeNotFoundException {
		employeeService.deleteEmployee(employeeId);
		List<Employee> listEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}
}
