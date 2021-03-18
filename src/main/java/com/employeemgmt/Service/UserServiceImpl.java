package com.employeemgmt.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemgmt.Dao.UserDao;
import com.employeemgmt.Domain.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public void register(User user) {
		this.userDao.saveUser(user);
	}

	public boolean validate(String userName,String password) {
		User user = this.userDao.getUser(userName);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

}
