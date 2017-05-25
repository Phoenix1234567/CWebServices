package netgloo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import netgloo.dao.EmployeeDAO;
import netgloo.models.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;
	//private static List<Employee> employees;
	
	@Override
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
		//employees = new ArrayList<>();
		//employees.add(new Employee(1, "gaurav", "ggarg777@gmail.com", "Noida", "9876900270"));
		//return employees;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	public Employee getEmployee(int empid) {
		return employeeDAO.getEmployee(empid);
		//return new Employee(1, "gaurav", "ggarg777@gmail.com", "Noida", "9876900270");
	}

	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(employee);
		//return new Employee(1, "gaurav", "ggarg777@gmail.com", "Noida", "9876900270");
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

}