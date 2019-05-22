package project.thangnd.services;

import project.thangnd.models.User;

public interface UserService {

	public int insertUser(User user);
	public User getUserById(int id_user);
}
