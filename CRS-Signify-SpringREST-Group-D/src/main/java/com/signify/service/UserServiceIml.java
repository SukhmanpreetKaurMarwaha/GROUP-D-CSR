/**
 * 
 */
package com.signify.service;

import org.springframework.stereotype.Service;

import com.signify.bean.User;
import com.signify.jdbc.StudentDAOImplementation;
import com.signify.jdbc.UserDAOImplementation;

/**
 * @author HP
 *
 */
@Service
public class UserServiceIml implements UserInterface{
	public void updateDetails() {
		return;
	}
	
	public boolean updatePassword(String newpass,User user) {
		
		StudentDAOImplementation y=new StudentDAOImplementation();	
		boolean val=y.update_pass(user.getUserid(),newpass,user.getPassword());
		if(val ==true)
			 return true;
		return false;
		
	}
	public boolean login(User user)
	{
		UserDAOImplementation unew=new UserDAOImplementation();
		 boolean ans=unew.login(user.getUserid(),user.getPassword(),user.getUser_name(),user.getRole());
		 
		 if(ans ==true)
			 return true;
		return false;
				
	}
	public boolean stdlogin(User user)
	{
		 StudentDAOImplementation stnew =new StudentDAOImplementation();
		 boolean ans=stnew.std_login(user.getUserid(),user.getPassword(),user.getUser_name());
		
		 if(ans ==true)
			 return true;
		return false;
				
	}

}
