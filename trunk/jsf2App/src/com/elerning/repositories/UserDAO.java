package com.elerning.repositories;

import java.util.List;

import com.elerning.model.User;

public interface UserDAO {
	public User getUserByLogin(String login);
	public List<User> getAllUsers();
}
