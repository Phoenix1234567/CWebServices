package netgloo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import netgloo.dao.interfaces.ProfileDao;
import netgloo.models.User;
import netgloo.services.interfaces.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDao profileDao;
	
	@Override
	public Boolean addUser(User user) {
		return profileDao.addUser(user);
	}
}
