package com.elerning.services.impl;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import com.elerning.model.Role;
import com.elerning.repositories.RoleDAO;
import com.elerning.services.RoleDataProvider;


@Service("roleDataProvider")
public class RoleDataProviderImpl implements RoleDataProvider {
	
	@Resource(name="RolesRepository")
	private RoleDAO rolesRepository;
	

	@Override
	public List<Role> getAllRoles() {
		return rolesRepository.getAllRoles();
	}
	
}
