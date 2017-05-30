package netgloo.connections;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseConnection {

	@Autowired
	private static SessionFactory sessionFactory;
	
	//Create database connection with current session
	public Session getConnection() {
		return sessionFactory.getCurrentSession();
	}	
}
