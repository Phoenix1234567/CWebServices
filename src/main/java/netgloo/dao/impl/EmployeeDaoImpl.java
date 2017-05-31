package netgloo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import netgloo.dao.interfaces.EmployeeDao;
import netgloo.exception.EmployeeNotFoundException;
import netgloo.models.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		getSession().save(employee);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		return getSession().createQuery("from Employee").list();
	}

	@Override
	public void deleteEmployee(Integer employeeId){
		try {
			Employee employee = (Employee) getSession().load(Employee.class, employeeId);
			if (null != employee) {
				this.getSession().delete(employee);
			}
		} catch (Exception e) {
			throw new EmployeeNotFoundException(e.getMessage());
		} 
	}

	@Override
	public Employee getEmployee(int empid) {
		return (Employee) getSession().get(Employee.class, empid);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		getSession().update(employee);
		return employee;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}