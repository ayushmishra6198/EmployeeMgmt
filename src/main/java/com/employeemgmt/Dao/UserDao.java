package com.employeemgmt.Dao;

import com.employeemgmt.Domain.User;

public interface UserDao {
	void saveUser(User user);

	User getUser(final String userName);
}
