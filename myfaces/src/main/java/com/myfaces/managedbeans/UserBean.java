package com.myfaces.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.myfaces.model.database.User;


@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
	
	private List<User> allUsers;
	
	public UserBean(){
		allUsers = new ArrayList<User>();
		allUsers.add(new User("kowal", "Jan", "Kowalski"));
		allUsers.add(new User("nowal", "Jan", "Nowak"));
		allUsers.add(new User("kowal", "Jan", "Kowalski"));
		allUsers.add(new User("nowal", "Jan", "Nowak"));
		allUsers.add(new User("kowal", "Jan", "Kowalski"));
		allUsers.add(new User("nowal", "Jan", "Nowak"));
		allUsers.add(new User("kowal", "Jan", "Kowalski"));
		allUsers.add(new User("nowal", "Jan", "Nowak"));
		allUsers.add(new User("kowal", "Jan", "Kowalski"));
		allUsers.add(new User("nowal", "Jan", "Nowak"));
	}

	public List<User> getAllUsers() {
		return allUsers;
	}

	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}
	
	

}
