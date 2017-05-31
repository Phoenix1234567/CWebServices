package netgloo.dao.impl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import netgloo.dao.interfaces.ProfileDao;
import netgloo.models.User;

@Repository
@Transactional
public class ProfileDaoImpl implements ProfileDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean addUser(User user) {
		Serializable user_id = getSession().save(user);
		if (user_id != null)
			return true;
		else
			return false;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
