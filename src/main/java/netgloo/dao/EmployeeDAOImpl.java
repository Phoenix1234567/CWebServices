package netgloo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import netgloo.connections.DatabaseConnection;
import netgloo.exception.EmployeeNotFoundException;
import netgloo.models.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private DatabaseConnection databaseConnection = new DatabaseConnection();
	
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		return databaseConnection.getConnection().createQuery("from Employee").list();
	}

	@Override
	public void deleteEmployee(Integer employeeId){
		try {
			Employee employee = (Employee) sessionFactory.getCurrentSession().load(Employee.class, employeeId);
			if (null != employee) {
				this.sessionFactory.getCurrentSession().delete(employee);
			}
		} catch (Exception e) {
			throw new EmployeeNotFoundException(e.getMessage());
		} 
	}

	@Override
	public Employee getEmployee(int empid) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

}