package com.signify.service;

import com.signify.bean.User;

public interface UserInterface {
	public void updateDetails();
	public boolean updatePassword(String newpass,User user);
	public boolean login(User user);
	public boolean stdlogin(User user);
	
}
