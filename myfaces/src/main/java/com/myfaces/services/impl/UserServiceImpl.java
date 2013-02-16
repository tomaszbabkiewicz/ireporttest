package com.myfaces.services.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.myfaces.model.database.User;
import com.myfaces.repositories.UserDAO;
import com.myfaces.services.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource(name="usersRepository")
	private UserDAO usersRepository;
	
	@Override
	public List<User> getAllUsers() {
		return usersRepository.getAllUsers();
	}
}
