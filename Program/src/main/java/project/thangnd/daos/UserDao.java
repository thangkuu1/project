package project.thangnd.daos;

import project.thangnd.models.User;

public interface UserDao {

	public int insertUser(User user);
	public User getUserById(int id_user);
}
