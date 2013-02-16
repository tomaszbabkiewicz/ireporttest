/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.myfaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.myfaces.services.UserService;


@ManagedBean(name = "helloWorld")
@RequestScoped
public class HelloWorldController {
	
	@ManagedProperty("#{userService}")
	private UserService userService;

	// properties
	private String name;

	/**
	 * default empty constructor
	 */
	public HelloWorldController() {
	}

	/**
	 * Method that is backed to a submit button of a form.
	 */
	public String send() {
		// do real logic, return a string which will be used for the navigation
		// system of JSF
		userService.getAllUsers();
		return "page2.xhtml";
	}

	// -------------------getter & setter
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
