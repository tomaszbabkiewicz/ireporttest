package com.elerning.services;

import java.util.List;

import com.elerning.model.User;

public interface UserDataProvider {

	public List<User> getUsersByRole(Integer roleId);

	public User getUserByLogin(String login);

	public void add(User newUser, Integer roleId);
	
	public List<User> getAllUsers();

}