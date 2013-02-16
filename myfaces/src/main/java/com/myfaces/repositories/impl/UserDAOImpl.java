package com.myfaces.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.myfaces.model.database.User;
import com.myfaces.repositories.UserDAO;


@Repository("usersRepository")
public class UserDAOImpl extends DAOImpl implements UserDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return  entityManager.createQuery("select p from User p")
				.setMaxResults(getMaxResult())
				.getResultList();
	}

}
