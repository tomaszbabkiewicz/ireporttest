package com.elerning.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.elerning.services.RoleDataProvider;
import com.elerning.services.UserDataProvider;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
	
	private String login;
	private String password;
	
	@ManagedProperty("#{userDataProvider}")
	private UserDataProvider userDataProvider;
	
	@ManagedProperty("#{roleDataProvider}")
	private RoleDataProvider roleDataProvider;
	
	public String getLogin() {
		login = "Users : " + userDataProvider.getAllUsers().toString();
		login = login + ".  Roles:  "+roleDataProvider.getAllRoles().toString();
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUserDataProvider(UserDataProvider userDataProvider) {
		this.userDataProvider = userDataProvider;
	}

	public void setRoleDataProvider(RoleDataProvider roleDataProvider) {
		this.roleDataProvider = roleDataProvider;
	}
}
