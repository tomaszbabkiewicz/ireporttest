package com.myfaces.repositories;

import java.util.List;

import com.myfaces.model.database.User;

public interface UserDAO {
	public List<User> getAllUsers();
}
