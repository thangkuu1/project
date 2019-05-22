package project.thangnd.daos;

import project.thangnd.models.User;
import project.thangnd.models.UserHistory;

public interface LoginDao {

	public int insertUserHistory(UserHistory userHistory);
	public User getUserByUsePass(String usename, String password);
	public int updateStatusLogin(int id_user);
	public int logoutUser(int id_user);
	public int logoutUserByName(String username);
}
