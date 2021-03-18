package com.employeemgmt.Service;

import com.employeemgmt.Domain.User;

public interface UserService {
	void register(User user);

	boolean validate(String userName,String password);
}

