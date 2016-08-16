package mum.edu.cs544.dao;

import java.util.List;

import mum.edu.cs544.domain.Users;

public interface IUserDAO {
	void createUser(Users user);
	boolean authenticateUser(Users User);
	public List<Users> getAllUsers();
}
