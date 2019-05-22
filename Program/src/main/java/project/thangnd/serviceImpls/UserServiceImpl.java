package project.thangnd.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.UserDao;
import project.thangnd.models.User;
import project.thangnd.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}
	@Override
	public User getUserById(int id_user) {
		return userDao.getUserById(id_user);
	}

}
