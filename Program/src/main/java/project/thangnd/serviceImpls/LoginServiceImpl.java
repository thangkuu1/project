package project.thangnd.serviceImpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.thangnd.daos.LoginDao;
import project.thangnd.models.User;
import project.thangnd.models.UserHistory;
import project.thangnd.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public User getUserByUsePass(String usename, String password) {
		// TODO Auto-generated method stub
		return loginDao.getUserByUsePass(usename, password);
	}

	@Override
	public int insertUserHistory(UserHistory userHistory) {
		// TODO Auto-generated method stub
		return loginDao.insertUserHistory(userHistory);
	}

	@Override
	public int updateStatusLogin(int id_user) {
		// TODO Auto-generated method stub
		return loginDao.updateStatusLogin(id_user);
	}

	@Override
	public int logoutUser(int id_user) {
		// TODO Auto-generated method stub
		return loginDao.logoutUser(id_user);
	}

	@Override
	public int logoutUserByName(String username) {
		// TODO Auto-generated method stub
		return loginDao.logoutUserByName(username);
	}

}
