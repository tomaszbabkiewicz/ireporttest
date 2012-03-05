package com.elerning.services.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elerning.model.User;
import com.elerning.repositories.UserDAO;
import com.elerning.services.UserDataProvider;


@Service("userDataProvider")
public class UserDataProviderImpl implements UserDataProvider {
	
	@Resource(name="UsersRepository")
	private UserDAO usersRepository;
	

	@Override
	public List<User> getUsersByRole(Integer roleId) {
		// return bikesRepository.loadBikesFromCategory(categoryId);
		return null;
	}

	@Override
	public User getUserByLogin(String login) {
		return usersRepository.getUserByLogin(login);
	}

	@Transactional
	@Override
	public void add(User newUser, Integer roleId) {
		//BikeCategory categorySelected = dictionaryRepository.loadBikeCategroryById(categoryId);
		//newBike.setCategory(categorySelected);
		//bikesRepository.saveBike(newBike);
	}

	@Override
	public List<User> getAllUsers() {
		return usersRepository.getAllUsers();
	}
	
}
